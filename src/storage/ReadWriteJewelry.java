package storage;

import model.Jewlry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteJewelry implements IReadWriteData<Jewlry>{

    @Override
    public List<Jewlry> readData() {
        List<Jewlry> roomList=new ArrayList<>();
        try{
            FileInputStream fis=new FileInputStream("jewlry.txt");
            ObjectInputStream ois=new ObjectInputStream(fis);
            roomList=(List<Jewlry>) ois.readObject();
            ois.close();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }return roomList;

    }

    @Override
    public void writeData(List<Jewlry> jewlriyList) {
        try{
            FileOutputStream fos =new FileOutputStream("jewlry.txt");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(jewlriyList);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
