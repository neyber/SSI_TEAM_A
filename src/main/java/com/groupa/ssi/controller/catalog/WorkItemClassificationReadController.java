package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.cmd.catalog.WorkItemClassificationReadCmd;
import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.catalog.WorkItemClassificationResponse;
import com.groupa.ssi.response.catalog.WorkItemClassificationResponseBuilder;
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
public class WorkItemClassificationReadController extends WorkItemClassificationAbstractController {

    @Autowired
    private WorkItemClassificationReadCmd cmd;

    @ApiOperation(value = "Read a work item classification")
    @RequestMapping(
            value = "/{workItemClassificationId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<WorkItemClassificationResponse> readWorkItemClassification(@PathVariable Integer workItemClassificationId,
                                                                                    @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setWorkItemClassificationId(workItemClassificationId);
        cmd.execute();

        return new SingleRestResponse<>(WorkItemClassificationResponseBuilder.getInstance(cmd.getWorkItemClassification()).build());
    }

}
