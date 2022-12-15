import classes.AccountOwnerThread;
import classes.BankAccount;
import enums.ActionEnum;

public class BankTransaction {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(100);
        /**
                * The account owner has a name, a quantity of money to deposit or extract, the type of action and the bank account.
                * The account is shared between the users.
         *
         * First the account balance was showed straight away, but now it is showed after the action is done.
                * Adding the synchronized keyword to the methods in the BankAccount class, the balance is showed correctly.
                */
        AccountOwnerThread juan = new AccountOwnerThread("John", 20, ActionEnum.EXTRACT, bankAccount);
        AccountOwnerThread laura = new AccountOwnerThread("Maria", 40, ActionEnum.EXTRACT, bankAccount);
        AccountOwnerThread antonio = new AccountOwnerThread("Peter", 35, ActionEnum.DEPOSIT, bankAccount);
        AccountOwnerThread pepito = new AccountOwnerThread("Mary", 80, ActionEnum.EXTRACT, bankAccount);
        AccountOwnerThread alberto = new AccountOwnerThread("Joseph", 40, ActionEnum.EXTRACT, bankAccount);

        juan.start();
        laura.start();
        antonio.start();
        pepito.start();
        alberto.start();
    }
}
