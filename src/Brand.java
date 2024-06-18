import java.util.*;
public class Brand implements Comparable<Brand> {
    private int ID;
    private String name;
    private static int idCounter =1 ;
    private static TreeSet <Brand> brandList = new TreeSet<>();
    public Brand(String name) {
        this.ID = idCounter++;
        this.name = name;
    }
    public Brand(){}
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    static {
        brandList.add(new Brand("Samsung"));
        brandList.add(new Brand("Lenovo"));
        brandList.add(new Brand("Apple"));
        brandList.add(new Brand("Huawei"));
        brandList.add(new Brand("Casper"));
        brandList.add(new Brand("Asus"));
        brandList.add(new Brand("HP"));
        brandList.add(new Brand("Xiaomi"));
        brandList.add(new Brand("Monster"));
    }
    @Override
    public int compareTo(Brand o){
        return this.name.compareTo(o.getName());
    }
    public void brandList(){
        for(Brand brand : brandList){
            System.out.println(brand.getName());
        }
    }
}
