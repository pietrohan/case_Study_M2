package view;

import controller.UserManagement;
import model.User;

import java.util.Scanner;
import java.util.jar.JarEntry;

public class LoginView {
    Scanner scanner = new Scanner(System.in);
    private UserManagement userManagement = new UserManagement();
    private Main main = new Main();


    public void run() {
        int choice = -1;
        a: do {
            menuLogin();
            System.out.println("Nhập lựa chọn của bạn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    doLogin();
                    break a;
                case 2:
                    doRegister();
                    break;
                case 0:
                    break;
            }
        } while (choice != 0);
    }

    private  void doLogin() {
        System.out.println("Nhập tài khoản: ");
        String acount = scanner.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String passwork = scanner.nextLine();
        boolean isLogin = userManagement.checkUserLogin(acount, passwork);
        if (isLogin){
            System.out.println("Đăng nhập thành công");
            main.toString();
        }else {
            System.err.println("Tài khoản hoặc mật khẩu không đúng");
            doLogin();
        }
    }

    private void doRegister() {
        System.out.println("Đăng kí tài khoản");
        User user = createUser();
        userManagement.register(user);
    }

    private User createUser() {
        String acount = inputAcount();
        String password = inputPasswork();
        String name = inputName();
        int age = inputAge();
        String phoneNumber = inputPhoneNumber();
        User user = new User(acount, password, name, age, phoneNumber);
        return user;
    }


    private String inputPhoneNumber() {
        String phoneNumber;
        do {
            scanner.nextLine();
            System.out.println("Nhập số điện thoại: ");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.length() != 10) {
                System.err.println("Số điện thoại bạn nhập không hợp lệ!");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (phoneNumber.length() != 10);
        return phoneNumber;
    }

    private String inputName() {
        System.out.println("Nhập họ và tên:");
        String name = scanner.nextLine();
        return name;
    }

    private int inputAge() {
        int age;
        do {
            System.out.println("Nhập tuổi:");
            age = scanner.nextInt();
            if (age < 18) {
                System.err.println("Bạn chưa đủ điều kiện để đăng ký tài khoản tại cửa hàng!");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (age < 18);
        return age;
    }

    private String inputPasswork() {
        String password;
        do {
            System.out.println("Nhập mật khẩu(6-12 kí tự):");
            password = scanner.nextLine();
            if (password.length() < 6 || password.length() > 12) {
                System.err.println("Mật khẩu không hợp lệ");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (password.length() < 6 || password.length() > 12);
        return password;
    }

    private String inputAcount() {
        String username;
        do {
            System.out.println("Nhập tài khoản(6-12 kí tự):");
            username = scanner.nextLine();
            if (username.length() < 6 || username.length() > 12) {
                System.err.println("Tài khoản không hợp lệ");
                inputAcount();
            } else if (userManagement.checkUsernameExist(username)) {
                System.err.println("Tài khoản này đã tồn tại");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (username.length() < 6 || username.length() > 12 || userManagement.checkUsernameExist(username));
        return username;
    }


    public void menuLogin() {
        System.out.println("---Ứng dụng quản lí cửa hàng đồ trang sức---");
        System.out.println("1.Đăng nhập");
        System.out.println("2.Đăng kí");
        System.out.println("0.Thoát chương trình");
    }

        public static void main(String[] args) {
            LoginView LG = new LoginView();
            LG.run();
        }
}
