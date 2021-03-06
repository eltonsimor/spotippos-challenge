package br.com.spotippos.challenge;

import br.com.spotippos.challenge.config.Application;
import br.com.spotippos.challenge.service.dto.PropertiesDTO;
import br.com.spotippos.challenge.service.dto.PropertyDTO;
import br.com.spotippos.challenge.task.LoadDataTask;
import br.com.spotippos.challenge.utils.ConverterUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

import static org.junit.Assert.*;



/**
 * @author Elton Moraes
 * @since 10/08/2016.
 */
@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class SpotipposIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private Gson gson;

    @Autowired
    private LoadDataTask task;

    private HttpHeaders headers;

    private final static String GODE = "Gode";
    private final static String RUJA = "Ruja";
    private final static String SCAVY = "Scavy";
    private final static String GROOLA = "Groola";
    private final static String JABY = "Jaby";
    private final static String NOVA = "Nova";

    @Before
    public void init(){
        headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        task.loadStoredData();
    }

    @Test
    public void test_application_its_working() throws Exception{
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/spotippos/", String.class);

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertTrue(entity.getBody().contains("OK"));
    }

    @Test
    public void test_save_property() throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> requestBody = requestPropertyInGodeRujaScavyGroola();
        HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(requestBody),headers);

        ResponseEntity<String> exchange = testRestTemplate.exchange("/spotippos/properties", HttpMethod.POST, entity, String.class);
        LinkedTreeMap response = gson.fromJson(exchange.getBody(), LinkedTreeMap.class);

        assertNotNull(exchange);
        assertEquals(exchange.getStatusCode(), HttpStatus.OK);
        assertTrue(!response.get("id").equals(0D));
        assertEquals(((Double) response.get("x")).intValue(), requestBody.get("x"));
        assertEquals(((Double) response.get("y")).intValue(), requestBody.get("y"));
        assertEquals(((Double) response.get("beds")).intValue(), requestBody.get("beds"));
        assertEquals(((Double) response.get("baths")).intValue(), requestBody.get("baths"));
        assertEquals(((Double) response.get("squareMeters")).intValue(), requestBody.get("squareMeters"));
        assertEquals(response.get("price"), requestBody.get("price"));
        assertEquals(response.get("title"), requestBody.get("title"));
        assertEquals(response.get("description"), requestBody.get("description"));
        assertTrue(((List) response.get("provinces")).size() == 4);
        assertTrue(((List) response.get("provinces")).contains(GODE));
        assertTrue(((List) response.get("provinces")).contains(RUJA));
        assertTrue(((List) response.get("provinces")).contains(SCAVY));
        assertTrue(((List) response.get("provinces")).contains(GROOLA));
    }

    @Test
    public void test_get_property_in_nova() throws Exception{
        ResponseEntity<String> entity = testRestTemplate.exchange("/spotippos/properties/700", HttpMethod.GET, new HttpEntity<>(headers), String.class);
        LinkedHashMap response = gson.fromJson(entity.getBody(), LinkedHashMap.class);

        assertEquals(entity.getStatusCode(), HttpStatus.OK);
        assertEquals(response.get("id"), 700D);
        assertEquals(response.get("x"), 1107D);
        assertEquals(response.get("y"), 39D);
        assertEquals(response.get("price"), 1380000D);
        assertEquals(response.get("beds"), 5D);
        assertEquals(response.get("baths"), 4D);
        assertEquals(response.get("squareMeters"), 135D);
        assertTrue(((List) response.get("provinces")).size() == 1);
        assertEquals(response.get("title"), "Imóvel código 700, com 5 quartos e 4 banheiros.");
        assertEquals(response.get("description"), "Do cillum sit tempor laborum enim. Cupidatat quis elit non aliqua ut irure.");
        assertTrue(((List) response.get("provinces")).contains(NOVA));
    }

    @Test
    public void test_get_property_in_jaby() throws Exception{
        ResponseEntity<String> entity = testRestTemplate.exchange("/spotippos/properties/990", HttpMethod.GET, new HttpEntity<>(headers), String.class);
        LinkedHashMap response = gson.fromJson(entity.getBody(), LinkedHashMap.class);

        assertEquals(entity.getStatusCode(), HttpStatus.OK);
        assertEquals(response.get("id"), 990D);
        assertEquals(response.get("x"), 1231D);
        assertEquals(response.get("y"), 606D);
        assertEquals(response.get("price"), 705000D);
        assertEquals(response.get("beds"), 3D);
        assertEquals(response.get("baths"), 2D);
        assertEquals(response.get("squareMeters"), 67D);
        assertTrue(((List) response.get("provinces")).size() == 1);
        assertEquals(response.get("title"), "Imóvel código 990, com 3 quartos e 2 banheiros.");
        assertEquals(response.get("description"), "Dolore aliquip aliqua est laboris commodo qui aliqua nostrud. Consectetur aliquip adipisicing proident nisi ex pariatur pariatur aute.");
        assertTrue(((List) response.get("provinces")).contains(JABY));
    }

    @Test
    public void test_get_properties_by_range() throws Exception{
        UriComponentsBuilder baseUrl = UriComponentsBuilder.fromUriString("/spotippos/properties");
        baseUrl.queryParam("ax", 0);
        baseUrl.queryParam("ay", 0);
        baseUrl.queryParam("bx", 50);
        baseUrl.queryParam("by", 10);

        ResponseEntity<String> exchange = testRestTemplate.exchange(baseUrl.build().encode().toUri().toString(), HttpMethod.GET, new HttpEntity<>(headers), String.class);
        LinkedHashMap linkedHashMap = gson.fromJson(exchange.getBody(), LinkedHashMap.class);
        PropertiesDTO propertiesDTO = new PropertiesDTO();

        propertiesDTO.setFoundProperties(Double.doubleToLongBits((Double) linkedHashMap.get("foundProperties")));
        propertiesDTO.setProperties(new ArrayList<>());
        List properties = (ArrayList)linkedHashMap.get("properties");

        properties.stream().forEach(p -> propertiesDTO.getProperties().add(ConverterUtils.convertTo(p, PropertyDTO.class)));


        assertEquals(exchange.getStatusCode(), HttpStatus.OK);
        assertTrue(propertiesDTO.getFoundProperties() > 1);
        assertTrue(!propertiesDTO.getProperties().get(0).getProvinces().isEmpty());
        assertTrue(!propertiesDTO.getProperties().get(1).getProvinces().isEmpty());
        assertTrue(!propertiesDTO.getProperties().get(2).getProvinces().isEmpty());
        assertEquals(propertiesDTO.getProperties().get(0).getProvinces().get(0), SCAVY);
        assertEquals(propertiesDTO.getProperties().get(1).getProvinces().get(0), SCAVY);
        assertEquals(propertiesDTO.getProperties().get(2).getProvinces().get(0), SCAVY);


    }

    private Map<String, Object> requestPropertyInGodeRujaScavyGroola(){
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("x",600);
        requestBody.put("y",500);
        requestBody.put("title","Imóvel código 1, com 5 quartos e 4 banheiros");
        requestBody.put("price", 1250000D);
        requestBody.put("description","Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        requestBody.put("beds", 4);
        requestBody.put("baths", 3);
        requestBody.put("squareMeters", 210);

        return requestBody;
    }

}
