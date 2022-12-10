package pet_store_smoke_test_insingleclass;

import base_urls.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.*;
import pojos.Category;
import pojos.PetStorePetPojo;
import pojos.PetStoreUserResponsePojo;
import pojos.Tags;

import java.io.IOException;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class S1_Post extends PetStoreBaseUrl {
    /*
Given
    https://petstore.swagger.io/v2/pet
And
    {
      "id": 1234321,
      "category": {
        "id": 0,
        "name": "Cat"
      },
      "name": "Pamuk",
      "photoUrls": [
        "string"
      ],
      "tags": [
        {
          "id": 0,
          "name": "My cute cat"
        }
      ],
      "status": "available"
    }
When
    User sends Post request

Then
    Http Status code is 200

And
    Response body is like: {
                            "id": 1234321,
                            "category": {
                                "id": 0,
                                "name": "Cat"
                            },
                            "name": "Pamuk",
                            "photoUrls": [
                                "string"
                            ],
                            "tags": [
                                {
                                    "id": 0,
                                    "name": "My cute cat"
                                }
                            ],
                            "status": "available"
                        }
 */

    @Test
    @Order(1)
    public void post01() throws IOException {
        //Set the url
        spec.pathParam("first", "pet");

        //Set the expected data
        Category category = new Category(0,"Cat");
        Tags tags = new Tags(0,"My cute cat");
        ArrayList<String > arrayList = new ArrayList<>();
        arrayList.add("string");
        ArrayList<Tags> arrayListTags = new ArrayList<>();
        arrayListTags.add(tags);

        PetStorePetPojo expectedData = new PetStorePetPojo(1234321,category,"Pamuk",arrayList,arrayListTags,"available");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //Do assertion
        PetStorePetPojo actualData = new ObjectMapper().readValue(response.asString(), PetStorePetPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(category.getId(), actualData.getCategory().getId());
        assertEquals(category.getName(), actualData.getCategory().getName());
        assertEquals(expectedData.getName(), actualData.getName());
        assertEquals(expectedData.getPhotoUrls(), actualData.getPhotoUrls());
        assertEquals(tags.getId(), actualData.getTags().get(0).getId());
        assertEquals(tags.getName(), actualData.getTags().get(0).getName());
        assertEquals(expectedData.getStatus(), actualData.getStatus());


    }

    @Test
    @Order(2)
    public void put01() throws IOException {
        //Set the url
        spec.pathParam("first", "pet");

        //Set the expected data
        Category category = new Category(0, "Cat");
        Tags tags = new Tags(0, "My cute cat");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("string");
        ArrayList<Tags> tagsArrayList = new ArrayList<>();
        tagsArrayList.add(tags);

        PetStorePetPojo expectedData = new PetStorePetPojo(1234321, category, "Cotton", arrayList, tagsArrayList,  "available" );
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().put("/{first}");
        response.prettyPrint();

        //Do Assertion
        PetStorePetPojo actualData = new ObjectMapper().readValue(response.asString(), PetStorePetPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(category.getId(), actualData.getCategory().getId());
        assertEquals(category.getName(), actualData.getCategory().getName());
        assertEquals(expectedData.getName(), actualData.getName());
        assertEquals(expectedData.getPhotoUrls(), actualData.getPhotoUrls());
        assertEquals(tags.getId(), actualData.getTags().get(0).getId());
        assertEquals(tags.getName(), actualData.getTags().get(0).getName());
        assertEquals(expectedData.getStatus(), actualData.getStatus());

    }
    @Test
    @Order(3)
    public void get01(){
        //Set the url
        spec.pathParams("first", "pet", "second", "findByStatus").
                queryParam("status", "available");

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        response.then().
                assertThat().
                statusCode(200).
                body("id", hasSize(greaterThan(30)),
                        "name", hasItems("doggie", "fish"));




    }

    @Test
    @Order(4)
    public void get02() throws IOException {
        //Set the url
        spec.pathParams("first", "pet", "second", 1234321);

        //Set the expected data
        Category category = new Category(0, "Cat");
        Tags tags = new Tags(0, "My cute cat");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("string");
        ArrayList<Tags> tagsArrayList = new ArrayList<>();
        tagsArrayList.add(tags);

        PetStorePetPojo expectedData = new PetStorePetPojo(1234321, category, "Cotton", arrayList, tagsArrayList,  "available" );
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        PetStorePetPojo actualData = new ObjectMapper().readValue(response.asString(), PetStorePetPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(category.getId(), actualData.getCategory().getId());
        assertEquals(category.getName(), actualData.getCategory().getName());
        assertEquals(expectedData.getName(), actualData.getName());
        assertEquals(expectedData.getPhotoUrls(), actualData.getPhotoUrls());
        assertEquals(tags.getId(), actualData.getTags().get(0).getId());
        assertEquals(tags.getName(), actualData.getTags().get(0).getName());
        assertEquals(expectedData.getStatus(), actualData.getStatus());


    }

    @Test
    @Order(5)
    public void delete01() throws IOException {
        //Set the url
        spec.pathParams("first", "pet", "second", 1234321);

        //Set the expected data
        PetStoreUserResponsePojo expectedData = new PetStoreUserResponsePojo(200, "unknown", "1234321");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        PetStoreUserResponsePojo actualData = new ObjectMapper().readValue(response.asString(), PetStoreUserResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getCode(), actualData.getCode());
        assertEquals(expectedData.getType(), actualData.getType());
        assertEquals(expectedData.getMessage(), actualData.getMessage());

    }

    @Test
    @Order(6)
    public void get03() throws IOException {
        //Set the url
        spec.pathParams("first", "pet", "second", 1234321);

        //Set the expected data
        PetStoreUserResponsePojo expectedData = new PetStoreUserResponsePojo(1, "error", "Pet not found");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        PetStoreUserResponsePojo actualData = new ObjectMapper().readValue(response.asString(), PetStoreUserResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(404, response.statusCode());
        assertEquals(expectedData.getCode(), actualData.getCode());
        assertEquals(expectedData.getType(), actualData.getType());
        assertEquals(expectedData.getMessage(), actualData.getMessage());

    }

}
