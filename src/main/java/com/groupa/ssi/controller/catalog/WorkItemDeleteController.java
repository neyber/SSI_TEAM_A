package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.cmd.catalog.WorkItemCreateCmd;
import com.groupa.ssi.cmd.catalog.WorkItemDeleteCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
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
public class WorkItemDeleteController extends WorkItemAbstractController {

    @Autowired
    private WorkItemDeleteCmd cmd;

    @ApiOperation(value = "Delete work item")
    @RequestMapping(
            value = "/{workItemId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deleteWorkItem(@PathVariable Integer workItemId,
                                              @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setWorkItemId(workItemId);
        cmd.execute();

        return new SuccessRestResponse();
    }

}
