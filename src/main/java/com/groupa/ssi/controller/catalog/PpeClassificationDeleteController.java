package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.cmd.catalog.PpeClassificationDeleteCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
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
public class  PpeClassificationDeleteController extends PpeClassificationAbstractController {

    @Autowired
    private PpeClassificationDeleteCmd cmd;

    @ApiOperation(value = "Delete personal protection equipment classification")
    @RequestMapping(
            value = "/{ppeClassificationId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deletePpeClassification(@PathVariable Integer ppeClassificationId,
                                              @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setPpeClassificationId(ppeClassificationId);
        cmd.execute();

        return new SuccessRestResponse();
    }

}
