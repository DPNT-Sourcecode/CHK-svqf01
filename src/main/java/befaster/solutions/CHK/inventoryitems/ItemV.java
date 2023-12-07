package befaster.solutions.CHK.inventoryitems;

public class ItemV extends Sku {

    private static final Integer BASE_COST = 40;

    public ItemV() {
        super(BASE_COST);
        addDiscount(2, 10);
        addDiscount(3, 20);
    }

}
