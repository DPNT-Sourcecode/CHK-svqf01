package befaster.solutions.CHK.inventoryitems;

import java.util.stream.Stream;

import befaster.solutions.CHK.UnexistentSkuException;

public enum SkuTypes {

    A(new ItemA()),
    B(new ItemB()),
    C(new ItemC()),
    D(new ItemD());

    private final Sku skuItem;

    SkuTypes(Sku skuItem) {
        this.skuItem = skuItem;
    }

    public Sku getSkuItem() {
        return skuItem;
    }

    public static boolean doesSkuTypeExist(final Character possibleSku){
        return Stream.of(SkuTypes.values())
            .anyMatch(skuType-> skuType.name().equals(possibleSku.toString()));
    }


    public static SkuTypes getSkuTypeByCharacter(final Character possibleSku){
        return Stream.of(SkuTypes.values())
            .filter(skuType-> skuType.name().equals(possibleSku.toString()))
            .findFirst()
            .orElseThrow(() -> new UnexistentSkuException(possibleSku));
    }


}
