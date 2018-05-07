package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.cmd.catalog.PpeClassificationListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.catalog.PpeClassificationResponse;
import com.groupa.ssi.response.catalog.PpeClassificationResponseBuilder;
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
 * Created on April 25, 2018
 * @author Walker Colina
 */
@Api(
        tags = PpeClassificationAbstractController.TAG_NAME,
        description = PpeClassificationAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class PpeClassificationListController extends PpeClassificationAbstractController {

    @Autowired
    private PpeClassificationListCmd cmd;

    @ApiOperation(value = "List of personal protection equipment classifications")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<PpeClassificationResponse> getPpeClassificationList(@RequestParam(value = "userId", required = false) Integer userId) {

        cmd.execute();

        List<PpeClassificationResponse> result = cmd.getPpeClassificationList().stream()
                .map(instance -> PpeClassificationResponseBuilder.getInstance(instance).build())
                .collect(Collectors.toList());

        return new ListRestResponse<>(result);
    }

}
