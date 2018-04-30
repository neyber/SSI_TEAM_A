package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.cmd.catalog.PpeClassificationCreateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.request.catalog.PpeClassificationRequest;
import com.groupa.ssi.services.catalog.PpeClassificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
@Api(
        tags = PpeClassificationAbstractController.TAG_NAME,
        description = PpeClassificationAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class PpeClassificationCreateController extends PpeClassificationAbstractController {

    @Autowired
    private PpeClassificationCreateCmd cmd;

    @ApiOperation(value = "Create personal protection equipment classification")
    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createPpeClassification(@RequestBody PpeClassificationRequest ppeClassificationRequest,
                                              @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setPpeClassificationRequest(ppeClassificationRequest);
        cmd.execute();

        return new SuccessRestResponse();
    }
}
