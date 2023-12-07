package befaster.solutions.CHK.inventoryitems;

import java.util.LinkedHashMap;
import java.util.Map;

public class ItemH extends Sku {

    private static final Integer BASE_COST = 10;

    public ItemH() {
        super(BASE_COST);
        addDiscount(10, 20);
        addDiscount(5, 5);
    }

}
