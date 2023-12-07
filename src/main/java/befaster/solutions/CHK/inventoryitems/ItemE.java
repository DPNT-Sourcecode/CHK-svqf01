package befaster.solutions.CHK.inventoryitems;

import java.util.Map;

public class ItemE extends Sku {

    private static final Integer BASE_COST = 50;

    private static final Integer DISCOUNT_VALUE = 20;

    private static final Integer NUMBER_OF_UNITS_FOR_DISCOUNT = 3;

    private static final Map<Integer,Integer> DISCOUNT_PAIRS = Map.of(5, 50, 3, 20);

    public ItemE() {
        super(BASE_COST, SkuTypes.A, DISCOUNT_PAIRS);
    }

}
