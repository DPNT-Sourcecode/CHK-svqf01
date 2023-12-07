package befaster.solutions.CHK;

import java.util.Map;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {


    Map<Character, Integer> prices = Map.of('A', 50, 'B', 30, 'C', 20, 'D', 15);

    public Integer checkout(String skus) {
    try{
        validateStringInput(skus);
    }
    catch (UnexistentSkuException e){
        System.out.println(e.getMessage());
        return -1;
    }
    return 0;
    }


    public void validateStringInput(final String input){
        for (int i = 0; i < input.length(); i++) {
            final Character sku = input.charAt(i);
            if(!prices.containsKey(sku))
                throw new UnexistentSkuException(sku);
        }
    }


}

