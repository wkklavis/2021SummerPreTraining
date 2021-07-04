package CollectionCatalogue;

import java.text.SimpleDateFormat;
import java.util.*;

public class Book {
    private String name;
    private Integer num;
    private Integer booknum;
    private Boolean in;
    private Stack<String> Outtime = new Stack<String>();
    private Stack<String> Returntime = new Stack<String>();
    private ArrayList<Double> overbook = new ArrayList<Double>();
    private Queue<String> waiting = new LinkedList<String>();

    //借出
    public void Loan() {
        Date cur = new Date();
        SimpleDateFormat form = new SimpleDateFormat("yyyymmdd");
        String current = form.format(cur);
        if (in == true) {
            if (waiting.isEmpty()) {
                in = false;
                Outtime.push(current);
                System.out.println("借书成功");
            } else {
                System.out.println("本书已经被人预约，不可借出");
                waiting.remove();
            }
        } else
            System.out.println("本书目前不在图书馆中");
    }

    //归还
    public void Return() {
        if (in == false) {
            in = true;
            Date cur = new Date();
            SimpleDateFormat form = new SimpleDateFormat("yyyymmdd");
            String current = form.format(cur);
            if (overtime()) {
                Integer cu = Integer.valueOf(current).intValue();
                Integer last = Integer.valueOf(Outtime.peek()).intValue();
                Integer period = cu - last;
                System.out.println("您此次图书归还逾期" + period + "天");
                System.out.println("逾期费用为：" + period * 0.1 + "元" + "(每逾期一天扣费0.1元");
                overbook.add(period * 0.1);
            }
            Returntime.push(current);
            System.out.println("归还成功");
        }
    }

    //构造函数
    Book(String n, Integer nu, Integer bonu, Boolean i) {
        name = n;
        num = nu;
        booknum = bonu;
        in = i;
    }

    Book(Integer bon) {
        booknum = bon;
    }

    public boolean overtime() {
        Date current = new Date();
        SimpleDateFormat form = new SimpleDateFormat("yyyymmdd");
        String cur = form.format(current);
        Integer ddl = Integer.valueOf(Outtime.peek()).intValue() + 30;
        Integer curr = Integer.valueOf(cur).intValue();
        if (curr <= ddl)
            return false;
        else
            return true;
    }

    //预约操作
    public void ad(String t) {
        if (in == false) {
            waiting.add(t);
        } else {
            System.out.println("本书在图书馆中,可直接出借，不需要预约");
        }
    }

    //逾期图书以及费用报告
    public void get_over() {
        System.out.println("逾期图书：" + name + "的逾期费用分别为：");
        for (int i = 0; i < overbook.size(); i++) {
            System.out.print(overbook.get(i));
            System.out.print("   " + "元");
        }
        System.out.println("   ");
    }

    public static void main(String args[]) {
        Book math = new Book("math", 100, 2019070501, true);
        math.Loan();
        math.Return();
    }

}
