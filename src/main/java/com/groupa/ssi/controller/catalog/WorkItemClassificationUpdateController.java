package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.cmd.catalog.WorkItemClassificationUpdateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.catalog.WorkItemClassificationRequest;
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
        tags = WorkItemClassificationAbstractController.TAG_NAME,
        description = WorkItemClassificationAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class WorkItemClassificationUpdateController extends WorkItemClassificationAbstractController {

    @Autowired
    private WorkItemClassificationUpdateCmd cmd;

    @ApiOperation(value = "Update work item classification")
    @RequestMapping(
            value = "/{workItemClassificationId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updateWorkItemClassification(@PathVariable Integer workItemClassificationId,
                                              @RequestBody WorkItemClassificationRequest workItemClassificationRequest,
                                              @RequestParam(value = "userId", required = false) Integer userId) {

        cmd.setWorkItemClassificationId(workItemClassificationId);
        cmd.setWorkItemClassificationRequest(workItemClassificationRequest);
        cmd.execute();

        return new SuccessRestResponse();
    }

}
