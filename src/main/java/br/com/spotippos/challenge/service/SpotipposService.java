package br.com.spotippos.challenge.service;

import br.com.spotippos.challenge.service.dto.PropertyDTO;
import br.com.spotippos.challenge.service.dto.ProvinceDTO;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mtzcpd663 on 04/08/2016.
 */
public interface SpotipposService extends Serializable{

    PropertyDTO saveProperty(PropertyDTO property);

    List<ProvinceDTO> findProvinces(long x, long y);

    ProvinceDTO saveProvince(ProvinceDTO province);

    long getPropertyID();
}
