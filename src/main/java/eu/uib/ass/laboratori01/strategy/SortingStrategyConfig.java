package eu.uib.ass.laboratori01.strategy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SortingStrategyConfig {

    @Bean
    public SortingStrategy listSortStrategy() {
        return new SortWithListSort();
    }

    @Bean
    public SortingStrategy streamSortStrategy() {
        return new SortWithStreamSorted();
    }
}
