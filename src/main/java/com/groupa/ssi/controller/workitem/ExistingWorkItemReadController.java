package com.groupa.ssi.controller.workitem;

import com.groupa.ssi.cmd.workitem.ExistingWorkItemReadCmd;
import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.workitem.ExistingWorkItemResponse;
import com.groupa.ssi.response.workitem.ExistingWorkItemResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Created on April 26, 2018
 * @author Walker Colina
 */
@Api(
        tags = ExistingWorkItemAbstractController.TAG_NAME,
        description = ExistingWorkItemAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class ExistingWorkItemReadController extends ExistingWorkItemAbstractController {

    @Autowired
    private ExistingWorkItemReadCmd cmd;

    @ApiOperation(value = "Read an existing work item")
    @RequestMapping(
            value = "/{existingWorkItemId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<ExistingWorkItemResponse> readExistingWorkItem(@PathVariable Integer existingWorkItemId,
                                                                             @RequestParam(value = "userId", required = false) Integer userId) {

        cmd.setExistingWorkItemId(existingWorkItemId);
        cmd.execute();

        return new SingleRestResponse<>(ExistingWorkItemResponseBuilder.getInstance(cmd.getExistingWorkItem()).build());
    }


}
