package br.com.spotippos.challenge.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Created by mtzcpd663 on 05/08/2016.
 */
public abstract class Converter {

    private final static Mapper mapper;

    static {
        mapper = new DozerBeanMapper();
    }

    public static <T> T convertTo(Object source, Class<T> destinationClazz){
        return mapper.map(source, destinationClazz);
    }

}
