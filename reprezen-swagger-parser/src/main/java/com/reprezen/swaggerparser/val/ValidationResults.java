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
package com.reprezen.swaggerparser.val;

import static com.reprezen.swaggerparser.val.ValidationResults.Severity.ERROR;
import static com.reprezen.swaggerparser.val.ValidationResults.Severity.INFO;
import static com.reprezen.swaggerparser.val.ValidationResults.Severity.MAX_SEVERITY;
import static com.reprezen.swaggerparser.val.ValidationResults.Severity.NONE;
import static com.reprezen.swaggerparser.val.ValidationResults.Severity.WARNING;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

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

    List<ValidationItem> items = Lists.newArrayList();
    List<String> currentCrumbs = Collections.emptyList();

    public void addInfo(String msg) {
        items.add(new ValidationItem(INFO, msg, currentCrumbs));
    }

    public void addWarning(String msg) {
        items.add(new ValidationItem(WARNING, msg, currentCrumbs));
    }

    public void addError(String msg) {
        items.add(new ValidationItem(ERROR, msg, currentCrumbs));
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

    public CrumbState withCrumb(String crumb) {
        return new CrumbState(crumb);
    }

    public CrumbState withCrumbs(List<String> crumbs) {
        return new CrumbState(crumbs);
    }

    public static class ValidationItem {
        private Severity severity;
        private String msg;
        private List<String> crumbs;

        public ValidationItem(Severity severity, String msg, List<String> crumbs) {
            super();
            this.severity = severity;
            this.msg = msg;
            this.crumbs = crumbs;
        }

        public Severity getSeverity() {
            return severity;
        }

        public String getMsg() {
            return msg;
        }

        public List<String> getCrumbs() {
            return crumbs;
        }

        @Override
        public String toString() {
            String label = crumbs != null & !crumbs.isEmpty() ? StringUtils.join(crumbs, '.') + ": " : "";
            return label + msg;
        }
    }

    public class CrumbState implements AutoCloseable {
        private List<String> priorCrumbs;

        public CrumbState(List<String> crumbs) {
            priorCrumbs = currentCrumbs;
            currentCrumbs = crumbs;
        }

        public CrumbState(String crumb) {
            priorCrumbs = currentCrumbs;
            if (crumb != null && crumb != Validator.NO_CRUMB) {
                currentCrumbs = Lists.newArrayList(currentCrumbs);
                currentCrumbs.add(crumb);
            }
        }

        @Override
        public void close() {
            currentCrumbs = priorCrumbs;
        }
    }
}
