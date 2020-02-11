package Utils;

public class ConfigurationReader extends FileReader {

    private String configurationLocation;

    private String hubUrl;
    private String baseUrl;
    private String browser;
    private String brandName;
    private String couponCode;

    public ConfigurationReader(String configurationLocation) {
        super(configurationLocation);
        this.configurationLocation = configurationLocation;
    }

    void loadData() {
        hubUrl = properties.getProperty("hubUrl");
        baseUrl = properties.getProperty("baseUrl");
        browser = properties.getProperty("browser");
        brandName = properties.getProperty("brandName");
        couponCode = properties.getProperty("couponCode");
    }

    public String getBrowser() {
        return browser;
    }

    public String getHubUrl() {
        return hubUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getBrandName() {
        return brandName;
    }

    public String  getCouponCode() {
        return couponCode;
    }
    public String getConfigurationLocation() {
        return configurationLocation;
    }

}
