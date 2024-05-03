package apiendereco.spring.apiendereco;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ArrayListComplexExample {
	public static void main(String[] args) {
		List<String> nomes = new ArrayList<>();
		nomes.add("Alice Green");
		nomes.add("Bob Brown");
		nomes.add("Charlie Blue");

		Predicate<String> filtro = nome -> nome.startsWith("A");
		Function<String, String> transformar = nome -> nome.toUpperCase();

		nomes.replaceAll(nome -> filtro.test(nome) ? transformar.apply(nome) : nome);

		System.out.println(nomes);
	}
}
