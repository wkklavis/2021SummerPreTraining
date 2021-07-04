import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class CountVowels {

    public static void main(String[] args) {
        Set a = new HashSet();
        Set e = new HashSet();
        Set i = new HashSet();
        Set o = new HashSet();
        Set u = new HashSet();
        int num_a = 0;
        int num_e = 0;
        int num_i = 0;
        int num_o = 0;
        int num_u = 0;
        a.add('a');
        a.add('A');
        e.add('e');
        e.add('E');
        i.add('i');
        i.add('I');
        o.add('o');
        o.add('O');
        u.add('u');
        u.add('U');
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        for (int j = 0; j < s.length(); j++) {
            if (a.contains(s.charAt(j))) {
                num_a++;
            }
            if (e.contains(s.charAt(j))) {
                num_e++;
            }
            if (i.contains(s.charAt(j))) {
                num_i++;
            }
            if (o.contains(s.charAt(j))) {
                num_o++;
            }
            if (u.contains(s.charAt(j))) {
                num_u++;
            }
        }
        System.out.println("NUM_A " + num_a);
        System.out.println("NUM_E " + num_e);
        System.out.println("NUM_I " + num_i);
        System.out.println("NUM_O " + num_o);
        System.out.println("NUM_U " + num_u);

    }

}
