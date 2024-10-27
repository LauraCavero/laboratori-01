package eu.uib.ass.laboratori01.visitor;

public class Cat implements Animal {
    public void meow() {
        System.out.println("Meow!");
    }

    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}
