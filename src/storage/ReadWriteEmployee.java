package storage;

import model.Client;
import model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteEmployee implements IReadWriteData<Employee> {
    @Override
    public List<Employee> readData() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("Employee.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            employeeList = (List<Employee>) ois.readObject();
            ois.close();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void writeData(List<Employee> employeeList) {
        try {
            FileOutputStream fos = new FileOutputStream("Employee.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employeeList);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}