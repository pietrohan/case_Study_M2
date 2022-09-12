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

public class MenuAdmin {
    public static void menuAdmin() {
        ManagerClient clients = new ManagerClient("Client.txt");
        ManagerJewelry jewelies = new ManagerJewelry();
        ManagerEmployee managerEmployee = new ManagerEmployee("Employee.txt");
        int choice =-1;
        int choice1 =-1;

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
                                "5. Tìm kếm sản phẩm \n" +
                                "6. Quay lại\n" +
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
                                String idProduct = Product.getProductId();
                                Jewlry jewlry1 = jewelies.search(idProduct);
                                System.out.println(jewlry1);
                            case 6:
                                menuAdmin();
                        }
                    }while (choice1 != 0);

                case 2:
                    do {
                        System.out.println(" ----- Client Imformation -----");
                        System.out.println("1. Thêm khách hàng\n" +
                                "2. Sửa thông tin khách hàng\n" +
                                "3. Xóa khách hàng \n" +
                                "4. khách hàng thanh toán (nhập id Client) \n"+
                                "5. Hiển thị thông tin khách hàng\n" +
                                "6. Tìm kiếm khách hàng\n" +
                                "7. Quay lại \n" +
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
                                String idClient = ClienAction.getIdClient();
                                double money = clients.getMoney1(idClient);
                                System.out.println(" tổng tiền thanh toán: " + money);
                                break;
                            case 5:
                                clients.displayPersons();
                                break;
                            case 6:
                                String id = Product.getProductId();
                                Client client = clients.search(id);
                                System.out.println(client);
                            case 7:
                                menuAdmin();
                        }
                    }while (choice1 != 0);

                case 3:
                    do {
                        System.out.println(" --- Employee Imformation ---");
                        System.out.println("1. Thêm nhân viên\n" +
                                "2. Sửa thông tin nhân viên\n" +
                                "3. Xóa nhân viên khỏi hệ thống \n" +
                                "4. Tổng tiền lương của nhân viên nhận được \n"+
                                "5. Hiển thị thông tin của nhân viên\n" +
                                "6. Quay lại \n" +
                                "0. thoát chương trình\n" +
                                "---------------------------");
                        Scanner sc1 = new Scanner(System.in);
                        choice1 = sc1.nextInt();
                        switch (choice1){
                            case 1:
                                Employee employee = EmployeeAction.newCEmployee();
                                managerEmployee.addNewEmployee(employee);
                                break;
                            case 2:
                                int index = EmployeeAction.getIndexOfPerson();
                                employee = EmployeeAction.newCEmployee();
                                managerEmployee.setEmployeeList(index, employee);
                                break;
                            case 3:
                                index = EmployeeAction.getIndexOfPerson();
                                managerEmployee.deletePerson(index);
                                break;
                            case 4:
                                String idEmployee = EmployeeAction.getIdEmployee();
                                double sumSalary = managerEmployee.sumSalaryEmployee(idEmployee);
                                System.out.println(" tổng tiền lương tháng: " + sumSalary);
                                break;
                            case 5:
                                managerEmployee.displayPersons();
                                break;
                            case 6:
                                menuAdmin();
                        }
                    }while (choice1 != 0);

                case 0:
                    System.exit(0);
            }
        } while (choice != 0);
    }
}