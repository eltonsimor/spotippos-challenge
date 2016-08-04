package br.com.spotippos.challenge;

import br.com.spotippos.challenge.service.SpotipposService;
import br.com.spotippos.challenge.service.dto.PropertyDTO;
import br.com.spotippos.challenge.service.impl.SpotipposServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mtzcpd663 on 04/08/2016.
 */
public class SpotipposTest {

    private SpotipposService spotipposService;

    @Before
    public void init(){
        spotipposService = new SpotipposServiceImpl();
    }

    @Test
    public final void saveProperty(){
        PropertyDTO mockdto = spotipposService.saveProperty(mockProperty());
        PropertyDTO mockdto2 = spotipposService.saveProperty(mockProperty());

        Assert.assertTrue(mockdto.getId() > 0);
        Assert.assertTrue(mockdto2.getId() > mockdto.getId());
    }

    private PropertyDTO mockProperty() {
        PropertyDTO dto = new PropertyDTO();
        dto.setBaths(1);
        dto.setBeds(2);
        dto.setSquareMeters(63);
        dto.setX(800);
        dto.setY(1200);
        return dto;
    }
}
