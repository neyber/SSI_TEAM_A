package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.cmd.catalog.WorkItemClassificationDeleteCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
@Api(
        tags = WorkItemClassificationAbstractController.TAG_NAME,
        description = WorkItemClassificationAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class WorkItemClassificationDeleteController extends WorkItemClassificationAbstractController {

    @Autowired
    private WorkItemClassificationDeleteCmd cmd;
    @ApiOperation(value = "Delete work item classification")
    @RequestMapping(
            value = "/{workItemClassificationId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deleteWorkItemClassification(@PathVariable Integer workItemClassificationId,
                                              @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setWorkItemClassificationId(workItemClassificationId);
        cmd.execute();

        return new SuccessRestResponse();
    }

}
