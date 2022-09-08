package view;

import controller.ManagerClient;
import controller.ManagerJewelry;
import model.Client;
import model.Jewlry;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerClient clients = new ManagerClient("Client.txt");
        ManagerJewelry jewelies = new ManagerJewelry();
        int choice;

        do {
            System.out.println("--Danh mục--");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Thêm khách hàng");
            System.out.println("5. Sửa thông tin khách hàng");
            System.out.println("6. Xóa thông tin khách hàng");
            System.out.println("7. Tính số tiền khách cần trả");
            System.out.println("8. Hiển thị danh sách sản phẩm");
            System.out.println("9. Hiển thị danh sách khách hàng");
            System.out.println("0 .Thoát");
            Scanner scanner=new Scanner(System.in);
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    Jewlry jewlry = getJewlryInfomation();
                    jewelies.addNewJewlry(jewlry);
                    break;
                case 2:
                    int index = getProductIndex();
                    jewlry = getJewlryInfomation();
                    jewelies.setInfomationProduct(index,jewlry);
                    break;
                case 3:
                    String idProduct1 = getProductId();
                    jewelies.deleteProductById(idProduct1);
                    break;
                case 4:
                    Client client1 = newClient();
                    clients.addNewClient(client1);
                    break;
                case 5:
                    index = getIndexOfPerson();
                    client1 = newClient();
                    clients.setClient(index,client1);
                    break;
                case 6:
                    index = getIndexOfPerson();
                    clients.deletePerson(index);
                    break;
                case 7:
                    String idProduct = getIdProduct();
                    int money = (int) jewelies.getMoney(idProduct);
                    System.out.println(" tổng tiền : "+money);
                    break;
                case 8:
                    jewelies.displayjewlries();
                    break;
                case 9:
                    clients.displayPersons();
                    break;
                case 0:
                    System.exit(0);
            }
        }while (choice!=0);
    }
    private static Jewlry getJewlryInfomation(){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        //String idProduct, String nameProduct, String typeProduct, String materialProduct, int weight, int ingredientPrice, int machiningPrice
        System.out.println(" nhập mã sản phẩm: ");
        String idProduct = sc.nextLine();
        System.out.println(" nhập tên sản phẩm: ");
        String nameProduct = sc.nextLine();
        System.out.println(" nhập loại sản phẩm: ");
        String typeProduct = sc.nextLine();
       int machiningPrice = 1100000;
        if (typeProduct.equals("choker"))
            machiningPrice = 1000000;
        else if (typeProduct.equals("ring")) {
            machiningPrice = 150000;
        } else if (typeProduct.equals("earrings")) {
            machiningPrice = 250000;
        } else if (typeProduct.equals("bracelet")) {
            machiningPrice = 200000;
        } else if (typeProduct.equals("anklet")) {
            machiningPrice = 250000;
        }
        System.out.println(" nhập trọng lượng sản phẩm: ");
        int weight = sc1.nextInt();
        System.out.println(" nhập chất liệu sản phẩm (Gold or Silver): ");
        String materialProduct = sc2.nextLine();
        int ingredientPrice;
        if (materialProduct.equals("Gold"))
             ingredientPrice = 6500000*weight;
        else ingredientPrice = 100000*weight;
        return new Jewlry(idProduct,nameProduct,typeProduct,materialProduct,weight,ingredientPrice,machiningPrice);
    }
    private static int getProductIndex() {
        System.out.println("Mời nhập sản phẩm cần thay đổi thông tin");
        Scanner scanner=new Scanner(System.in);
        int index=scanner.nextInt();
        return index;
    }
    private static String getProductId() {
        System.out.println("Nhập vị trí sản phẩm cần xóa: ");
        Scanner scanner=new Scanner(System.in);
        String productId=scanner.nextLine();
        return productId;
    }
    private static Client newClient(){
//        String id, String name, String information, String phoneNumber, String address
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.println("nhập id của khách hàng: ");
        String id = sc.nextLine();
        System.out.println(" nhập tên của khách hàng: ");
        String name = sc.nextLine();
        System.out.println(" nhập thông tin đặc biệt của khách hàng: ");
        String information = sc.nextLine();
        System.out.println(" nhâ số điện thoại: ");
        String phoneNumber = sc1.nextLine();
        System.out.println(" nhập địa chỉ của khách hàng: ");
        String address = sc1.nextLine();
        return new Client(id,name,information,phoneNumber,address,getJewlryInfomation());
    }
    private static int getIndexOfPerson() {
        System.out.println("Nhập vị trí khách hàng cần sửa đổi hoặc xóa");
        Scanner scanner=new Scanner(System.in);
        int index=scanner.nextInt();
        return index;
    }
    private static String getIdProduct() {
        System.out.println("Nhập mã sản phẩm: ");
        Scanner scanner2=new Scanner(System.in);
        String idProduct =scanner2.nextLine();
        return idProduct;
    }
}