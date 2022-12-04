package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class ReqresBaseUrl {

    protected RequestSpecification spec;

    @BeforeEach//JunitJupiter annotation/JunitJupiter dependency new feature
    public void setUp(){

        spec= new RequestSpecBuilder().setBaseUri("https://reqres.in/api/").build();
    }

}
