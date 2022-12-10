package pet_store_smoke_test02;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;
import pojos.PetStoreInventoryPojo;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class S4Get02 extends PetStoreBaseUrl {
    /*
    Given
    https://petstore.swagger.io/v2/store/inventory
    When
        User sends Get request
    Then
        Status code is 200
    And
        Response body is like
                                {
                                    "sold": 1,
                                    "teststa5": 544,
                                    "string": 242,
                                    "unavailable": 2,
                                    "pending": 3,
                                    "available": 207
                                }
     */
    @Test
    public void get02() throws IOException {
        //Set the url
        spec.pathParams("first", "store", "second", "inventory");

        //Set the expected data
        PetStoreInventoryPojo expectedData = new PetStoreInventoryPojo(1, 437, 309, 2, 3, 247);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        PetStoreInventoryPojo actualData = new ObjectMapper().readValue(response.asString(), PetStoreInventoryPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
//        assertEquals(expectedData.getSold(), actualData.getSold());
//        assertEquals(expectedData.getTeststa5(), actualData.getTeststa5());
//        assertEquals(expectedData.getString(), actualData.getString());
//        assertEquals(expectedData.getUnavailable(), actualData.getUnavailable());
//        assertEquals(expectedData.getPending(), actualData.getPending());
//        assertEquals(expectedData.getAvailable(), actualData.getAvailable());




    }

}
