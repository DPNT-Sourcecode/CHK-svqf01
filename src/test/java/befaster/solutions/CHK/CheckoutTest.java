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
    }

}
