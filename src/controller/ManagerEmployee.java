package controller;

import model.Employee;
import storage.IReadWriteData;
import storage.ReadWriteEmployee;

import java.util.List;

public class ManagerEmployee {
    private String name;

    public ManagerEmployee() {
    }

    public ManagerEmployee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static IReadWriteData iReadWriteData = new ReadWriteEmployee();
    public static List<Employee> employeeList = iReadWriteData.readData();

    public void addNewEmployee(Employee employee) {
        employeeList.add(employee);
        iReadWriteData.writeData(employeeList);

    }

    public void setEmployeeList(int index, Employee person) {
        employeeList.set(index, person);
        iReadWriteData.writeData(employeeList);
    }

    public void deletePerson(int index) {
        employeeList.remove(index);
        iReadWriteData.writeData(employeeList);
    }

    public void displayPersons() {
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println(employeeList.get(i));
        }
    }
    public double sumSalaryEmployee(String idEmployee) {
        int index = findClientByIdEmployee(idEmployee);
        try {
            return employeeList.get(index).getSalary()+employeeList.get(index).getBonus()-employeeList.get(index).getFine();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Không tìm thấy nhân viên này tại cửa hàng.");
            return 0;
        }
    }
    private int findClientByIdEmployee(String id) {
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeList.get(i).getIdEmployee().equals(id)){
                return i;
            }
        }
        return -1;
    }
}