package br.com.spotippos.challenge;

import br.com.spotippos.challenge.config.Application;
import br.com.spotippos.challenge.service.SpotipposService;
import br.com.spotippos.challenge.service.dto.BottomRightDTO;
import br.com.spotippos.challenge.service.dto.BoundariesDTO;
import br.com.spotippos.challenge.service.dto.ProvinceDTO;
import br.com.spotippos.challenge.service.dto.UpperLeftDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;



/**
 * Created by mtzcpd663 on 10/08/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class SpotipposIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private SpotipposService spotipposService;

    private final static String GODE = "Gode";
    private final static String RUJA = "Ruja";
    private final static String SCAVY = "Scavy";
    private final static String GROOLA = "Groola";
    private final static String JABY = "Jaby";
    private final static String NOVA = "Nova";

    @Before
    public void init(){
        loadProvinces();
    }

    @Test
    public void testApplicationItsWorking() throws Exception{
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/spotippos/", String.class);

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(entity.getBody(), "Hello Spotippos");
        assertEquals(entity.getStatusCodeValue(),HttpStatus.OK.value());
    }

    @Test
    public void testSaveProperty() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("x",600);
        requestBody.put("y",500);
        requestBody.put("title","Imóvel código 1, com 5 quartos e 4 banheiros");
        requestBody.put("price", 1250000);
        requestBody.put("description","Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        requestBody.put("beds", 4);
        requestBody.put("baths", 3);
        requestBody.put("squareMeters", 210);
        HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(requestBody),headers);

        ResponseEntity<String> exchange = testRestTemplate.exchange("/spotippos/properties", HttpMethod.POST, entity, String.class);

        assertNotNull(exchange);
        assertEquals(exchange.getStatusCode(), HttpStatus.OK);
    }



    private void loadProvinces(){
        ProvinceDTO gode = spy(ProvinceDTO.class);
        BoundariesDTO boundariesGode = spy(BoundariesDTO.class);
        UpperLeftDTO uppperleftGode = spy(UpperLeftDTO.class);
        BottomRightDTO bottomRightGode = spy(BottomRightDTO.class);

        when(gode.getName()).thenReturn(GODE);
        when(gode.getBoundaries()).thenReturn(boundariesGode);
        when(gode.getBoundaries().getUpperLeft()).thenReturn(uppperleftGode);
        when(gode.getBoundaries().getBottomRight()).thenReturn(bottomRightGode);
        when(gode.getBoundaries().getUpperLeft().getX()).thenReturn(0L);
        when(gode.getBoundaries().getUpperLeft().getY()).thenReturn(1000L);
        when(gode.getBoundaries().getBottomRight().getX()).thenReturn(600L);
        when(gode.getBoundaries().getBottomRight().getY()).thenReturn(500L);


        ProvinceDTO ruja = spy(ProvinceDTO.class);
        BoundariesDTO boundariesRuja = spy(BoundariesDTO.class);
        UpperLeftDTO uppperleftRuja = spy(UpperLeftDTO.class);
        BottomRightDTO bottomRightRuja = spy(BottomRightDTO.class);

        when(ruja.getName()).thenReturn(RUJA);
        when(ruja.getBoundaries()).thenReturn(boundariesRuja);
        when(ruja.getBoundaries().getUpperLeft()).thenReturn(uppperleftRuja);
        when(ruja.getBoundaries().getBottomRight()).thenReturn(bottomRightRuja);
        when(ruja.getBoundaries().getUpperLeft().getX()).thenReturn(400L);
        when(ruja.getBoundaries().getUpperLeft().getY()).thenReturn(1000L);
        when(ruja.getBoundaries().getBottomRight().getX()).thenReturn(1100L);
        when(ruja.getBoundaries().getBottomRight().getY()).thenReturn(500L);


        ProvinceDTO scavy = spy(ProvinceDTO.class);
        BoundariesDTO boundariesScavy = spy(BoundariesDTO.class);
        UpperLeftDTO uppperleftScavy = spy(UpperLeftDTO.class);
        BottomRightDTO bottomRightScavy = spy(BottomRightDTO.class);

        when(scavy.getName()).thenReturn(SCAVY);
        when(scavy.getBoundaries()).thenReturn(boundariesScavy);
        when(scavy.getBoundaries().getUpperLeft()).thenReturn(uppperleftScavy);
        when(scavy.getBoundaries().getBottomRight()).thenReturn(bottomRightScavy);
        when(scavy.getBoundaries().getUpperLeft().getX()).thenReturn(0L);
        when(scavy.getBoundaries().getUpperLeft().getY()).thenReturn(500L);
        when(scavy.getBoundaries().getBottomRight().getX()).thenReturn(600L);
        when(scavy.getBoundaries().getBottomRight().getY()).thenReturn(0L);


        ProvinceDTO groola = spy(ProvinceDTO.class);
        BoundariesDTO boundariesGroola = spy(BoundariesDTO.class);
        UpperLeftDTO uppperleftGroola = spy(UpperLeftDTO.class);
        BottomRightDTO bottomRightGroola = spy(BottomRightDTO.class);

        when(groola.getName()).thenReturn(GROOLA);
        when(groola.getBoundaries()).thenReturn(boundariesGroola);
        when(groola.getBoundaries().getUpperLeft()).thenReturn(uppperleftGroola);
        when(groola.getBoundaries().getBottomRight()).thenReturn(bottomRightGroola);
        when(groola.getBoundaries().getUpperLeft().getX()).thenReturn(600L);
        when(groola.getBoundaries().getUpperLeft().getY()).thenReturn(500L);
        when(groola.getBoundaries().getBottomRight().getX()).thenReturn(800L);
        when(groola.getBoundaries().getBottomRight().getY()).thenReturn(0L);


        ProvinceDTO jaby = spy(ProvinceDTO.class);
        BoundariesDTO boundariesJaby = spy(BoundariesDTO.class);
        UpperLeftDTO uppperleftJaby = spy(UpperLeftDTO.class);
        BottomRightDTO bottomRightJaby = spy(BottomRightDTO.class);

        when(jaby.getName()).thenReturn(JABY);
        when(jaby.getBoundaries()).thenReturn(boundariesJaby);
        when(jaby.getBoundaries().getUpperLeft()).thenReturn(uppperleftJaby);
        when(jaby.getBoundaries().getBottomRight()).thenReturn(bottomRightJaby);
        when(jaby.getBoundaries().getUpperLeft().getX()).thenReturn(1100L);
        when(jaby.getBoundaries().getUpperLeft().getY()).thenReturn(1000L);
        when(jaby.getBoundaries().getBottomRight().getX()).thenReturn(1400L);
        when(jaby.getBoundaries().getBottomRight().getY()).thenReturn(500L);


        ProvinceDTO nova = spy(ProvinceDTO.class);
        BoundariesDTO boundariesNova = spy(BoundariesDTO.class);
        UpperLeftDTO uppperleftNova = spy(UpperLeftDTO.class);
        BottomRightDTO bottomRightNova = spy(BottomRightDTO.class);

        when(nova.getName()).thenReturn(NOVA);
        when(nova.getBoundaries()).thenReturn(boundariesNova);
        when(nova.getBoundaries().getUpperLeft()).thenReturn(uppperleftNova);
        when(nova.getBoundaries().getBottomRight()).thenReturn(bottomRightNova);
        when(nova.getBoundaries().getUpperLeft().getX()).thenReturn(800L);
        when(nova.getBoundaries().getUpperLeft().getY()).thenReturn(500L);
        when(nova.getBoundaries().getBottomRight().getX()).thenReturn(1400L);
        when(nova.getBoundaries().getBottomRight().getY()).thenReturn(0L);

        spotipposService.saveProvince(gode);
        spotipposService.saveProvince(ruja);
        spotipposService.saveProvince(scavy);
        spotipposService.saveProvince(groola);
        spotipposService.saveProvince(jaby);
        spotipposService.saveProvince(nova);
    }

}
