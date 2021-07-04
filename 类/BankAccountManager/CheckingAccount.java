package BankAccountManager;

public class CheckingAccount extends Account {
    CheckingAccount(String n,String p,Double m){
        name=n;
        pasword=p;
        money=m;
    }
    public void repay(Double remoney){
        money+=remoney;
    }
    public void loan(Double lemoney){
        if(lemoney<money)
            money-=lemoney;
        else
            System.out.println("您的余额不足");
    }
    public double get_money(){
        return money;
    }
}
