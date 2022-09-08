package controller;

import model.Jewlry;
import storage.IReadWriteData;
import storage.ReadWriteJewelry;

import java.util.List;

public class ManagerJewelry {
    private String name;

    public ManagerJewelry() {
    }

    public ManagerJewelry(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    static IReadWriteData iReadWriteData=new ReadWriteJewelry();
    public static List<Jewlry> jewlryList=iReadWriteData.readData();
    public void addNewJewlry(Jewlry jewlry){
        jewlryList.add(jewlry);
        iReadWriteData.writeData(jewlryList);
    }
    public void deleteProductById(String roomId){
        int index=findJewlryById(roomId);
        if(index>-1){
            jewlryList.remove(index);
            iReadWriteData.writeData(jewlryList);
        }

    }
    public void setInfomationProduct(int index,Jewlry jewlry){
        jewlryList.get(index).setIdProduct(jewlry.getIdProduct());
        jewlryList.get(index).setMaterialProduct(jewlry.getMaterialProduct());
        jewlryList.get(index).setIngredientPrice(jewlry.getIngredientPrice());
        jewlryList.get(index).setMachiningPrice(jewlry.getMachiningPrice());

        iReadWriteData.writeData(jewlryList);
    }
    public int findJewlryById(String productId){
        for (int i = 0; i < jewlryList.size(); i++) {
            if(jewlryList.get(i).getIdProduct().equals(productId)){
                return i;
            }
        }

        return -1;
    }
    public void displayjewlries(){
        for (int i = 0; i < jewlryList.size(); i++) {
            System.out.println(jewlryList.get(i).toString());
        }
    }

        public double getMoney(String idProduct) {
            int index = findClientByIdProduct(idProduct);
            try {
                return jewlryList.get(index).getIngredientPrice()+jewlryList.get(index).getMachiningPrice();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Không tìm thấy sản phẩm này.");
                return 0;
            }
        }
    private int findClientByIdProduct(String id) {
        for (int i = 0; i < jewlryList.size(); i++) {
            if(jewlryList.get(i).getIdProduct().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
