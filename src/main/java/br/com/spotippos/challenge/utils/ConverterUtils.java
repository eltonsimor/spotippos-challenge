package br.com.spotippos.challenge.utils;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * @author Elton Moraes
 * @since 05/08/2016.
 */
public abstract class ConverterUtils {

    private final static Mapper mapper;

    static {
        mapper = new DozerBeanMapper();
    }

    public static <T> T convertTo(Object source, Class<T> destinationClazz){
        return mapper.map(source, destinationClazz);
    }

}
