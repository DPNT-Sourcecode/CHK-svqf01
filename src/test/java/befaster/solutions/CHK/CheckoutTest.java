package befaster.solutions.CHK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutTest {

    private CheckoutSolution checkoutSolution;

    @BeforeEach
    public void name() {
        checkoutSolution = new CheckoutSolution();
    }


    @Test
    public void checkoutInvalidInput() {
        assertThat(checkoutSolution.checkout("ABDL"), equalTo(-1));
        assertThat(checkoutSolution.checkout("123"), equalTo(-1));
        assertThat(checkoutSolution.checkout("ABD3"), equalTo(-1));
    }

    @Test
    public void checkOutNoDiscounts() {
        assertThat(checkoutSolution.checkout("AA"), equalTo(100));
        assertThat(checkoutSolution.checkout("A"), equalTo(50));
        assertThat(checkoutSolution.checkout("AB"), equalTo(80));
        assertThat(checkoutSolution.checkout("ABA"), equalTo(130));
        assertThat(checkoutSolution.checkout("ABCD"), equalTo(115));
    }

    @Test
    public void checkOutDiscounts() {
        assertThat(checkoutSolution.checkout("AAA"), equalTo(130));
        assertThat(checkoutSolution.checkout("BB"), equalTo(45));
        assertThat(checkoutSolution.checkout("ABB"), equalTo(95));
        assertThat(checkoutSolution.checkout("AAAB"), equalTo(160));
        assertThat(checkoutSolution.checkout("AAABB"), equalTo(175));
    }


}




