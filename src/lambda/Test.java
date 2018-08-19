package lambda;

import java.util.*;
import java.util.stream.*;

public class Test {
	public static void main(String[] args) {
		Map<String, List<Integer>> groups = Stream.of(1, 2, 3, 4, 5)
				.collect(Collectors.groupingBy(x -> x % 2 == 0 ? "even" : "odd"));
		for (Map.Entry<String, List<Integer>> e : groups.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}

		String s = Stream.of(1, 2, 3, 4, 5).map(x -> x.toString()).collect(Collectors.joining(", "));
		System.out.println(s);
	}
}