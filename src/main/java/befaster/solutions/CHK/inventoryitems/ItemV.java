package befaster.solutions.CHK.inventoryitems;

public class ItemV extends Sku {

    private static final Integer BASE_COST = 50;

    public ItemV() {
        super(BASE_COST);
        addDiscount(3, 20);
        addDiscount(2, 10);
    }

}
