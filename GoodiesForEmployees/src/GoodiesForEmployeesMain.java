/**
 * Created by Chandana BM on 02-11-2020.
 */
import java.io.*;
import java.util.*;
public class GoodiesForEmployeesMain {
    static int[] finals = null;
    static HashMap<String, Integer> mainMap;
    static String outPut = "";

    public static void main(String[] args) {
        HelperForGoodies goodiesHelper = new HelperForGoodies();
        goodiesHelper.readFile();

        int[] arr1 = new int[10];
        int[] arr3 = new int[10];
        int num = Integer.parseInt(goodiesHelper.num);
        int[] differences = new int[arr1.length - num + 1];
        finals = new int[differences.length];

        mainMap = goodiesHelper.map;

        int min = 0;
        int c = 0;
        int counter = 0;

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = goodiesHelper.ar2[i];
        }
        Arrays.sort(arr1);

        for (int i = arr3.length - 1; i >= 0; i--) {
            arr3[i] = arr1[c];
            c++;
        }

        for (int i = 0; i < differences.length; i++) {
            differences[i] = arr3[i] - arr3[i + num - 1];
        }

        int index = 0;
        int mini = differences[index];

        for (int i = 1; i < differences.length; i++) {
            if (differences[i] < mini) {
                mini = differences[i];
                index = i;
            }
            min = index;
        }

        System.out.println();

        finals = new int[(min + num - 1)];
        for (int i = min; i <= (min + num - 1); i++) {
            finals[counter] = arr3[i];
            counter++;
        }

        for (int l = 0; l <= finals.length - 1; l++) {
            printList(finals[l]);
        }
        System.out.println("And the difference between the chosen goodie with highest price and the lowest price is " + mini);
        outPut = outPut + "\n\nAnd the difference between the chosen goodie with highest price and the lowest price is" + mini;
        writeFile(outPut);
        outPut = null;
    }

    public static void printList(Integer i) {
        if (i == null || i == 0) {
            return;
        }

        for (Map.Entry<String, Integer> entry : mainMap.entrySet()) {
            if (entry.getValue().equals(i)) {
                System.out.println(i + ":" + entry.getKey());
                outPut = outPut+"\n"+i + ":" + entry.getKey();
                break;
            }
        }
    }

    public static void writeFile(String output) {

        BufferedWriter bw = null;
        BufferedReader br = null;
        String path = null;


        Scanner sc1 = new Scanner(System.in);


        System.out.println("\n\nEnter file path to store output :");
        path = sc1.nextLine();
       // path="C:/Users/Chandana BM/Desktop/Output.txt";

        try {
            bw = new BufferedWriter(new FileWriter(path));
            br = new BufferedReader(new FileReader(path));
            //while ((output = br.readLine()) != null) {
            bw.write(output);
            //}
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.getMessage();
            }
        }
    }
}
