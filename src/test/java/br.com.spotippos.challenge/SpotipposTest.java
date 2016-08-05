package br.com.spotippos.challenge;


import br.com.spotippos.challenge.service.SpotipposService;
import br.com.spotippos.challenge.service.dto.*;
import br.com.spotippos.challenge.service.impl.SpotipposServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.Mockito.*;


/**
 * Created by mtzcpd663 on 04/08/2016.
 */
public class SpotipposTest {

    @InjectMocks
    private SpotipposService spotipposService = new SpotipposServiceImpl();

    @Test
    public final void saveProperty(){
        PropertyDTO mockDto = mockProperty();
        PropertyDTO dto = spotipposService.saveProperty(mockDto);

        Assert.assertTrue(dto.getId() > 0);
        Assert.assertEquals(mockDto.getBaths(), dto.getBaths(), 0);
        Assert.assertEquals(mockDto.getBeds(), dto.getBeds(), 0);
        Assert.assertEquals(mockDto.getX(), dto.getX(), 0);
        Assert.assertEquals(mockDto.getY(), dto.getY(), 0);
        Assert.assertEquals(mockDto.getPrice(), dto.getPrice(), 0);
        Assert.assertEquals(mockDto.getDescription(), dto.getDescription());
        Assert.assertEquals(mockDto.getTitle(), dto.getTitle());
    }

    @Test
    public final void saveProvince(){
        ProvinceDTO mockDto = mockProvinceGode();
        ProvinceDTO dto = spotipposService.saveProvince(mockDto);

        Assert.assertEquals(mockDto.getName(), dto.getName());
        Assert.assertEquals(mockDto.getBoundaries().getBottomRight().getX(), dto.getBoundaries().getBottomRight().getX(), 0);
        Assert.assertEquals(mockDto.getBoundaries().getBottomRight().getY(), dto.getBoundaries().getBottomRight().getY(), 0);
        Assert.assertEquals(mockDto.getBoundaries().getUpperLeft().getX(), dto.getBoundaries().getUpperLeft().getX(), 0);
        Assert.assertEquals(mockDto.getBoundaries().getUpperLeft().getY(), dto.getBoundaries().getUpperLeft().getY(), 0);
    }

    private PropertyDTO mockProperty() {

        PropertyDTO mock = spy(PropertyDTO.class);
        when(mock.getBaths()).thenReturn(1);
        when(mock.getBeds()).thenReturn(2);
        when(mock.getPrice()).thenReturn(1250000D);
        when(mock.getDescription()).thenReturn("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        when(mock.getSquareMeters()).thenReturn(63L);
        when(mock.getTitle()).thenReturn("Imóvel código 1, com 5 quartos e 4 banheiros");
        when(mock.getX()).thenReturn(800L);
        when(mock.getY()).thenReturn(1200L);

        return mock;
    }

    private ProvinceDTO mockProvinceGode(){
        ProvinceDTO province = mock(ProvinceDTO.class);
        BoundariesDTO boundaries = mock(BoundariesDTO.class);
        UpperLeftDTO uppperleft = mock(UpperLeftDTO.class);
        BottomRightDTO bottomRight = mock(BottomRightDTO.class);

        when(province.getName()).thenReturn("Gode");
        when(province.getBoundaries()).thenReturn(boundaries);
        when(province.getBoundaries().getUpperLeft()).thenReturn(uppperleft);
        when(province.getBoundaries().getBottomRight()).thenReturn(bottomRight);
        when(province.getBoundaries().getUpperLeft().getX()).thenReturn(0L);
        when(province.getBoundaries().getUpperLeft().getY()).thenReturn(1000L);
        when(province.getBoundaries().getBottomRight().getX()).thenReturn(600L);
        when(province.getBoundaries().getBottomRight().getY()).thenReturn(500L);

        return province;
    }
}
