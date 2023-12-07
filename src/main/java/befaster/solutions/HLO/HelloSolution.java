package befaster.solutions.HLO;

import befaster.runner.SolutionNotImplementedException;

public class HelloSolution {

    private static final String HELLO_TO_THE_WORLD_MESSAGE = "Hello, %s!";

    public String hello(String friendName) {
        return HELLO_TO_THE_WORLD_MESSAGE.formatted(friendName);
    }
}


