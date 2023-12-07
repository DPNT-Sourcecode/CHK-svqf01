package befaster.solutions.CHK.inventoryitems;

import java.util.LinkedHashMap;
import java.util.Map;

public class ItemB extends Sku{

    public static final Integer BASE_COST = 30;

    public ItemB() {
        super(BASE_COST);
        addDiscount(2, 15);
    }

}

