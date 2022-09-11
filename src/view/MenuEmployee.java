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

public class MenuEmployee {
    public static void menuEmployee() {
        ManagerClient clients = new ManagerClient("Client.txt");
        ManagerJewelry jewelies = new ManagerJewelry();
        ManagerEmployee managerEmployee = new ManagerEmployee("Employee.txt");
        int choice;
        int choice1;

        do {
            System.out.println("-----Menu-----");
            System.out.println("1. Jewlry Product\n" +
                    "2. Client Imformation \n" +
                    "3. Employee Imformation \n"+
                    "0 .Thoát\n" +
                    "----------------------");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    do {
                        System.out.println(" --- Jewlry Product ---");
                        System.out.println("1. Thêm sản phẩm \n" +
                                "2. Sửa thông tin sản phẩm \n" +
                                "3. Xóa sản phẩm\n" +
                                "4. Hiển thị thông tin sản phẩm \n" +
                                "5. Quay lại\n" +
                                "0. thoát chương trình\n" +
                                "---------------------------");
                        Scanner sc1 = new Scanner(System.in);
                        choice1 = sc1.nextInt();
                        switch (choice1){
                            case 1:
                                Jewlry jewlry = Product.getJewlryInfomation();
                                jewelies.addNewJewlry(jewlry);
                                break;
                            case 2:
                                int index = Product.getProductIndex();
                                jewlry = Product.getJewlryInfomation();
                                jewelies.setInfomationProduct(index, jewlry);
                                break;
                            case 3:
                                String idProduct1 = Product.getProductId();
                                jewelies.deleteProductById(idProduct1);
                                break;
                            case 4:
                                jewelies.displayjewlries();
                                break;
                            case 5:
                                menuEmployee();
                        }
                    }while (choice1 != 0);

                case 2:
                    do {
                        System.out.println(" --- Client Imformation ---");
                        System.out.println("1. Thêm khách hàng\n" +
                                "2. Sửa thông tin khách hàng\n" +
                                "3. Xóa khách hàng \n" +
                                "4. Tổng tiền thanh toán \n"+
                                "5. Hiển thị thông tin khách hàng\n" +
                                "6. Quay lại \n" +
                                "0. thoát chương trình.\n" +
                                "---------------------------------");
                        Scanner sc1 = new Scanner(System.in);
                        choice1 = sc1.nextInt();
                        switch (choice1){
                            case 1:
                                Client client1 = ClienAction.newClient();
                                clients.addNewClient(client1);
                                break;
                            case 2:
                                int index = ClienAction.getIndexOfPerson();
                                client1 = ClienAction.newClient();
                                clients.setClient(index, client1);
                                break;
                            case 3:
                                index = ClienAction.getIndexOfPerson();
                                clients.deletePerson(index);
                                break;
                            case 4:
                                String idProduct = ClienAction.getIdClient();
                                double money = clients.getMoney1(idProduct);
                                System.out.println(" tổng tiền thanh toán: " + money);
                                break;
                            case 5:
                                clients.displayPersons();
                                break;
                            case 6:
                                menuEmployee();
                        }
                    }while (choice1 != 0);

                case 3:
                    do {
                        System.out.println(" --- Employee Imformation ---");
                        System.out.println(
                                "1. Hiển thị thông tin của nhân viên\n" +
                                "2. Quay lại \n" +
                                "0. thoát chương trình\n" +
                                "---------------------------");
                        Scanner sc1 = new Scanner(System.in);
                        choice1 = sc1.nextInt();
                        switch (choice1){
                            case 1:
                                managerEmployee.displayPersons();
                                break;
                            case 2:
                                menuEmployee();
                        }
                    }while (choice1 != 0);

                case 0:
                    System.exit(0);
            }
        } while (choice != 0);
    }
}