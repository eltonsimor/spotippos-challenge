package br.com.spotippos.challenge.rest;

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
        PropertyResponse response = new PropertyResponse();
        response.setBaths(rq.getBaths());
        response.setBeds(rq.getBeds());
        response.setDescription(rq.getDescription());
        response.setPrice(rq.getPrice());
        response.setSquareMeters(rq.getSquareMeters());
        response.setTitle(rq.getTitle());
        response.setX(rq.getX());
        response.setY(rq.getY());

        return response;
    }


}
