package befaster.solutions.CHK.inventoryitems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ItemA  extends Sku{

    private static final Integer BASE_COST = 50;
    private static final Map<Integer,Integer> DISCOUNT_PAIRS = new LinkedHashMap<>();

    public ItemA() {
        super(BASE_COST, SkuTypes.A, DISCOUNT_PAIRS);
        DISCOUNT_PAIRS.put(5, 50);
        DISCOUNT_PAIRS.put(3, 20);
    }

}


