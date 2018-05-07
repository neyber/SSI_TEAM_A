package com.groupa.ssi.controller.workitem;

import com.groupa.ssi.cmd.workitem.WorkItemUpdateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.workitem.WorkItemRequest;
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
public class WorkItemUpdateController extends WorkItemAbstractController {

    @Autowired
    private WorkItemUpdateCmd cmd;

    @ApiOperation(value = "Update work item")
    @RequestMapping(
            value = "/{workItemId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updateWorkItem(@PathVariable Integer workItemId,
                                              @RequestBody WorkItemRequest workItemRequest,
                                              @RequestParam(value = "userId", required = false) Integer userId) {

        cmd.setWorkItemId(workItemId);
        cmd.setWorkItemRequest(workItemRequest);
        cmd.execute();

        return new SuccessRestResponse();
    }

}
