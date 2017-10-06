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

public class OverlayException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OverlayException() {
		super();
	}

	public OverlayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OverlayException(String message, Throwable cause) {
		super(message, cause);
	}

	public OverlayException(String message) {
		super(message);
	}

	public OverlayException(Throwable cause) {
		super(cause);
	}
}
