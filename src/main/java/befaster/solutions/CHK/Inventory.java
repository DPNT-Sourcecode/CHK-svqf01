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
        checkoutItems.forEach((k, v) -> checkoutValue.addAndGet(v.totalCost()));
        return checkoutValue.get();
    }

    private void updateCheckoutList(final String skus) {
        checkoutItems = new HashMap<>();
        for (int i = 0; i < skus.length(); i++) {
            final Character sku = skus.charAt(i);
            checkoutItems.compute(sku, (k, v) -> {
                if (v == null) {
                    return SkuTypes.getSkuTypeByCharacter(sku).getSkuItem();
                } else {
                    v.incrementCount();
                    return v;
                }
            });
        }
    }


}

