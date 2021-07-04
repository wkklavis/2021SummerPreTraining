package BankAccountManager;

import java.util.Scanner;

public class SavingsAccount extends Account {
    Double credit;
    Integer limitperm;
    Integer times;
    SavingsAccount(String n,String p,Double m){
        name=n;
        pasword=p;
        money=m;
        credit=0.02;
        limitperm=2;
        times=0;
    }
    //还款
    public void repay(Double remoney){
        times++;
        if(times<=limitperm)
            money+=remoney;
        else
            money=money+remoney-(times-limitperm)*2;
    }
    //取钱
    public void loan(Double lemoney){
        times++;
        if(times<=limitperm){
            if(lemoney<money)
                money-=lemoney;
            else
                System.out.println("您的账户余额不够");
        }
        else
            money=money-lemoney-(times-limitperm)*2;
    }
    //查询余额
    public double get_money(){
        System.out.println("请输入存款时间");
        Scanner sc= new Scanner(System.in);
        Integer period=sc.nextInt();
        money=get_credit_with_money(period);
        return money;
    }
    //计算利息
    public double get_credit_with_money(Integer p){
        Integer m=p/30;
        Integer day=p%30;
        money+=money*credit*m;
        money+=money*(credit/90)*day;
        return money;
    }
}
