package eu.uib.ass.laboratori01.visitor;

public interface AnimalVisitor {
    void visit(Cat cat);
    void visit(Dog dog);
}
