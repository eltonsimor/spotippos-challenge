package br.com.spotippos.challenge.service;

import br.com.spotippos.challenge.service.dto.PropertyDTO;
import br.com.spotippos.challenge.service.dto.ProvinceDTO;

import java.io.Serializable;
import java.util.List;

/**
 * @author Elton Moraes
 * @since 04/08/2016.
 */
public interface SpotipposService extends Serializable{

    PropertyDTO saveProperty(PropertyDTO property);

    List<ProvinceDTO> findProvinces(long x, long y);

    PropertyDTO findPropertyByID(long id);

    ProvinceDTO saveProvince(ProvinceDTO province);

    List<ProvinceDTO> getAllProvinces();
}
