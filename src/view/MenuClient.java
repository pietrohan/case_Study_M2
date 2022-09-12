package view;

import controller.ManagerClient;
import controller.ManagerEmployee;
import controller.ManagerJewelry;
import model.Client;
import model.Employee;
import model.Jewlry;
import view.userAction.ClienAction;
import view.userAction.EmployeeAction;
import view.userAction.Product;

import java.util.Scanner;

public class MenuClient {
    public static void menuClient() {
        ManagerJewelry jewelies = new ManagerJewelry();
        jewelies.displayjewlries();
        int choice =-1;
        do {
            System.out.println("1. Tìm kiếm sản phẩm: \n" +
                    "0.  Thoát chương trình");
            switch (choice){
                case 1:
                    String idProduct = Product.getProductId();
                    Jewlry jewlry1 = jewelies.search(idProduct);
                    System.out.println(jewlry1);
            }
        }while (choice!=0);


    }
}