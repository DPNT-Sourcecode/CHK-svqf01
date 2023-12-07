package befaster.solutions.SUM;

import befaster.runner.SolutionNotImplementedException;

@SuppressWarnings("unused")
public class SumSolution {

    public int compute(int x, int y) {
        validateInput(x);
        validateInput(y);
        return x + y;
    }

    private void validateInput(int input){
        if(input < 0 || input > 100)
            throw new RuntimeException();
    }

}

