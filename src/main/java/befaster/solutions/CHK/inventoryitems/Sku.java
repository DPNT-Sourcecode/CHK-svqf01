package befaster.solutions.CHK.inventoryitems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Sku {

    private int baseCost;

    private final Map<Integer, Integer> discountPairs;

    private int count = 1;

    public Sku(int baseCost) {
        this.baseCost = baseCost;
        this.discountPairs = new LinkedHashMap<>();
    }

    public void addDiscount(final Integer numberOfItemsForDiscount, final Integer discountValue) {
        discountPairs.put(numberOfItemsForDiscount, discountValue);
    }

    public int getBaseCost() {
        return baseCost;
    }

    public void incrementCount() {
        count++;
    }

    public void decrementCount() {
        count--;
    }

    public void resetCount() {
        count = 1;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
