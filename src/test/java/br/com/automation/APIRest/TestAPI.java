package br.com.automation.APIRest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestAPI {
	
//	@Test
//	public void TestGet() {
//		String uriBase = "https://postman-echo.com/get";
//		
//		given() //Bloco de configuração da request
//		.relaxedHTTPSValidation() // Ignora o https
//		.param("foo1", "ba1")
//		.param("foo2", "bar2")
//		.when() // Bloco de envio
//		.get(uriBase)
//		.then() // Retornos da request
//		.statusCode(200)
//		.contentType(ContentType.JSON)
//		.body("headers.host", is("postman-echo.com"))  // A chave “host” possui exatamente o valor “postman-echo.com”
//		.body("args.foo1", containsString("ba")) //A chave “foo1” contém o valor “bar”
//		.body("args.foo2", is("bar2"));
//	}
	
	@Test
	public void TestPost() {
		
		String uriBase = "https://postman-echo.com/post";
		String json = "{\"foo1\":\"bar1\",\"foo2\":\"bar2,\"foo3\":\"bar3\"}";
		
		Response response = given() //Bloco de configuração da request
			.relaxedHTTPSValidation() // Ignora o https
			.contentType("application/json")
			.body(json)
		.when() // Bloco de envio
			.post(uriBase);
		
		System.out.println("Status: " + response.statusCode());
		System.out.println("JSON Data: " + response.path("data").toString());
		System.out.println("JSON Body: " + response.body().asString()); 
	}
	
}
