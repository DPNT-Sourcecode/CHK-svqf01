package befaster.solutions.SUM;

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
        assert(sum.compute(101, 5), instanceOf(RuntimeException.class));
        assertThat(sum.compute(5, 101), instanceOf(RuntimeException.class));
        assertThat(sum.compute(101, 101), instanceOf(RuntimeException.class));

        assertThat(sum.compute(-5, 1), instanceOf(RuntimeException.class));
        assertThat(sum.compute(1, -5), instanceOf(RuntimeException.class));
        assertThat(sum.compute(-5, -5), instanceOf(RuntimeException.class));

        assertThat(sum.compute(101, -5), instanceOf(RuntimeException.class));


    }


}

