package eu.uib.ass.laboratori01.visitor;

public class CountingVisitor implements AnimalVisitor {
    private int catCount = 0;
    private int dogCount = 0;

    @Override
    public void visit(Cat cat) {
        catCount++;
    }

    @Override
    public void visit(Dog dog) {
        dogCount++;
    }

    public int getCatCount() {
        return catCount;
    }

    public int getDogCount() {
        return dogCount;
    }
}
