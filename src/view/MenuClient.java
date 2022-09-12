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
            ManagerClient clients = new ManagerClient("ClientVIP.txt");
            ManagerJewelry jewelies = new ManagerJewelry();
        jewelies.displayjewlries();
    }
}