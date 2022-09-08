package model;

import java.io.Serializable;

public class Jewlry implements Serializable {
    //idProduct, nameProduct, typeProduct, infomationProduct, weight, price
    private String idProduct, nameProduct, typeProduct, materialProduct;
    private int weight, ingredientPrice, machiningPrice;

    public Jewlry() {
    }

    public Jewlry(String idProduct, String nameProduct, String typeProduct, String materialProduct, int weight, int ingredientPrice, int machiningPrice) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.typeProduct = typeProduct;
        this.materialProduct = materialProduct;
        this.weight = weight;
        this.ingredientPrice = ingredientPrice;
        this.machiningPrice = machiningPrice;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getMaterialProduct() {
        return materialProduct;
    }

    public void setMaterialProduct(String materialProduct) {
        this.materialProduct = materialProduct;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getIngredientPrice() {
        return ingredientPrice;
    }

    public void setIngredientPrice(int ingredientPrice) {
        this.ingredientPrice = ingredientPrice;
    }

    public int getMachiningPrice() {
        return machiningPrice;
    }

    public void setMachiningPrice(int machiningPrice) {
        this.machiningPrice = machiningPrice;
    }

    @Override
    public String toString() {
        return "Jewlry{" +
                "idProduct='" + idProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", typeProduct='" + typeProduct + '\'' +
                ", materialProduct='" + materialProduct + '\'' +
                ", weight=" + weight +
                ", ingredientPrice=" + ingredientPrice +
                ", machiningPrice=" + machiningPrice +
                '}';
    }
}
