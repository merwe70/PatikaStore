import java.util.*;
import java.util.Scanner;

public class PhoneMenu {
    ArrayList<Phone> phoneList;

    static Scanner input = new Scanner(System.in);

    public PhoneMenu() {
        this.phoneList = phoneList;
    }

    public ArrayList<Phone> getPhoneList() {
        if (phoneList == null) {
            phoneList = new ArrayList<>();
        }

        return phoneList;
    }

    public void setPhoneList(ArrayList<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public void start() {
        initialPhoneList();
        boolean toMainMenu = true;
        while(toMainMenu){
            System.out.println("Telefon İşlemleri Yapacağınız İşlemi Seçiniz.");
            System.out.println("1 - Telefonları Listele");
            System.out.println("2 - Yeni Telefon Ekle");
            System.out.println("3 - ID Numarasına Göre Sil.");
            System.out.println("4 - ID Numarasına Göre Göster.");
            System.out.println("5 - Markasına Göre Göster.");
            System.out.println("0 - Üst Menüye Dön.");
            System.out.print("Yapmak istediğiniz işlemi seçiniz : ");
            int select = input.nextInt();

            switch (select) {
                case 1:
                    showPhoneList();
                    break;
                case 2:
                    addPhoneList();
                    break;
                case 3:
                    deletePhoneList();
                    break;
                case 4:
                    filterById();
                    break;
                case 5:
                    filterByBrand();
                    break;
                case 0:
                    toMainMenu = false;
                    break;
                default:
                    System.out.println("Geçersiz Sayı Girildi Tekrar Giriniz.");
            }
        }
    }

    public void initialPhoneList() {

        Phone samsungGalaxyA51 = new Phone(1, 10, 5, "Samsung Galaxy A51", 3199.00, "Samsung", 128, 6.5, 32, 4000.0, 6, "Siyah");
        Phone iphone11 = new Phone(2, 5, 5, "Apple iPhone 11", 4299.00, "Apple", 512, 6.3, 32, 3600.0, 12, "Kırmızı");
        Phone redMi = new Phone(3, 15, 5, "Xiaomi", 2199.00, "Xiaomi", 128, 7.2, 16, 4800.0, 6, "Beyaz");

        getPhoneList().add(samsungGalaxyA51);
        getPhoneList().add(iphone11);
        getPhoneList().add(redMi);

    }
    public void showPhoneList() {

        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s| %-20s| %-8s| %-12s| %-10s| %-6s| %-6s| %-8s| %-9s| %-6s| %-9s|%n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM", "Pil", "Renk", "Stok", "İndirim");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        for (Phone phone : getPhoneList()) {
            System.out.printf("| %-4s| %-20s| %-8s| %-12s| %-10s| %-6s| %-6s| %-8s| %-9s| %-6s| %-9s|%n",
                    phone.getproductID(), phone.getProductName(), phone.getPrice(), phone.getBrandName(), phone.getStorage(),
                    phone.getScreenSize(), phone.getRAM(), phone.getBattery(), phone.getColor(),
                    phone.getStockAmount(), phone.getDiscountRate());
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
    }

    public void addPhoneList() {

        ArrayList<Integer> phoneIDs = new ArrayList<>();

        for (Phone phones : getPhoneList()) {
            phoneIDs.add(phones.getproductID());
        }

        System.out.print("Ürün ID'si giriniz : ");
        int inputID = input.nextInt();

        if (!phoneIDs.contains(inputID)) {
            System.out.print("Ürünün Adı Giriniz : ");
            String inputProductName = input.next();

            System.out.print("Ürünün Fiyatı Giriniz : ");
            double inputPrice = input.nextDouble();

            System.out.print("Ürünün Markası Giriniz : ");
            String inputBrandName = input.next();

            System.out.print("Ürünün Depolama Boyutu Giriniz : ");
            int inputStorage = input.nextInt();

            System.out.print("Ürünün Ekran Boyutunu Griniz : ");
            double inputScreenSize = input.nextDouble();

            System.out.print("Ürünün Kamera Pixeli Giriniz : ");
            int inputCamera = input.nextInt();

            System.out.print("Ürünün Pil Gücünü Giriniz : ");
            int inputBatery = input.nextInt();

            System.out.print("Ürünün RAMi Giriniz : ");
            int inputRAM = input.nextInt();

            System.out.print("Ürünün Rengi Giriniz : ");
            String inputColor = input.next();

            System.out.print("Ürünün Stoktaki Sayısını Giriniz : ");
            int inputStock = input.nextInt();

            System.out.print("Ürünün indirimini Giriniz : ");
            double inputDiscountRate = input.nextDouble();

            Phone addPhone = new Phone(inputID, inputDiscountRate, inputStock, inputProductName, inputPrice, inputBrandName, inputStorage, inputScreenSize, inputCamera, inputBatery, inputRAM, inputColor);
            getPhoneList().add(addPhone);
            System.out.println("Başarıyla Eklendi.");
            showPhoneList();
        } else {
            System.out.println("Geçersiz ID");
        }
    }

    public void deletePhoneList() {
        showPhoneList();
        System.out.print("Silinecek ID numarasını giriniz : ");
        int idNumber = input.nextInt();

        try {
            for (Phone phone : getPhoneList()) {
                if (idNumber == phone.getproductID()) {

                    getPhoneList().remove(phone);
                    System.out.println(phone.getProductName() + " Silindi");
                } else {
                    System.out.println("işlem yapılamdı yanlış ID girildi.");
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        showPhoneList();
    }

    public void filterById(){

        ArrayList<Phone> filtredArr = new ArrayList<>();

        System.out.print("Gösterilecek ID numarasını giriniz : ");
        int idNumber = input.nextInt();

        try {
            for (Phone phone : getPhoneList()) {
                if (idNumber == phone.getproductID()) {
                    filtredArr.add(phone);
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("| %-4s| %-20s| %-8s| %-12s| %-10s| %-6s| %-6s| %-8s| %-9s| %-6s| %-9s|%n",
                            phone.getproductID(), phone.getProductName(), phone.getPrice(), phone.getBrandName(), phone.getStorage(),
                            phone.getScreenSize(), phone.getRAM(), phone.getBattery(), phone.getColor(),
                            phone.getStockAmount(), phone.getDiscountRate());
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------");

                } else {
                    System.out.println("işlem yapılamdı yanlış ID girildi.");
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void filterByBrand(){
        ArrayList<Phone> filtredArrByBrand = new ArrayList<>();

        System.out.print("Gösterilecek Markayı Giriniz : ");
        String brandName = input.next();

        try {
            for (Phone phone : getPhoneList()) {
                if (brandName.equals(phone.getBrandName())){
                    filtredArrByBrand.add(phone);
                    for(Phone filterPhone: filtredArrByBrand){
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
                        System.out.printf("| %-4s| %-20s| %-8s| %-12s| %-10s| %-6s| %-6s| %-8s| %-9s| %-6s| %-9s|%n",
                                filterPhone.getproductID(), filterPhone.getProductName(), filterPhone.getPrice(), filterPhone.getBrandName(), filterPhone.getStorage(),
                                filterPhone.getScreenSize(), filterPhone.getRAM(), filterPhone.getBattery(), filterPhone.getColor(),
                                filterPhone.getStockAmount(), filterPhone.getDiscountRate());
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
                    }
                } else {
                    System.out.println("işlem yapılamdı marka girildi.");
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
