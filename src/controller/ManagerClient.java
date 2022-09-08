package controller;

import model.Client;
import storage.IReadWriteData;
import storage.ReadWriteFileClient;
import storage.ReadWriteJewelry;

import java.util.List;
import java.util.Scanner;

public class ManagerClient {
    private String name;

    public ManagerClient() {
    }
    public ManagerClient(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    static IReadWriteData iReadWriteData = new ReadWriteFileClient();
    public static List<Client> clientList = iReadWriteData.readData();
    public void addNewClient( Client client){
        clientList.add(client);
        iReadWriteData.writeData(clientList);

    }
    public void setClient(int index,Client person){
        clientList.set(index,person);
        iReadWriteData.writeData(clientList);
    }
    public void deletePerson(int index){
        clientList.remove(index);
        iReadWriteData.writeData(clientList);
    }
    public void displayPersons(){
        for (int i = 0; i < clientList.size(); i++) {
            System.out.println(clientList.get(i));
        }
    }



}
