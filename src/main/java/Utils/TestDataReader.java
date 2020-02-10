package Utils;

public class TestDataReader extends FileReader {

    private String testDataLocation;
    private Brand brand;

    public TestDataReader(String testDataLocation) {
        super(testDataLocation);
        this.testDataLocation = testDataLocation;
    }

    void loadData() {
        brand = new Brand(properties);
    }

    public Brand getBrand() {
        return brand;
    }


}
