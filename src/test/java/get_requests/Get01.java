package get_requests;

import io.restassured.response.Response;
import org.apache.commons.lang3.builder.ToStringExclude;

import static io.restassured.RestAssured.given;

public class Get01 {
    /*
   Given
       https://petstore.swagger.io/v2/pet/12
   When
       User sends a GET Request to the url
   Then
       HTTP Status Code should be 200
   And
       Content Type should be JSON
   And
       Status Line should be HTTP/1.1 200 OK
*/

    public static void main(String[] args) {
        //Set the url
        String url= "https://petstore.swagger.io/v2/pet/12";
        
        //Set the expected data 
        
        //Send the request and get the response
        //Note: To send request and get response we use RestAssured Library
        Response response = given().when().get(url);
        response.prettyPrint();
        
        //Do Assertion

        //HTTP Status Code should be 200
        if(response.statusCode()==200){
            System.out.println("Test Passed: Status Code is 200");
        }else{
            System.out.println("Test Failed: Status Code " + response.statusCode());
        }

        //Junit and Testng Libraries are very useful for the automation test. Without those libraries, we are able only to test manually.

        //Content Type should be JSON
        if(response.contentType().equals("application/json")){
            System.out.println("Test Passed: Content Type is " + response.contentType());
        }else{
            System.out.println("Test failed: Content TYpe is " + response.contentType());
        }

        //Status Line should be HTTP/1.1 200 OK
        if(response.statusLine().equals("HTTP/1.1 200 OK")){
            System.out.println("Test Passes: Status Line is " + response.statusLine());
            //System.out.println("Test Passes: Status Line is HTTP/1.1 200 OK");
        }else{
            System.out.println("Test Failed: Status Line is " + response.statusLine());
        }
    }

}
