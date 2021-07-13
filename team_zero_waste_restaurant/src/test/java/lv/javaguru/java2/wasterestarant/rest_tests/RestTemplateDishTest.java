package lv.javaguru.java2.wasterestarant.rest_tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lv.javaguru.java2.wasterestarant.core.domain.Dish;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class RestTemplateDishTest {

    private RestTemplate restTemplate;
    private static final String dishResourceUrl = "http://localhost:8080/dish";

    @Before
    public void beforeTest() {
        restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {

            }

            @Override
            public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {

            }
        });
    }

    @Test
    public void givenUrlWhenSendGetThenReturnStatusOk() {
        final ResponseEntity<Dish> responseEntity = restTemplate.getForEntity(dishResourceUrl + "/1", Dish.class);
        assert (responseEntity.getStatusCode().equals(HttpStatus.OK));
    }

    @Test
    public void givenUrlWhenSendGetRequestThenObjectCorrect() throws JsonProcessingException {
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<String> responseEntity = restTemplate.getForEntity(dishResourceUrl + "/1", String.class);

        final ObjectMapper mapper = new JsonMapper();
        final JsonNode root = mapper.readTree(String.valueOf(responseEntity.getBody()));
        final JsonNode name = root.path("name");
        assertThat (name.asText(), notNullValue());
    }

//    @Test
//    public void givenUrlWhenSendGetRequestFieldsThenReturnCorrect() {
//        final Dish dish = restTemplate.getForObject(dishResourceUrl + "/1", Dish.class);
//
//        assert dish != null;
//        assertThat(dish.getName(), notNullValue());
//        assertThat(dish.getDishID(), is(1L));
//    }
//
//    @Test
//    public void whenCallHeadersThenReceiveHeadersForThatUrl(){
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Content-Type", "application/json");
//                httpHeaders = restTemplate.headForHeaders(dishResourceUrl);
//        assertTrue(httpHeaders.getContentType()
//        .includes(MediaType.APPLICATION_JSON));
//    }
//
//    @Test
//    public void whenCreatingAnObjectThenItIsReturned () {
//        final HttpEntity<Dish> request = new HttpEntity<>(new Dish("soup","soup", "soup", 340, 6));
//        final Dish dish = restTemplate.postForObject(dishResourceUrl, request, Dish.class);
//        assertThat(dish, notNullValue());
//        assertThat(dish.getName(), is("soup"));
//    }
//
//    @Test
//    public void givenDishService_whenCallDelete_thenEntityIsDeleted() {
//        final Dish dish = new Dish("remove me","soup", "soup", 340, 6);
//        final ResponseEntity<Dish> response = restTemplate.postForEntity(dishResourceUrl, dish, Dish.class);
//        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
//
//        final String entityUrl = dishResourceUrl + "/" + response.getBody()
//                .getDishID();
//        restTemplate.delete(entityUrl);
//        try {
//            restTemplate.getForEntity(entityUrl, Dish.class);
//            fail();
//        } catch (final HttpClientErrorException ex) {
//            assertThat(ex.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
//        }
//    }
}
