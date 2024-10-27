package eu.uib.ass.laboratori01.visitor;

public class Dog implements Animal {
    public void woof() {
        System.out.println("Woof!");
    }

    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}
