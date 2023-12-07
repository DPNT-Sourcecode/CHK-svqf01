package befaster.solutions.HLO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import befaster.solutions.TST.One;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HelloWorldTest {

    private HelloSolution helloSolution;

    @BeforeEach
    public void name() {
        helloSolution = new HelloSolution();
    }

    @Test
    public void runHello() {
        assertThat(helloSolution.hello("wtv"), equalTo("Hello, wtv!"));
        assertThat(helloSolution.hello("John"), equalTo("Hello, John!"));
    }


}


