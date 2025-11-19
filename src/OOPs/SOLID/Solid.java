package OOPs.SOLID;

/*
Below code is the example of "Dependency Inversion Principle" ('D' of SOLID principle)
 */
interface PaymentProcessor {
    void processPayment();
}

class UPIPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment() {
        System.out.println("UPI payment processing...");
    }
}

class CreditCardPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment() {
        System.out.println("Credit Card payment processing...");
    }
}

class PaymentService {
    private PaymentProcessor processor;

    PaymentService(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void makePayment() {
        processor.processPayment();
    }
}

public class Solid {
    public static void main(String[] args) {
        PaymentProcessor creditcard = new CreditCardPaymentProcessor();
        PaymentProcessor upipayment = new UPIPaymentProcessor();

        PaymentService paymentservice = new PaymentService(creditcard);
        paymentservice.makePayment();

        PaymentService upiPaymentservice = new PaymentService(upipayment);
        upiPaymentservice.makePayment();
    }
}
