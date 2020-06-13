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

    //computes the percentages to the given weight
    public static Object[][] compute(int value) {

        Object percentages[][] = new Object[10][12];

        for (int i = 0; i < 10; i++) {
            //Percentage
            percentages[i][0] = 50 + (i * 5) + "%";
            //weightvalue of percentage
            percentages[i][1] = Math.round((value * (0.5 + (i * 0.05))) * 100.0) / 100.0 + " Kg";
            //relative intesity from repetitions and weight
            for (int j = 2; j < 12; j++) {
                int tmp = ((int) (((Math.round((value * (0.5 + (i * 0.05))) * 100.0) / 100.0) / (((j * 0.025) + 0.70) * value)) * 100));
                //make sure nothing impossible
                if (tmp <= 100) {
                    percentages[i][j] = tmp + "%";
                } else {
                    percentages[i][j] = "-";
                }

            }
        }
        return percentages;
    }

}
