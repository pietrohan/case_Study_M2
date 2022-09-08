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
        int choice;

        do {
            System.out.println("--Danh mục--");
            System.out.println("1. Thêm sản phẩm \n" +
                    "2. Sửa thông tin sản phẩm\n" +
                    "3. Xóa sản phẩm\n" +
                    "4. Thêm khách hàng\n" +
                    "5. Sửa thông tin khách hàng\n" +
                    "6. Xóa thông tin khách hàng\n" +
                    "7. Tính số tiền khách cần trả\n" +
                    "8. thêm nhân viên mới\n" +
                    "9. sửa thông tin của nhân viên\n" +
                    "10. xóa nhân viên\n" +
                    "11. tổng tiền lương của nhân viên\n" +
                    "12. Hiển thị danh sách sản phẩm\n" +
                    "13. Hiển thị danh sách khách hàng\n" +
                    "14. hiển thị danh sách nhân viên của cửa hàng\n" +
                    "0 .Thoát");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
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
                    Client client1 = ClienAction.newClient();
                    clients.addNewClient(client1);
                    break;
                case 5:
                    index = ClienAction.getIndexOfPerson();
                    client1 = ClienAction.newClient();
                    clients.setClient(index, client1);
                    break;
                case 6:
                    index = ClienAction.getIndexOfPerson();
                    clients.deletePerson(index);
                    break;
                case 7:
                    String idProduct = ClienAction.getIdProduct();
                    int money = (int) jewelies.getMoney(idProduct);
                    System.out.println(" tổng tiền thanh toán: " + money);
                    break;
                case 8:
                    Employee employee = EmployeeAction.newCEmployee();
                    managerEmployee.addNewEmployee(employee);
                    break;
                case 9:
                    index = EmployeeAction.getIndexOfPerson();
                    employee = EmployeeAction.newCEmployee();
                    managerEmployee.setEmployeeList(index, employee);
                    break;
                case 10:
                    index = EmployeeAction.getIndexOfPerson();
                    managerEmployee.deletePerson(index);
                    break;
                case 11:
                    String idEmployee = EmployeeAction.getIdEmployee();
                    double sumSalary = managerEmployee.sumSalaryEmployee(idEmployee);
                    System.out.println(" tổng tiền thanh toán: " + sumSalary);
                    break;
                case 12:
                    jewelies.displayjewlries();
                    break;
                case 13:
                    clients.displayPersons();
                    break;
                case 14:
                    managerEmployee.displayPersons();
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);
    }
}