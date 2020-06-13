/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 * @author Lennard computes all percentages to a given weight with method
 * computeTablePercentages
 */
public class Compute {

    /*
    *Singleton pattern 
     */
    private static Compute compP = new Compute();

    private Compute() {
    }

    public static Compute instance() {
        return compP;
    }

    /*
    *computes the percentages to the given weight and stores them to use in table
    *returns Object because jTable wants Objects
     */
    public Object[][] computeTablePercentages(double value) {

        Object percentages[][] = new Object[15][12];

        for (int i = 0; i < 15; i++) {
            double percentage = generatePercentageFactor(0.5, (i * 0.05));
            //Percentage
            percentages[i][0] = Math.round(percentage * 100) + percent;
            //weightvalue of percentage
            percentages[i][1] = computeWeight(value, percentage) + kg;
            //relative intesity from repetitions and weight
            for (int j = 2; j < 12; j++) {
                double relative = generatePercentageFactor(0.7, j * 0.025);

                percentages[i][j] = computeRelativePercentage(percentage, relative) + percent;
                if (percentages[i][j].equals("0%")) {
                    percentages[i][j] = null;
                }
            }
        }
        return percentages;
    }

    /*
    *round to 2 digits
     */
    private double roundTwoDigits(double input) {
        return (Math.round(input * hundredFactor) / hundredFactor);
    }

    /*
    *generates percentagefactor
    */
    private double generatePercentageFactor(double offset, double increment) {
        return offset + increment;
    }
    
    /*
    *computes the relative percentage, checks if >100 if so, returns 0
    */
    private int computeRelativePercentage(double absolute, double relative) {
        int tmp = (int) ((absolute / relative) * 100);
        if (tmp <= 100) {
            return tmp;
        } else {
            return 0;
        }
    }

    /*
    *returns given percentage of value
    */
    private double computeWeight(double value, double percentage) {
        return roundTwoDigits(value * percentage);
    }

    /*
    *constant values
     */
    final String percent = "%";
    final double hundredFactor = 100.0;
    final String kg = "Kg";

}
