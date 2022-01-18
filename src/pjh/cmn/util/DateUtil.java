package pjh.cmn.util;

import java.text.SimpleDateFormat;
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
}
