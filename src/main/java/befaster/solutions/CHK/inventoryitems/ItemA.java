package befaster.solutions.CHK.inventoryitems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ItemA  extends Sku{

    private static final Integer BASE_COST = 50;

    public ItemA() {
        super(BASE_COST);
        addDiscount(5, 50);
        addDiscount(3, 20);
    }

}
