package MovieShop;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;

public class Control {
    private String username;
    // private String outTime;
    private String daoqiTime;
    private String shijidaoqiTime;
    private boolean isyuqi = false;
    private int yuqi;
    private int yuqijine = 50;
    private LinkedList<String> Outime = new LinkedList<String>();
    //租借人产生的金额
    HashMap<String, Integer> rmoney = new HashMap<String, Integer>();
    //租借人
    public Control(String username) {
        this.username = username;
    }
    //借出日期
    public void record_outTime(String outTime) {
        Outime.addFirst(outTime);
    }
    //如果租界日是今天的话
    public void record_outTime() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String nows = sdf.format(now);
        Outime.addFirst(nows);
    }
    //到期日期
    public void record_daoqiTime(String daoqiTime) {
        this.daoqiTime = daoqiTime;
    }
    //如果到期日是今天的话
    public void record_daiqiTime() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String nows = sdf.format(now);
        Integer cur = Integer.valueOf(nows);
        cur = cur + 30;
        nows = Integer.toString(cur);
        daoqiTime = nows;
    }
    //【判断用户是否逾期
    public boolean isIsyuqi(String shijidaoqiTime) {
        assert Outime.peek() != null;
        Integer daoqi = Integer.valueOf(daoqiTime);
        Integer shiji = Integer.valueOf(shijidaoqiTime);
        return isyuqi = shiji > daoqi;
    }
    //记录不逾期的租金
    public void record_money(Integer money ){
        rmoney.put(username,money);
    }
    //记录逾期租金
    public void record_money(String time){
        Integer daoqi = Integer.valueOf(daoqiTime);
        Integer shijidaoqi = Integer.valueOf(time);
        Integer period = ((shijidaoqi-daoqi)/3)*2;
        rmoney.put(username,period);
    }
    //生成逾期报告
    public void get_info(String name){
        System.out.println(name+"用户的逾期报告如下：");
        for(String k:rmoney.keySet()){
            if(k==name){
                System.out.print("欠费为：");
                Integer money=rmoney.get(k);
                System.out.print(money);
            }
            else continue;
        }
    }


}
