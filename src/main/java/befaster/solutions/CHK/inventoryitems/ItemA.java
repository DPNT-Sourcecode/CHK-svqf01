package befaster.solutions.CHK.inventoryitems;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ItemA  extends Sku{

    private static final Integer BASE_COST = 50;
    private static final Map<Integer,Integer> DISCOUNT_PAIRS = Map.of(5, 50, 3, 20);

    public ItemA() {
        super(BASE_COST, SkuTypes.A, DISCOUNT_PAIRS);
    }

}
