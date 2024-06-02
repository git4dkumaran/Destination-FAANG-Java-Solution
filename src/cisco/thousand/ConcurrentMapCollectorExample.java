package cisco.thousand;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcurrentMapCollectorExample {

	public static void main(String[] args) {
		sampleStream();

		sampleStream2();

		sampleStream3();

	}

	private static void sampleStream() {
		// Create a stream of strings
		Stream<String> strings = Stream.of("cat", "fish", "dog");

		// Collect the strings into a concurrent map, using the string itself as the key
		// and the string length as the value
		ConcurrentMap<String, Integer> map = strings.parallel()
				.collect(Collectors.toConcurrentMap(Function.identity(), String::length));

		// Print the map
		System.out.println(map);
	}

	private static void sampleStream2() {
		// Create a stream of strings
		Stream<String> strings = Stream.of("cat", "fish", "dog");

		// Collect the strings into a concurrent map, using the string itself as the key
		// and the string length as the value
		ConcurrentMap<String, Integer> map = strings.parallel()
				.collect(Collectors.toConcurrentMap(String -> String, String::length)

				);

		// Print the map
		System.out.println(map);
	}

	private static void sampleStream3() {
		// Create a stream of strings
		Stream<String> strings = Stream.of("cat", "fish", "dog");

		// Collect the strings into a concurrent map, using the string itself as the key
		// and the string length as the value
		ConcurrentSkipListMap<Integer, String> map = strings.parallel()
				.collect(
						Collectors.toConcurrentMap(
								String::length, 	// Key
								String -> String, // Value
								(oldValue, newValue) -> oldValue == null ? null : newValue, // merger function for duplicate value to handle
								ConcurrentSkipListMap<Integer, String>::new) // Datastructure provider.

				);

		// Print the map
		System.out.println(map);
	}

}
