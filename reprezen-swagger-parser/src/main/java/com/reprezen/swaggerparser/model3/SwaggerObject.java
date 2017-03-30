package com.reprezen.swaggerparser.model3;

public interface SwaggerObject {

    Swagger3 getModel();

    SwaggerObject getParent();

    boolean isMissing();
}
