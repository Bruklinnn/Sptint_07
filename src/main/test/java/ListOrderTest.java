import Steps.ListOrderStep;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static java.util.Optional.empty;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

public class ListOrderTest extends LinkTest {
    private ListOrderStep listOrderStep;

    @Before
    public void setUp() {
        listOrderStep = new ListOrderStep();
    }

    @Test
    @DisplayName("Get orders list")
    public void getOrdersListTest() {
        listOrderStep.getOrders()
                .statusCode(200)
                .body("orders", is(not(empty())));
    }
}
