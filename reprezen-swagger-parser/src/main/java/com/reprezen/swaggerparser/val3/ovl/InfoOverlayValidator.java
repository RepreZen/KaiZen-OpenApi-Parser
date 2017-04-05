package com.reprezen.swaggerparser.val3.ovl;

import com.reprezen.swaggerparser.model3.Info;
import com.reprezen.swaggerparser.ovl3.InfoImpl;
import com.reprezen.swaggerparser.val.ImplValidator;
import com.reprezen.swaggerparser.val.ObjectValidator;
import com.reprezen.swaggerparser.val.ValidationResults;

public class InfoOverlayValidator extends ObjectValidator<InfoImpl> implements ImplValidator<Info> {

    @Override
    public void validateImpl(Info info, ValidationResults results) {
        super.validate((InfoImpl) info, results);
    }

}
