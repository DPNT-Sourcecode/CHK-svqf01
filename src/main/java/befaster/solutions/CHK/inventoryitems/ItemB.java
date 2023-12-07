package befaster.solutions.CHK.inventoryitems;

public class ItemB extends Sku{

    private static final Integer BASE_COST = 30;

    private static final Integer DISCOUNT_VALUE = 15;

    private static final Integer NUMBER_OF_UNITS_FOR_DISCOUNT = 2;


    public ItemB() {
        super(BASE_COST, DISCOUNT_VALUE, NUMBER_OF_UNITS_FOR_DISCOUNT, SkuTypes.B);
    }

}
