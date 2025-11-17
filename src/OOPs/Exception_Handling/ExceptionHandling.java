package OOPs.Exception_Handling;

class InsufficientBalance extends Exception {
    InsufficientBalance(String errorMsg) {
        super(errorMsg);
        System.out.println("InsufficientBalance Called");
    }
}

class BankBalance {
    private int amount;

    BankBalance(int val){
        amount = val;
    }

    public void addBalance(int val) {
        amount += val;
    }

    public void withdrawBalance(int val) throws InsufficientBalance {
        if(val > amount){
            throw new InsufficientBalance("Available amount is : " + amount);
        }
        amount -= val;
    }
}


public class ExceptionHandling {
    public static void main(String[] args) {
        BankBalance ac = new BankBalance(100);
        ac.addBalance(10);
        try {
            ac.withdrawBalance(100);
            ac.withdrawBalance(100);
        } catch (Exception e) {
            System.out.println("Exception Caught : " + e.getMessage());
        }
    }
}
