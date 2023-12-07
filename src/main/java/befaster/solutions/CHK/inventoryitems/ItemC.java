package befaster.solutions.CHK.inventoryitems;

public class ItemC extends Sku{

    private static final Integer BASE_COST = 20;

    private static final Integer DISCOUNT_VALUE = 0;

    private static final Integer NUMBER_OF_UNITS_FOR_DISCOUNT = 0;

    public ItemC() {
        super(BASE_COST, DISCOUNT_VALUE, NUMBER_OF_UNITS_FOR_DISCOUNT, SkuTypes.C);
    }

}

