package BankAccountManager;

import java.util.Scanner;

public class ATM {
    public static void main(String args[]) {
        System.out.println("请输入账号密码以及存款");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        String pasword = sc.next();
        Double money = sc.nextDouble();
        System.out.println("请选择账户类型：1-CheckingAccount  2-SavingsAccount 3-BusinessAccount");
        Integer choice = sc.nextInt();
        switch (choice) {
            case 1:
                CheckingAccount checkingAccount = new CheckingAccount(name, pasword, money);
                System.out.println("请选择操作：1-存钱 2-取钱 3-查询余额 4-退出");
                Integer ch = sc.nextInt();
                while (ch != 4) {
                    switch (ch) {
                        case 1:
                            System.out.println("存钱数额为：");
                            Double mon = sc.nextDouble();
                            checkingAccount.repay(mon);
                            System.out.println("请选择操作：1-存钱 2-取钱 3-查询余额 4-退出");
                            ch = sc.nextInt();
                            break;
                        case 2:
                            System.out.println("取款数额为：");
                            Double m = sc.nextDouble();
                            checkingAccount.loan(m);
                            System.out.println("请选择操作：1-存钱 2-取钱 3-查询余额 4-退出");
                            ch = sc.nextInt();
                            break;
                        case 3:
                            Double mo = checkingAccount.get_money();
                            System.out.println("本账户余额为:  " + mo);
                            System.out.println("请选择操作：1-存钱 2-取钱 3-查询余额 4-退出");
                            ch = sc.nextInt();
                            break;
                    }
                }
                break;
            case 2:
                SavingsAccount savingsAccount = new SavingsAccount(name, pasword, money);
                System.out.println("请选择操作：1-存钱 2-取钱 3-查询余额 4-退出");
                Integer cho = sc.nextInt();
                while (cho != 4) {
                    switch (cho) {
                        case 1:
                            System.out.println("存钱数额为：");
                            Double mon = sc.nextDouble();
                            savingsAccount.repay(mon);
                            System.out.println("请选择操作：1-存钱 2-取钱 3-查询余额 4-退出");
                            cho = sc.nextInt();
                            break;
                        case 2:
                            Double m = sc.nextDouble();
                            savingsAccount.loan(m);
                            System.out.println("请选择操作：1-存钱 2-取钱 3-查询余额 4-退出");
                            cho = sc.nextInt();
                            break;
                        case 3:
                            Double mo = savingsAccount.get_money();
                            System.out.println("本账户余额为:  " + mo);
                            System.out.println("请选择操作：1-存钱 2-取钱 3-查询余额 4-退出");
                            cho = sc.nextInt();
                            break;

                    }
                }
                break;
            case 3:
                BusinessAccount businessAccount = new BusinessAccount(name, pasword, money);
                System.out.println("请选择操作：1-存钱 2-取钱 3-查询余额 4-退出");
                Integer choi = sc.nextInt();
                while (choi != 4) {
                    switch (choi) {
                        case 1:
                            System.out.println("存钱数额为：");
                            Double mone = sc.nextDouble();
                            businessAccount.repay(mone);
                            System.out.println("请选择操作：1-存钱 2-取钱 3-查询余额 4-退出");
                            choi = sc.nextInt();
                            break;
                        case 2:
                            System.out.println("存钱数额为：");
                            Double mon = sc.nextDouble();
                            businessAccount.loan(mon);
                            System.out.println("请选择操作：1-存钱 2-取钱 3-查询余额 4-退出");
                            choi = sc.nextInt();
                            break;
                        case 3:
                            Double mo = businessAccount.get_money();
                            System.out.println("本账户余额为:  " + mo);
                            System.out.println("请选择操作：1-存钱 2-取钱 3-查询余额 4-退出");
                            choi = sc.nextInt();
                            break;
                    }
                }
                break;
        }
    }


}
