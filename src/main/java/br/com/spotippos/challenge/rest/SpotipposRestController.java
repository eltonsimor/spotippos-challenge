package br.com.spotippos.challenge.rest;

import br.com.spotippos.challenge.config.Converter;
import br.com.spotippos.challenge.rest.request.PropertyRequest;
import br.com.spotippos.challenge.rest.response.PropertyResponse;
import br.com.spotippos.challenge.service.SpotipposService;
import br.com.spotippos.challenge.service.dto.PropertyDTO;
import br.com.spotippos.challenge.service.impl.SpotipposServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by mtzcpd663 on 04/08/2016.
 */
@RestController
@RequestMapping
public class SpotipposRestController {

    @Autowired
    private SpotipposService spotipposService;

    @RequestMapping(method = RequestMethod.GET)
    public String hello(){
        return "Hello Spotippos";
    }


    @RequestMapping(
            value = "/properties",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public PropertyResponse saveProperty(@Valid
                                         @RequestBody
                                         PropertyRequest rq){

        PropertyDTO property = Converter.convertTo(rq, PropertyDTO.class);
        PropertyDTO dto = spotipposService.saveProperty(property);

        PropertyResponse response = Converter.convertTo(dto, PropertyResponse.class);

        return response;
    }




}
