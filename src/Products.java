public abstract class Products {
    private int productID;
    private double discountRate;
    private int stockAmount;
    private String productName;
    private double price;
    private String brandName;
    private int storage;
    private double screenSize;
    private int RAM;

    public Products(int productID, double discountRate, int stockAmount, String productName, double price, String brandName, int storage, double screenSize, int RAM) {
        this.productID = productID;
        this.discountRate = discountRate;
        this.stockAmount = stockAmount;
        this.productName = productName;
        this.price = price;
        this.brandName = brandName;
        this.storage = storage;
        this.screenSize = screenSize;
        this.RAM = RAM;
    }

    public int getproductID() {
        return productID;
    }

    public void setproductID(int ID) {
        this.productID = ID;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrand(String brandName) {
        this.brandName = brandName;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }
}
