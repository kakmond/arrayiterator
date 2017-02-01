package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ArrayIterator class that provides an Iterator for any array.
 * 
 * @author Wongsathorn Panichkurkul
 *
 * @param <T> is the type of thing in the ArrayIterator
 */

public class ArrayIterator<T> implements Iterator<T> {

	/** attribute for the array we want to iterate over */
	private T[] array;
	/** cursor is the position of array */
	private int cursor;
	/** status that remove() can be use or not */
	private boolean status;

	/**
	 * Initialize a new array iterator with the array to process.
	 * 
	 * @param array is the array to iterate over
	 */
	public ArrayIterator(T[] array) {
		this.array = array;
		this.cursor = 0;
		this.status = false;
	}

	/**
	 * Return the next non-null element from array, if any.
	 * 
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException
	 *             if there are no more elements to return.
	 */
	@Override
	public T next() {
		if (hasNext()) {
			T next = this.array[cursor];
			status = true;
			this.cursor++;
			return next;
		} else
			throw new NoSuchElementException();
	}

	/**
	 * Returns true if next() can return another non-null array element, false
	 * if no more elements.
	 * 
	 * @return true if next() can return another non-null array element, 
	 *         false if no more elements.
	 */
	@Override
	public boolean hasNext() {
		for (int i = this.cursor; i < array.length; i++) {
			if (array[i] != null) {
				this.cursor = i;
				return true;
			}
		}
		return false;
	}

	/**
	 * Remove most recent element returned by next() from the array by setting
	 * it to null. This method may only be called once after a call to next().
	 * 
	 * @throws IllegalStateException
	 *             If this method is called without calling next(). or called
	 *             more than once after calling next()
	 */
	@Override
	public void remove() {
		if (status) {
			array[cursor - 1] = null;
			status = false;
		} else
			throw new IllegalStateException();
	}

}