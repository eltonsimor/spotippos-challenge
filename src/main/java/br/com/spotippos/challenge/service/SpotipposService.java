package br.com.spotippos.challenge.service;

import br.com.spotippos.challenge.service.dto.PropertyDTO;
import br.com.spotippos.challenge.service.dto.ProvinceDTO;

import java.util.List;

/**
 * Created by mtzcpd663 on 04/08/2016.
 */
public interface SpotipposService {

    PropertyDTO saveProperty(PropertyDTO property);

    List<ProvinceDTO> findProvinces(long x, long y);

    ProvinceDTO saveProvince(ProvinceDTO province);

    long getPropertyID();
}
