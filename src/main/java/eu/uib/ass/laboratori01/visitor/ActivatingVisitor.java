package eu.uib.ass.laboratori01.visitor;

public class ActivatingVisitor implements AnimalVisitor {

    @Override
    public void visit(Cat cat) {
        cat.meow();
    }

    @Override
    public void visit(Dog dog) {
        dog.woof();
    }
}
