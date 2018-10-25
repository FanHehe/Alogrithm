import java.util.Arrays;

public class Main {

    public static final int max = 12;

    public static int nArr[][] = new int[6][12];
    public static int nCost[] = {0, 2 , 5 , 3 , 10 , 4};  // 花费
    public static int nVol[]  = {0, 1 , 3 , 2 , 6 , 2}; // 物体体积

    public static void main(String[] args) {
        for (int i = 1, rowLength = nCost.length; i < rowLength; i++) {
            for (int j = 1, columnLength = max; j < columnLength; j++) {
                if (nVol[i] > j) {
                    nArr[i][j] = nArr[i - 1][j];
                    continue;
                }

                nArr[i][j] = Math.max(nArr[i - 1][j], nArr[i - 1][j - nVol[i]] + nCost[i]);
            }
        }

        for (int i = 0; i < nArr.length; i++) {
            for (int j = 0; j < nArr[i].length; j++) {
                System.out.print(" " + nArr[i][j]);
            }

            System.out.println("");
        }
    }
}

