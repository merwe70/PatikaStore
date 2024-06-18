import java.util.ArrayList;
import java.util.Scanner;
public class NotebookMenu {
    ArrayList<Notebook> notebookList;
    static Scanner input = new Scanner(System.in);
    public NotebookMenu() {
        this.notebookList = notebookList;
    }
    public ArrayList<Notebook> getNotebookList() {
        if (notebookList == null) {
            notebookList = new ArrayList<>();
        }
        return notebookList;
    }
    public void setNotebookList() {
        this.notebookList = notebookList;
    }
    public void start() {
        initialNotebookList();
        boolean toMainMenu = true;
        while (toMainMenu) {
            System.out.println("Notebook İşlemleri Yapacağınız İşlemi Seçiniz.");
            System.out.println("1 - Notebbokları Listele");
            System.out.println("2 - Yeni Notebook Ekle");
            System.out.println("3 - ID Numarasına Göre Sil.");
            System.out.println("4 - ID Numarasına Göre Göster.");
            System.out.println("5 - Markasına Göre Göster.");
            System.out.println("0 - Üst Menüye Dön.");
            System.out.print("Yapmak istediğiniz işlemi seçiniz : ");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    showNotebookList();
                    break;
                case 2:
                    addNotebookList();
                    break;
                case 3:
                    deleteNotebookList();
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
    public void initialNotebookList() {

        Notebook nt1 = new Notebook(1, 10, 10, "Huawei Notebook 14", 7000.0, "Huawei", 512, 14.5, 16);
        Notebook nt2 = new Notebook(2, 10, 10, "Lenovo v14 IGL", 3699.0, "Lenovo", 1024, 14.0, 8);
        Notebook nt3 = new Notebook(3, 5, 8, "Asus Tuf Gaming", 8199.0, "Asus", 2048, 16.0, 32);

        getNotebookList().add(nt1);
        getNotebookList().add(nt2);
        getNotebookList().add(nt3);
    }
    public void showNotebookList() {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("| %-4s| %-20s| %-8s| %-12s| %-10s| %-6s| %-6s|%n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("---------------------------------------------------------------------------------");
        for (Notebook noteBook : getNotebookList()) {
            System.out.printf("| %-4s| %-20s| %-8s| %-12s| %-10s| %-6s| %-6s|%n",
                    noteBook.getproductID(), noteBook.getBrandName(), noteBook.getPrice(), noteBook.getBrandName(), noteBook.getStorage(), noteBook.getScreenSize(), noteBook.getRAM());
        }
        System.out.println("---------------------------------------------------------------------------------");
    }
    public void addNotebookList() {
        ArrayList<Integer> notebookIDs = new ArrayList<>();
        for (Notebook notebook : getNotebookList()) {
            notebookIDs.add(notebook.getproductID());
        }
        System.out.print("Ürün ID'si giriniz : ");
        int inputID = input.nextInt();
        if (!notebookIDs.contains(inputID)) {
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


            System.out.print("Ürünün RAMi Giriniz : ");
            int inputRAM = input.nextInt();


            System.out.print("Ürünün Stoktaki Sayısını Giriniz : ");
            int inputStock = input.nextInt();

            System.out.print("Ürünün indirimini Giriniz : ");
            double inputDiscountRate = input.nextDouble();

            Notebook addNotebook = new Notebook(inputID, inputDiscountRate, inputStock, inputProductName, inputPrice, inputBrandName, inputStorage, inputScreenSize, inputRAM);
            getNotebookList().add(addNotebook);
            System.out.println("Başarıyla Eklendi.");
            showNotebookList();
        } else {
            System.out.println("Geçersiz ID");
        }
    }
    public void deleteNotebookList() {
        showNotebookList();
        System.out.print("Silinecek ID numarasını giriniz : ");
        int idNumber = input.nextInt();
        try {
            for (Notebook notebook : getNotebookList()) {
                if (idNumber == notebook.getproductID()) {
                    getNotebookList().remove(notebook);
                    System.out.println(notebook.getProductName() + " Silindi");
                } else {
                    System.out.println("işlem yapılamdı yanlış ID girildi.");
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        showNotebookList();
    }
    public void filterById() {
        ArrayList<Notebook> filtredArr = new ArrayList<>();
        System.out.print("Gösterilecek ID numarasını giriniz : ");
        int idNumber = input.nextInt();
        try {
            for (Notebook notebook : getNotebookList()) {
                if (idNumber == notebook.getproductID()) {
                    filtredArr.add(notebook);
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("| %-4s| %-20s| %-8s| %-12s| %-10s| %-6s| %-6s|%n",
                            notebook.getproductID(), notebook.getBrandName(), notebook.getPrice(), notebook.getBrandName(), notebook.getStorage(), notebook.getScreenSize(), notebook.getRAM());
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------");
                } else {
                    System.out.println("işlem yapılamdı yanlış ID girildi.");
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public void filterByBrand() {
        ArrayList<Notebook> filtredArrByBrand = new ArrayList<>();
        System.out.print("Gösterilecek Markayı Giriniz : ");
        String brandName = input.next();
        try {
            for (Notebook notebook : getNotebookList()) {
                if (brandName.equals(notebook.getBrandName())) {
                    filtredArrByBrand.add(notebook);
                    for (Notebook filterNotebook : filtredArrByBrand) {
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
                        System.out.printf("| %-4s| %-20s| %-8s| %-12s| %-10s| %-6s| %-6s|%n",
                                notebook.getproductID(), notebook.getBrandName(), notebook.getPrice(), notebook.getBrandName(), notebook.getStorage(), notebook.getScreenSize(), notebook.getRAM());
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