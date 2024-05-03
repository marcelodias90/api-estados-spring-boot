package apiendereco.spring.apiendereco;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamComplexExample4 {
	public static void main(String[] args) {
		List<String> nomes = Arrays.asList("Ana", "Paulo", "Ana", "Pedro", "Paulo");

		Map<String, Long> frequenciaDeNomes = nomes.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(frequenciaDeNomes);
	}
}
