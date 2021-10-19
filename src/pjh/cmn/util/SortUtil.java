package pjh.cmn.util;

import java.util.Arrays;

public class SortUtil {
	/**
	 * 인스턴스화 방지
	 */
	private SortUtil() throws InstantiationException {
		throw new InstantiationException();
	}
	
	/**
	 * 버블 정렬
	 * @param int[] 정수 배열
	 * @param boolean 오름차순 여부
	 * @return int[]
	 * 
	 */
	public static int[] bubbleSort(int src[], boolean ascYn) {
		int len = src.length;
		int[] dst = src.clone();
//		int[] dst = Arrays.copyOf(src, len);
		int tmp = 0;
		
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < (len - i) - 1; j++) {
				if (ascYn ? dst[j] > dst[j + 1] : dst[j] < dst[j + 1]) {
					tmp = dst[j];
					dst[j] = dst[j + 1];
					dst[j + 1] = tmp;
				}
			}
		}
		return dst;
	}
}