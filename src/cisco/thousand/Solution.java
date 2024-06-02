package cisco.thousand;

/*
 * Create a packet buffer. Think of this as a middle layer between something
 * that is consuming the packets off of the wire, and some application that will
 * read the data. The buffer will receive a single stream of packets from the
 * lower layer, one packet at a time. These packets can arrive out of order and
 * there may be duplicates. The upper layer will request one packet at a time.
 * You must output packets to the upper layer in order, with no duplicates or
 * gaps.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* Create a packet buffer.
 *
 *            +-----------------+
 *            |   Application   |
 *            +-----------------+
 *                    |
 *                    | readFromBuffer()
 *                    V
 *            +-----------------+
 *            |  Packet Buffer  |
 *            +-----------------+
 *                    ^
 *                    | addToBuffer()
 *                    |
 *            +-----------------+
 *            |Network Interface|
 *            +-----------------+
 * 
 * - Think of this as a middle layer between something that is consuming the
 *   packets off of the wire, and some application that will read the data.
 * 
 * - There is a single producer (the network) and a single consumer (the
 *   application)
 *
 * - The buffer will receive a single stream of packets from the lower layer,
 *   one packet at a time. These packets can arrive out of order and there may be
 *   duplicates.
 *
 * - The upper layer will request one packet at a time. You must output packets
 *   to the upper layer in order, starting at seqNum 1, with no duplicates or gaps.
*/
//
//class Solution {
//	public static void main(String[] args) {
//		// write code here to test the PacketBuffer
//	}
//}

class Solution {

	// private Queue queue = new ConcurrentLinkedQueue<Packet>();
	private Packet lastPacket = null;
	// private Map holderMap = new HashMap<Integer, Packet>();

	private TreeMap<Integer, Packet> holderTreeMap = new TreeMap<Integer, Packet>(new PacketCompator());

	public void addToBuffer(Packet incomingPacket) {

		if (holderTreeMap.put(Integer.valueOf(incomingPacket.getSeqNum()), incomingPacket) != null) {
			lastPacket = incomingPacket;
		}

		// if ( lastPacket == null ) {
		// lastPacket = incomingPacket;
		// queue.add(incomingPacket);
		// }

		// holderMap.put(incomingPacket.getSeqNum(), incomingPacket);

		// Packet nextPacket = holderMap.get(lastPacket.getSeqNum()+1);
		// if ( nextPacket != null ) {
		// queue.add(nextPacket);
		// lastPacket = nextPacket;
		// }
	}

	public Packet getFromBuffer() {

		Packet result = null;
		if (holderTreeMap.size() > 0 && lastPacket != null) {
			result = holderTreeMap.get(lastPacket.getSeqNum());
			holderTreeMap.remove(lastPacket.getSeqNum());
		}

		return result;
	}

}

class PacketCompator implements Comparator<Integer> {

	// @Override
	// public int compare(Packet p1, Packet p2) {
	// return p1.getSeqNum() == p2.getSeqNum() ? p2.getSeqNum() - p1.getSeqNum() :
	// p1.getSeqNum() - p2.getSeqNum();
	// }

	@Override
	public int compare(Integer p1, Integer p2) {
		return p1 == p2 ? p2 - p1 : p1 - p2;
	}
} 