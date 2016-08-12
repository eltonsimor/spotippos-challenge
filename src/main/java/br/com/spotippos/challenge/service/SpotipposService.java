package br.com.spotippos.challenge.service;

import br.com.spotippos.challenge.exceptions.SpotipposException;
import br.com.spotippos.challenge.service.dto.PropertiesDTO;
import br.com.spotippos.challenge.service.dto.PropertyDTO;
import br.com.spotippos.challenge.service.dto.ProvinceDTO;

import java.io.Serializable;
import java.util.List;

/**
 * @author Elton Moraes
 * @since 04/08/2016.
 */
public interface SpotipposService extends Serializable{

    PropertyDTO saveProperty(PropertyDTO property) throws SpotipposException;

    List<ProvinceDTO> findProvinces(long x, long y) throws SpotipposException;

    PropertyDTO findPropertyByID(long id) throws SpotipposException;

    ProvinceDTO saveProvince(ProvinceDTO province) throws SpotipposException;

    List<ProvinceDTO> getAllProvinces();

    PropertiesDTO findPropertiesByRange(final long ax, final long ay, final long bx, final long by) throws SpotipposException;
}
