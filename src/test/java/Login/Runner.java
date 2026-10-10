package Login;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PARALLEL_EXECUTION_ENABLED_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.EXECUTION_MODE_FEATURE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.EXECUTION_MODE_SCENARIO_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("Features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "Login")
@ConfigurationParameter(
    key = PLUGIN_PROPERTY_NAME,
    value = "pretty, html:target/cucumber-reports/cucumber.html, json:target/cucumber-reports/cucumber.json, util.ExtentReportListener"
)
@ConfigurationParameter(key = PARALLEL_EXECUTION_ENABLED_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = EXECUTION_MODE_FEATURE_PROPERTY_NAME, value = "concurrent")
@ConfigurationParameter(key = EXECUTION_MODE_SCENARIO_PROPERTY_NAME, value = "concurrent")
public class Runner {
}
