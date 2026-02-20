package oop.lsp;

public class Sparrow implements Flyable {

    @Override
    public void move() {
        System.out.println("Sparrow hops along the branch.");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow flies through the air.");
    }
}
