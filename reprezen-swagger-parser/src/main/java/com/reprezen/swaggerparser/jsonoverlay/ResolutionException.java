/*******************************************************************************
 *  Copyright (c) $(date) ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.swaggerparser.jsonoverlay;

public class ResolutionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResolutionException() {
        super();
    }

    public ResolutionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ResolutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResolutionException(String message) {
        super(message);
    }

    public ResolutionException(Throwable cause) {
        super(cause);
    }

}
