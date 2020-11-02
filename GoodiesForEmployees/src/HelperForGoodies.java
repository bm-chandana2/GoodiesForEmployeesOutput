/**
 * Created by Chandana BM on 02-11-2020.
 */
import java.io.*;
import java.util.*;
public class HelperForGoodies {
    Integer integer1;
    static HashMap<String, Integer> map = new HashMap<String, Integer>();
    int ar2[] = new int[10];
    int i = 0;
    String num;

    public void readFile() {

        BufferedReader br = null;
        String line = null;
        String path = null;

        int n;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter file path :");
        path = sc1.nextLine();

        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                if (line.contains("Number of employees: ")) {
                    n = (line.trim().lastIndexOf(":") + 2);
                    num = "" + line.charAt(n);
                    //  System.out.println("num is  :" + num);
                } else if (!(line.trim().contains("Goodies and Prices:"))) {
                    int intIndex = line.indexOf(":");
                    if (intIndex != -1) {

                        storeValues(line);
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.getMessage();
            }
        }
    }

    public void storeValues(String line) {
        String[] parts = line.split(":");
        String key = parts[0].trim();
        integer1 = Integer.parseInt(parts[1].trim());
        map.put(key, integer1);
        ar2[i] = integer1;
        i++;
    }
}
