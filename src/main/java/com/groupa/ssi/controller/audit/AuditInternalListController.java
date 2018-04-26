package com.groupa.ssi.controller.audit;

import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.audit.AuditInternalResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;

/**
 * @author Neyber Rojas Zapata
 */
@Api(tags = AuditInternalAbstractController.TAG_NAME, description = AuditInternalAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class AuditInternalListController extends AuditInternalAbstractController {

    @ApiOperation(value = "List Audit Internals")
    @RequestMapping(method = RequestMethod.GET)
    public ListRestResponse<AuditInternalResponse> getAuditInternalList(@RequestParam(value = "userId") Integer userId) {
        return new ListRestResponse<>(new ArrayList<>());
    }
}
