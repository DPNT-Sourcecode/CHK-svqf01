package befaster.solutions.CHK.inventoryitems;

public class ItemP extends Sku {

    private static final Integer BASE_COST = 50;

    public ItemP() {
        super(BASE_COST);
        addDiscount(5, 50);
    }

}
