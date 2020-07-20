package java8.chapter05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TraderTest {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));


        List<Transaction> no1 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        // System.out.println(no1);

        List<String> no2 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        // System.out.println(no2);

        List<Trader> no3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        // System.out.println(no3);

        List<String> no4 = transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .collect(Collectors.toList());
        // System.out.println(no4);

        boolean no5 = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        // System.out.println(no5);

        List<Integer> no6 = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
        // System.out.println(no6);

        Optional<Integer> no7 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        // System.out.println(no7.get());

        Optional<Transaction> no8 = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        // System.out.println(no8.get());

        Optional<Transaction> no8_2 = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println(no8_2.get());
    }
}
