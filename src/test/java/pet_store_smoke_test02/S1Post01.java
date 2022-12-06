package pet_store_smoke_test02;

import base_urls.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;
import pojos.PetStoreStorePojo;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class S1Post01 extends PetStoreBaseUrl {
    /*Type an automation smoke test by using https://petstore.swagger.io/v2/ documentation.
     Create a pet store then read and delete the store you created.
    */
    /*
    Given
            https://petstore.swagger.io/v2/store/order
    And
                    {
            "id": 444666,
            "petId": 1569,
            "quantity": 12,
            "shipDate": "2022-11-15T17:59:36.177+0000",
            "status": "placed",
            "complete": true
        }
     When
            user sends Post request
     Then
            Status Code must be 200
     And
            the response body must be like the following
                        {
                "id": 444666,
                "petId": 1569,
                "quantity": 12,
                "shipDate": "2022-11-15T17:59:36.177+0000",
                "status": "placed",
                "complete": true
            }

     */
    @Test
    public void post01() throws IOException {
        //Set the url
        spec.pathParams("first", "store", "second", "order");

        //Set the expected data
        PetStoreStorePojo expectedData = new PetStoreStorePojo(444666,1569, 12, "2022-11-15T17:59:36.177+0000", "placed", true);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        PetStoreStorePojo actualData = new ObjectMapper().readValue(response.asString(), PetStoreStorePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getPetId(), actualData.getPetId());
        assertEquals(expectedData.getQuantity(), actualData.getQuantity());
        assertEquals(expectedData.getShipDate(), actualData.getShipDate());
        assertEquals(expectedData.getStatus(), actualData.getStatus());
        assertEquals(expectedData.isComplete(), actualData.isComplete());

    }

}
