package classes;

public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    /**
     * In this program we have to extract money from the account and deposit money to the account,
     * so we have to create a method to extract money from the account and another method to deposit
     * money to the account, just adding and subtracting the quantity from the balance.
     *
     * the synchronized keyword is added to the methods, so the threads can't access the methods at the same time.
     *
     * synchronized method to deposit money from the account.
     * @param quantity
     * @param ownerName
     */
     synchronized public void deposit(int quantity, String ownerName) {
        String message = ownerName;
        this.balance += quantity;
        message += " has deposited " + quantity + "€ to the account";
        System.out.println(message);
        this.printBalance();
    }

    /**
     * Syncronized method to extract money from the account.
     * @param quantity
     * @param ownerName
     */
    synchronized public void extract(int quantity, String ownerName) {
        String message = ownerName;
        if (this.balance >= quantity) {
            this.balance -= quantity;
            message += " has extracted " + quantity + "€ from the account";
        } else {
            message += " has tried to extract " + quantity + "€ from the account but the balance is " + this.balance;
        }
        System.out.println(message);
        this.printBalance();
    }

    private void printBalance() {
        System.out.println("The actual balance is: " + this.balance);
    }
}
