package pjh.cmn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import pjh.cmn.consts.CmnConsts;

public class DateUtil {
	/**
	 * 인스턴스화 방지
	 */
	private DateUtil() throws InstantiationException {
		throw new InstantiationException();
	}

	public static String getCurrentTmss(String format, Locale locale) {
		String fotmatNotEmpty = StringUtil.isEmptyTrim(format) ? CmnConsts.DATE_FORMAT.DEFAULT : format;
		Locale localeNotEmpty = TypeUtil.isNull(locale) ? Locale.getDefault() : locale;
		SimpleDateFormat sdf = new SimpleDateFormat(fotmatNotEmpty, localeNotEmpty);
		String currentTmss = sdf.format(System.currentTimeMillis());
		System.out.println("현재 일시 " + "("+ format + " | " + locale + ") : " + currentTmss);
		return currentTmss;
	}
	
	/**
	 * 오늘날짜가 시작날짜, 종료날짜 사이에 있는지 여부 반환
	 * parse error 방지를 위해 파라미터 문자열 길이는 모두 동일해야 함
	 * @param stdDateStr 현재날짜 문자열
	 * @param startDateStr 시작날짜 문자열
	 * @param endDateStr 종료날짜 문자열
	 * @param datefrmt 날짜형식 문자열 (특수문자 포함 불가, 숫자만)
	 * @return
	 */
	public static boolean isStdDateBetween(String stdDateStr, String startDateStr, String endDateStr, String datefrmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(datefrmt, Locale.getDefault());
		Date stdDate = new Date();
		Date startDate = new Date();
		Date endDate = new Date();
		int frmtLen = 0;
		
		if (StringUtil.isEmptyTrim(datefrmt)) {
			System.out.println("[isStdDateBetween] datefrmt is empty.");
			return false;
		} else {
			frmtLen = datefrmt.length();
		}
		
		if (StringUtil.isEmptyTrim(stdDateStr)
				|| StringUtil.isEmptyTrim(startDateStr)
				|| StringUtil.isEmptyTrim(endDateStr)
				|| StringUtil.isEmptyTrim(datefrmt)
				|| stdDateStr.length() != frmtLen
				|| startDateStr.length() != frmtLen
				|| endDateStr.length() != frmtLen
			) {
			System.out.println("[isStdDateBetween] one of params is empty or params length is different.");
			return false;
		}
		
		try {
			stdDate = sdf.parse(stdDateStr);
			startDate = sdf.parse(startDateStr);
			endDate = sdf.parse(endDateStr);
			System.out.println("stdDate:" + stdDate);
		} catch (ParseException e) {
			System.out.println("[isStdDateBetween] parse error!" + startDateStr + "/" + endDateStr + "/" + datefrmt);
			return false;
		}
		
		return stdDate.compareTo(startDate) >= 0 && stdDate.compareTo(endDate) <= 0;
	}
}
