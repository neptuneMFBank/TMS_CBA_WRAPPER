package com.neptune.cbawrapper.RequestRessponseSchema;

public class BalanceResponse {

    private Double effective_balance;
    private Double ledger_balance;
    private Double last_credit_amount;
    private String last_credit_date;
    private Double hold_bal;
    private Double last_debit_amount;
    private String last_debit_date;
    private Double accured_interest;
    private Double accured_interest_overdrawn;
    private Double late_fess;
    private String account_number;

    public Double getEffective_balance() {
        return effective_balance;
    }

    public void setEffective_balance(Double effective_balance) {
        this.effective_balance = effective_balance;
    }

    public Double getLedger_balance() {
        return ledger_balance;
    }

    public void setLedger_balance(Double ledger_balance) {
        this.ledger_balance = ledger_balance;
    }

    public Double getLast_credit_amount() {
        return last_credit_amount;
    }

    public void setLast_credit_amount(Double last_credit_amount) {
        this.last_credit_amount = last_credit_amount;
    }

    public String getLast_credit_date() {
        return last_credit_date;
    }

    public void setLast_credit_date(String last_credit_date) {
        this.last_credit_date = last_credit_date;
    }

    public Double getHold_bal() {
        return hold_bal;
    }

    public void setHold_bal(Double hold_bal) {
        this.hold_bal = hold_bal;
    }

    public Double getLast_debit_amount() {
        return last_debit_amount;
    }

    public void setLast_debit_amount(Double last_debit_amount) {
        this.last_debit_amount = last_debit_amount;
    }

    public String getLast_debit_date() {
        return last_debit_date;
    }

    public void setLast_debit_date(String last_debit_date) {
        this.last_debit_date = last_debit_date;
    }

    public Double getAccured_interest() {
        return accured_interest;
    }

    public void setAccured_interest(Double accured_interest) {
        this.accured_interest = accured_interest;
    }

    public Double getAccured_interest_overdrawn() {
        return accured_interest_overdrawn;
    }

    public void setAccured_interest_overdrawn(Double accured_interest_overdrawn) {
        this.accured_interest_overdrawn = accured_interest_overdrawn;
    }

    public Double getLate_fess() {
        return late_fess;
    }

    public void setLate_fess(Double late_fess) {
        this.late_fess = late_fess;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public BalanceResponse() {
    }
}
