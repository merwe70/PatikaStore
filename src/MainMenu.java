import java.util.Scanner;
public class MainMenu {
    PhoneMenu phoneMenu = new PhoneMenu();
    NotebookMenu notebbokMenu = new NotebookMenu();
    Brand brand = new Brand();
    static Scanner input = new Scanner(System.in);
    public void start (){
        System.out.println("Patika Store'a Hoş Geldiniz ! ");
        System.out.println("1 - Telefon İşlemleri");
        System.out.println("2 - NoteBook İşlemleri");
        System.out.println("3 - Markaları Listeleyin");
        System.out.println("0 - Çıkış Yap");
        System.out.print("Yapmak istediğiniz işlemi seçiniz : ");
        int select = input.nextInt();
        switch (select){
            case 1:
                phoneMenu.start();
                break;
            case 2:
                notebbokMenu.start();
                break;
            case 3:
                brand.brandList();
                start();
                break;
            case 0:
                System.out.println("Tekrar Görüşmek Üzere");
                break;
            default:
                System.out.println("Geçersiz Değer Tekrar Giriniz.");
                start();
        }
    }
}
