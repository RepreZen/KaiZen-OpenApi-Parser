# The KaiZen OpenAPI Parser API and Object Model

# Overall Structure

# The OpenApi Object Model

In its most common use-case, the KaiZen OpenAPI Parser consumes an
OpenAPI model and creates Java objects that expose and allow
manipulation of its component parts. Those objects are constructed
from classes and interfaces that are nearly 100% generated from a
succinct catalog of OpenAPI objects, their properties, and their
relationships. As a result, the object models are highly uniform.

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
names of properties belonging to the map object. This scheme even
allows more than one map object to coexistin the same JSON object,
requiring that the associated regular expressions be mutually
exclusive.

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

* `Collection<? extends Server> getServers()` - get the list of server
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

* `void setSetServers(Collection<? extends Server> servers)` - set the
  servers to the given list.

* `void setServer(int index, Server server)` - replace the server at
  the given position in the servers list. If the index matches the
  current size of the servers list, the server is added to the end of
  list. Otherwise, the index must specify a current position in the
  list.

* `void addServer(Server server)` - add the given server to the end of
  the servers list.

* `void removeServer(int index)` - remove the server at the given list
  position.

### Map Values

As an example of a map value, we'll use the `paths` property of an
OpenAPI 3.0 model.

* `Map<String, ? extends Path> getPaths()` - obtain the map of path
  strings to path item objects. As in the case for lists, an empty map
  is returned if the `paths` property is missing from the model.

* `boolean hasPaths()` - whether the model has a `paths` property.

* `boolean hasPath(String name)` - whether a path with the given path
  string appears in the model's `paths` object`.

* `Path getPath(String name)` - obtain the path item with the given
  path string.

* `void setPaths(Map<String, ? extends Path> paths)` - set the `paths`
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
  properties object, from the model. As with lists and maps, this will
  never be null.

* `void setInfo(Info info)` - set the model's `info` value to the
  given properties object.


