<img src="https://cdn2.hubspot.net/hubfs/597611/Assets_Swagger/KaiZen%20OpenAPI%20Parser%20Logo%20(medium).png" height="50%" width="50%" alt="KaiZen OpenAPI Parser Logo" />

# KaiZen OpenAPI Parser

## Overview ##

The KaiZen OpenApi Parser from RepreZen is a Java-based validating parser for
OpenAPI 3.0 offering full compliance with the
[OpenAPI 3.0 Specification](https://github.com/OAI/OpenAPI-Specification/blob/3.0.0-rc0/versions/3.0.md),
and a highly uniform read/write programming API.

Feature highlights include:
* **High Performance** - Informal testing shows a 3x-4x performance
  improvement over the current Java Swagger 2.0 parser. This is
  largely attributable to a design based on adapting Jackson
  `JsonNode` objects, rather than deserializing to internal POJOs.
  
* **Read/Write API** - All aspects of a model may be interrogated and
  modified. We also provide fluent builders for all
  model object types. We provide bidirectional navigation throughout the
  model, and every object that is a property value of its containing
  object (whether as a named field or a map entry) knows its own key.
  
* **Tolerant Reader** - The parser yields a fully accessible result
  from any valid JSON or YAML input - whether or not the input is a
  valid OpenAPI specification.
  
* **Separate, extensible validation** - All validation beyond base
  JSON/YAML parsing is performed after the initial parse, and it can
  be disabled for speed. Model-level validation (i.e. anything that can
  be checked with our provided Java API) is separated from
  injectable implementation-level validation. The latter covers anything
  that needs to look "under the covers", using methods of the implementation
  classes that lie outside the model API. For example, this
  is where unrecognized JSON properties would be noted and flagged, 
  as they are not visible from the model API.

* **Serialization** - Serialization to JSON or YAML is supported, and
  by default, round-tripping will not cause any reordering of model
  content.
  
* **DI-Ready** - Our API is interface-based and allows substitution of
  custom implementations that either augment or completely replace our
  provided implementation, using
  [Google Guice](https://github.com/google/guice) dependency
  injection.
  
* **Easy Evolution** - A YAML-based DSL is used to capture most of the
  details of the OpenAPI Specification. We use code generation to
  create interfaces and implementation classes. Member-level
  `@Generated` annotations make it possible to augment the generated
  sources with manual code that is preserved during re-generation.
  
* **Flexible Reference Handling** - References are detected and
  resolved after JSON/YAML parsing but before model-level parsing. All
  JSON references are processed, resulting in effective inlining for
  non-conforming references (i.e. anything other than path or
  component references specifically allowed in the
  specification). References are normally traversed automatically by
  the API, but full details of references and their resolution status
  are also available.
  
## Quick Start Documentation

The [Getting Started Guide](GettingStarted.md) shows how to build the 
software locally, and contains a simple sample program that shows how 
to use the parser.
  
## Current State

* `JsonOverlay` framework is fairly stable and working well.

* OpenAPI 3.0 type specification, and the generated code passes some
  early tests.

* Both read and write APIs are fully implemented, though not well
  tested. No builders have been created as yet.

* Model-level validation is mostly complete, but requires development
  of extensive tests, as well as a careful inventory of all
  requirements appearing in the specification (noting all uses of
  MUST, SHOULD, etc.) to ensure that validation is complete.

* Serialization has not yet been implemented.

* DI for implementation-level validators exists, but validators need
  to be written. This is likely to be limited to a small number of
  JSON-level validators, namely detecting where incompatible JSON
  types appear, and detecting unexpected property names. 

* A handful of high-level tests have been implemented:
  - *BigParseTest* parses a large model without validation and checks
    that every value node in the input is accessible in the expected
    fashion in the resulting model object.
  - *ExamplesTest* - Parses and validates all example models currently
    in the
    [`dm/examples`](https://github.com/OAI/OpenAPI-Specification/tree/dm/examples)
    branch of the `OAI/OpenAPI-Specification` GitHub repo.

    Many more tests are required!

* Few JavaDocs exist at present, unfortunately. There's an open issue
  to correct that.

### Packages

_Some of these packages are likely to be refactored out into separate
component Maven projects._

All packages are prefixed by `com.reprezen.kaizen`

* `oasparser`: Top-level package, directly includes
  `OpenApiParser` class and some things related to code generation
  that will probably move elsewehere.
  
* `oasparser.jsonoverlay`: The JSON Overlay framework underpinning
  the parser.
  
* `oasparser.jsonoverlay.std,coll`: Overlay classes for standard
  scalar types and collection types, respectively.
  
* `oasparser.jsonoverlay.gen`: Code generators for interfaces and
  overlay-based implementations of object types

* `oasparser.model3`: Generated model interfaces

* `oasparser.ovl3`: Generated model implementation classes (using
  JSON Overlay)

* `oasparser.val`: Base classes for validators, and primitive type
  validators.

* `oasparser.val3`: Model-level validators for all OpenAPI
  objects.

* `oasparser.val3.ovl`: Implementation-level validators for
  OpenAPI objects.

* `oasparser.test`: The handful of tests that have been
  implemented so far. More needed


## License
KaiZen OpenAPI Parser is provided under the Eclipse Public License (https://www.eclipse.org/legal/epl-v10.html)

## Contributing

We welcome serious contributors. However, we are at an early and
fast-changing phase in this project, so we recommend coordinating
with us before diving into a juicy bit of coding. This might spare 
you the frustration of finding that some sweeping low-level change
has rendered your efforts unusable.

If you would like to work with us, please drop us a line at
API.Community@RepreZen.com, or open a new issue if you have
a suggestion or want to report a bug or omission.

## Resources
* Blog Post: [Introducing KaiZen OpenAPI 3.0 Parser: fast, flexible Java parsing & validation](http://www.reprezen.com/blog/kaizen-openapi-3_0-parser-swagger-java-open-source)
* [Getting Started Guide](GettingStarted.md)
