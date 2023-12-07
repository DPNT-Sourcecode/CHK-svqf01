package befaster.solutions.CHK.inventoryitems;

public class ItemQ extends Sku {

    private static final Integer BASE_COST = 30;

    public ItemQ() {
        super(BASE_COST);
        addDiscount(3, 10);
    }

}
