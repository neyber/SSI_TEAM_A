package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.cmd.catalog.WorkItemReadCmd;
import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.model.domain.catalog.WorkItem;
import com.groupa.ssi.response.catalog.WorkItemResponse;
import com.groupa.ssi.response.catalog.WorkItemResponseBuilder;
import com.groupa.ssi.services.catalog.WorkItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Miguel Rojas
 */
@Api(
        tags = WorkItemAbstractController.TAG_NAME,
        description = WorkItemAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class WorkItemReadController extends WorkItemAbstractController {

    @Autowired
    private WorkItemReadCmd cmd;

    @ApiOperation(value = "Read a work item")
    @RequestMapping(
            value = "/{workItemId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<WorkItemResponse> readWorkItem(@PathVariable Integer workItemId,
                                                             @RequestParam(value = "userId", required = false) Integer userId) {

        cmd.setWorkItemId(workItemId);
        cmd.execute();

        return new SingleRestResponse<>(WorkItemResponseBuilder.getInstance(cmd.getWorkItem()).build());
    }

}
