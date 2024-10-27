package eu.uib.ass.laboratori01.strategy;

import java.util.List;
import java.util.stream.Collectors;

public class SortWithStreamSorted implements SortingStrategy {
    @Override
    public List<Integer> sort(List<Integer> list) {
        return list.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }
}
