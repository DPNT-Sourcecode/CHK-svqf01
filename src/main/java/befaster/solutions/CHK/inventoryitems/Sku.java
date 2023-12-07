package befaster.solutions.CHK.inventoryitems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Sku {

    private int baseCost;

    private final Map<Integer, Integer> discountPairs;

    private int count = 1;
    private SkuTypes skuType;

    public Sku(int baseCost,SkuTypes skuType, Map<Integer, Integer> discountPairs) {
        this.baseCost = baseCost;
        this.skuType = skuType;
        this.discountPairs = discountPairs;
    }

    public Sku(int baseCost,SkuTypes skuType) {
        this.baseCost = baseCost;
        this.skuType = skuType;
        this.discountPairs = new LinkedHashMap<>();
    }

    public void incrementCount() {
        count++;
    }

    public void resetCount() {
        count = 1;
    }

    public int getCount() {
        return count;
    }

    public Integer totalCost() {
        int discountValue = calculateDiscountValue(count);
        return (baseCost * count) - discountValue;
    }

    private Integer calculateDiscountValue(int numberOfUnits) {
        AtomicInteger discount = new AtomicInteger();
        AtomicInteger numberOfRemainingUnits = new AtomicInteger(numberOfUnits);
        discountPairs.forEach((numberOfUnitsForDiscount, discountValue) -> {
                if(numberOfRemainingUnits.get() >= numberOfUnitsForDiscount){
                    discount.addAndGet((numberOfRemainingUnits.get() / numberOfUnitsForDiscount) * discountValue);
                    numberOfRemainingUnits.updateAndGet(val -> val % numberOfUnitsForDiscount );
                }
            }
        );
        return discount.get();
    }
}



