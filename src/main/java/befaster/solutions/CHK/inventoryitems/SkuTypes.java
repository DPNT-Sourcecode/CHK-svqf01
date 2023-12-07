package befaster.solutions.CHK.inventoryitems;

import java.util.stream.Stream;

import befaster.solutions.CHK.UnexistentSkuException;

public enum SkuTypes {

    A(new ItemA()),
    B(new ItemB()),
    C(new ItemC()),
    D(new ItemD()),
    E(new ItemE()),
    F(new ItemF()),
    G(new ItemG()),
    H(new ItemH()),
    I(new ItemI()),
    J(new ItemJ()),
    K(new ItemK()),
    L(new ItemL()),
    M(new ItemM()),
    N(new ItemN()),
    O(new ItemO()),
    P(new ItemP()),
    Q(new ItemQ()),
    R(new ItemR()),
    S(new ItemS()),
    T(new ItemT()),
    U(new ItemU()),
    V(new ItemV()),
    W(new ItemW()),
    X(new ItemX()),
    Y(new ItemY()),
    Z(new ItemZ())
    ;

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
    
    public Character getCharacter(){
        return this.toString().charAt(0);
    }


}
