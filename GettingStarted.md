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

### Special Considerations for Tests

If you run tests, please note the following special instructions:

1. Set environment variable `OAS_PARSER_LAX_REQUIRED=true` in order to
   allow parse/validation tests of published OpenAPI3.0 examples to
   succeed. Some of the published examples are missing properties that
   the KaiZen parser treats as required - primarily the `type`
   parameter in `Schema` objects. The environment setting suppresses
   required property checks. 
   
   _Note:_ This is a temporary feature that allows tests to pass while
   we sort out whether our interpretation of `type` as a required 
   property is correct. This behavior will be moved once either our
   validator or the example models are fixed.

2. If you expect to frequently run tests, you should set GITHUB_AUTH
   environment variable to your GitHub `username:password`. The
   `ExamplesTest` test uses the GitHub API to retrieve the latest
   examples from the `OAI/OpenAPI-Specification` repo (currently, the
   [`dm/exampless` branch](https://github.com/OAI/OpenAPI-Specification/tree/dm/examples/examples/v3.0), and rate limits are severe for
   unauthenticated requests.

### Regenerating Code

The KaiZen parser generates interfaces and implementation classes for
all OpeanAPI object types, based on information provided in a
YAML-based DSL (`types3.yaml`). The git repo always contains
up-to-date copies of all these generated sources, but if you ever want
to regenerate them, you need to activate the `gen` maven profile, as
in:

```
mvn compile -P gen
```

## A Simple Example

You can take the parser for a spin with the following simple program,
or of course explore with your own models.

The program parses each of the
[four
example OpenAPI 3.0 models](https://github.com/OAI/OpenAPI-Specification/tree/dm/examples/examples/v3.0) currently available in the OAS GitHub
Repo. In each case, if validation succeeds, a summary of all the
model's paths, operations and operation parameters is
printed. Otherwise, all validation messages are printed.

As mentioned above, the examples currently fail validation because of
missing `type` properties in schema objects. If you provide "-n" as a
command line argument when running this program, validation will be
skipped, and you will see the paths, operations, and parameters as you
would for a valid model.

```
package test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import com.reprezen.kaizen.oasparser.OpenApiParser;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.val.ValidationResults.ValidationItem;

public class Test {

    public static void main(String[] args) throws URISyntaxException {
        boolean validate = !(args.length >= 1 && args[0].equals("-n"));
        for (String modelName : Arrays.asList("api-with-examples", "petstore", "petstore-expanded", "uber")) {
            URI modelUri = new URI(
                    "https://raw.githubusercontent.com/OAI/OpenAPI-Specification/dm/examples/examples/v3.0/" + modelName
                            + ".yaml");
            processModel(modelUri, validate);
        }
    }

    private static void processModel(URI modelUri, boolean validate) {
        OpenApi3 model = (OpenApi3) new OpenApiParser().parse(modelUri, validate);
        System.out.printf("== Model %s\n", modelUri);
        if (!validate || model.isValid()) {
            describeModel(model);
        } else {
            for (ValidationItem item : model.getValidationItems()) {
                System.out.println(item);
            }
        }
        System.out.printf("------\n\n");
    }

    private static void describeModel(OpenApi3 model) {
        System.out.printf("Title: %s\n", model.getInfo().getTitle());
        for (Path path : model.getPaths().values()) {
            System.out.printf("Path %s:\n", path.getKey());
            for (Operation op : path.getOperations().values()) {
                System.out.printf("  %s: [%s] %s\n", op.getKey().toUpperCase(), op.getOperationId(), op.getSummary());
                for (Parameter param : op.getParameters()) {
                    System.out.printf("    %s[%s]:, %s - %s\n", param.getName(), param.getIn(), getParameterType(param),
                            param.getDescription());
                }
            }
        }
    }

    private static String getParameterType(Parameter param) {
        Schema schema = param.getSchema();
        return schema != null ? schema.getType() : "unknown";
    }

}
```
