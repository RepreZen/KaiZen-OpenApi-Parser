package com.reprezen.swaggerparser.jsonoverlay.coll;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Optional;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;

public class ObjectOverlay<OO extends ObjectOverlay<OO>> extends JsonOverlay<OO> {

    public ObjectOverlay(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    public ObjectOverlay(String key, JsonOverlay<?> parent) {
        this(key, parent.getJson(key), parent);
    }

    @Override
    protected Iterable<? extends JsonOverlay<?>> getChildren() {
        // TODO fix this
        return Collections.emptyList();
    }

    @Override
    public JsonNode toJson() {
        return getJson(); // TODO fix this
    }

    @Override
    public OO fromJson() {
        return (OO) this; // TODO fix this
    }

    @Override
    public void set(OO value) {
        super.set(value);
    }

    protected static <T extends ObjectOverlay<?>> boolean isEmptyRecursive(JsonOverlay<?> obj, Class<T> cls) {
        while (obj != null) {
            if (!obj.isMissing()) {
                return false;
            } else if (obj.getClass().equals(cls)) {
                return true;
            }
            obj = obj.getParentOverlay();
        }
        return false;
    }

    private static Map<Class<? extends ObjectOverlay<?>>, FieldData> fieldData = Maps.newHashMap();

    protected <T extends JsonOverlay<?>> T registerField(String path, String fieldName, String pattern, T instance) {
        @SuppressWarnings("unchecked")
        Class<? extends ObjectOverlay<?>> cls = (Class<? extends ObjectOverlay<?>>) getClass();
        path = path != null ? path.replaceAll("/", ":") : null;
        if (!fieldData.containsKey(cls)) {
            fieldData.put(cls, new FieldData());
        }
        try {
            fieldData.get(cls).add(path, fieldName, pattern, this);
        } catch (SecurityException e) {
            // we don't normally need this functionality except in testing, so if security manager blocks us we'll just
            // proceed normally, and fail later if anyone tries to use the feature
        } catch (NoSuchFieldException e) {
            // this one we do care about - it means that the generated code is bogus
            throw new IllegalStateException(
                    String.format("Internal error: expected field '%s' in generated class '%s' does not exist",
                            fieldName, getClass()),
                    e);
        }
        return instance;
    }

    public Optional<JsonOverlay<?>> getFieldValue(String path) throws IllegalArgumentException, IllegalAccessException {
        @SuppressWarnings("unchecked")
        Class<? extends ObjectOverlay<?>> cls = (Class<? extends ObjectOverlay<?>>) getClass();
        if (fieldData.containsKey(cls)) {
            return fieldData.get(cls).getFieldValue(path, this);
        } else {
            return Optional.absent();
        }
    }

    private static class FieldData {
        Multimap<String, FieldDataItem> itemsByPath = HashMultimap.create();

        public void add(String path, String fieldName, String pattern, ObjectOverlay<?> overlay)
                throws NoSuchFieldException, SecurityException {
            itemsByPath.put(path, new FieldDataItem(fieldName, overlay));
        }

        public Optional<JsonOverlay<?>> getFieldValue(String path, ObjectOverlay<?> overlay)
                throws IllegalArgumentException, IllegalAccessException {
            if (itemsByPath.containsKey(path)) {
                for (FieldDataItem item : itemsByPath.get(path)) {
                    Optional<JsonOverlay<?>> value = item.getFieldValue(path, overlay);
                    if (value.isPresent()) {
                        return value;
                    }
                }
            } else {
                for (FieldDataItem item : itemsByPath.get(removeKey(path))) {
                    Optional<JsonOverlay<?>> value = item.getFieldValue(path, overlay);
                    if (value.isPresent()) {
                        return value;
                    }
                }
            }
            return Optional.absent();
        }

        private String removeKey(String path) {
            int lastColon = path.lastIndexOf(':');
            if (lastColon >= 0) {
                return path.substring(0, lastColon);
            } else {
                return "";
            }
        }
    }

    private static class FieldDataItem {
        private Field field;

        public FieldDataItem(String fieldName, ObjectOverlay<?> overlay)
                throws NoSuchFieldException, SecurityException {
            super();
            this.field = findField(overlay, fieldName);
            this.field.setAccessible(true);
        }

        private Field findField(ObjectOverlay<?> overlay, String fieldName) throws NoSuchFieldException {
            Class<?> cls = overlay.getClass();
            NoSuchFieldException nsf = null;
            while (ObjectOverlay.class.isAssignableFrom(cls)) {
                try {
                    return cls.getDeclaredField(fieldName);
                } catch (NoSuchFieldException e) {
                    if (nsf == null) {
                        nsf = e;
                    }
                    cls = cls.getSuperclass();
                }
            }
            throw nsf;
        }

        public Optional<JsonOverlay<?>> getFieldValue(String path, ObjectOverlay<?> overlay)
                throws IllegalArgumentException, IllegalAccessException {
            JsonOverlay<?> fieldValue = (JsonOverlay<?>) field.get(overlay);
            if (fieldValue != null) {
                if (fieldValue instanceof MapOverlay || fieldValue instanceof ValMapOverlay) {
                    String key = getKey(path);
                    if (key != null) {
                        CollectionStore<?> store = ((CollectionOverlay<?>) fieldValue).getStore();
                        JsonOverlay<?> keyedValue = store.getOverlay(key);
                        if (keyedValue != null) {
                            return Optional.<JsonOverlay<?>> of(keyedValue);
                        }
                    }
                } else {
                    return Optional.<JsonOverlay<?>> of(fieldValue);
                }
            }
            return Optional.absent();
        }

        private String getKey(String path) {
            int lastColon = path.lastIndexOf(':');
            return lastColon >= 0 ? path.substring(lastColon + 1) : path;
        }
    }
}
