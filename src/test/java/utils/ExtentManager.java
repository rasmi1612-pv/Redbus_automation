package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            // 1. Create report file with timestamp
            String reportPath = "./reports/RedBusReport_" + System.currentTimeMillis() + ".html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            // 2. Report UI Settings
            spark.config().setReportName("RedBus Automation Report");
            spark.config().setDocumentTitle("RedBus Automation Execution Report");
            spark.config().setTheme(Theme.DARK);
            spark.config().setEncoding("utf-8");

            // 3. Attach to extent
            extent = new ExtentReports();
            extent.attachReporter(spark);

            // 4. Execution Details / System Info
            extent.setSystemInfo("Project Name", "RedBus Automation");
            extent.setSystemInfo("Tester Name", "tester");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("OS Version", System.getProperty("os.version"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Executed On", System.getProperty("user.name"));
            extent.setSystemInfo("Build Number", "1.0.0");
            extent.setSystemInfo("Execution Time", java.time.LocalDateTime.now().toString());
        }
        
        return extent;
    }
}
