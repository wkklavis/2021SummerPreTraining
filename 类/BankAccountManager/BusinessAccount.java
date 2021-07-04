package BankAccountManager;

import java.util.Scanner;

public class BusinessAccount extends Account {
    Double credit;//利率
    Double limitmoney;//贷款额度
    BusinessAccount(String n,String p,Double m){
        name=n;
        pasword=p;
        money=m;
        credit=0.1;
        limitmoney=money*0.5;
    }
    //存钱
    public void repay(Double remoney){
        money+=remoney;
        limitmoney=money*0.5;
    }
    //取款
    public void loan(Double lemoney){
        if(lemoney<limitmoney+money){
            money-=lemoney;
            limitmoney=money*0.5;
        }
        else
            System.out.println("您的账户余额不够");
    }
    public double get_money(){
        System.out.println("请输入存款时间");
        Scanner sc= new Scanner(System.in);
        Integer period=sc.nextInt();
        money=get_credit_money(period);
        return money;
    }
    public double get_credit_money(Integer days){
        Integer m=days/30;
        Integer d=days%30;
        money+=money*credit*m;
        money+=money*(credit/100)*d;
        limitmoney=money*0.5;
        return money;
    }
}
