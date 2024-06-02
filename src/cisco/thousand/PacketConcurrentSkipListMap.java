package cisco.thousand;

import java.util.Random;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PacketConcurrentSkipListMap {

	public static void main(String args[]) {

		System.out.println(" PacketConcurrentSkipListMap --> ");

		Random r = new Random();

		String sampleByte = "sampleByteData";
		Stream<Packet> randomProductStream = Stream.generate(() -> new Packet(r.nextInt(1000), sampleByte.getBytes()))
				.limit(1000);

		System.out.println(" randomProductStream --> " + randomProductStream);

		PacketBuffer pb = new PacketBuffer();

		pb.addToBuffer(randomProductStream);

		System.out.println(" Done... ");
	}

}

// https://blog.ycrash.io/parallelism-in-concurrenthashmap/

class PacketBuffer1 {

	private ConcurrentSkipListMap<Integer, Packet> map = new ConcurrentSkipListMap<Integer, Packet>();

	public void addToBuffer(Stream<Packet> incomingPacket) {

		System.out.println(" Count.. " + incomingPacket);

		map = (ConcurrentSkipListMap<Integer, Packet>)
				incomingPacket.parallel().collect(
						Collectors.toConcurrentMap(
								Packet::getSeqNum, 
								Packet -> Packet, 
								(oldValue, newValue) -> oldValue == null ? null : newValue, // Merge function
								ConcurrentSkipListMap<Integer, Packet>::new // Supplier to create ConcurrentHashMap
		));

		System.out.println(" map.. " + map);
		//map.descendingKeySet().stream().forEach(System.out::println);

	}

}



class Packet1 implements Comparable<Packet1> {
	private int seqNum;
	private byte[] data;

	public Packet1(int seqNum, byte[] data) {
		this.seqNum = seqNum;
		this.data = data;
	}

	public int getSeqNum() {
		return seqNum;
	}

	public String toString() {
		return String.format("[%d]=%s", seqNum, new String(data));
	}

	@Override
	public int compareTo(Packet1 p) {
		return this.seqNum - p.seqNum;
	}
}


