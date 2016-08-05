package br.com.spotippos.challenge.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Created by mtzcpd663 on 05/08/2016.
 */
public abstract class ConverterClazz {

    public static <T> T convertTo(Object source, Class<T> destinationClazz){
        Mapper mapper = new DozerBeanMapper();
        return mapper.map(source, destinationClazz);
    }

}
