package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;
import com.groupa.ssi.response.personalprotectionequipment.PpeResponse;
import com.groupa.ssi.services.personalprotectionequipment.PpeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
@Api(
        tags = PpeAbstractController.TAG_NAME,
        description = PpeAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class PpeListController extends PpeAbstractController {

    private PpeService service;

    public PpeListController(PpeService service){
        this.service = service;
    }

    @ApiOperation(value = "List of personal protection equipment")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<PpeResponse> getPpeList(@RequestParam(value = "userId") Integer userId) {
        List<Ppe> ppeList = service.findAll();
        return new ListRestResponse(ppeList);
    }

}
