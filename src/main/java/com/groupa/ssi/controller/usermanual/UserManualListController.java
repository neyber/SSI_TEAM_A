package com.groupa.ssi.controller.usermanual;

import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.usermanual.UserManualResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;

/**
 * @author Marcelo Loayza
 */

@Api(tags = UserManualAbstractController.TAG_NAME, description = UserManualAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class UserManualListController extends UserManualAbstractController {

    @ApiOperation(value = "List UserManuals")
    @RequestMapping(method = RequestMethod.GET)
    public ListRestResponse<UserManualResponse> getUserManualList(@RequestParam(value="userId") Integer userId){
        return new ListRestResponse<>(new ArrayList<>());
    }
}