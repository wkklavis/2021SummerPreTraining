package RealTimeStockPrice;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

import org.jfree.chart.ChartPanel;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.Month;
import org.jfree.data.time.Second;
import java.net.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
public class Main {
    public static ArrayList DealTime(String s) {
        ArrayList al = new ArrayList();
        Pattern pattern = Pattern.compile("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]");
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
            for(int i=0; i<=matcher.groupCount(); i++){
                al.add(matcher.group(i));
            }
        }
        pattern = Pattern.compile("[0-9][0-9]:[0-9][0-9]:[0-9][0-9]");
        matcher = pattern.matcher(s);
        if(matcher.find()){
            for(int i=0; i<=matcher.groupCount(); i++){
                al.add(matcher.group(i));
            }
        }
        return al;
    }
    public static ArrayList DealData(String s) {//拿出所有DIV里的内容
        ArrayList al = new ArrayList();
        int beg=0;
        int end=0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='>')
                beg=i+1;
            if(s.charAt(i)=='<') {
                end=i;
                al.add(s.substring(beg, end));
            }
        }
        return al;
    }
    public static String getContent(String s ) {//截掉字符串内空白的部分
        String ans = null;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='\u0000') {
                ans = s.substring(0, i);
            }
        }
        return ans;
    }
    public static boolean HasDataNotUsed = false;

    public static void main(String[] args) throws IOException, ParseException {


        JFrame frame = new JFrame("Test Chart");
        RealTimeChart rtcp = new RealTimeChart("HenShen", "Price", "Num");
        frame.getContentPane().add(rtcp, new BorderLayout().CENTER);
        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowevent) {
                System.exit(0);
            }

        });


        ArrayList Grap = new ArrayList();


        ServerSocket ss = new ServerSocket(3000);
        Socket client = ss.accept();
        InputStream is = client.getInputStream();
        byte [] b = new byte[1024];


        new Thread() {//新线程用于接收数据
            public void run() {
                while(true) {
                    synchronized(client) {//同步锁

                        try {
                            is.read(b);
                        } catch (IOException e) {
                            e.printStackTrace();
                            break;
                        }
                        HasDataNotUsed=true;//告诉主线程，数据已更新

                    }


                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }


                }
            }
        }.start();
        String s = null;
        double price=0;
        int index=0;
        while(true) {//主线程用来更新图像
            synchronized(client) {
                if(HasDataNotUsed) {
                    s=new String(b,"UTF-8");
                    System.out.println("HTML:++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println(s);
                    System.out.println("HTML:++++++++++++++++++++++++++++++++++++++++++++++");
                    if(s.equals("None")) {
                        HasDataNotUsed=false;
                        continue;
                    }
                    s=Main.getContent(s);
                    ArrayList data = DealData(s);
                    ArrayList time = DealTime(s);
                    Iterator it = data.iterator();
                    double PriceCha = Double.parseDouble((String) data.get(2))-price;
                    price = Double.parseDouble((String) data.get(2));//得到股票价格
                    boolean isRed = (PriceCha>0.0);//红色表示涨
                    NumberFormat nf=NumberFormat.getPercentInstance();//得到股票涨跌百分比
                    Number m=null;
                    if(!((String) data.get(6)).isEmpty())
                        m = nf.parse(((String) data.get(6)).substring(1, ((String) data.get(6)).length()));
                    double percent = m.doubleValue();

                    String time_d = (String)time.get(0);//get(0)中存储着时间信息
                    System.out.println(time_d);
                    System.out.println("Percent : "+percent);
                    //分别提取日月年时分秒
                    Day d = new Day(Integer.parseInt(time_d.substring(8,10)),Integer.parseInt(time_d.substring(5,7)),Integer.parseInt(time_d.substring(0,4)));
                    int hour = Integer.parseInt(((String)time.get(1)).substring(0, 2));
                    int minute = Integer.parseInt(((String)time.get(1)).substring(3, 5));
                    int second = Integer.parseInt(((String)time.get(1)).substring(6, 8));
                    //建立对象
                    Hour time_h = new Hour(hour,d);
                    Minute time_m = new  Minute(minute,time_h);
                    Second time_s = new  Second(second,time_m);

                    rtcp.update(time_s, price);
                    HasDataNotUsed=false;

                }
            }
        }
    }
}
