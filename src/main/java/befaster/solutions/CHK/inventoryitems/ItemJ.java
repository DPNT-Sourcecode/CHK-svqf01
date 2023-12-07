package befaster.solutions.CHK.inventoryitems;

import java.util.LinkedHashMap;
import java.util.Map;

public class ItemI extends Sku {

    private static final Integer BASE_COST = 35;

    public ItemI() {
        super(BASE_COST, SkuTypes.H);
    }

}
