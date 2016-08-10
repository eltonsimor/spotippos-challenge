package br.com.spotippos.challenge.rest;

import br.com.spotippos.challenge.config.Converter;
import br.com.spotippos.challenge.rest.request.PropertyRequest;
import br.com.spotippos.challenge.rest.response.ErrorResponse;
import br.com.spotippos.challenge.rest.response.PropertyResponse;
import br.com.spotippos.challenge.service.SpotipposService;
import br.com.spotippos.challenge.service.dto.PropertyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


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
    public <Response> Response saveProperty(
             @Valid
             @RequestBody
             PropertyRequest rq){
        Response response;
        try {
            PropertyDTO property = Converter.convertTo(rq, PropertyDTO.class);
            PropertyDTO dto = spotipposService.saveProperty(property);
            response = (Response) Converter.convertTo(dto, PropertyResponse.class);
        } catch (Exception e) {
            response = (Response) new ErrorResponse(77777,"Erro ao salvar a propriedade. Verifique o contrato do request.");
        }

        return response;
    }

    @RequestMapping(
            value = "/properties/{id}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public <Response> Response findPropertyByID(
            @Valid
            @PathVariable("id")
            @Min(value = 0, message = "{id.min}")
            @NotNull(message = "{id.notnull}")
            long id){

        Response response;
        try {
            PropertyDTO property = spotipposService.findPropertyByID(id);
            response = (Response) Converter.convertTo(property, PropertyResponse.class);
        } catch (Exception e) {
            response = (Response) new ErrorResponse(8888,"Erro ao buscar Propriedade por ID");
        }

        return  response;
    }

}
