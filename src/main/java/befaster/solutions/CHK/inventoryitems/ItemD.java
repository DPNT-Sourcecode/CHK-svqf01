package befaster.solutions.CHK.inventoryitems;

public class ItemD extends Sku{

    private static final Integer BASE_COST = 15;

    private static final Integer DISCOUNT_VALUE = 0;

    private static final Integer NUMBER_OF_UNITS_FOR_DISCOUNT = 0;

    public ItemD() {
        super(BASE_COST, DISCOUNT_VALUE, NUMBER_OF_UNITS_FOR_DISCOUNT, SkuTypes.D);
    }

}

