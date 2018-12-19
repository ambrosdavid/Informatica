/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazon;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class Amazon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array = {10,
            9,
            1,
            6,
            6,
            3,
            9,
            3,
            7,
            9,
            4};

        int diferenza = 0;
        for (int i = 1;
                i < array[0]; i++) {
            if (Math.abs((array[i] - array[i + 1])) > diferenza) {
                diferenza = Math.abs(array[i] - array[i + 1]);
            }

        }

        System.out.println(diferenza);

    }

}
