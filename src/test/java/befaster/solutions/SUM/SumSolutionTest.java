package befaster.solutions.SUM;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

public class SumSolutionTest {
    private SumSolution sum;

    @BeforeEach
    public void setUp() {
        sum = new SumSolution();
    }

    @Test
    public void compute_sum() {
        assertThat(sum.compute(1, 1), equalTo(2));
    }

    @Test
    public void compute_sum_invalid_digits(){
        //over 100
        Assertions.assertThrows(RuntimeException.class, () -> sum.compute(101, 5));
        Assertions.assertThrows(RuntimeException.class,()->  sum.compute(5, 101));
        Assertions.assertThrows(RuntimeException.class,()->  sum.compute(101, 101));

        //under 0
        Assertions.assertThrows(RuntimeException.class,()->  sum.compute(-5, 1));
        Assertions.assertThrows(RuntimeException.class,()->  sum.compute(1, -5));
        Assertions.assertThrows(RuntimeException.class,()->  sum.compute(-5, -5));

        //over 100 and under 0
        Assertions.assertThrows(RuntimeException.class,()->  sum.compute(101, -5));
    }


}


