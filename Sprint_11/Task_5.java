public class InsufficientAmountException extends Exception {
    private double amount;
    public InsufficientAmountException(double needs) {
        this.amount = needs;
    }

    public double getAmount() {
        return amount;
    }
    
    public String getMessage() {
        return "Sorry, but you are short $" + amount;
    }
}
