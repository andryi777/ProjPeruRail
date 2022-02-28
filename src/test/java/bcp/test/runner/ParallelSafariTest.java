package bcp.test.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import bcp.test.browserstack.BrowserStackSerenityTest;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features = { "src/test/resources/features/" }, tags = { "@CompraTicketTrenBelmond" }, glue = {
"bcp" }, plugin = { "pretty", "html:target/serenity-reports/serenity-html-report",
		"json:target/serenity-reports/cucumber_report.json", "rerun:target/serenity-reports/rerun.txt" })
public class ParallelSafariTest extends BrowserStackSerenityTest {
}
