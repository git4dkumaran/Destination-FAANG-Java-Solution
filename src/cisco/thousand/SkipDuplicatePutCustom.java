//package cisco.thousand;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentSkipListMap;
//import java.util.function.BiFunction;
//import java.util.function.BinaryOperator;
//import java.util.function.Function;
//import java.util.function.Supplier;
//import java.util.stream.Collector;
//import java.util.stream.Collector.Characteristics;
//
//class SkipDuplicateCollector<K> implements Collector<K, ?, ConcurrentSkipListMap<Integer, Packet>> {
//
//	@Override
//	public Supplier<ConcurrentSkipListMap<K, Boolean>> supplier() {
//		return ConcurrentSkipListMap::new;
//	}
//
//	@Override
//	public BiFunction<ConcurrentSkipListMap<K, Boolean>, K, Boolean> accumulator() {
//		return (map, key) -> map.putIfAbsent(key, true); // Add only if absent (first occurrence)
//	}
//
//	@Override
//	public BinaryOperator<ConcurrentSkipListMap<K, Boolean>> combiner() {
//		return ConcurrentSkipListMap::putAll;
//	}
//
//	@Override
//	public Function<ConcurrentSkipListMap<K, Boolean>, ConcurrentSkipListMap<K, Boolean>> finisher() {
//		return map -> map;
//	}
//
//	@Override
//	public Set<Characteristics> characteristics() {
//		return Collections.emptySet();
//	}
//
//	public static <K> Collector<K, ?, ConcurrentSkipListMap<K, Boolean>> toSkipDuplicateMap() {
//		return new SkipDuplicateCollector<>();
//	}
//}
//
//public class SkipDuplicatePutCustom {
//
//	public static void main(String[] args) {
//		String[] words = { "apple", "banana", "apple", "orange", "banana" };
//
//		// Skip duplicates while putting (count only the first occurrence)
//		Map<String, Boolean> uniqueWords = Arrays.stream(words).collect(SkipDuplicateCollector.toSkipDuplicateMap());
//
//		System.out.println("Unique Words: " + uniqueWords);
//	}
//}