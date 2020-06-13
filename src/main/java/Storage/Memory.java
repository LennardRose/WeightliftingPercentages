/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import Logic.Exercise;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;

import java.util.Map;


/**
 *
 * @author Lennard
 */
public class Memory {
    
    private static Memory mem = new Memory();
    
    private Memory()
    {}
    
    public static Memory instance(){
        return mem;
    }

    static private Map<Exercise, Integer> weights;

    //set weight to map, not to file
    public void setWeight(Exercise ex, int w) {

        weights.put(ex, w);
    }

    //get weight from map, not from file
    public int getWeight(Exercise ex) {
        if (weights.containsKey(ex)) {
            return weights.get(ex);
        } else {
            return 0;
        }

    }

    //read Enummap from file
    public void ReadMapFromFile() {

        try (FileInputStream fileIn = new FileInputStream("Weights.ser");
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            weights = ((EnumMap<Exercise, Integer>) objectIn.readObject());
        } catch (FileNotFoundException e) {
            weights = new EnumMap<>(Exercise.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //save map in file, overwrites the old one
    public void WriteMapToFile() {

        try (FileOutputStream fileOut = new FileOutputStream("Weights.ser");
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(weights);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
