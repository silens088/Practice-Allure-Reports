package qa.vitalii.allure;

import org.junit.jupiter.api.Test;
import qa.vitalii.allure.Steps.GithubSteps;

public class StepsAnnotatedTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 68;
    private static final String TAB_ISSUES = "Issues";
    private static final String URL_GITHUB = "https://github.com";

    private GithubSteps steps = new GithubSteps();

    @Test
    public void testGithub() {
        steps.openMainPage(URL_GITHUB);
        steps.seachForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab(TAB_ISSUES);
        steps.shoudSeeIssueWithNumber(ISSUE_NUMBER);

    }
}
