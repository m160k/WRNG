import org.junit.jupiter.api.Test;
import org.mangroup.WRNG;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WRNGTest {

    private WRNG rollSimulator = new WRNG();

    @Test
    public void nextNum() {
        int[] randomNums = {100,200,300,400,500};
        float[] probabilities = {0.01f, 0.05f, 0.2f, 0.35f, 0.39f};

        int[] hits = new int[randomNums.length];
        roll(randomNums, hits, 10);
        int hitsSum = Arrays.stream(hits).sum();
        double[] deviationSmallSize = new double[hits.length];
        for (int i=0;i<hits.length;i++) {
            deviationSmallSize[i] = Math.abs((hits[i] / (double)hitsSum) - probabilities[i]);
        }

        roll(randomNums, hits, 1000);
        hitsSum = Arrays.stream(hits).sum();
        double[] deviationBigSize = new double[hits.length];
        for (int i=0;i<hits.length;i++) {
            deviationBigSize[i] = Math.abs((hits[i] / (double)hitsSum) - probabilities[i]);
        }

        assertTrue(Arrays.stream(deviationSmallSize).sum() > Arrays.stream(deviationBigSize).sum());
    }

    private void roll(int[] randomNums, int[] hits, int size) {
        for (int i=0;i<size;i++) {
            int roll = rollSimulator.nextNum();

            for(int i1=0;i1<randomNums.length;i1++) {
                if(randomNums[i1] == roll) hits[i1] = hits[i1] +1;
            }
        }
    }

}
