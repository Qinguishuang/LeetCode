package java8.chapter08;

import java.util.function.Consumer;

public class ModelRebuild {
    public static void main(String[] args) {
        // new OnlineBankingLambda().processCustomer(123, (Customer c) -> System.out.println("hello"));
    }

}

abstract class OnlineBanking {
    public void processCustomer(int id) {
        Customer c = new Customer(id);
        makeCustomerMoreHappy(c);
    }

    abstract void makeCustomerMoreHappy(Customer c);
}

abstract class OnlineBankingLambda {

    public void processCustomer(int id, Consumer<Customer> make) {
        Customer c = new Customer(id);
        make.accept(c);
    }
}

class Customer {
    int id;

    public Customer(int id) {
        this.id = id;
    }
}