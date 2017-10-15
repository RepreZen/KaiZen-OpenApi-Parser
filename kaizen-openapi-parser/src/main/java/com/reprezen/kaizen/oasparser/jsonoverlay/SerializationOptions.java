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

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import com.google.common.collect.Sets;

public class SerializationOptions {
	public enum Option {
		KEEP_EMPTY, KEEP_ONE_EMPTY, FOLLOW_REFS;
	}

	private final Set<SerializationOptions.Option> options;

	public SerializationOptions(SerializationOptions.Option... options) {
		this.options = Sets.newHashSet(options);
	}

	public SerializationOptions(Collection<SerializationOptions.Option> options) {
		this.options = Sets.newHashSet(options);
	}

	public SerializationOptions plus(Collection<SerializationOptions.Option> addOptions) {
		Set<SerializationOptions.Option> newOptions = Sets.newHashSet(this.options);
		newOptions.addAll(addOptions);
		return new SerializationOptions(newOptions);
	}

	public SerializationOptions plus(SerializationOptions.Option... addOptions) {
		return plus(Arrays.asList(addOptions));
	}

	public SerializationOptions minus(Collection<SerializationOptions.Option> removeOptions) {
		Set<SerializationOptions.Option> newOptions = Sets.newHashSet(this.options);
		newOptions.removeAll(removeOptions);
		return new SerializationOptions(newOptions);
	}

	public SerializationOptions minus(SerializationOptions.Option... removeOptions) {
		return minus(Arrays.asList(removeOptions));
	}

	public boolean isKeepEmpty() {
		return options.contains(Option.KEEP_EMPTY);
	}

	public boolean isKeepOneEmpty() {
		return options.contains(Option.KEEP_ONE_EMPTY);
	}

	public boolean isKeepThisEmpty() {
		return isKeepEmpty() || isKeepOneEmpty();
	}

	public boolean isFollowRefs() {
		return options.contains(Option.FOLLOW_REFS);
	}
}