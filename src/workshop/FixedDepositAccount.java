package workshop;

public class FixedDepositAccount extends BankAccount {
    
    private float interest = 3;
    private int durationMonths = 6; 
    private int interestDurationCounter = 0;

    public FixedDepositAccount(String accountName, float initialAccountBalance) {
        super(accountName, initialAccountBalance);
        this.interestDurationCounter = 0;
    }

    public FixedDepositAccount(String accountName, float initialAccountBalance, float interest) {
        super(accountName, initialAccountBalance);
        this.interest = interest;
        this.interestDurationCounter = 0;
    }

    public FixedDepositAccount(String accountName, float initialAccountBalance, float interest, int durationMonths) {
        super(accountName, initialAccountBalance);
        this.interest = interest;
        this.durationMonths = durationMonths; 
        this.interestDurationCounter = 0;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        if (interest <= 0) {
            throw new IllegalArgumentException("Invalid interest, must be more than 0");
        }
        this.interest = interest;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        if (durationMonths <= 0) {
            throw new IllegalArgumentException("Invalid duration, must be more than 0");
        }
        this.durationMonths = durationMonths;
    }

    public int getInterestDurationCounter() {
        return interestDurationCounter;
    }

    public void setInterestDurationCounter(int interestDurationCounter) {
        this.interestDurationCounter = interestDurationCounter;
    }

    public void setInterestAndDuration(float interest, int durationMonths) {
        if(interestDurationCounter == 1) {
            throw new IllegalArgumentException("Interest and duration can only be changed once");
        }

        setInterest(interest);              // calling the setInterest method with the interest parameter above
        setDurationMonths(durationMonths);  // calling the setDurationMonths method with the durationMonths parameter above
        interestDurationCounter++; 
    }

    @Override
    public void withdraw() {
        ;
    }

    @Override
    public void deposit() {
        ;
    }

    @Override
    public float getAccountBalance() {
        return super.getAccountBalance() + interest; 
    }
}
