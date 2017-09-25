/*******************************************************************************
 *  Copyright (c) 2017 ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.kaizen.oasparser.jsonoverlay;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.common.base.Charsets;

public class Reference {

    private String refString;
    private ResolutionBase base;
    private String fragment;
    private Boolean isValid = null;
    private JsonNode json = null;
    private ResolutionException error;
    private String key;

    private final ResolutionBaseRegistry resolutionBaseRegistry;

    /*package*/ Reference(String refString, ResolutionBase base) {
        this.refString = refString;
        resolutionBaseRegistry = base.getResolutionBaseRegistry();
        int pos = refString.indexOf('#');
        String relUrl = pos < 0 ? refString : refString.substring(0, pos);
        if (relUrl.isEmpty()) {
            this.base = base;
        } else {
            // note re false: if creating a ref with resolution requested, the base will be resolved as a side-effect
            // during ref resolution, so no need to do it now.
            this.base = resolutionBaseRegistry.of(base.comprehend(relUrl), false);
        }
        if (pos >= 0) {
            this.fragment = refString.substring(pos);
        }
        if (fragment != null) {
            try {
                // certain chars *should* be URL encoded in fragments, and if they are we'll decode them before applying
                // as a pointer. But if not, we don't complain (all our URL/URI parsing is done with fragments removed).
                this.fragment = URLDecoder.decode(fragment, Charsets.UTF_8.name());
            } catch (UnsupportedEncodingException e) {
            }
        }
        this.key = refString;
    }

    /*package*/ Reference(String refString, ResolutionBase base, ResolutionException e) {
        this.refString = refString;
        resolutionBaseRegistry = base.getResolutionBaseRegistry();
        this.fragment = null;
        this.base = base;
        this.isValid = false;
        this.error = e;
        this.key = String.format("[%s,%s]", refString, base.getUrlString());
    }

    public String getRefString() {
        return refString;
    }

    public ResolutionBase getBase() {
        return base;
    }

    public String getFragment() {
        return fragment;
    }

    public JsonNode getJson() {
        if (isValid()) {
            return json;
        } else {
            return MissingNode.getInstance();
        }
    }

    public boolean isValid() {
        return isValid != null && isValid;
    }

    public boolean isInvalid() {
        return isValid != null && !isValid;
    }

    public boolean isResolved() {
        return isValid != null;
    }

    public ResolutionException getError() {
        return error;
    }

    public String getErrorReason() {
        return error != null ? error.getLocalizedMessage() : null;
    }

    public String getKey() {
        return key;
    }

    public JsonNode resolve() {
        if (!isResolved()) {
            try {
                JsonNode root = base.resolve();
                if (fragment == null) {
                    this.json = root;
                } else {
                    try {
                        this.json = root.at(fragment.substring(1));
                    } catch (IllegalArgumentException e) {
                        throw new ResolutionException("Failed to resolve JSON pointer", e);
                    }
                }
                isValid = true;
            } catch (ResolutionException e) {
                this.error = e;
                this.isValid = false;
                this.json = MissingNode.getInstance();
            }
        }
        return json;
    }
}
