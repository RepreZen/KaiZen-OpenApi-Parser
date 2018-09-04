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

If you expect to frequently run tests, you should set GITHUB_AUTH
environment variable to your GitHub `username:password`. The
`ExamplesTest` test uses the GitHub API to retrieve the latest
examples from the `OAI/OpenAPI-Specification` repo (specifically,
folder `examples/v3.0` in the `master` branch), and rate limits are
severe for unauthenticated requests.

### Regenerating Code

The KaiZen parser uses JsonOverlay to generate interfaces and implementation classes for
all OpenAPI object types, based on information provided in a
YAML-based DSL (`types3.yaml`). The git repo always contains
up-to-date copies of all these generated sources, but if you ever want
to regenerate them, you need to activate the `gen` maven profile, as
in:

```
mvn test -P gen
```
Code generation takes place during the maven `generate-sources` phase, preceding compilation. The `gen` profile is disabled by default, so unless you specifically activate it, your build will use existing sources, without regeneration.

The generator makes use of a Java parser to parse existing source files before regenerating them. This is so that class members that are *not* marked with the `@Generated` annotation can be preserved during regeneration. If this parse fails for whatever reason, the overall build will be interrupted at that point and will fail. To recover from this scenario, you can check out the most recently checked-in files from your git working tree and then retry. To ensure that this will be possible as you make your own changes to the code it is recommended that you ALWAYS check in parseable copies of the generated sources after regeneration, before you begin any customization of those sources (adding non-generated members or replacements for nonrmally-generated members).


## Learn About the APIs

See the [API Overview](API-Overview.md) for a detailed description of
the APIs offered by the parser, the serializer, and the model
representation, including reference treatments.

## A Simple Example

You can take the parser for a spin with the following simple program,
or of course explore with your own models.

The program parses each of the
[example OpenAPI 3.0 models](https://github.com/OAI/OpenAPI-Specification/tree/master/examples/v3.0)
currently available in the `OAI/OpenAPI-Specification` GitHub Repo. In
each case, if validation succeeds, a summary of all the model's paths,
operations and operation parameters is printed. Otherwise, all
validation messages are printed.

At the time of this writing, validation fails on the
`callback-example` because that example does not include the required
`openapi` and `info` properties.

```java
package test;

import java.net.URI;
import java.util.Arrays;

import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.kaizen.oasparser.OpenApi3Parser;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.val.ValidationResults.ValidationItem;

public class GettingStarted {

	public static void main(String[] args) throws Exception {
		boolean validate = !(args.length >= 1 && args[0].equals("-n"));
		for (String modelName : Arrays.asList("api-with-examples", "callback-example", "link-example", "petstore",
				"petstore-expanded", "uspto")) {
			URI modelUri = new URI("https://raw.githubusercontent.com/OAI/OpenAPI-Specification/master/examples/v3.0/"
					+ modelName + ".yaml");
			processModel(modelUri, validate);
		}
	}

	private static void processModel(URI modelUri, boolean validate) throws Exception {
		OpenApi3 model = new OpenApi3Parser().parse(modelUri, validate);
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
			System.out.printf("Path %s:\n", Overlay.of(path).getPathInParent());
			for (Operation op : path.getOperations().values()) {
				System.out.printf("  %s: [%s] %s\n", Overlay.of(op).getPathInParent().toUpperCase(),
						op.getOperationId(), op.getSummary());
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

}```
