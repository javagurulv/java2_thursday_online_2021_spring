package lv.javaguru.java2.wasterestarant.rest_tests;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class RestTemplateProductTest {
    //This operates with the database that has been assigned to the web server (currently : zero_waste not zero_waste_test)
    //Incomplete
    //Cant find the cause of errors

    RestTemplate restTemplate = new RestTemplate();
    String productResourceUrl = "http://localhost:8080/product/";


//    @Test
//    public void AddTest() throws ParseException{
//
//
//        HttpEntity<Product> request = new HttpEntity<>(new Product("Apple",12.0,0.89,new SimpleDateFormat("dd,MM,YYYY").parse("16,07,2021")));
//        ResponseEntity<Product> response = restTemplate.exchange(productResourceUrl, HttpMethod.POST, request, Product.class);
//
//        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
//
//        Product product = response.getBody();
//
//        assertThat(product, notNullValue());
//        assertThat(product.getName(), is("Apple"));
//
//
//    }

    @Test
           public void testResponse() {
        ResponseEntity<String> response
                = restTemplate.getForEntity(productResourceUrl + "1", String.class);
        assertThat(response.getStatusCode(),  equalTo(HttpStatus.OK));
    }

    @Test
    public void getProductJsonTest() throws JsonProcessingException {
        //Manually add product with id 9
        //Unable to add products probably because of Date
        ResponseEntity<String> response = restTemplate.getForEntity(productResourceUrl + "9", String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode name = root.path("product").path("name");

        assert response != null;
        assertThat(name.asText(), is("aaa"));
    }


}
