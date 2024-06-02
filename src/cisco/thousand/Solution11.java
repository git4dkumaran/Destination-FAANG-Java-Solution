package cisco.thousand;

import java.nio.BufferOverflowException;

public class PacketBuffer  {

    private final Packet[] buffer;
    private int head; // Index of the next packet to be read
    private int tail; // Index of the next slot to write
    private final int capacity;

    public PacketBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new Packet[capacity];
        head = tail = 0;
    }

    public synchronized void addToBuffer(Packet packet) {
        // Check for buffer overflow
        if ((tail + 1) % capacity == head) {
            throw new BufferOverflowException("Packet buffer is full!");
        }

        // Handle out-of-order packets and duplicates
        int seqNum = packet.getSeqNum();
        if (seqNum < getHeadSeqNum() || (seqNum == getHeadSeqNum() && contains(packet))) {
            return; // Duplicate or already processed packet
        }

        // Insert packet at the correct position (sorted by sequence number)
        int nextTail = (tail + 1) % capacity;
        while (nextTail != head && buffer[nextTail] != null && buffer[nextTail].getSeqNum() < seqNum) {
            nextTail = (nextTail + 1) % capacity;
        }
        buffer[nextTail] = packet;
        tail = nextTail;
    }

    public synchronized Packet readFromBuffer() {
        // Check for empty buffer
        if (head == tail) {
            return null;
        }

        Packet packet = buffer[head];
        buffer[head] = null; // Mark slot as empty
        head = (head + 1) % capacity;
        return packet;
    }

    private int getHeadSeqNum() {
        return head == tail ? -1 : buffer[head].getSeqNum();
    }

    private boolean contains(Packet packet) {
        for (int i = head; i != tail; i = (i + 1) % capacity) {
            if (buffer[i] != null && buffer[i].equals(packet)) {
                return true;
            }
        }
        return false;
    }
}

class Packet {
    private final int seqNum;

    public Packet(int seqNum) {
        this.seqNum = seqNum;
    }

    public int getSeqNum() {
        return seqNum;
    }
}

