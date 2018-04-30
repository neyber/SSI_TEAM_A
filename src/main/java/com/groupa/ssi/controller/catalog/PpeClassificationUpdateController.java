package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.cmd.catalog.PpeClassificationUpdateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.catalog.PpeClassificationRequest;
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
public class PpeClassificationUpdateController extends PpeClassificationAbstractController {

    @Autowired
    private PpeClassificationUpdateCmd cmd;

    @ApiOperation(value = "Update personal protection equipment classification")
    @RequestMapping(
            value = "/{ppeClassificationId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updatePpeClassification(@PathVariable Integer ppeClassificationId,
                                              @RequestBody PpeClassificationRequest ppeClassificationRequest,
                                              @RequestParam(value = "userId", required = false) Integer userId) {

        cmd.setPpeClassificationId(ppeClassificationId);
        cmd.setPpeClassificationRequest(ppeClassificationRequest);
        cmd.execute();

        return new SuccessRestResponse();
    }

}
