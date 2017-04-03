package com.reprezen.swaggerparser.val3;

import static com.reprezen.swaggerparser.val.Messages.m;

import java.util.Map.Entry;
import java.util.Set;

import com.reprezen.swaggerparser.model3.SecurityParameter;
import com.reprezen.swaggerparser.model3.SecurityRequirement;
import com.reprezen.swaggerparser.model3.Swagger3;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;

public class SecurityRequirementValidator extends ObjectValidatorBase<SecurityRequirement> {

    @Override
    public void validateModel(SecurityRequirement securityRequirement, ValidationResults results) {
        Swagger3 model = securityRequirement.getModel();
        Set<String> definedSchemes = model.getSecuritySchemes().keySet();
        for (Entry<String, ? extends SecurityParameter> entry : securityRequirement.getRequirements().entrySet()) {
            if (!definedSchemes.contains(entry.getKey())) {
                results.addError(
                        m.msg("UnkSecScheme|Security scheme not defined in components object", entry.getKey()));
            } else {
                String type = model.getSecurityScheme(entry.getKey()).getType();
                switch (type) {
                case "oauth2":
                case "openIdConnect":
                    // TODO Q: anything to test here? do we know what the allowed scope names are?
                    break;
                default:
                    if (!entry.getValue().getParameters().isEmpty()) {
                        results.addError(
                                m.msg("NonEmptySecReqParms|Security requirement parameters must be empty unless scheme type is oauth2 or openIdConnect",
                                        entry.getKey(), type));
                    }

                }
            }
        }
    }
}
