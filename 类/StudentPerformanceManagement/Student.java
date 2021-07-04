package StudentPerformanceManagement;

import java.util.Scanner;

public class Student {
    private String name;
    private Double aver;
    private String level;
    private Double grade[];

    Student(String n, Double d[], Integer nu) {
        name = n;
        double sum = 0;
        grade = new Double[nu];
        for (Integer i = 0; i < d.length; i++) {
            grade[i] = d[i];
            sum += d[i];
        }
        aver = sum / d.length;
        if (aver < 60)
            level = "E";
        else if (aver < 70)
            level = "D";
        else if (aver < 80)
            level = "C";
        else if (aver < 90)
            level = "B";
        else if (aver <= 100)
            level = "A";
    }

    public void get_info() {
        System.out.print(this.name + "成绩为:");
        for (int i = 0; i < grade.length; i++)
            System.out.print(grade[i] + "    ");
        System.out.print("平均分为：" + this.aver + "等级为：  " + this.level);
    }

    public static void main(String[] args) {
        System.out.println("Please enter a student information and number of grades");
        Scanner in = new Scanner(System.in);
        String sn = in.next();
        Integer num = in.nextInt();
        Integer i = 0;
        Double gr[] = new Double[num];
        Double grade;
        while (i < num) {
            grade = in.nextDouble();
            gr[i] = grade;
            i++;
        }
        Student s = new Student(sn, gr, num);
        s.get_info();
    }
}