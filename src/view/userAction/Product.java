package view.userAction;

import model.Client;
import model.Jewlry;

import java.util.Scanner;

public class Product {
    public static Jewlry getJewlryInfomation(){
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
    public static int getProductIndex() {
        System.out.println("Mời nhập sản phẩm cần thay đổi thông tin");
        Scanner scanner=new Scanner(System.in);
        int index=scanner.nextInt();
        return index;
    }
    public static String getProductId() {
        System.out.println("Nhập vị trí sản phẩm cần xóa: ");
        Scanner scanner=new Scanner(System.in);
        String productId=scanner.nextLine();
        return productId;
    }
}
