import java.util.Arrays;


public class ArrayHeap<V extends Comparable<V>> implements Heap {
	
	private int INITIAL_SIZE = 100;
	private MODE mode;
	private static Object[] theHeap;
	private int lastIndex = 0;
	private int elemCount;
	public int length;
	
	public ArrayHeap() {
		mode=Heap.MODE.MAX;
		theHeap = new V[INITIAL_SIZE];
		theHeap = new V[]{25, 12, 45, 21, 10, 11, 34, 69, 23, 35, 28};//TESTY BITS PLS REMOVE IN CASE OF GENERIC IMPLEMENTATION
		length = theHeap.length;
	}
	public static void main(String[] args){
		ArrayHeap<Integer> h  = new ArrayHeap<Integer>();
		h.heapify();
		//h.siftDown(0);
		for(int i = 0;i<h.length;i++){
			System.out.println(theHeap[i]);//this prints the heap yo, its WRONG
		}
	}
	public V remove() {
		V temp = (V)theHeap[0];
		swapValues(0, lastIndex);
		lastIndex--;
		siftDown(0);
		return temp;
	}
	@Override
	public V remove(V value) {
		// TODO Auto-generated method stub
		Object result = null;
		if(elemCount > 0){
			result = theHeap[0];
			swapValues(0, lastIndex);
			theHeap[lastIndex]=null;
			elemCount--;
			if(elemCount > 0){
				lastIndex--;
				siftDown(0);
			}
			return (V)result;
		}
	}
	@Override
	public void fromArray(V[] array) {
		// TODO Auto-generated method stub
		int newCapacity = computeCapacity(array.length);
		theHeap = Arrays.copyOf(array, newCapacity);
	}
	@Override
	public void add(V value) {
		// TODO Auto-generated method stub
		ensureCapacity();
		if(elemCount++ > 0){
			lastIndex++;
		}
		theHeap[lastIndex] = value;
		siftUp(lastIndex);
	}
	private void ensureCapacity() {
		// TODO Auto-generated method stub
		
	}
	public void heapify(){
		for(int i=theHeap.length/2;i>=0;i--){
			siftDown(i);
		}
		
	}
	public V[] getSortedContents(){
		/**
		 * comments
		 */
		
		return null;
	}
	private void siftDown(int index) {
		assert (index >= 0 && index <= (lastIndex));
		// This condition guarantees that the initial value
		// of index corresponds to an internal node.
		// Note to students: Why? And why do I need to make sure
		// index is an internal node?
		if (index <= ((lastIndex - 1) / 2)) {
			int ch1Index;
			int ch2Index;
			int swapIndex = 0;
			boolean swapped;

			do {
				swapped = false;
				ch1Index = 2 * index + 1;

				if (ch1Index <= lastIndex) {
					ch2Index = ch1Index + 1;

					swapIndex = ch2Index <= lastIndex
							&& compareValues(ch2Index, ch1Index) ? ch2Index
							: ch1Index;
				}

				if (compareValues(swapIndex, index)) {
					swapValues(swapIndex, index);
					index = swapIndex;
					swapped = true;
				}
			} while (swapped);
		}
	}
	private void siftUp(int index){
		assert(index >= 0 && index <=lastIndex); 
		int parentIndex;
		boolean swapped = true;
		while(index > 0 && swapped == true){
			swapped = false;
			parentIndex = (index-1)/2;
			if(compareValues(index, parentIndex)){
				swapValues(index, parentIndex);//THERE ARE TWO CONDITIONS WHERE THIS SHOULD CONTINUE)
				swapped = true;
			}
		}
	}
	private void swapValues(int index1, int index2) {//simple swapping method
		// TODO Auto-generated method stub
		Object value = theHeap[index1];
		theHeap[index1] = theHeap[index2];
		theHeap[index2] = value;
	}
	private boolean compareValues(int ch2Index, int ch1Index) {
		//method created to deal with changeable mode for the heap and clean up the other method
		//MAX >> max heap,   otherwise min heap
		if(mode == Heap.MODE.MAX) {
			return((V)theHeap[ch2Index]).compareTo((V)theHeap[ch1Index]) > 0;//returns true for ch2>ch1
		}else{
			return((V)theHeap[ch2Index]).compareTo((V)theHeap[ch1Index]) < 0;//returns true for ch1>ch2
		}
	}
	@Override
	public V[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
}
/*
public void HeapSort(V[] array){
	heapify(array);//HYPER SUPER ULTRA NOT USEFUL EXACTLY :\ DECENT EXAMPLE FOR STARTING POINT
	lastIndex = array.length-1;
	while(lastIndex > 0){
		swap(0, lastIndex, array);
		lastIndex--;
		siftDown(0);	
	}
}
*/