import io.restassured.RestAssured;
import org.junit.Before;

public class LinkTest {
    @Before
    public void setupRestAssured(){
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
    }
}
