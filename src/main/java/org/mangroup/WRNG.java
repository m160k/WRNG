package org.mangroup;

import java.util.Random;

public class WRNG {
    // Values that may be returned by nextNum() private
    int[] randomNums = {100,200,300,400,500};
    // Probability of the occurence of randomNums private
    float[] probabilities = {0.01f, 0.05f, 0.2f, 0.35f, 0.39f};
    /**float[] probabilities = {0.2f, 0.2f, 0.2f, 0.2f, 0.2f};
     Returns one of the randomNums. When this method is called
     multiple times over a long period, it should return the
     numbers roughly with the initialized probabilities.
     */
    public int nextNum() {
        float roll = new Random().nextFloat();

        float currentWeight = 0.0f;
        for(int i=0;i<probabilities.length;i++) {
            currentWeight += probabilities[i];
            if(roll <= currentWeight) return randomNums[i];
        }

        throw new RuntimeException("Something went wrong...");
    }

}