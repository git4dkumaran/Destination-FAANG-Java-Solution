package cisco.thousand;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;

public class PacketBufferGemini {

	private final ConcurrentSkipListMap<Integer, Packet> buffer;
	private final AtomicInteger expectedSeqNum;

	public PacketBufferGemini() {
		buffer = new ConcurrentSkipListMap<>();
		expectedSeqNum = new AtomicInteger(1);
	}

	public void addToBuffer(Packet packet) {
		buffer.put(packet.getSeqNum(), packet);
	}

	public synchronized Packet readFromBuffer() {
		int currentExpectedSeqNum = expectedSeqNum.get();
		Packet packet = buffer.get(currentExpectedSeqNum);

		if (packet != null) {
			// Remove packet only if it matches expected sequence number
			buffer.remove(currentExpectedSeqNum);
			expectedSeqNum.incrementAndGet();
			return packet;
		}

		// No packet available for current expected sequence number, return null
		return null;
	}
}
//
//class Packet {
//	private final int seqNum;
//
//	public Packet(int seqNum) {
//		this.seqNum = seqNum;
//	}
//
//	public int getSeqNum() {
//		return seqNum;
//	}
//
//	// Add your packet data access methods here
//}
