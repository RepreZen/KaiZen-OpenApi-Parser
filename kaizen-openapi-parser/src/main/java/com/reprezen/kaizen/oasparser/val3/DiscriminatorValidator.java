package com.reprezen.kaizen.oasparser.val3;

import com.reprezen.kaizen.oasparser.model3.Discriminator;
import com.reprezen.kaizen.oasparser.ovl3.DiscriminatorImpl;
import com.reprezen.kaizen.oasparser.val.ValidatorBase;

public class DiscriminatorValidator extends ValidatorBase<Discriminator> {

    @Override
    public void runValidations() {
        validateStringField(DiscriminatorImpl.F_propertyName, true);
        validateMapField("mappings", false, false, String.class, null);
    }
}
