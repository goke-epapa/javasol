
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ca351um
 */
public class RajusTraining {

    public static void main(String[] args) throws IOException {
        BufferedReader bInputStream = new BufferedReader(new InputStreamReader(System.in));
        String line = bInputStream.readLine().trim();
        String[] arr = line.split(" ");

        int N_noOfSubjects = Integer.parseInt(arr[0]);
        int M_noOfConstraints = Integer.parseInt(arr[1]);

        String[] constraints = new String[M_noOfConstraints];
        for (int i = 0; i < M_noOfConstraints; i++) {
            constraints[i] = bInputStream.readLine().trim();
        }
        String studyPlan = bInputStream.readLine().trim();

        process(studyPlan, constraints);
        System.exit(0);
    }

    public static void process(String studyPlan, String[] constraints) {
        studyPlan = studyPlan.replace(" ", "");
        int len = studyPlan.length();
        for (int i = 0; i < len; i++) {

            char c = studyPlan.charAt(i);
            for (int j = i + 1; j < len; j++) {
                char cC = studyPlan.charAt(j);
                for (String constraint : constraints) {
                    if (constraint.indexOf(c + "") != -1 && constraint.indexOf(cC + "") != -1) {
                        if (constraint.indexOf(c + "") > constraint.indexOf(cC + "")) {
                            System.out.println("NO");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("YES");
    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println("");
    }

}
