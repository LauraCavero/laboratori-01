package eu.uib.ass.laboratori01.strategy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListSortingService {
    private SortingStrategy sortingStrategy;

    // Utilitza @Qualifier per especificar quina estratègia injectar
    public ListSortingService(@Qualifier("listSortStrategy") SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public List<Integer> sort(List<Integer> list) {
        return sortingStrategy.sort(list);
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }
}
