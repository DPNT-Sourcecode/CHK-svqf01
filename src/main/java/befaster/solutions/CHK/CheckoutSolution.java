package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

import befaster.solutions.CHK.inventoryitems.SkuTypes;

public class CheckoutSolution {
    public Integer checkout(String skus) {
    try{
        validateStringInput(skus);
    }
    catch (UnexistentSkuException e){
        System.out.println(e.getMessage());
        return -1;
    }

    final Map<Character, Integer> totalNumberOfItems = calculateTotalNumberOfItems(skus);




    return 0;
    }

    public void validateStringInput(final String input){
        for (int i = 0; i < input.length(); i++) {
            final Character sku = input.charAt(i);
            if(!SkuTypes.doesSkuTypeExist(sku))
                throw new UnexistentSkuException(sku);
        }
    }

    public Map<Character, Integer> calculateTotalNumberOfItems(final String input){
        final Map<Character, Integer> totalNumberOfItems = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            final Character sku = input.charAt(i);
            totalNumberOfItems.compute(sku, (k, v) -> {
                if(v == null){
                    return 1;
                }
                else{
                    return ++v;
                }
            });
        }

        return totalNumberOfItems;
    }

    public Map<Character, Integer> calculateTotalNumberOfItems(final Map<Character, Integer> totalNumberOfItems){
        final Integer billTotal = 0;

//        totalNumberOfItems.fo

        return totalNumberOfItems;
    }


}

