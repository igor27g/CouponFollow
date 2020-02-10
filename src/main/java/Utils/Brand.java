package Utils;

import java.util.Properties;

public class Brand {

    private final String brandName;

    public Brand(Properties properties) {
        brandName = properties.getProperty("Brand.brandName");
    }

    public String getBrandName() {
        return brandName;
    }

}
