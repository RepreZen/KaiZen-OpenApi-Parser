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

import static com.reprezen.kaizen.oasparser.val.ValidationResults.Severity.ERROR;
import static com.reprezen.kaizen.oasparser.val.ValidationResults.Severity.INFO;
import static com.reprezen.kaizen.oasparser.val.ValidationResults.Severity.MAX_SEVERITY;
import static com.reprezen.kaizen.oasparser.val.ValidationResults.Severity.NONE;
import static com.reprezen.kaizen.oasparser.val.ValidationResults.Severity.WARNING;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.jsonoverlay.PositionInfo;

public class ValidationResults {

    public enum Severity {
        NONE, INFO, WARNING, ERROR;

        public static final Severity MAX_SEVERITY = ERROR;

        public boolean lt(Severity other) {
            return this.compareTo(other) < 0;
        }

        public boolean le(Severity other) {
            return this.compareTo(other) <= 0;
        }

        public boolean gt(Severity other) {
            return this.compareTo(other) > 0;
        }

        public boolean ge(Severity other) {
            return this.compareTo(other) >= 0;
        }
    };

    private List<ValidationItem> items = new ArrayList<>();

    public <V> void addInfo(String msg, Overlay<V> context) {
        items.add(new ValidationItem(INFO, msg, context));
    }

    public void addWarning(String msg, Overlay<?> context) {
        items.add(new ValidationItem(WARNING, msg, context));
    }

    public void addError(String msg, Overlay<?> context) {
        items.add(new ValidationItem(ERROR, msg, context));
    }

    public void add(ValidationResults results) {
        items.addAll(results.getItems());
    }

    public Collection<ValidationItem> getItems() {
        return items;
    }

    public Severity getSeverity() {
        Severity severity = NONE;
        for (ValidationItem item : items) {
            if (item.getSeverity().gt(severity)) {
                severity = item.getSeverity();
                if (severity == MAX_SEVERITY) {
                    break;
                }
            }
        }
        return severity;
    }

    public static class ValidationItem {
        private Severity severity;
        private String msg;
        private PositionInfo positionInfo;

        public ValidationItem(Severity severity, String msg, Overlay<?> context) {
            this.severity = severity;
            this.msg = msg;
            this.positionInfo = context != null ? context.getPositionInfo().orElse(null) : null;
        }

        public Severity getSeverity() {
            return severity;
        }

        public String getMsg() {
            return msg;
        }

        public PositionInfo getPositionInfo() {
            return positionInfo;
        }

        @Override
        public String toString() {
            String posString = positionInfo != null ? positionInfo.toString(true) + ": " : "";
            return posString + msg;
        }
    }
}
