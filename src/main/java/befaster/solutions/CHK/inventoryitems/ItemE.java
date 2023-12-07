package befaster.solutions.CHK.inventoryitems;

import java.util.Map;

public class ItemE extends Sku {

    private static final Integer BASE_COST = 40;

    private static final Map<Integer,Integer> DISCOUNT_PAIRS = Map.of(2, ItemB.BASE_COST);

    public ItemE() {
        super(BASE_COST, SkuTypes.E, DISCOUNT_PAIRS);
    }

}
