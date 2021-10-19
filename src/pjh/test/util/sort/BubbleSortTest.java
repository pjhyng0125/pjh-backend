package pjh.test.util.sort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pjh.cmn.util.SortUtil;
import pjh.cmn.util.StringUtil;

/**
 * 정렬 테스트
 */
class BubbleSortTest {
	final int arr[] = {6, 5, 3, 2, 9, 4, 9};
	final int ascArr[] = {2, 3, 4, 5, 6, 9, 9};
	final int descArr[] = {9, 9, 6, 5, 4, 3,2 };
	
	@Test
	void bubbleSortAscTest() {
		assertArrayEquals(SortUtil.bubbleSort(arr, true), ascArr);
	}
	
	@Test
	void bubbleSortDescTest() {
		assertArrayEquals(SortUtil.bubbleSort(arr, false), descArr);
	}
}
