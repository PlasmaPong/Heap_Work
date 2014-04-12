
public interface Heap<V extends Comparable<V>> {
	enum MODE {MIN, MAX};

	/**
	 * @param value
	 */
	public void add(V value);

	/**
	 * @return
	 */
	public V[] toArray();

	/**
	 * @return
	 */
	public V remove();

	/**
	 * @param value
	 */
	public V remove(V value);

	/**
	 * @param array
	 */
	public void fromArray(V[] array);

	/**
	 * @return
	 */
	public V[] getSortedContents();

}

