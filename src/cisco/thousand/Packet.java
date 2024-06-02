package cisco.thousand;

class Packet implements Comparable<Packet> {
	private int seqNum;
	private byte[] data;

	public Packet(int seqNum, byte[] data) {
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
	public int compareTo(Packet p) {
		return this.seqNum - p.seqNum;
	}
}
