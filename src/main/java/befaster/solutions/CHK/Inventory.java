package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import befaster.solutions.CHK.inventoryitems.Sku;
import befaster.solutions.CHK.inventoryitems.SkuTypes;

public class Inventory {

    private Map<Character, Sku> checkoutItems;
    private AtomicInteger checkoutValue;


    public Integer calculateTotal(final String skus){

        checkoutValue = new AtomicInteger();

        updateCheckoutList(skus);

        removeFreeItemsWithPromotions();
        removeGroupingOffer();

        checkoutItems.forEach((k, v) -> checkoutValue.addAndGet(v.totalCost()));

        return checkoutValue.get();
    }

    //Creates a Map where for each SKU character, there's an instance of the Item{Character} class
    // with the appropriate count.
    private void updateCheckoutList(final String skus) {
        checkoutItems = new HashMap<>();

        for (int i = 0; i < skus.length(); i++) {

            final Character skuCharacter = skus.charAt(i);

            checkoutItems.compute(skuCharacter, (k, v) -> {
                if (v == null) {
                    //Create a new Sku instance and make sure to reset its count.
                    final Sku item = SkuTypes.getSkuTypeByCharacter(skuCharacter).getSkuItem();
                    item.resetCount();
                    return item;
                } else {
                    //Increment the count of the existent sku instance.
                    v.incrementCount();
                    return v;
                }
            });
        }
    }

    private void removeFreeItemsWithPromotions() {
        removeFreeItemsIfPossible(SkuTypes.E.getCharacter(), SkuTypes.B.getCharacter(), 2);
        removeFreeItemsIfPossible(SkuTypes.F.getCharacter(), SkuTypes.F.getCharacter(), 3);
        removeFreeItemsIfPossible(SkuTypes.N.getCharacter(), SkuTypes.M.getCharacter(), 3);
        removeFreeItemsIfPossible(SkuTypes.R.getCharacter(), SkuTypes.Q.getCharacter(), 3);
        removeFreeItemsIfPossible(SkuTypes.U.getCharacter(), SkuTypes.U.getCharacter(), 4);
    }

    private void removeGroupingOffer(){
        removeGroupOffersGivenSkuTypes(List.of(SkuTypes.S, SkuTypes.T, SkuTypes.X, SkuTypes.Y, SkuTypes.Z), 3, 45);
    }

    private void removeGroupOffersGivenSkuTypes(final List<SkuTypes> initialSkuTypesList, final int groupSize, final int groupValue) {
        
        List<SkuTypes> groupOfferSkuTypes = new ArrayList<>(initialSkuTypesList);
        
        //Sort them in a descendent way by price
        groupOfferSkuTypes.sort((v1, v2) -> v2.getSkuItem().getBaseCost() - v1.getSkuItem().getBaseCost());

        int numberOfGroupOffer = getNumberOfGroupOffers(groupOfferSkuTypes, groupSize);

        checkoutValue.addAndGet(groupValue * numberOfGroupOffer);
        int totalOfDecrementsNecessary = numberOfGroupOffer * groupSize;

        while(totalOfDecrementsNecessary > 0){
            for (SkuTypes skuType: groupOfferSkuTypes) {
                //no need to keep going when no more decrements are necessary
                if(totalOfDecrementsNecessary <= 0 )
                    break;
                if( checkoutItems.containsKey(skuType.getCharacter())){
                    final Sku currentSku = checkoutItems.get(skuType.getCharacter());
                    //We only decrement the count until 0.
                    int skuCountAfterDecrement = Math.max(currentSku.getCount() - totalOfDecrementsNecessary, 0);
                    totalOfDecrementsNecessary -= currentSku.getCount();
                    currentSku.setCount(skuCountAfterDecrement);
                }
            }
        }
    }

    private int getNumberOfGroupOffers(List<SkuTypes> groupOfferSkuTypes, int groupSize) {
        AtomicInteger numberOfGroupOffers = new AtomicInteger();

        groupOfferSkuTypes.forEach((skuTypes -> {
            if(checkoutItems.containsKey(skuTypes.getCharacter())){
                numberOfGroupOffers.getAndAdd(checkoutItems.get(skuTypes.getCharacter()).getCount());
            }
        }));

        return numberOfGroupOffers.get() / groupSize;
    }


    private void removeFreeItemsIfPossible(Character promoSkuType, Character freeSkuType, Integer numberOfItemsPerPromo) {
        if(checkoutItems.containsKey(promoSkuType) && checkoutItems.containsKey(freeSkuType))
        {
            final Sku freeSkuItem = checkoutItems.get(freeSkuType);
            int totalNumberOfPossibleFreeItems = freeSkuItem.getCount();
            int totalNumberOfPromoItems = checkoutItems.get(promoSkuType).getCount();

            if(totalNumberOfPossibleFreeItems > 0 && totalNumberOfPromoItems >= numberOfItemsPerPromo){
                int numberOfFreeItems = totalNumberOfPromoItems / numberOfItemsPerPromo;
                freeSkuItem.setCount(totalNumberOfPossibleFreeItems - numberOfFreeItems);
            }
        }
    }


}

