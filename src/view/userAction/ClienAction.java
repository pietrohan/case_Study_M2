package view.userAction;

import model.Client;

import java.util.Scanner;

public class ClienAction {
    public static Client newClient(){
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
        System.out.println(" nhập số điện thoại: ");
        String phoneNumber = sc1.nextLine();
        System.out.println(" nhập địa chỉ của khách hàng: ");
        String address = sc1.nextLine();
        return new Client(id,name,information,phoneNumber,address,Product.getJewlryInfomation());
    }
    public static int getIndexOfPerson() {
        System.out.println("Nhập vị trí khách hàng cần sửa đổi hoặc xóa");
        Scanner scanner=new Scanner(System.in);
        int index=scanner.nextInt();
        return index;
    }
    public static String getIdClient() {
        System.out.println("Nhập mã khách hàng: ");
        Scanner scanner2=new Scanner(System.in);
        String idProduct =scanner2.nextLine();
        return idProduct;
    }
}
