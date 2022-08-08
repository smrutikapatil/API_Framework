package com.Framework.API.helpers;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.HttpStatus;
import com.Framework.API.constants.EndPoints;
import com.Framework.API.models.Person;
import com.Framework.API.utils.ConfigManagers;
import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PersonServiceHelpers {
	
	// We need to read the config variables
	// Rest Assured About the URL, port
	// Make a Get REQUEST on this url and send the data to TestGETPost
	
	private  static  final String BASE_URL = ConfigManagers.getInstance().getString("base_url");
    private  static  final String PORT = ConfigManagers.getInstance().getString("port");

    public PersonServiceHelpers(){

        RestAssured.baseURI = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();
        
    }

	public List<Person> getAllPosts() {
		
		Response response = RestAssured
				.given().log().all()
				.contentType(ContentType.JSON)
				.get(EndPoints.GET_ALL_POSTS)
				.andReturn();
		
		Type type = new TypeReference<List<Person>>() {}.getType();

		//assertEquals(response.statusCode(), HttpStatus.SC_OK, "OK");
		List<Person> personList = response.as(type);
		return personList;
	}

	public Response createPosts() {
		Person posts = new Person();
		posts.setId(15);
		posts.setTitle("java program");
		posts.setAuthor("joy");

		// Need to make a post call
		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.when()
				.body(posts)
				.post(EndPoints.CREATE_POSTS)
				.andReturn();
		//assertEquals(response.statusCode(), HttpStatus.SC_CREATED, "Created");
	    response.prettyPrint();
		return response;
	}

	public Response updatePosts(Integer id) {
		Person posts = new Person();
		posts.setId(15);
		posts.setTitle("java program");
		posts.setAuthor("joy");
		
		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.pathParam("id", id)
				.when()
				.body(posts)
				.patch(EndPoints.UPDATE_POSTS)
				.andReturn();
		assertTrue(response.getStatusCode() == HttpStatus.SC_OK);

		return response;
	}

	public Response deletePost(Integer id) {
		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.pathParam("id", id)
				.log().all()
				.when().delete(EndPoints.DELETE_POSTS)
				.andReturn();
				
		assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
		return response;
	}	
}
