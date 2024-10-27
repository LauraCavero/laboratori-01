package eu.uib.ass.laboratori01.strategy;

import java.util.List;

public class SortWithListSort implements SortingStrategy {
    @Override
    public List<Integer> sort(List<Integer> list) {
        list.sort(Integer::compareTo);
        return list;
    }
}
