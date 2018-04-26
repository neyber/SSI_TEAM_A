package com.groupa.ssi.controller.personalprotectionequipment;

import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.personalprotectionequipment.PpeResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;

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

    @ApiOperation(value = "List of personal protection equipment")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<PpeResponse> getPpeList(@RequestParam(value = "userId") Integer userId) {
        System.out.println(" Implementation pending... getPpe" );
        return new ListRestResponse<>(new ArrayList<>());
    }

}
