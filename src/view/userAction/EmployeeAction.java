package view.userAction;

import model.Client;
import model.Employee;

import java.util.Scanner;

public class EmployeeAction {
    public static Employee newCEmployee(){
//String idEmployee, String name, String age, String address, String phoneNumber, double salary, double bonus,fine
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.println("nhập id của nhân viên: ");
        String idEmployee = sc.nextLine();
        System.out.println(" nhập tên của nhân viên: ");
        String name = sc.nextLine();
        System.out.println(" nhập tuổi của nhân viên: ");
        String  age = sc.nextLine();
        System.out.println(" nhập số điện thoại: ");
        String phoneNumber = sc1.nextLine();
        System.out.println(" nhập địa chỉ của nhân viên: ");
        String address = sc1.nextLine();
        System.out.println(" nhập số lương cứng: ");
        double salary = sc2.nextDouble();
        System.out.println(" nhập tiền thưởng trong tháng: ");
        double bonus = sc2.nextDouble();
        System.out.println(" nhập tiền phạt trong tháng: ");
        double fine = sc2.nextDouble();
        return new Employee(idEmployee,name,age,address,phoneNumber,salary,bonus,fine);
    }
    public static int getIndexOfPerson() {
        System.out.println("Nhập vị trí nhân viên cần sửa hoặc xóa");
        Scanner scanner=new Scanner(System.in);
        int index=scanner.nextInt();
        return index;
    }
    public static String getIdEmployee() {
        System.out.println("Nhập mã sản phẩm: ");
        Scanner scanner2=new Scanner(System.in);
        String idEmployee =scanner2.nextLine();
        return idEmployee;
    }
}
