package oop.lsp;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Polymorphic method: รับได้ทุกตัวที่ Moveable
    static void showMove(Moveable m) {
        System.out.print("showMove(): ");
        m.move();
    }

    // Polymorphic method: รับได้เฉพาะตัวที่ Flyable
    static void showFly(Flyable f) {
        System.out.print("showFly(): ");
        f.fly();
    }

    public static void main(String[] args) {

        Moveable penguin = new Penguin();
        Moveable ostrich = new Ostrich();
        Flyable sparrow = new Sparrow();
        Flyable eagle = new Eagle();

        // Polymorphic collection (Moveable รับได้ทั้งบินได้/บินไม่ได้)
        List<Moveable> movers = new ArrayList<>();
        movers.add(penguin);
        movers.add(ostrich);
        movers.add(sparrow); // Flyable ใช้แทน Moveable ได้ (LSP)
        movers.add(eagle);   // Flyable ใช้แทน Moveable ได้ (LSP)

        System.out.println("=== Moveable collection: all can move() ===");
        for (Moveable m : movers) {
            m.move();
        }

        System.out.println("\n=== Using polymorphic methods ===");
        showMove(penguin);
        showMove(ostrich);
        showMove(sparrow);
        showMove(eagle);

        // Flyable collection (มีเฉพาะตัวที่บินได้)
        List<Flyable> flyers = new ArrayList<>();
        flyers.add(sparrow);
        flyers.add(eagle);

        System.out.println("\n=== Flyable collection: only these can fly() ===");
        for (Flyable f : flyers) {
            showFly(f); // เรียกผ่าน method เพื่อโชว์ polymorphism
        }

        // กัน runtime/logical issue ตั้งแต่ compile-time:
        // showFly(penguin);         // Compile-time error
        // flyers.add(new Penguin()); // Compile-time error
    }
}