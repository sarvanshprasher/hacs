package testHacs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hacs.ListIterator;

public class TestListIterator {

	ListIterator listIterator;

	ArrayList<Object> list;

	Object test;

	@BeforeEach
	void getList() {

		list=new ArrayList<>();
		test=new Object();
		list.add(test);
		listIterator = new ListIterator(list);

	}

	@Test
	void testHasNext() {

		assertTrue(listIterator.hasNext());

	}

	@Test
	void testHasNextWhenNull() {

		assertFalse(new ListIterator(new ArrayList<>()).hasNext());

	}

	@Test
	void testNext() {

		Object object = listIterator.next();
		assertEquals(test, object);

	}

	@Test
	void testNextWhenNull() {

		Object object = new ListIterator(new ArrayList<>()).next();
		assertEquals(null, object);

	}

	@Test
	void testRemove() {

		int size = 0;
		while (listIterator.hasNext()){
			size++;
			listIterator.next();
		}
		listIterator.remove();
		int newSize = 0;
		while (listIterator.hasNext()){
			newSize++;
			listIterator.next();
		}
		assertTrue(newSize == size - 1);

	}

}
