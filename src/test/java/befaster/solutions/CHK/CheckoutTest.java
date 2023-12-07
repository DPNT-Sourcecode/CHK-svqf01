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
        assertThat(checkoutSolution.checkout("ABD-"), equalTo(-1));
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

        assertThat(checkoutSolution.checkout("FF"), equalTo(20));
    }

    @Test
    public void checkOutDiscounts() {
        assertThat(checkoutSolution.checkout("AAA"), equalTo(130));
        assertThat(checkoutSolution.checkout("BB"), equalTo(45));
        assertThat(checkoutSolution.checkout("ABB"), equalTo(95));
        assertThat(checkoutSolution.checkout("AAAB"), equalTo(160));
        assertThat(checkoutSolution.checkout("AAABB"), equalTo(175));

        assertThat(checkoutSolution.checkout("AAAAA"), equalTo(200));
        assertThat(checkoutSolution.checkout("EE"), equalTo(80));
        assertThat(checkoutSolution.checkout("AEAAAEA"), equalTo(280));

        assertThat(checkoutSolution.checkout("HHHHH"), equalTo(45));
        assertThat(checkoutSolution.checkout("HHHHHHHHHH"), equalTo(80));

        assertThat(checkoutSolution.checkout("KK"), equalTo(150));

        assertThat(checkoutSolution.checkout("PPPPP"), equalTo(200));

        assertThat(checkoutSolution.checkout("QQQ"), equalTo(80));

        assertThat(checkoutSolution.checkout("VV"), equalTo(90));
        assertThat(checkoutSolution.checkout("VVV"), equalTo(130));

    }

    @Test
    public void checkOutFreeItems() {
        assertThat(checkoutSolution.checkout("EEEEBB"), equalTo(160));
        assertThat(checkoutSolution.checkout("BEBEEE"), equalTo(160));

        assertThat(checkoutSolution.checkout("FFF"), equalTo(20));
        assertThat(checkoutSolution.checkout("FFFF"), equalTo(30));
        assertThat(checkoutSolution.checkout("FFFFFF"), equalTo(40));
        assertThat(checkoutSolution.checkout("FFFFF"), equalTo(40));
        assertThat(checkoutSolution.checkout("FFFFFF"), equalTo(40));

        assertThat(checkoutSolution.checkout("NNNM"), equalTo(120));

        assertThat(checkoutSolution.checkout("RRRQ"), equalTo(150));

        assertThat(checkoutSolution.checkout("UUUU"), equalTo(120));

    }


}



