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
        checkoutItems.forEach((k, v) -> checkoutValue.addAndGet(v.totalCost()));
        return checkoutValue.get();
    }

    private void updateCheckoutList(final String skus) {
        checkoutItems = new HashMap<>();
        for (int i = 0; i < skus.length(); i++) {
            final Character sku = skus.charAt(i);
            checkoutItems.compute(sku, (k, v) -> {
                if (v == null) {
                    final Sku item = SkuTypes.getSkuTypeByCharacter(sku).getSkuItem();
                    item.resetCount();
                    return item;
                } else {
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
        removeGroupingOffer();
    }

    private void removeGroupingOffer(){
        removeGroupOffersGivenSkuTypes(List.of(SkuTypes.S, SkuTypes.T, SkuTypes.X, SkuTypes.Y, SkuTypes.Z), 3, 45);
    }

    private void removeGroupOffersGivenSkuTypes(final List<SkuTypes> initialSkuTypesList, final int groupSize, final int groupValue) {
        
        List<SkuTypes> groupOfferSkuTypes = new ArrayList<>(initialSkuTypesList);
        
        //Sort them in a descendent way by price
        groupOfferSkuTypes.sort((v1, v2) -> v2.getSkuItem().getBaseCost() - v1.getSkuItem().getBaseCost());

        int numberOfGroupOffer = getNumberOfGroupOffers(groupOfferSkuTypes, groupSize);

        while(numberOfGroupOffer > 0){
            int totalItemsDecremented = 0;
            for (SkuTypes skuType: groupOfferSkuTypes) {
                //We decrement a number of group-size items which means we need to add the groupValue to the total
                if(totalItemsDecremented == groupSize){
                    break;
                }
                if(checkoutItems.containsKey(skuType.getCharacter())){
                    checkoutItems.get(skuType.getCharacter()).decrementCount();
                    totalItemsDecremented++;
                }
            }
            checkoutValue.addAndGet(groupValue );
            numberOfGroupOffer--;
        }
    }

    private int getNumberOfGroupOffers(List<SkuTypes> groupOfferSkuTypes, int groupSize) {
        AtomicInteger numberOfGroupOffers = new AtomicInteger();

        //Create an array of groupSize where the min value is the max number of groups offers.
        groupOfferSkuTypes.forEach((skuTypes -> {
            if(checkoutItems.containsKey(skuTypes.getCharacter()) &&
                checkoutItems.get(skuTypes.getCharacter()).getCount() > groupSize){
                numberOfGroupOffers.set(checkoutItems.get(skuTypes.getCharacter()).getCount());
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

