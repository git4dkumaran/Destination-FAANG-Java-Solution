package infy;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The design of the CopyOnWriteArrayList uses an interesting technique to make
 * it thread-safe without a need for synchronization. When we are using any of
 * the modify methods – such as add() or remove() – the whole content of the
 * CopyOnWriteArrayList is copied into the new internal copy.
 **/

public class CopyOnWrite {

	public static void main(String args[]) {
		CopyOnWrite cw = new CopyOnWrite();
		cw.sampleCopyOnWrite();
	}

	/**
	 * The design of the CopyOnWriteArrayList uses an interesting technique to make
	 * it thread-safe without a need for synchronization. When we are using any of
	 * the modify methods – such as add() or remove() – the whole content of the
	 * CopyOnWriteArrayList is copied into the new internal copy.
	 * 
	 * Due to this simple fact, we can iterate over the list in a safe way, even
	 * when concurrent modification is happening.
	 * 
	 * When we’re calling the iterator() method on the CopyOnWriteArrayList, we get
	 * back an Iterator backed up by the immutable snapshot of the content of the
	 * CopyOnWriteArrayList.
	 */
	public void sampleCopyOnWrite() {
		CopyOnWriteArrayList<Integer> numbers 
		  = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8});
		
		Iterator<Integer> iterator = numbers.iterator();  // new Copy of Array is created for the iterator.
		

		
		numbers.add(10);

		
		List<Integer> result = new LinkedList<>();
		iterator.forEachRemaining(result::add);
		
		
		List<Integer> assertResult = new LinkedList<>();
		assertResult.add(1); assertResult.add(3); assertResult.add(5); assertResult.add(8); 
		
		assertEquals(result,  assertResult);;

		assertResult.iterator().forEachRemaining(System.out::println);
		result.iterator().forEachRemaining(System.out::println);
		
		
		Iterator<Integer> iterator2 = numbers.iterator();
		List<Integer> result2 = new LinkedList<>();
		iterator2.forEachRemaining(result2::add);
		
		assertResult.add(10);

		assertEquals(result2,  assertResult);;


		System.out.println(" --------------------------" );

	 
		assertResult.iterator().forEachRemaining(System.out::println);
		
		result2.iterator().forEachRemaining(System.out::println);
		
	}
	

}
