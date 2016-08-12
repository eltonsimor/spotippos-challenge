package br.com.spotippos.challenge.rest;

import br.com.spotippos.challenge.exceptions.SpotipposException;
import br.com.spotippos.challenge.rest.request.PropertyRequest;
import br.com.spotippos.challenge.rest.response.ErrorResponse;
import br.com.spotippos.challenge.rest.response.PropertiesResponse;
import br.com.spotippos.challenge.rest.response.PropertyResponse;
import br.com.spotippos.challenge.service.SpotipposService;
import br.com.spotippos.challenge.service.dto.PropertiesDTO;
import br.com.spotippos.challenge.service.dto.PropertyDTO;
import br.com.spotippos.challenge.utils.ConverterUtils;
import org.dozer.MappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 * @author Elton Moraes
 * @since 04/08/2016.
 */
@RestController
public class SpotipposRestController {
    private static final Logger LOG = LoggerFactory.getLogger(SpotipposRestController.class);

    @Autowired
    private SpotipposService spotipposService;

    @RequestMapping(method = RequestMethod.GET)
    public String status(){
        return "Spotippos - Status OK";
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
            PropertyDTO property = ConverterUtils.convertTo(rq, PropertyDTO.class);
            PropertyDTO dto = spotipposService.saveProperty(property);
            response = (Response) ConverterUtils.convertTo(dto, PropertyResponse.class);
        } catch (SpotipposException | MappingException e) {
            LOG.error(e.getMessage(), e);
            response = (Response) new ErrorResponse(77777, "Erro ao salvar a propriedade. Verifique o contrato do request.");
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
            Integer id){

        Response response;
        try {
            PropertyDTO property = spotipposService.findPropertyByID(id);
            response = (Response) ConverterUtils.convertTo(property, PropertyResponse.class);
        } catch (SpotipposException | MappingException e) {
            LOG.error(e.getMessage(), e);
            response = (Response) new ErrorResponse(8888, "Não foi possível localizar a propriedade pelo o ID: " + id);
        }

        return  response;
    }

    @RequestMapping(
            value = "/properties",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public <Response> Response findPropertiesByRange(
            @Valid
            @RequestParam("ax")
            @NotNull(message = "{ax.notnull}")
            @Min(value = 0, message = "{ax.min}")
            @Max(value = 1400, message = "{ax.max}")
            Integer ax,
            @Valid
            @RequestParam("ay")
            @NotNull(message = "{ay.notnull}")
            @Min(value = 0, message = "{ay.min}")
            @Max(value = 1000, message = "{ay.max}")
            Integer ay,
            @Valid
            @RequestParam("bx")
            @NotNull(message = "{bx.notnull}")
            @Min(value = 0, message = "{bx.min}")
            @Max(value = 1400, message = "{bx.max}")
            Integer bx,
            @Valid
            @RequestParam("by")
            @NotNull(message = "{by.notnull}")
            @Min(value = 0, message = "{by.min}")
            @Max(value = 1000, message = "{by.max}")
            Integer by){

        Response response;
        try {
            PropertiesDTO propertiesDTO = spotipposService.findPropertiesByRange(ax, ay, bx, by);
            response = (Response) ConverterUtils.convertTo(propertiesDTO, PropertiesResponse.class);
        } catch (SpotipposException | MappingException e) {
            LOG.error(e.getMessage(), e);
            response = (Response) new ErrorResponse(9999, "Não foi possível localizar nenhuma propriedade no intervalo solicitado.");
        }

        return response;
    }



}
