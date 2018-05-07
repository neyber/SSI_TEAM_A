package com.groupa.ssi.controller.workitem;

import com.groupa.ssi.cmd.workitem.WorkItemListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.workitem.WorkItemResponse;
import com.groupa.ssi.response.workitem.WorkItemResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Miguel Rojas
 */
@Api(
        tags = WorkItemAbstractController.TAG_NAME,
        description = WorkItemAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class WorkItemListController extends WorkItemAbstractController {

    @Autowired
    private WorkItemListCmd cmd;

    @ApiOperation(value = "List of work items")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<WorkItemResponse> getWorkItemList(@RequestParam(value = "userId", required = false) Integer userId) {

        cmd.execute();

        List<WorkItemResponse> result = cmd.getWorkItemList().stream()
                .map(instance -> WorkItemResponseBuilder.getInstance(instance).build())
                .collect(Collectors.toList());

        return new ListRestResponse<>(result);
    }

}
