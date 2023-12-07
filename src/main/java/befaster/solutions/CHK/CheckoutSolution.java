package befaster.solutions.CHK;



import befaster.solutions.CHK.inventoryitems.SkuTypes;

public class CheckoutSolution {


    Inventory inventory = new Inventory();

    public Integer checkout(String skus) {
    try{
        validateStringInput(skus);
    }
    catch (UnexistentSkuException e){
        System.out.println(e.getMessage());
        return -1;
    }

    return inventory.calculateTotal(skus);

    }

    public void validateStringInput(final String input){
        for (int i = 0; i < input.length(); i++) {
            final Character sku = input.charAt(i);
            if(!SkuTypes.doesSkuTypeExist(sku))
                throw new UnexistentSkuException(sku);
        }
    }

}
