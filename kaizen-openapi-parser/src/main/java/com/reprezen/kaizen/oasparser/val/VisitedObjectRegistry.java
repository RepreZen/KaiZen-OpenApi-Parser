package com.reprezen.kaizen.oasparser.val;

import java.util.IdentityHashMap;
import java.util.Map;

public class VisitedObjectRegistry {

	private Map<Object, Object> visitedObjects = new IdentityHashMap<>();

	public boolean visitIfUnvisited(Object o) {
		if (visitedObjects.containsKey(o)) {
			return false;
		} else {
			visitedObjects.put(o, o);
			return true;
		}
	}
}
