<img src="https://cdn2.hubspot.net/hubfs/597611/Assets_Swagger/KaiZen%20OpenAPI%20Parser%20Logo%20(medium).png" height="50%" width="50%" alt="KaiZen OpenAPI Parser Logo" />

# KaiZen OpenAPI Parser

## Overview ##

The KaiZen OpenApi Parser from RepreZen is a Java-based validating
parser for OpenAPI 3.0 offering full compliance with the
[OpenAPI 3.0 Specification](https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.0.md),
and a highly uniform read/write programming API.
[OpenAPI](http://openapis.org), formerly known as the Swagger
specification, is the industry-standard format for machine-readable
REST API descriptions.

Feature highlights of KaiZen OpenAPI Parser include:
* **High Performance** - Informal testing shows a 3x-4x performance
  improvement over the current Java Swagger 2.0 parser. This is
  largely attributable to a design based on adapting Jackson
  `JsonNode` objects, rather than deserializing to internal POJOs.
  
* **Read/Write API** - All aspects of a model may be interrogated and
  modified. We also plan to provide fluent builders for all
  model object types. We provide bidirectional navigation throughout the
  model, and every object that is a property value of its containing
  object (whether as a named field or a map entry) knows its own name.
  
* **Tolerant Reader** - The parser yields a fully accessible result
  from any valid JSON or YAML input - whether or not the input is a
  valid OpenAPI specification.
  
* **Separate validation** - All validation beyond basic
  JSON/YAML parsing is performed after the initial parse, and it can
  be disabled for speed. Validation goes beyond checking what can be
  expressed in JSON Schema, to include all requirements described in
  the OpenAPI specification.

* **Serialization** - Serialization to JSON or YAML is supported, and
  by default, round-tripping will not cause any reordering of model
  content.
  
* **Easy Evolution** - A YAML-based DSL is used to capture most of the
  details of the OpenAPI Specification. We use code generation to
  create interfaces and implementation classes. Member-level
  `@Generated` annotations make it possible to augment the generated
  sources with manual code that is preserved during re-generation.
  
* **Flexible Reference Handling** - All references are detected and
  during parsing, including references not technically permitted by
  the OpenAPI specification. References are normally traversed 
  automatically by the API, but full details of references and 
  their resolution status are also available.
  
* **Unpolluted API** - Many features of the parser API are not directly
  accessible from modeled objects, but are accessed via adapter objects.
  This ensures that these features will not collide with generated
  methods of the model API, even as new features are added to the
  OpenAPI specification in the future.
    
## Documentation

The [Getting Started Guide](GettingStarted.md) shows how to build the 
software locally, and contains a simple sample program that shows how 
to use the parser.

The [API Overview](API-Overview.md) describes the APIs presented in
the project, including the parser, the serializer, the read/write
model, and the treatment of references.

## Who's using KaiZen Parser?

Here's a starting list of projects that are currently using KaiZen OpenAPI Parser. If you don't see your project here, please open an issue or pull request to add it:

| Project Link | Description |
| --- | --- | 
| [Eclipse Vert.x](http://vertx.io/) | Eclipse Vert.x is a tool-kit for building reactive applications on the JVM. | 
| [RepreZen API Studio](http://reprezen.com/OpenAPI) | RepreZen API Studio is an integrated workbench for API design, documentation and development, built on the Eclipse platform. | 


## Current State

* The parser is currently based on the pre-release [revision 3.0.0-rc0](https://github.com/OAI/OpenAPI-Specification/blob/d232e6d3e1ea4038a533329a82876ae868e9cf13/versions/3.0.md). We are nearly ready with an upgrade to the [3.0.2 draft revision](https://github.com/OAI/OpenAPI-Specification/blob/v3.0.2-dev/versions/3.0.2.md).

* The [JsonOverlay Project](https://github.com/RepreZen/JsonOverlay) is a framework for creating parsers and APIs for YAML/JSON based DSLs. It is the backbone of the KaiZen OpenApi Parser. Features that that it provides include:
 
  * Read-Write API for all model objects, based on a YAML document that describes the OpenAPI model structure
  * Factories for model objects (used internally, but not currently well exposed to user code; that will change shortly)
  * Full handling of all references.
  * Serialization, reference inspection, navigation, and numerous other features via its `Overlay` adapter classes.
  * Position-aware parser providing URL, line and file number for all parsed objects, available through `Overlay` adapters and used by the KaiZen parser in its validation messages.

* Validations are currently all contained within this project, however many routine validations (e.g. validating proper JSON types throughout a model document, checking that required properties are present, etc.) will at some point be moved into the JsonOverlay project.

* Most validations are present, but there are a number that are currently missing, and some existing validations still reflect the OpenAPI specification in its pre-release revision 3.0.0-rc0. Work is underway on Issue #26](https://github.com/RepreZen/KaiZen-OpenApi-Parser/issues/26), which should result in a complete and robust implementation of all model validations, updated to the 3.0.2 revision (currently in draft status).

* Serialization is available via the `Overlay` adapter's `toJson` method. By default references appear in the serialized output, but an option causes references to be followed and inlined in the output. Recursive references cause serialization to blow up if this option is used.
  - A separate component, called "OpenAPI Normalizer," will soon be made available that will provide much greater control over the treatment of references. This is currently a private feature embedded in [RepreZen API Studio](https://www.reprezen.com/). Its primary function is to turn an OpenAPI model spread across multiple files into an equivalent single-file model. Options control which references are inlined, and which are _localized_ as named component objects in the constructed single-file model.
  
* A handful of high-level tests have been implemented:
  - *BigParseTest* parses a large model without validation and checks
    that every value node in the input is accessible in the expected
    fashion in the resulting model object.
  - *ExamplesTest* - Parses and validates all example models currently
    in the the `OAI/OpenAPI-Specification` GitHub repo.

    Many more tests are required!

* Few JavaDocs exist at present, unfortunately. There's an open issue
  to correct that.

### Packages

_Some of these packages are likely to be refactored out into separate
component Maven projects._

All packages are prefixed by `com.reprezen.kaizen`

* `oasparser`: Top-level package, directly includes
  `OpenApiParser` class and some things related to code generation.
  
* `oasparser.model3`: Generated model interfaces (generated by JsonOverlay)

* `oasparser.ovl3`: Generated model implementation classes (generated by JsonOverlay)

* `oasparser.val`: Base classes for validators

* `oasparser.val3`: Validators for all OpenAPI objects.

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
* [API Overview](API-Overview.md)
