package BankAccountManager;

public abstract class Account {
    String name;//账户名
    Double money;//存款
    String pasword;//密码
    //还款
    public void repay(Double rem){}

    //借出
    public void loan(Double lem){}

    //查询存款
    public double get_money(){return money;}

}
