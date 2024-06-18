import java.util.ArrayList;

public class Phone extends Products {
    private int camera;
    private double battery;
    private String color;
    private ArrayList<Phone> phoneList;

    public Phone(int ID,double discountRate, int stockAmount, String productName, double price, String brandName, int storage, double screenSize, int camera, double battery, int RAM, String color) {
        super(ID, discountRate, stockAmount, productName, price, brandName, RAM, screenSize, storage);
        this.camera = camera;
        this.battery = battery;
        this.color = color;

    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(ArrayList<Phone> phoneList) {
        this.phoneList = phoneList;
    }
}
