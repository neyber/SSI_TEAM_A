package com.groupa.ssi.controller.workitem;

import com.groupa.ssi.cmd.workitem.WorkItemCreateCmd;
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
public class WorkItemCreateController extends WorkItemAbstractController {

    @Autowired
    private WorkItemCreateCmd cmd;

    @ApiOperation(value = "Create work item")
    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createWorkItem(@RequestBody WorkItemRequest workItemRequest,
                                              @RequestParam(value = "userId", required = false) Integer userId) {

        cmd.setWorkItemRequest(workItemRequest);
        cmd.execute();
        return new SuccessRestResponse();
    }

}
