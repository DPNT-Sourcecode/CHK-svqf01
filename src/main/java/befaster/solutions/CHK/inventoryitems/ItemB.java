package befaster.solutions.CHK.inventoryitems;

import java.util.LinkedHashMap;
import java.util.Map;

public class ItemB extends Sku{

    public static final Integer BASE_COST = 30;

    private static final Map<Integer,Integer> DISCOUNT_PAIRS = new LinkedHashMap<>();

    public ItemB() {
        super(BASE_COST, SkuTypes.B, DISCOUNT_PAIRS);
        DISCOUNT_PAIRS.put(2, 15);
    }

}
