import Models.Orders;
import Steps.CreatedOrderStep;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class OrderParamCreateTest extends LinkTest {
    private final Orders orders;
    private CreatedOrderStep createOrderStep;

    public OrderParamCreateTest (Orders orders) {
        this.orders = orders;
    }

    @Parameterized.Parameters(name = "Test {index}: Test with colors={0}")
    public static Object[][] getColorData() {
        return new Object[][]{
                {new Orders("Аид", "Кроносон", "правый берег Леты", "1",
                        "+1234567890", 5, "2024-07-07", "Comment", new String[]{"BLACK"})},
                {new Orders("Зевс", "Кроносон", "Олимпия 777", "2",
                        "+1234567890", 5, "2024-07-07", "Comment", new String[]{"GREY"})},
                {new Orders("Посейдон", "Кроносон", "Антлантческая 1", "3",
                        "+1234567890", 5, "2024-07-07", "Comment", new String[]{"BLACK", "GREY"})},
                {new Orders("Арес", "Олимпийский", "Марсово поле 1", "4",
                        "+1234567890", 5, "2024-07-07", "Comment", new String[]{})}
        };
    }

    @Before
    public void setUp() {
        createOrderStep = new CreatedOrderStep();
    }

    @After
    public void tearDown() {
        if (orders.getTrack() != null) {
            createOrderStep.cancelOrder(orders);
        }
    }

    @Test
    @DisplayName("Create order with different colors")
    public void createOrderTest() {
        createOrderStep.createOrder(orders)
                .statusCode(201)
                .body("track", notNullValue());
    }
}