package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.AbstractJsonOverlay;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.jsonoverlay.ChildOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.model3.Header;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.Schema;

public class HeaderImpl extends PropertiesOverlay<Header> implements Header {

	@Generated("com.reprezen.gen.CodeGenerator")
	public HeaderImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public HeaderImpl(Header header, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(header, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> name;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> in;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> description;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Boolean> required;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Boolean> deprecated;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Boolean> allowEmptyValue;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> style;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Boolean> explode;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Boolean> allowReserved;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Schema> schema;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Object> example;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Example> examples;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<MediaType> contentMediaTypes;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// Name
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getName() {
		return name._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getName(boolean elaborate) {
		return name._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setName(String name) {
		this.name._set(name);
	}

	// In
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getIn() {
		return in._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getIn(boolean elaborate) {
		return in._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setIn(String in) {
		this.in._set(in);
	}

	// Description
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getDescription() {
		return description._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getDescription(boolean elaborate) {
		return description._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setDescription(String description) {
		this.description._set(description);
	}

	// Required
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getRequired() {
		return required._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getRequired(boolean elaborate) {
		return required._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean isRequired() {
		return required._get() != null ? required._get() : false;
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setRequired(Boolean required) {
		this.required._set(required);
	}

	// Deprecated
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getDeprecated() {
		return deprecated._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getDeprecated(boolean elaborate) {
		return deprecated._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean isDeprecated() {
		return deprecated._get() != null ? deprecated._get() : false;
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setDeprecated(Boolean deprecated) {
		this.deprecated._set(deprecated);
	}

	// AllowEmptyValue
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getAllowEmptyValue() {
		return allowEmptyValue._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getAllowEmptyValue(boolean elaborate) {
		return allowEmptyValue._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean isAllowEmptyValue() {
		return allowEmptyValue._get() != null ? allowEmptyValue._get() : false;
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setAllowEmptyValue(Boolean allowEmptyValue) {
		this.allowEmptyValue._set(allowEmptyValue);
	}

	// Style
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getStyle() {
		return style._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getStyle(boolean elaborate) {
		return style._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setStyle(String style) {
		this.style._set(style);
	}

	// Explode
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getExplode() {
		return explode._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getExplode(boolean elaborate) {
		return explode._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean isExplode() {
		return explode._get() != null ? explode._get() : false;
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExplode(Boolean explode) {
		this.explode._set(explode);
	}

	// AllowReserved
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getAllowReserved() {
		return allowReserved._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getAllowReserved(boolean elaborate) {
		return allowReserved._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean isAllowReserved() {
		return allowReserved._get() != null ? allowReserved._get() : false;
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setAllowReserved(Boolean allowReserved) {
		this.allowReserved._set(allowReserved);
	}

	// Schema
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Schema getSchema() {
		return schema._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Schema getSchema(boolean elaborate) {
		return schema._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setSchema(Schema schema) {
		this.schema._set(schema);
	}

	// Example
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getExample() {
		return example._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getExample(boolean elaborate) {
		return example._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExample(Object example) {
		this.example._set(example);
	}

	// Example
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Example> getExamples() {
		return examples._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Example> getExamples(boolean elaborate) {
		return examples._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasExample(String name) {
		return examples.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Example getExample(String name) {
		return examples._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExamples(Map<String, Example> examples) {
		this.examples._set(examples);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExample(String name, Example example) {
		examples._set(name, example);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeExample(String name) {
		examples._remove(name);
	}

	// ContentMediaType
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, MediaType> getContentMediaTypes() {
		return contentMediaTypes._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, MediaType> getContentMediaTypes(boolean elaborate) {
		return contentMediaTypes._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasContentMediaType(String name) {
		return contentMediaTypes.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public MediaType getContentMediaType(String name) {
		return contentMediaTypes._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setContentMediaTypes(Map<String, MediaType> contentMediaTypes) {
		this.contentMediaTypes._set(contentMediaTypes);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setContentMediaType(String name, MediaType contentMediaType) {
		contentMediaTypes._set(name, contentMediaType);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeContentMediaType(String name) {
		contentMediaTypes._remove(name);
	}

	// Extension
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getExtensions() {
		return extensions._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getExtensions(boolean elaborate) {
		return extensions._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasExtension(String name) {
		return extensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getExtension(String name) {
		return extensions._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExtensions(Map<String, Object> extensions) {
		this.extensions._set(extensions);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExtension(String name, Object extension) {
		extensions._set(name, extension);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeExtension(String name) {
		extensions._remove(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	protected void elaborateChildren() {
		super.elaborateChildren();
		name = createChild("name", this, StringOverlay.factory);
		in = createChild("in", this, StringOverlay.factory);
		description = createChild("description", this, StringOverlay.factory);
		required = createChild("required", this, BooleanOverlay.factory);
		deprecated = createChild("deprecated", this, BooleanOverlay.factory);
		allowEmptyValue = createChild("allowEmptyValue", this, BooleanOverlay.factory);
		style = createChild("style", this, StringOverlay.factory);
		explode = createChild("explode", this, BooleanOverlay.factory);
		allowReserved = createChild("allowReserved", this, BooleanOverlay.factory);
		schema = createChild("schema", this, SchemaImpl.factory);
		example = createChild("example", this, ObjectOverlay.factory);
		examples = createChildMap("examples", this, ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");
		contentMediaTypes = createChildMap("content", this, MediaTypeImpl.factory, null);
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public static OverlayFactory<Header> factory = new OverlayFactory<Header>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super Header>> getOverlayClass() {
			return HeaderImpl.class;
		}

		@Override
		public JsonOverlay<Header> _create(Header header, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new HeaderImpl(header, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Header> castOverlay = (JsonOverlay<Header>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Header> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new HeaderImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Header> castOverlay = (JsonOverlay<Header>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends Header> getSubtypeOf(Header header) {
		return Header.class;
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends Header> getSubtypeOf(JsonNode json) {
		return Header.class;
	}
}
