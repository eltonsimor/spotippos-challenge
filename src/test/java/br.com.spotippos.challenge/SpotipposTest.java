package br.com.spotippos.challenge;


import br.com.spotippos.challenge.service.SpotipposService;
import br.com.spotippos.challenge.service.dto.*;
import br.com.spotippos.challenge.service.impl.SpotipposServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;


/**
 * @author Elton Moraes
 * @since 04/08/2016.
 */
public class SpotipposTest {

    private SpotipposService spotipposService;

    private final static String GODE = "Gode";
    private final static String RUJA = "Ruja";
    private final static String SCAVY = "Scavy";
    private final static String GROOLA = "Groola";
    private final static String JABY = "Jaby";
    private final static String NOVA = "Nova";

    @Before
    public void init(){
        spotipposService = new SpotipposServiceImpl();
        loadProvinces();
    }

    @Test
    public final void test_get_province_gode(){
        List<ProvinceDTO> provinces = spotipposService.findProvinces(399, 1000);

        assertEquals(provinces.size(), 1, 0);
        assertEquals(provinces.get(0).getName(), GODE);
    }

    @Test
    public final void test_get_province_ruja(){
        List<ProvinceDTO> provinces = spotipposService.findProvinces(601, 1000);

        assertEquals(provinces.size(), 1, 0);
        assertEquals(provinces.get(0).getName(), RUJA);
    }

    @Test
    public final void test_get_province_jaby(){
        List<ProvinceDTO> provinces = spotipposService.findProvinces(1101, 1000);

        assertEquals(provinces.size(), 1, 0);
        assertEquals(provinces.get(0).getName(), JABY);
    }

    @Test
    public final void test_get_province_scavy(){
        List<ProvinceDTO> provinces = spotipposService.findProvinces(0, 0);

        assertEquals(provinces.size(), 1, 0);
        assertEquals(provinces.get(0).getName(), SCAVY);
    }

    @Test
    public final void test_get_province_groola(){
        List<ProvinceDTO> provinces = spotipposService.findProvinces(601, 0);

        assertEquals(provinces.size(), 1, 0);
        assertEquals(provinces.get(0).getName(), GROOLA);
    }

    @Test
    public final void test_get_province_nova(){
        List<ProvinceDTO> provinces = spotipposService.findProvinces(801, 0);

        assertEquals(provinces.size(), 1, 0);
        assertEquals(provinces.get(0).getName(), NOVA);
    }


    @Test
    public final void test_save_property(){
        PropertyDTO mockDto = mockPropertyInGode();
        PropertyDTO dto = spotipposService.saveProperty(mockDto);

        assertTrue(dto.getId() > 0);
        assertEquals(mockDto.getBaths(), dto.getBaths(), 0);
        assertEquals(mockDto.getBeds(), dto.getBeds(), 0);
        assertEquals(mockDto.getX(), dto.getX(), 0);
        assertEquals(mockDto.getY(), dto.getY(), 0);
        assertEquals(mockDto.getPrice(), dto.getPrice(), 0);
        assertEquals(mockDto.getDescription(), dto.getDescription());
        assertEquals(mockDto.getTitle(), dto.getTitle());
    }

    @Test
    public final void test_get_property_in_gode(){
        PropertyDTO property = spotipposService.saveProperty(mockPropertyInGode());

        assertEquals(property.getProvinces().size(), 1);
        assertEquals(property.getProvinces().get(0).getName(), GODE);
    }

    @Test
    public final void test_get_property_in_gode_ruja_scavy_groola(){
        PropertyDTO property = spotipposService.saveProperty(mockPropertyInGodeRujaScavyGroola());

        assertEquals(property.getProvinces().size(), 4, 0);
        assertEquals(property.getProvinces().get(0).getName(), GODE);
        assertEquals(property.getProvinces().get(1).getName(), RUJA);
        assertEquals(property.getProvinces().get(2).getName(), SCAVY);
        assertEquals(property.getProvinces().get(3).getName(), GROOLA);

    }

    @Test
    public final void test_get_property_in_ruja_groola_nova(){

        PropertyDTO property = spotipposService.saveProperty(mockPropertyInRujaGroolaNova());

        assertEquals(property.getProvinces().size(), 3, 0);
        assertEquals(property.getProvinces().get(0).getName(), RUJA);
        assertEquals(property.getProvinces().get(1).getName(), GROOLA);
        assertEquals(property.getProvinces().get(2).getName(), NOVA);

    }

    @Test
    public final void test_get_property_in_ruja_jaby_nova(){
        PropertyDTO property = spotipposService.saveProperty(mockPropertyInRujaJabyNova());

        assertEquals(property.getProvinces().size(), 3, 0);
        assertEquals(property.getProvinces().get(0).getName(), RUJA);
        assertEquals(property.getProvinces().get(1).getName(), JABY);
        assertEquals(property.getProvinces().get(2).getName(), NOVA);
    }

    @Test
    public final void test_get_property_by_id(){
        PropertyDTO dto = mockPropertyInGode();
        spotipposService.saveProperty(dto);
        PropertyDTO propertyByID = spotipposService.findPropertyByID(1L);

        assertEquals(propertyByID.getId(), 1, 0);
        assertEquals(propertyByID.getDescription(), dto.getDescription());
        assertEquals(propertyByID.getTitle(), dto.getTitle());
        assertEquals(propertyByID.getBaths(), dto.getBaths(), 0);
        assertEquals(propertyByID.getBeds(), dto.getBeds(), 0);
        assertEquals(propertyByID.getPrice(), dto.getPrice(), 0);
        assertEquals(propertyByID.getSquareMeters(), dto.getSquareMeters(), 0);
        assertEquals(propertyByID.getProvinces().size(), dto.getProvinces().size(), 0);
        assertEquals(propertyByID.getProvinces().get(0).getName(), dto.getProvinces().get(0).getName());
        assertEquals(propertyByID.getProvinces().get(0).getBoundaries().getBottomRight().getX(),
                dto.getProvinces().get(0).getBoundaries().getBottomRight().getX(), 0);
        assertEquals(propertyByID.getProvinces().get(0).getBoundaries().getBottomRight().getY(),
                dto.getProvinces().get(0).getBoundaries().getBottomRight().getY(), 0);
        assertEquals(propertyByID.getProvinces().get(0).getBoundaries().getUpperLeft().getX(),
                dto.getProvinces().get(0).getBoundaries().getUpperLeft().getX(), 0);
        assertEquals(propertyByID.getProvinces().get(0).getBoundaries().getUpperLeft().getY(),
                dto.getProvinces().get(0).getBoundaries().getUpperLeft().getY(), 0);
    }

    @Test
    public final void test_get_properties_by_range(){
        PropertyDTO godeRujaScavyGroola = mockPropertyInGodeRujaScavyGroola();
        PropertyDTO gode = mockPropertyInGode();
        spotipposService.saveProperty(gode);
        spotipposService.saveProperty(godeRujaScavyGroola);
        PropertiesDTO properties = spotipposService.findPropertiesByRange(0, 500, 600, 1000);

        assertTrue(!properties.getProperties().isEmpty());
        assertTrue(properties.getFoundProperties() > 1);
    }

    private PropertyDTO mockPropertyInGode() {

        PropertyDTO property = spy(PropertyDTO.class);
        when(property.getBaths()).thenReturn(1);
        when(property.getBeds()).thenReturn(2);
        when(property.getPrice()).thenReturn(1250000D);
        when(property.getDescription()).thenReturn("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        when(property.getSquareMeters()).thenReturn(63L);
        when(property.getTitle()).thenReturn("Imóvel código 1, com 5 quartos e 4 banheiros");
        when(property.getX()).thenReturn(300L);
        when(property.getY()).thenReturn(1000L);

        return property;
    }

    private PropertyDTO mockPropertyInGodeRujaScavyGroola(){
        PropertyDTO property = spy(PropertyDTO.class);
        when(property.getBaths()).thenReturn(1);
        when(property.getBeds()).thenReturn(2);
        when(property.getPrice()).thenReturn(1250000D);
        when(property.getDescription()).thenReturn("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        when(property.getSquareMeters()).thenReturn(63L);
        when(property.getTitle()).thenReturn("Imóvel código 1, com 5 quartos e 4 banheiros");
        when(property.getX()).thenReturn(600L);
        when(property.getY()).thenReturn(500L);

        return property;
    }

    private PropertyDTO mockPropertyInRujaGroolaNova(){
        PropertyDTO property = spy(PropertyDTO.class);
        when(property.getBaths()).thenReturn(1);
        when(property.getBeds()).thenReturn(2);
        when(property.getPrice()).thenReturn(1250000D);
        when(property.getDescription()).thenReturn("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        when(property.getSquareMeters()).thenReturn(63L);
        when(property.getTitle()).thenReturn("Imóvel código 1, com 5 quartos e 4 banheiros");
        when(property.getX()).thenReturn(800L);
        when(property.getY()).thenReturn(500L);

        return property;
    }

    private PropertyDTO mockPropertyInRujaJabyNova(){
        PropertyDTO property = spy(PropertyDTO.class);
        when(property.getBaths()).thenReturn(1);
        when(property.getBeds()).thenReturn(2);
        when(property.getPrice()).thenReturn(1250000D);
        when(property.getDescription()).thenReturn("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        when(property.getSquareMeters()).thenReturn(63L);
        when(property.getTitle()).thenReturn("Imóvel código 1, com 5 quartos e 4 banheiros");
        when(property.getX()).thenReturn(1100L);
        when(property.getY()).thenReturn(500L);

        return property;
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
