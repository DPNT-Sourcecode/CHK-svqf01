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
        removeFreeItems();
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

    private void removeFreeItems() {
        if(checkoutItems.containsKey(SkuTypes.B.toString().charAt(0)) && checkoutItems.containsKey(SkuTypes.E.toString().charAt(0)))
        {
            final Sku skuBItem = checkoutItems.get(SkuTypes.B.toString().charAt(0));
            int totalNumberOfBItems = skuBItem.getCount();
            int totalNumberOfEItems = checkoutItems.get(SkuTypes.E.toString().charAt(0)).getCount();

            if(totalNumberOfBItems > 0 && totalNumberOfEItems >= 2){
                int numberOfFreeItems = totalNumberOfEItems / 2;
                skuBItem.setCount(totalNumberOfBItems - numberOfFreeItems);
            }
        }

    }


}
