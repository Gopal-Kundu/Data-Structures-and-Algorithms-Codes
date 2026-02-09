// https://leetcode.com/problems/simple-bank-system/description/

class Bank {
    long[] accountBalance;
    public Bank(long[] balance) {
        accountBalance = new long[balance.length];
        for(int i = 0; i < balance.length; i++)
        accountBalance[i] = balance[i];
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1 <= accountBalance.length && account2 <= accountBalance.length){

            if(accountBalance[account1-1] >= money){
                accountBalance[account1-1] -= money;
                accountBalance[account2-1] += money;
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(account > accountBalance.length) return false;
        accountBalance[account-1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account > accountBalance.length || accountBalance[account-1] < money) return false;
        accountBalance[account-1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */