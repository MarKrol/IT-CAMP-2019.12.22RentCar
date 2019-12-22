package pl.camp.it;

import pl.camp.it.model.Car;

public class Main {
    public static void main(String[] args) {
        final int a = 5;
        final Car c = new Car("Audi", "A5", 1999, 300.00, "AWS");;

        System.out.println(a);
        System.out.println(c);

        c.setPrice(1000.00);

        System.out.println(c);
    }
}
