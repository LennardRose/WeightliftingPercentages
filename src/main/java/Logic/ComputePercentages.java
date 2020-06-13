/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Lennard
 */
public class ComputePercentages {

    private static ComputePercentages compP = new ComputePercentages();

    private ComputePercentages() {
    }

    public static ComputePercentages instance() {
        return compP;
    }

    //computes the percentages to the given weight
    public Object[][] compute(int value) {

        /*
        *Object because jTable wants objects
        */
        Object percentages[][] = new Object[15][12];

        for (int i = 0; i < 15; i++) {
            //Percentage
            percentages[i][0] = 50 + (i * 5) + percent;
            //weightvalue of percentage
            percentages[i][1] = roundTwoDigits(value * (0.5 + (i * 0.05))) + kg;
            //relative intesity from repetitions and weight
            for (int j = 2; j < 12; j++) {
                int tmp = ((int) (((roundTwoDigits(value * (0.5 + (i * 0.05)))) / (((j * 0.025) + 0.70) * value)) * 100)); 
                //make sure nothing impossible
                if (tmp <= 100) {
                    percentages[i][j] = tmp + percent;
                } else {
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
    
    
    final String percent = "%";
    final double hundredFactor = 100.0;
    final String kg = "Kg";

}
