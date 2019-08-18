package frameworkHelpers.web;

public class DriverManagerFactory {

    public static DriverManagers getManager(String driverType) {

        DriverManagers driverManager;

        switch (driverType.toUpperCase()) {
            case "CHROME":
                driverManager = new ChromeDriverManager();
                break;
            case "IE":
                driverManager = new IEDriverManager();
                break;
            case "FIREFOX":
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;

    }
}

