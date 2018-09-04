# The KaiZen OpenAPI Parser API and Object Model

In its most common use-case, the KaiZen OpenAPI Parser consumes an
OpenAPI model and creates Java objects that expose and allow
manipulation of its component parts. Those objects are constructed
from classes and interfaces that are nearly 100% generated from a
succinct catalog of OpenAPI objects, their properties, and their
relationships. As a result, the object APIs are highly uniform.

## Model Values

Values fall broadly into four categories, each with its own unique
API features:

* Scalar objects: These represent scalar JSON values that appear
  throughout an OpenAPI model, including strings, numbers, booleans,
  etc.

* List objects: These represent parts of an OpenAPI model that appear
  as JSON arrays.

* Map objects: These represents parts of the OpenAPI model that appear
  as JSON objects whose property names are not fixed by the OpenAPI
  specification. Examples are the Paths Object and the Responses
  Object. In the former, URL paths defined by the API act as property
  names in a JSON object that contains, as property values, Path Item
  objects describing the operations associated with those paths. In
  the latter, HTTP response codes (or wildcards) serve as property
  names.

* Properties objects: These represent most of the "Objects" of the
  OpenAPI specification - Path Item Objects, Schema Objects, etc. Each
  appears in an OpenAPI model as a JSON object, with fixed property
  names defined in the OpenAPI specification.

In many cases, a single JSON object in an OpenAPI model houses both a
properties object and one or more map objects. The most common case of
this appears with objects that can contain "vendor extensions" - JSON
properties with names that begin with `x-`. In all cases of this
nature, the OpenAPI specification defines a regular expression for the
names of properties belonging to the map object. The fixed properties
will be represented in the properties object, while other properties
matching the regular expression will appear in the map value.

This scheme even allows multiple map objects to coexist in the same
JSON object, as long as the associated property name regular
expressions are mutually exclusive.

Each of the value types listed above appears in the top-level JSON
object of an overall OpenAPI 3.0 model, and we'll use examples from
this context to describe API features of each.

In the following three sections, we will, unless noted otherwise, show
method signatures that appear in the `OpenApi3` interface.

### Scalar Values

The `openapi` property is a required property of an OpenAPI 3.0 model,
and the top-level model object exposes this object via the following
generated methods:

* `String getOpenApi()` - Obtain the string value of the `openapi` model
property.
* `void setOpenApi(String openApi)` - Set the value of the `openapi` model
property.

That's pretty much it for scalars, except in the case of boolean
properties. In that case, the methods look like this instead (using
the `exclusiveMaximum` property of a Schema object for the example):

* `Boolean getExclusiveMaximum()` - returns the property value, or
  `null` if the property did not appear in the model.

* `boolean isExclusiveMaximum()` - returns the property value, or
  `false` if it was not specified in the model.

* `void setExclusiveMaximum(Boolean exclusiveMaximum)` - set the value
  of the property (allows `null`).

### List Values

As an example of list values, we'll use the `servers` property of an
OpenAPI 3.0 model object.

* `List<Server> getServers()` - get the list of server
  objects. This list will never be null, even if the `servers`
  property is missing in the top-level object. (This is an instance of
  a general preference in the API to avoid returning `null` for
  missing items, which can significantly simplify a great deal of
  client code by eliminating the need for null checks to avoid
  `NullPointerException`.)

* `boolean hasServers()` - true if the model really does include a
  `servers` property. This can be used to distinguish a missing value
  from an empty list of servers, when that distinction is important.

* `Server getServer(int index)` - obtain a specific server object from
  the list.

* `void setSetServers(List<Server> servers)` - set the
  servers to the given list.

* `void setServer(int index, Server server)` - replace the server at
  the given position in the servers list. If the index matches the
  current size of the servers list, the server is added to the end of
  list. Otherwise, the index must specify a current position in the
  list.

* `void addServer(Server server)` - add the given server to the end of
  the servers list.
  
* `void insertServer(int index, Server server)` - move existing servers at or beyond the specified index one position to the right, and then insert the given server at the now vacated position.

* `void removeServer(int index)` - remove the server at the given list
  position.

### Map Values

As an example of a map value, we'll use the `paths` property of an
OpenAPI 3.0 model.

* `Map<String, Path> getPaths()` - obtain the map of path
  strings to path item objects. As in the case for lists, an empty map
  is returned if the `paths` property is missing from the model.

* `boolean hasPaths()` - whether the model has a `paths` property.

* `boolean hasPath(String name)` - whether a path with the given path
  string appears in the model's `paths` object`.

* `Path getPath(String name)` - obtain the path item with the given
  path string.

* `void setPaths(Map<String, Path> paths)` - set the `paths`
  value to the given map.

* `void setPath(String name, Path path)` - sets the path item object
  for the given path string. If the path string was already present in
  the map, this replaces the existing value. Otherwise the path is
  added as a new path.

* `void removePath(String name)` - removes the given path string (and
  its associated path item) from the map.

### Properties Values

As an example of a properties value, we'll use the `info` property of
an OpenApi 3.0 model.

* `Info getInfo()` - return the `info` property, packaged as a
  an instance of the generated `InfoImpl` class (which implements the generated `Info` interface), from the model. As with lists and maps, this will never be null.

* `Info getInfo(boolean elaborate)` - like `getInfo()`, but allows the caller to determine whether "elaboration" of the `Info` object occurs as a side-effect. See the following sub-section.

* `void setInfo(Info info)` - set the model's `info` value to the
  given `Info` instance.

#### Properties Value Elaboration

As mentioned earlier, the API is designed in such a way as to minimize
the need for null checks to avoid raising `NullPointerException`. In
practical terms, this means that values obtainable from a properties
object - with the exception of scalar values - will not generally be
`null`.

If `model` is a variable holding a parsed OpenAPI 3.0 model, then
`model.getServes()` will return an empty list even if no `servers`
property appears in the model, and likewise for `model.getPaths()`.

It also means that `model.getInfo()` will generally return an `Info`
object, even if no `info` property appears in the model. However, this
case is a bit more nuanced, because of the possibility of recursive
properties object structures.

In general, we call the process of filling a value from its
corresponding JSON structure "elaboration" of the value. The overall
parsing process basically consists of a depth-first elaboration of
nested values from JSON structures.

During elaboration of a properties object, missing properties are
elaborated as follows:

* A scalar property is elaborated to an internal structure that
  represent a `null` value for the property

* A list or map property is elaborated to an empty container.

* A properties value will be elaborated to an internal object of the
  type required for the property.

The elaboration of missing scalar, list or map values always
terminates immediately. However, this is not the case with properties
objects.

Consider an OpenAPI 3.0 model with no `info` property. Elaborating the
`info` property of that model will create an `Info` object. Then
elaborating that `Info` object will cause a `Contact` object and a
`License` object to be created. Elaborating those objects will not
cause any further properties objects to be created, since those
objects only contain scalar properties (and may have maps of vendor
extensions).

Things are different for a `Schema` object. A schema includes a few
properties whose values may themselves be schemas: `items`, `not`, and
`additionalProperties`. Elaborating a `Schema` object therefore
creates new `Schema` objects as a side-effect. Elaborating those
objects would then create additional `Schema` objects, and so on without end.

As a result of this potential for recursive elaboration of missing properties objects, the KaiZen
OpenApi Parser (actually this is built into the JsonOverlay framework) adopts a lazy elaboration strategy for properties
values whose corresponding JSON structures are missing. During the
initial parse, these values are created, but their own properties are
not elaborated at that time. Elaboration is triggered the first time
the object is retrieved. For example, `schema.getDescription()` will
trigger the elaboration of the schema object's property values, if the schema had not previously been elaborated. The object would have been *created* during
the initial parse (or when its parent object was elaborated), but it will not be elaborated until one of its properties is accessed..

#### Avoiding Triggered Elaboration

There are situations in which one must navigate to a property value
without triggering elaboration. One example is the KaiZen OpenAPI
Parser validation framework, since validation should not alter the
object being validated. (And besides, blindly triggering elaboration
in this context would lead to infinite recursion.)

To avoid elaboration, `get` methods for properties values come with an
optional boolean argument, named `elaborate`. If `true` (the default),
the `get` operation will trigger elaboration; `false` will
not. Attempts to retrieve property values of an unelaborated
properties object, using elaboration suppression in this way, will always return `null`, even for properties with list, map, or properties object value types.

## References

There are several places in the OpenAPI specification where reference
objects are permitted in place of inline structures. Such a  reference
must resolve to a JSON value that is compatible with the context of
the reference. For example, if a schema's `items` property is a
reference, that reference needs to resolve to a JSON value that
embodies a valid schema object.

### Shared Representations

The KaiZen OpenAPI parser attempts to resolve all references that are
encountered when parsing a model, including references
appearing in JSON data that was itself obtained to satisfy a
reference. If the same JSON value is referenced in more than one place
in a model, that value is parsed only once, and the result is linked
as needed into the overall parsed model structure.

This means that "object-equality" (`==`) tests will show that the same
object obtained by different paths do, in fact, share a single
internal represenation.

As an example, consider this model:

```yaml
---
openapi: 3.0.0
info:
  title: Link Example
  version: 1.0.0
paths: {}
components:
  schemas:
    X:
      type: string
    Y:
      type: object
      properties:
        x: 
          $ref: "#/components/schemas/X"
    Z:
      type: array
      items:
        $ref: "#/components/schemas/X"
```

When the model is parsed, the following will all be equal per `==`:

* `model.getSchema("X")`
* `model.getSchema("Y").getProperty("x")`
* `model.getSchema("Z").getItemsSchema()`

### Exposing References

The shared representation is a very handy feature of the parser, but
it is sometimes important to be able to distinguish references from
inlined structures, and to obtain details of references.

This is possible using `Overlay` adapters created from the values being examined. This is just one of many features provided by these adapters.

For example, imagine that we have an `Operation` object, and we want know whether its first (i.e. zeroth) parameter is defined via a reference. For this we could write:

```java
if (Overlay.of(op.getParameters()).isReference(0)) {
  ...
}
```

If we wish to inspect the reference, we use `getReference(int)` instead of `isReference(int)`, to obtain a representation of the reference itself.

Note that reference information is obtained from an `Overlay` object for the `Operation`, not for the `Parameter` we're interested in. The reason is that the `Parameter` object itself may appear in several places within the model, some by reference and (at most) one not by reference. That's the whole point of references, after all. So asking whether an object is included by reference is really asking a question not about the object but about the point of inclusion.

JSON has two means by which one value can be included within another - an array with its child elements, and an object with its property values. We've seen, above, how the first case can be handled, and it applies to list properties like `Operation.parameters` and `Path.servers`. JSON object properties come in two forms for us - entries in map values, and properties of what we are calling "properties objects." In both cases, there are variants of `isReference()` and `getReference()` that take a string value as a parameter instead of an `int`.

As an example, to see whether a particular operation response is included by reference, you could use:

```java
if (Overlay.of(op.getResponses()).isReference("200")) {
  ...
}
```

To see whether the schema associated with that response is included by reference, we could use something like this:

```java
if (Overlay.of(op.getResponse("200").getContentMediaType("*/*")).isReference("schema")) {
  ...
}
```

### Canonical Reference Strings

The reference string appearing in a reference (the value of the `$ref`
property in the JSON object) may come in any of three forms - all just
variants of the general URL syntax:

* Local reference - consists of nothing but a *fragment*, beginning with
  `#`, e.g. `#/components/schemas/Foo`. The fragment must be a valid
  JSON Pointer.

* Relative reference - consists of a relative URL with or without a
  fragment, e.g. `../schemas/PetSchema.yaml` or
  `../schemas/PetStore.yaml#/components/schemas/Pet`.

* Absolute reference - consists of an absolute URL with our without a
  fragment, e.g. `http://example.com/catalog/schemas/Pet.yaml` or
  `http://example.com/catalog/PetStore.yaml#/components/schemas/Pet`

Whenever any reference is encountered, the KaiZen OpenAPI Parser first
canonicalizes the reference string. This operation never changes the
fragment, and only operates on the non-fragment portion.

Canonicalization of an absolute reference means simplifying portions
of the path (e.g. changing `/a/b/c/../d/./foo.yaml` to
`/a/b/d/foo.yaml`).

Canonicalization of a relative reference means converting it to an absolute
URL by merging it into the *context URL* (the URL of the containing
file), and then canonicalizing the result.

Canonicalizing a local reference means attaching the fragment
appearing in the reference to the (canonicalized) context URL.

When two references have the same canonical reference string, the
corresponding references are treated as identical, and will yield
shared representations as described above. Otherwise they will not,
even the two canonicalized URLs actually address the same location on the internet. For example, `http://www.example.com/example.yaml` and `http://153.43.29.173/example.yaml` will be treated as different reference strings, even if at the time of resolution IP address `153.43.29.173` addresses the server known as `www.example.com`. The content retrieved from the server by the two addresses will be parsed independently, and the resulting parsed structures will not be shared.

### Reference Resolution

The parser attempts to resolve all references that are encountered,
but sometimes this fails. This may happen for many different reasons,
including:

* The reference string is syntactically invalid (e.g. the fragment is
  not a valid JSON Pointer, or non-fragment parts are invalid).

* Canonicalizaation of a relative reference fails (e.g. `../foo.yaml`
  cannot be canonicalized with a `http://example.com/bar.yaml` as a
  context URL, because there is no container in the `/bar.yaml` context path with which to resolve the `..` component in the reference).

* The parser fails to retrieve content from the canonicalized URL.

* The content retrieved from the canonicalized URL is not valid JSON
  or YAML.

* The JSON Pointer supplied in the fragment does not address a value
  contained in the JSON object retrieved from the canonicalized URL.

In all such cases, the corresponding model value will appear to be
missing, but you will still be able to obtain reference information about it as described earlier. The fact that the reference
was found to be invalid - as well as details of the reason - will be
available the `Reference` object obtained via `getReference(...)`.


### The Reference Object

A `Reference` object, obtained via the `Overlay#getReference(...)` methods, supports the following methods:

* `String getRefString()` - returns the reference string appearing in
  the source reference object (the `$ref` property value)

* `String getCanonicalRefString()` returns the canonicalized reference
  string. 

* `String getFragment()`- returns the fragment portion, or `null` if
  there was none.

* `JsonNode getJson()` - returns the retrieved and parsed JSON
  structure addressed by the reference, or `null` if no value could be obtained (in this case the reference will be invalid).

* `boolean isValid()` - `true` if the reference could be resolved.

* `boolean isInvalid()` - `true` if the reference could not be
  resolved.

* `ResolutionException getInvalidReason()` - returns an exception explaining
  the reason behind a resolution failure (including a stack trace).

* `String getErrorReason().getMessage()` - get a human-readable explanation of the resolution failure.

## Manually Defined Methods for OpenAPI 3.0

Methods for certain objects have been defined manually to supplement
the standard behavior in some way. They are as follows:

### OpenApi3 Object

* `void validate()` - perform validation on entire model.
* `boolean isValid()` - if the model has not been validated, validate
  it. Then return `true` if there are no validation items at the
  `ERROR` severity level.
* `ValidationResults getValidationResults()` - validate the model if
  it has not been validated. Then return the results of the
  validation.
* `Collection<ValidationResults.ValidationItem>
  getValidationItems()` - shortcut for
  `getValidationResults().getItems()`. 

### Path Object

* `String getPathString()` - returns this path's path string (i.e. its key in the model's `paths` map)
* `Operation getGet()` - returns the `get` operation for this path.
* `Operation getPut()` - returns the `put` operation for this path.
* `Operation getPost()` - returns the `post` operation for this path.
* `Operation getDelete()` - returns the `delete` operation for this path.
* `Operation getOptions()` - returns the `options` operation for this path.
* `Operation getHead()` - returns the `head` operation for this path.
* `Operation getPatch()` - returns the `patch` operation for this path.
* `Operation getTrace()` - returns the `trace` operation for this path.

Each of the above also comes with corresponding non-elaborating `get`,
and `set` methods. E.g. `getGet(boolean elaborate)` and
`setGet(Operation get)`. In all cases, the effect is identical to
accessing the operations via the generated methods for the
`operations` map value, e.g. `getOperation("get")`.

## Overlay Methods

The following methods are available in all `Overlay` objects:

* `JsonOverlay<?> find(String path)` - navigate through the model
  from this point using the given JSONPointer, and return the located
  model object, or `null` if not found. The path is according to the
  actual JSON structure of the model. For example,
  `Overlay.of(method).find("/responses/200/headers/MyHeader/schema/enum/3").get()` would
  be equivalent to
  `method.getResponse("200").getHeader("MyHeader").getSchema().getEnum(3)`. (Note: the final `get()` call in the first case is used to obtain the `Object` value from the `JsonOverlay<Object>` value used to represent it in the parsed structure). 


* `IJsonOverlay<?> find(JsonPointer path)` - same as `String` version
  but with a `JsonPointer` object compiled from the same string.

* `boolean isPresent()`  - `true` if the object is actually considered
  present in the model - i.e. it was present in the JSON/YAML file
  from which the model was parsed, or it was added using the mutation
  API.

* `boolean isElaborated()` - `true` if the object has
  already been elaborated - see
  [Properties Value Elaboration](#properties-value-elaboration).

* `IJsonOverlay<?> getParent()` return the
  [overlay object](json-overlay-framework) that is the 
  parent of this one. Note that references *do not* establish
  parenting relationships among overlay objects. Only inlined model
  content does so. For example, imagine a schema named `Foo` defined
  in `/components/schemas/Foo` in a model, and referenced as the
  `items` schema in another schema named `FooList`. Then
  `Overlay.of(model.getSchema("Foo")).getParent()` and
  `Overlay.of(model.getSchema("FooList").getItemsSchema()).getParent()` will both
  return the map overlay object corresponding to the
  `model.getSchemas()` map. It is entirely possible for a value to be
  included in a model only through external references, and in such a
  case its parent will be `null`.

* `String getPathInParent()` - returns a slash-separated list of JSON
  property names that, in the JSON structure, would navigate from the
  parent's JSON value to this value. For example,
  `Overlay.of(model.getInfo()).getPathInParent()` is `"info"` and
  `model.getSchemas("Foo").getPathInParent()` is `"Foo"`. An example
  with a multi-component path is
  `Overlay.of(model.getSchemas()).getPathInParent()`, which is
  `"components/schemas"`.

* `JsonOverlay<?> getRoot()` - performs `getParent()` repeatedly until a
  `null` value is obtained, and return the final non-null overlay
  object in the sequence. This may not correspond to the root JSON value in a parsed file. For example, if a schema is included by reference and none of its ancestors in the referenced files is included, then that schema will be considered its own root.
  
* `OpenApi3 getModel()` Locates the root node in the parsed model of in which this value appears. Unlike `getRoot()`, this method navigates references. Note that this method returns a
  value of type `M` in an instance of the type `OpenApi<M>` that
  corresponds to the type of OpenAPI model that was parsed or
  created. Currently this will always be `OpenApi3`, but in the
  future, other types like Swagger 2.0 may be supported.

## Structural Choices

In creating an overall object model  to represent an OpenAPI 3.0
model, a number of choices were made, and some may be somewhat
unexpected. Here are the most likely cases of that:

### Vendor Extensions

Vendor extensions are always represented as map values (`Map<String,
Object>`).

Vendor extensions that are embedded in an object that
corresponds to a properties value in this API will appear as a map
value named `extensions` in that object. Thus we have
`schema.getExtensions()`, `schema.getExtension("x-whatever")`, etc.

Sometimes, vendor extensions appear embedded in other map values, and
they apply to that map as a whole. An example is the `paths` object in
an OpenAPI 3.0 model. This object is primarily a map of path strings
to path item objects, but it may also contain vendor extensions. The
extensions - like the paths themselves - are available from the
top-level model object, as in `model.getPathsExtensions()` and
`model.getPathsExtension("x-whatever")`.

### No Components Object

We do not implement a components object per-se. Doing so would only
lead to the addition of `getComponents()` to any code that wanted to
navigate to anything of interest within the object. Instead, the API
treats all the individual maps appearing in the `components` object of
a model as top-level map objects. Hence we have `model.getCallbacks()`
and `model.getCallbacksExtensions()` instead of
`model.getComponents().getCallbacks()` and
`model.getComponents().getCallbacksExtensions()`, as would be the case
if we had created a `Components` properties object.

### Security Requirements

The Security Requirement Object in the OpenAPI 3.0 is defined as a map
of names to string arrays. This does not fit the capabilities of the
[JSON Overlay Framework](#json-overlay-framework) used by the KaiZen
OpenAPI Parser, and so an intermediate object was introduced, called
`SecurityParemter`. The `SecurityRequirements` object is defined with
a map property named `requirement`, and `SecurityParameter` is defined
with a list property named `parameter`. Thus, for example, one might
use
`operation.getSecurityRequirement(0).getRequirement("petstore_auth").getParameter(0)`.

## Parser API

The `OpenApiParser` class is the entry point for parsing OpenAPI
models. It features automatic detection of the OpenAPI version to
which a model conforms, and it applies the corresponding
version-specific parser. (Currently, only OpenAPI 3.0 is implemented.)
The class of the result can be interrogated to determine the model
type and cast as needed.

When the model type is known in advance, one may instead use a
type-specific parser, e.g. `OpenApi3Parser` instead. Attempting to
parse a different type of model will fail, but the result will be of
the correct object type, with no interrogation or casting necessary.

Here we will focus on the `OpenApi3Parser` methods, which mimic those
of `OpenApiParser` (and, we expect, parsers for other versions of
OpenAPI).

Create a new parser using the empty constructor:
```java
OpenApi3Parser parser = new OpenApi3Parser();
```

### Parsing Options

Several method signatures exist for parsing a model:

* `OpenApi3 parse(String model, URL resolutionBase)` - parse a JSON or
  YAML string, with the given URL used for resolving any relative
  references encountered in the model. If `resolutionBase` is null, relative references will all fail resolution.

* `OpenApi3 parse(File specFile)` - parse the content of the given
  file, and use the corresponding file URL as the resolution base.

* `OpenApi3 parse(URI uri)` - parse the content retrieved from the
 given URI and use the corresponding URL as the resolution base.

* `OpenApi3 parse(URL url)` - parse the content retrieved from the
  given URL and use that same URL as the resolution base.

In all the above, validation occurs automatically, and validation
results are available from the model object. (See
[above](#openapi3-object).) Validation can be suppressed (but can be
performed later) by adding a final `false` argument to any of the
above `parse` methods.

## Serialization API

The serialization API applies to any `Overlay` adapter object but most commonly will be applied to complete models. It consists of a single method:

```java
JsonNode toJson(SerializationOptions.options... options)
```

The return value is of type `JsonNode` from the Jackson library. It
can be easily translated into either a JSON or YAML string using
so-called *mapper* objects from that library. For example:

```java
JsonNode serial = model.toJson();
String json = new ObjectMapper().writeValueAsString(serial);
String yaml = new YAMLMapper().writeValueAsString(serial);
String prettyYaml = new YAMLMapper().writerWithDefaultPrettyPrinter().writeValueAsString(serial);
```

Available options for the `toJson()` method include:

* `FOLLOW_REFS` - By default, objects that are defined by references
  are serialized using reference objects containing the
  (un-canonocalized) referene strings. With `FOLLOW_REFS`, the
  referenced structures will be inlined instead. If your model includes
  recursive reference structures, this will currently blow up, but we
  intend to fix that by emitting a reference object whenever recursion
  would otherwise occur.

* `KEEP_EMPTY` - Normally, emtpy lists and objects are omitted from
  the serialized output. This option causes them to be retained in the
  serialized structure.

  N.B. Neither treatment distinguishes between empty structures that
  were created automatically during the elaboration process, and empty
  structures that were present in the source model (or added via the
  mutation API). This is especially problematic in certain cases where
  empty structures actually mean something different from missing
  structures in the OpenAPI specification. For example, an empty
  `servers` list in an Operation Object overrides `servers` objects at
  the path or root level in the model, but a missing `servers` object
  does not. Until this issue is addressed properly, `toJson()` can
  yield models that differ semantically from their intended
  meaning. Round-tripping through the parser and the serializer can
  change the meaning of a model.
  
  There are a couple of places in the OpenAPI specification where
  missing structures are actually invalid, namely: the `paths`
  property of the root object, and the array values for properties in
  a Security Requirement Object. The serializer supplies empty objects
  in this case, regardless of the `KEEP_EMPTY` setting.

* `KEEP_ONE_EMPTY` - This is an internal option used by the serializer
  so that if an empty value is an element of a list object or a
  property value in a properties object, it will be rendered as empty
  regardless of the `KEEP_EMPTY` setting. Users are not expected to
  make use of this option.

## Builders

Builder APIs have not yet been implemented.

Additional information TBA.


