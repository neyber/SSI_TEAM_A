package com.groupa.ssi.controller.workitem;

import com.groupa.ssi.cmd.workitem.ExistingWorkItemCreateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.workitem.ExistingWorkItemRequest;
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
        tags = ExistingWorkItemAbstractController.TAG_NAME,
        description = ExistingWorkItemAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class ExistingWorkItemCreateController extends ExistingWorkItemAbstractController {

    @Autowired
    private ExistingWorkItemCreateCmd cmd;

    @ApiOperation(value = "Create existing work item")
    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createExistingWorkItem(@RequestBody ExistingWorkItemRequest existingWorkItemRequest,
                                              @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setExistingWorkItemRequest(existingWorkItemRequest);
        cmd.execute();

        return new SuccessRestResponse();
    }
}
