package com.groupa.ssi.controller.audit;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Neyber Rojas Zapata
 */
@Api(tags = AuditInternalAbstractController.TAG_NAME, description = AuditInternalAbstractController.DESCRIPTION)
@RestController
@RequestScope
public class AuditInternalDeleteController extends AuditInternalAbstractController {

    @ApiOperation(value = "Delete AuditInternal")
    @RequestMapping(value = "/{auditInternalId}", method = RequestMethod.DELETE)
    public SuccessRestResponse deleteAuditInternal(@PathVariable Integer auditInternalId, @RequestParam(value = "userId") Integer userId) {
        return new SuccessRestResponse();
    }
}
