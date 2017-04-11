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
package com.reprezen.kaizen.oasparser.val;

import java.util.Arrays;

public class Messages {
    public static Messages m = new Messages();

    public String msg(String text, Object... args) {
        int pos = text.indexOf('|');
        if (pos >= 0) {
            String nls = nls(text.substring(0, pos));
            text = nls != null ? nls : text.substring(pos + 1);
        }
        return String.format("%s %s", text, Arrays.asList(args));
    }

    public String nls(String text) {
        return null;
    }
}
