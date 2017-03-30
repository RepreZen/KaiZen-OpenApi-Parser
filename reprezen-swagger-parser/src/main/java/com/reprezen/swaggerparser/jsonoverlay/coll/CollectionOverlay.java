package com.reprezen.swaggerparser.jsonoverlay.coll;

import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;

public interface CollectionOverlay<OV extends JsonOverlay<?>> {

    public CollectionStore<OV> getStore();
}
