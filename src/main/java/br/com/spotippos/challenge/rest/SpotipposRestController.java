package br.com.spotippos.challenge.rest;

import br.com.spotippos.challenge.config.Converter;
import br.com.spotippos.challenge.rest.request.PropertyRequest;
import br.com.spotippos.challenge.rest.response.PropertyResponse;
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

        PropertyResponse response = Converter.convertTo(rq, PropertyResponse.class);

        return response;
    }


}
