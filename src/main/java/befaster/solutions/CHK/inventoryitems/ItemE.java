package befaster.solutions.CHK.inventoryitems;

import java.util.LinkedHashMap;
import java.util.Map;

public class ItemE extends Sku {

    private static final Integer BASE_COST = 40;

    private static final Map<Integer,Integer> DISCOUNT_PAIRS = new LinkedHashMap<>();

    public ItemE() {
        super(BASE_COST, SkuTypes.E, DISCOUNT_PAIRS);
        DISCOUNT_PAIRS.put(2, ItemB.BASE_COST);
    }

}

