package com.groupa.ssi.controller.workitem;

import com.groupa.ssi.cmd.workitem.ExistingWorkItemListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.workitem.ExistingWorkItemResponse;
import com.groupa.ssi.response.workitem.ExistingWorkItemResponseBuilder;
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
 * Created on May 1, 2018
 * @author Walker Colina
 */
@Api(
        tags = ExistingWorkItemAbstractController.TAG_NAME,
        description = ExistingWorkItemAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class ExistingWorkItemListController extends ExistingWorkItemAbstractController {

    @Autowired
    private ExistingWorkItemListCmd cmd;

    @ApiOperation(value = "List of existing work item")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<ExistingWorkItemResponse> getExistingWorkItemList(@RequestParam(value = "userId", required = false) Integer userId) {
        cmd.execute();

        List<ExistingWorkItemResponse> result = cmd.getExistingWorkItemList().stream()
                .map(instance -> ExistingWorkItemResponseBuilder.getInstance(instance).build())
                .collect(Collectors.toList());

        return new ListRestResponse<>(result);
    }

}
