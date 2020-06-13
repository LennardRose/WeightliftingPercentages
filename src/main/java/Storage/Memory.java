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
 * @author Lennard
 * holds map with weights
 * loads map from File
 * persists map by loading it to file
 */
public class Memory {
    /*
    *Singleton pattern 
    */
    private static Memory mem = new Memory();
    
    private Memory()
    {}
    
    public static Memory instance(){
        return mem;
    }
    
    /*
    *contains the weights for each Exercise
    */
    static private Map<Exercise, Double> weights;

     /*
    * set weight to map, not to file
    */
    public void setWeight(Exercise ex, double weight) {

        weights.put(ex, weight);
    }

    /*
    *get weight from map, not from file
    *returns 0 if Exercise has no value
    */
    public double getWeight(Exercise ex) {
        if (weights.containsKey(ex)) {
            return weights.get(ex);
        } else {
            return 0;
        }

    }

    /*
    *read Enummap from file
    */
    public void ReadMapFromFile() {

        try (FileInputStream fileIn = new FileInputStream("Weights.ser");
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            weights = ((EnumMap<Exercise, Double>) objectIn.readObject());
        } 
        /*
        * If File doesnt exist, create new empty map
        */
        catch (FileNotFoundException e) {
            weights = new EnumMap<>(Exercise.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /*
    *save map in file, overwrites the old one
    */
    public void WriteMapToFile() {

        try (FileOutputStream fileOut = new FileOutputStream("Weights.ser");
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(weights);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
