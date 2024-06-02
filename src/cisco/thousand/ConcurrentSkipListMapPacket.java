package cisco.thousand;

import java.util.Random;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcurrentSkipListMapPacket {

	public static void main(String args[]) {

		System.out.println(" ConcurrentSkipListMapPacket --> ");

		Random r = new Random();

		String sampleByte = "sampleByteData";
		Stream<Packet> randomProductStream = Stream.generate(() -> new Packet(r.nextInt(1000), sampleByte.getBytes()))
				.limit(1000);

		System.out.println(" Generated.. randomProductStream --> ");

		System.out.println(" randomProductStream --> " + randomProductStream);

		// randomProductStream.forEach(packet -> System.out.println(packet));

//		System.out.println( " map.. " + map );

		PacketBuffer pb = new PacketBuffer();

		pb.addToBuffer(randomProductStream);

		System.out.println(" Done... ");
	}

}

// https://blog.ycrash.io/parallelism-in-concurrenthashmap/

class PacketBuffer {

	private ConcurrentSkipListMap<Integer, Packet> map = new ConcurrentSkipListMap<Integer, Packet>();

	public void addToBuffer(Stream<Packet> incomingPacket) {

		System.out.println(" Count.. " + incomingPacket);

		// ConcurrentMap<String, Integer> map = incomingPacket.parallel().collect(
		map = (ConcurrentSkipListMap<Integer, Packet>) incomingPacket.parallel().collect(Collectors.toConcurrentMap(
				Packet::getSeqNum, Packet -> Packet, (oldValue, newValue) -> oldValue == null ? null : newValue // Merge
																												// function
				, ConcurrentSkipListMap<Integer, Packet>::new // Supplier to create ConcurrentHashMap
		));

		System.out.println(" map.. " + map);

		map.descendingKeySet().stream().forEach(System.out::println);

	}

	public void addToBuffer(Packet incomingPacket) {

		if (incomingPacket != null) {
			map.put(incomingPacket.getSeqNum(), incomingPacket);
		}

	}

	public void sampleConcurrentOperaton() {

		// Create a stream of strings
		Stream<String> strings = Stream.of("cat", "fish", "dog");

		// Collect the strings into a concurrent map, using the string itself as the key
		// and the string length as the value
		ConcurrentMap<String, Integer> map = strings.parallel()
				.collect(Collectors.toConcurrentMap(Function.identity(), String::length));

		// Print the map
		System.out.println(map);
	}

}
