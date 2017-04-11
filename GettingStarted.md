# Getting Started with KaiZen OpenAPI Parser

## Build

All the software currently resides in a single Eclipse/Maven project
located in `kaizen-openapi-parser`.

From this directory, you can use:
* `mvn package` to build locally
* `mvn install` to build and install into your local maven repository
  cache
* `mvn test` to compile and run tests
* etc.

If you run tests, please note the following special instructions:

1. Set environment variable OAS_PARSER_LAX_REQUIRED=true in order to
   allow parse/validation tests of published OpenAPI3.0 examples to
   succeed. Some of the published examples are missing properties that
   the KaiZen parser treats as required - primarily the `type`
   parameter in `Schema` objects. The environment setting suppresses
   required property checks.

2. If you expect to frequently run tests, you should set GITHUB_AUTH
   environment variable to your GitHub username:password. The
   `ExamplesTest` test uses the GitHub API to retrieve the latest
   examples from the `OAI/OpenAPI-Specification` repo (currently, the
   `dm/exampless` branch), and rate limits are severe for
   unauthenticated requests.

## A Simple Example

You can take the parser for a spin with the following simple program,
or of course explore with your own models.

The program parses each of the
[https://github.com/OAI/OpenAPI-Specification/tree/dm/examples/examples/v3.0](four
example OpenAPI 3.0 models) currently available in the OAS GitHub
Repo. In each case, if validation succeeds, a summary of all the
model's paths, operations and operation parameters is
printed. Otherwise, all validation messages are printed.

As mentioned above, the examples currently fail validation because of
missing `type` properties in schema objects. If you provide "-n" as a
command line argument when running this program, validation will be
skipped, and you will see the paths, operations, and parameters as you
would for a valid model.
