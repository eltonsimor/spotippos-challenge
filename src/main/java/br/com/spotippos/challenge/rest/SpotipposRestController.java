package br.com.spotippos.challenge.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
