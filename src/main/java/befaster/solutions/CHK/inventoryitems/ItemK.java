package befaster.solutions.CHK.inventoryitems;

public class ItemK extends Sku {

    private static final Integer BASE_COST = 70;

    public ItemK() {
        super(BASE_COST);
        addDiscount(2, 20);
    }

}
