package oop.lsp;

public class Eagle implements Flyable {

    @Override
    public void move() {
        System.out.println("Eagle strides forward and spreads its wings.");
    }

    @Override
    public void fly() {
        System.out.println("Eagle soars high and circles above.");
    }
}