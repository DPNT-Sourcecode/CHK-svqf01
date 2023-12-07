package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import befaster.solutions.CHK.inventoryitems.Sku;
import befaster.solutions.CHK.inventoryitems.SkuTypes;

public class Inventory {

    private Map<Character, Sku> checkoutItems;

    public Integer calculateTotal(final String skus){
        final AtomicInteger checkoutValue = new AtomicInteger();
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
        removeFreeItemsIfPossible(SkuTypes.E.toString().charAt(0), SkuTypes.B.toString().charAt(0), 2);
        removeFreeItemsIfPossible(SkuTypes.F.toString().charAt(0), SkuTypes.F.toString().charAt(0), 3);
        removeFreeItemsIfPossible(SkuTypes.N.toString().charAt(0), SkuTypes.M.toString().charAt(0), 3);
        removeFreeItemsIfPossible(SkuTypes.R.toString().charAt(0), SkuTypes.Q.toString().charAt(0), 3);
        removeFreeItemsIfPossible(SkuTypes.U.toString().charAt(0), SkuTypes.U.toString().charAt(0), 4);

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
