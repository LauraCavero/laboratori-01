package eu.uib.ass.laboratori01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// STRATEGY
import eu.uib.ass.laboratori01.strategy.ListSortingService;
import eu.uib.ass.laboratori01.strategy.SortWithListSort;
import eu.uib.ass.laboratori01.strategy.SortWithStreamSorted;

// VISITOR
import eu.uib.ass.laboratori01.visitor.Animal;
import eu.uib.ass.laboratori01.visitor.Cat;
import eu.uib.ass.laboratori01.visitor.Dog;
import eu.uib.ass.laboratori01.visitor.CountingVisitor;
import eu.uib.ass.laboratori01.visitor.ActivatingVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Laboratori01Application {

	public static void main(String[] args) {
		SpringApplication.run(Laboratori01Application.class, args);
	}

	@Order(1)
	@Component
	public class HelloWorldGreeting implements CommandLineRunner {
		@Override
		public void run(String... args) throws Exception {
			System.out.println("Hello, world!");
		}
	}

	@Order(5)
	@Component
	public class ListSortingRunner implements CommandLineRunner {
		private final ListSortingService listSortingService;

		public ListSortingRunner(ListSortingService listSortingService) {
			this.listSortingService = listSortingService;
		}

		@Override
		public void run(String... args) throws Exception {
			List<Integer> list = new ArrayList<>(List.of(8, 3, 6, 1, 9));

			listSortingService.setSortingStrategy(new SortWithListSort());
			System.out.print("Ordenat amb list.sort: ");
			printList(listSortingService.sort(list));

			list = new ArrayList<>(List.of(8, 3, 6, 1, 9));
			listSortingService.setSortingStrategy(new SortWithStreamSorted());
			System.out.print("Ordenat amb stream.sorted: ");
			printList(listSortingService.sort(list));
		}

		private static void printList(final List<?> list) {
			System.out.println(list.stream()
					.map(Object::toString)
					.collect(Collectors.joining(",")));
		}
	}

	// Afegim el runner pel patró Visitor
	@Order(10)
	@Component
	public class VisitorPatternRunner implements CommandLineRunner {
		@Override
		public void run(String... args) throws Exception {
			List<Animal> animals = List.of(new Cat(), new Dog(), new Cat(), new Dog(), new Dog());

			// Visitor de recompte
			CountingVisitor countingVisitor = new CountingVisitor();
			animals.forEach(animal -> animal.accept(countingVisitor));
			System.out.println("Nombre de Cats: " + countingVisitor.getCatCount());
			System.out.println("Nombre de Dogs: " + countingVisitor.getDogCount());

			// Visitor d'activació
			ActivatingVisitor activatingVisitor = new ActivatingVisitor();
			animals.forEach(animal -> animal.accept(activatingVisitor));
		}
	}
}
