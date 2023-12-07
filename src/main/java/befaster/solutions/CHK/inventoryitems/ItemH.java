package befaster.solutions.CHK.inventoryitems;

import java.util.LinkedHashMap;
import java.util.Map;

public class ItemH extends Sku {

    private static final Integer BASE_COST = 10;

    private static final Map<Integer,Integer> DISCOUNT_PAIRS = new LinkedHashMap<>();

    public ItemH() {
        super(BASE_COST, SkuTypes.H);
        DISCOUNT_PAIRS.put(5, 5);
        DISCOUNT_PAIRS.put(10, 20);

    }

}

