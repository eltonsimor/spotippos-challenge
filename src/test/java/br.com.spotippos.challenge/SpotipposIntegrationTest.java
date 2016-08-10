package br.com.spotippos.challenge;

import br.com.spotippos.challenge.config.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;



/**
 * Created by mtzcpd663 on 10/08/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class SpotipposIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testApplicationItsWorking() throws Exception{
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/spotippos/", String.class);

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(entity.getBody(), "Hello Spotippos");
        assertEquals(entity.getStatusCodeValue(),HttpStatus.OK.value());
    }

}
