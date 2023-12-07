package befaster.solutions.CHK.inventoryitems;

import java.util.HashMap;
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
        this.discountPairs = new HashMap<>();
    }

    public void incrementCount() {
        count++;
    }

    public void resetCount() {
        count = 1;
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
                    System.out.println("number of discounts applied is " + (numberOfRemainingUnits.get() / numberOfUnitsForDiscount) );
                    numberOfRemainingUnits.updateAndGet(val -> val % numberOfUnitsForDiscount );
                }
                System.out.println("Number of units is " + numberOfUnits + " and the current discount is " + discount);
            }
        );
        return discount.get();
    }
}
