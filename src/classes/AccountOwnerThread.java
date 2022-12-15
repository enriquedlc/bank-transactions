package classes;

import enums.ActionEnum;

public class AccountOwnerThread extends Thread {

    private String name;
    private int quantity;
    private ActionEnum action;
    private BankAccount bankAccount;

    /**
     * The account owner has a name, a quantity of money to deposit or extract, the type of action and the bank account.
     * @param name
     * @param quantity
     * @param action
     * @param bankAccount
     */

    public AccountOwnerThread(String name, int quantity, ActionEnum action, BankAccount bankAccount) {
        this.name = name;
        this.quantity = quantity;
        this.action = action;
        this.bankAccount = bankAccount;
    }

    /**
     * The run method is executed when the thread is started.
     * The action is executed depending on the type of transaction in the enum.
     * The action is done in the bank account.
     * The bank account is shared between the users.
     */
    @Override
    public void run() {
        if (action.equals(ActionEnum.EXTRACT)) {
            this.bankAccount.extract(this.quantity, this.name);
        } else {
            this.bankAccount.deposit(this.quantity, this.name);
        }
    }
}
