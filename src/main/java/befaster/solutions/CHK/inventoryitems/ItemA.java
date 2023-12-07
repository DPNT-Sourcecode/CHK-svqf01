package befaster.solutions.CHK.inventoryitems;

public class ItemA  extends Sku{

    private static final Integer BASE_COST = 50;

    private static final Integer DISCOUNT_VALUE = 20;

    private static final Integer NUMBER_OF_UNITS_FOR_DISCOUNT = 3;

    public ItemA() {
        super(BASE_COST, DISCOUNT_VALUE, NUMBER_OF_UNITS_FOR_DISCOUNT, SkuTypes.A);
    }

}
