package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.cmd.catalog.WorkItemClassificationCreateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.catalog.WorkItemClassificationRequest;
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
public class WorkItemClassificationCreateController extends WorkItemClassificationAbstractController {

    @Autowired
    private WorkItemClassificationCreateCmd cmd;

    @ApiOperation(value = "Create work item classification")
    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createWorkItemClassification(@RequestBody WorkItemClassificationRequest workItemClassificationRequest,
                                              @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setWorkItemClassificationRequest(workItemClassificationRequest);
        cmd.execute();

        return new SuccessRestResponse();
    }
}
