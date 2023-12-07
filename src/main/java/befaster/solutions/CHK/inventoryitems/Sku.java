package befaster.solutions.CHK.inventoryitems;

public abstract class Sku {

    private int baseCost;

    private int discountCost;

    private int discountUnitPackage;

    private int count = 1;

    private SkuTypes skuType;

    public Sku(int baseCost, int discountCost, int discountUnitPackage, SkuTypes skuType) {
        this.baseCost = baseCost;
        this.discountCost = discountCost;
        this.discountUnitPackage = discountUnitPackage;
        this.skuType = skuType;
    }

    public void incrementCount(){
        count++;
    }

    public void resetCount(){
        count = 1;
    }

    public Integer totalCost() {
        int numberOfTimesToApplyDiscount = discountUnitPackage == 0 ? 0 : count / discountUnitPackage;
        return (baseCost * count) - numberOfTimesToApplyDiscount * discountCost;
    }


}
