package befaster.solutions.CHK.inventoryitems;

public class ItemB implements  InventoryItem{

    int baseCost = 50;

    int discountCost = 20;

    int discountUnitPackage = 3;

    int count;

    @Override
    public Integer totalCost() {
        int numberOfTimesToApplyDiscount = count / discountUnitPackage;
        return (baseCost * count) - numberOfTimesToApplyDiscount * discountCost;
    }

}
