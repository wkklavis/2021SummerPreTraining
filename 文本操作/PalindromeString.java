import java.util.*;
import java.io.*;

public class PalindromeString {
    public static void main(String[] args) {
        System.out.println("输入一个数");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == judge(num)) { //判断是否回文
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static int judge(int num) {
        int last = 0;
        int reverse = 0;
        while (true) {
            last = num % 10;  //取出个位数
            reverse = reverse * 10 + last; //定义的reverse存放回文数
            num /= 10; //逐个除10取下一位
            if (num % 10 == 0) //取到最后一位break

                break;

        }
        return reverse;
    }
}