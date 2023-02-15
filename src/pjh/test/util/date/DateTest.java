package pjh.test.util.date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pjh.cmn.consts.CmnConsts;
import pjh.cmn.util.DateUtil;

/**
 * 디렉토리 관련 테스트
 */
class DateTest {
	String stdDateyyyyMMdd = "20230121";
	String stdDateyyyyMMddHHmmdd = "20230121110000";
	
	@Test
	void getDefaultTest() {
		assertNotNull(DateUtil.getCurrentTmss(CmnConsts.DATE_FORMAT.DEFAULT, Locale.getDefault()));
	}
	
	@Test
	void getNullTest() {
		assertNotNull(DateUtil.getCurrentTmss(null, null));
	}
	
	@Test
	void getEmptyTest() {
		assertNotNull(DateUtil.getCurrentTmss("", null));
	}
	
	@Test
	void getddMMyyTest() {
		assertNotNull(DateUtil.getCurrentTmss(CmnConsts.DATE_FORMAT.ddMMyy, Locale.getDefault()));
	}
	
	@Test
	void getEEEMMMdyyTest() {
		assertNotNull(DateUtil.getCurrentTmss(CmnConsts.DATE_FORMAT.EEEMMMdyy, Locale.getDefault()));
	}
	
	@Test
	void getEEEMMMdyyKOREATest() {
		assertNotNull(DateUtil.getCurrentTmss(CmnConsts.DATE_FORMAT.EEEMMMdyy, Locale.KOREA));
	}
	
	@Test
	void getEEEMMMdyyENGLISHTest() {
		assertNotNull(DateUtil.getCurrentTmss(CmnConsts.DATE_FORMAT.EEEMMMdyy, Locale.ENGLISH));
	}
	
	@Test
	@DisplayName("yyyyMMdd (정상)")
	void isDayBetween_true_20230121() {
		assertTrue(DateUtil.isStdDateBetween(stdDateyyyyMMdd, "20230121", "20230123", "yyyyMMdd"));
	}
	
	@Test
	@DisplayName("yyyyMMdd (시작날짜 == 오늘날짜)")
	void isDayBetween_true_20230121_start_same() {
		assertTrue(DateUtil.isStdDateBetween(stdDateyyyyMMdd, "20230121", "20230123", "yyyyMMdd"));
	}
	
	@Test
	@DisplayName("yyyyMMdd 종료날짜 == 오늘날짜)")
	void isDayBetween_true_20230121_end_same() {
		assertTrue(DateUtil.isStdDateBetween(stdDateyyyyMMdd, "20230119", "20230121", "yyyyMMdd"));
	}
	
	@Test
	@DisplayName("yyyyMMdd (시작일자 느림)")
	void isDayBetween_false_20230121_start_later() {
		assertFalse(DateUtil.isStdDateBetween(stdDateyyyyMMdd, "20230129", "20230123", "yyyyMMdd"));
	}
	
	@Test
	@DisplayName("yyyyMMdd (종료일자 빠름)")
	void isDayBetween_false_20230121_end_first() {
		assertFalse(DateUtil.isStdDateBetween(stdDateyyyyMMdd, "20230120", "20230119", "yyyyMMdd"));
	}
	
	@Test
	@DisplayName("yyyyMMdd (공백)")
	void isDayBetween_false_empty() {
		assertFalse(DateUtil.isStdDateBetween(stdDateyyyyMMdd, "20230120", "", "yyyyMMdd"));
	}
	
	@Test
	@DisplayName("yyyyMMdd (null)")
	void isDayBetween_false_null() {
		assertFalse(DateUtil.isStdDateBetween(stdDateyyyyMMdd, null, "20230123", "yyyyMMdd"));
	}
	
	@Test
	@DisplayName("yyyyMMddHHmmss (정상)")
	void isDtmBetween_true_20230121110000() {
		assertTrue(DateUtil.isStdDateBetween(stdDateyyyyMMddHHmmdd, "20230121100000", "20230121120000", "yyyyMMddHHmmss"));
	}
	
	@Test
	@DisplayName("yyyyMMddHHmmss (시작일시==오늘일시)")
	void isDtmBetween_false_20230121110000_start_same() {
		assertTrue(DateUtil.isStdDateBetween(stdDateyyyyMMddHHmmdd, stdDateyyyyMMddHHmmdd, "20230121120000", "yyyyMMddHHmmss"));
	}
	
	@Test
	@DisplayName("yyyyMMddHHmmss (종료일시==오늘일시)")
	void isDtmBetween_false_20230121110000_end_same() {
		assertTrue(DateUtil.isStdDateBetween(stdDateyyyyMMddHHmmdd, "20230121100000", stdDateyyyyMMddHHmmdd, "yyyyMMddHHmmss"));
	}
	
	@Test
	@DisplayName("yyyyMMddHHmmss (시작일시 느림)")
	void isDtmBetween_false_20230121110000_start_later() {
		assertFalse(DateUtil.isStdDateBetween(stdDateyyyyMMddHHmmdd, "20230123100000", "20230121120000", "yyyyMMddHHmmss"));
	}
	
	@Test
	@DisplayName("yyyyMMddHHmmss (종료일시 빠름)")
	void isDtmBetween_false_20230121110000_end_first() {
		assertFalse(DateUtil.isStdDateBetween(stdDateyyyyMMddHHmmdd, "20230121100000", "20230121100000", "yyyyMMddHHmmss"));
	}
	
	@Test
	@DisplayName("yyyyMMddHHmmss (길이다름)")
	void isDtmBetween_false_20230121110000_param_length_different() {
		assertFalse(DateUtil.isStdDateBetween(stdDateyyyyMMddHHmmdd, "20230121100000", "20230121100000", "yyyyMMdd"));
	}
	
	@Test
	@DisplayName("yyyyMMddHHmmss (공백)")
	void isDtmBetween_false_20230121110000_empty() {
		assertFalse(DateUtil.isStdDateBetween(stdDateyyyyMMddHHmmdd, "20230121100000", "20230121100000", ""));
	}
	
	@Test
	@DisplayName("yyyyMMddHHmmss (null)")
	void isDtmBetween_false_20230121110000_null() {
		assertFalse(DateUtil.isStdDateBetween(stdDateyyyyMMddHHmmdd, null, "20230121100000", "yyyyMMddHHmmss"));
	}
	
	@Test
	@DisplayName("월의 주 반환")
	void getWeekOfMonth() throws ParseException {
		String dayStr = "20230211";
		String format = "yyyyMMdd";
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = sdf.parse(dayStr);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		int week = cal.get(Calendar.WEEK_OF_MONTH);
		
		System.out.println("월 주차 : " + month +"월 " + week +"주차" );
	}
	
	@Test
	@DisplayName("주의 처음과 마지막 일자 반환")
	void getWeekOfFitstAndLastDay() throws ParseException {
		String format = "yyyy-MM-dd (EEE)";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		Calendar c = Calendar.getInstance();
		System.out.println("today : " + sdf.format(c.getTime()));
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		System.out.println("first day of week : " + sdf.format(c.getTime()));
		c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		System.out.println("last day of week : " + sdf.format(c.getTime()));
	}
	
	@Test
	@DisplayName("Calendar 클래스 week 테스트")
	void calendarClassWeekTest() throws ParseException {
		int y = 2023;
		int m = Calendar.FEBRUARY;
		int d = 15;
		
		String format = "yyyy-MM-dd (EEE)";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, y);
		c.set(Calendar.MONTH, m);
		c.set(Calendar.DAY_OF_MONTH, d);
		
		System.out.println("m월 n주차 : " + ( c.get(Calendar.MONTH) + 1 ) + "월 " + c.get(Calendar.WEEK_OF_MONTH) + "주차");
		
		System.out.println("today : " + sdf.format(c.getTime()));
		
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		System.out.println("first day of week : " + sdf.format(c.getTime()));
		
		c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		System.out.println("last day of week : " + sdf.format(c.getTime()));
	}
}
