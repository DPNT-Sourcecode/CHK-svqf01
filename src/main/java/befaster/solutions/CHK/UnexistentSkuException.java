package befaster.solutions.CHK;

public class UnexistentSkuException extends RuntimeException {

    private static final String NON_EXISTENT_SKU_MESSAGE = "No existent SKU for %s";

    public UnexistentSkuException(Character sku) {
        super(NON_EXISTENT_SKU_MESSAGE.formatted(sku));
    }
}
