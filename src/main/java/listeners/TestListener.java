package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.log4j.Logger;

public class TestListener implements ITestListener {
    private static final Logger LOGGER = Logger.getLogger(TestListener.class);

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("PASSED ------>" + result.getMethod().getQualifiedName());
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        LOGGER.info("SKIPPED ------>" + result.getMethod().getQualifiedName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info("FAILURE ------>" + result.getMethod().getQualifiedName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("STARTED ------>" + result.getMethod().getQualifiedName());
    }
}
