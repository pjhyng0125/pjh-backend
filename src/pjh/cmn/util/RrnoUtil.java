package pjh.cmn.util;

import java.util.HashMap;
import java.util.Map;

import pjh.cmn.consts.CmnConsts;

/**
 * 주민등록번호 Util
 */
public class RrnoUtil {
	private final static String KEY_BIRTH = "birth"; 		// 생년월일
	private final static String KEY_FRNR_C = "frnrC";		// 내외국인 코드
	private final static String KEY_GENDER_C = "genderC"; 	// 성별 코드
	private final static String NTNLY_KRN = "1"; 			// 내국인 (한국국적)
	private final static String NTNLY_FRNR = "2"; 			// 외국인 (외국국적)
	private final static String GENDER_MAN = "1"; 			// 남자
	private final static String GENDER_FMLE = "2"; 			// 여자
	private final static String YY_2000 = "20"; 			// 2000 년대생
	private final static String YY_1900 = "19"; 			// 1900 년대생
	private final static String YY_1800 = "18"; 			// 1800 년대생
	
	/**
	 * 인스턴스화 방지
	 */
	private RrnoUtil() throws InstantiationException {
		throw new InstantiationException();
	}
	
	/**
	 * 주민등록번호 구분 정보 반환
	 * @param String 생년월일(YYYYMMDD)
	 * @param String 내외국인 코드
	 * @param String 성별 코드
	 * @return String 주민등록번호 구분 정보
	 */
	public static String getRrnoDvCFromPsnlInfo(String birth, String frnrDv, String genderC) {
		String rrnoDvC = "";
		if (!StringUtil.isEmptyTrim(birth) &&
			!StringUtil.isEmptyTrim(frnrDv) &&
			!StringUtil.isEmptyTrim(genderC) &&
			birth.length() > 1) {
			String birthYY = birth.substring(0, 2);
			switch(birthYY) {
			case YY_2000:
				if (frnrDv.equals(NTNLY_KRN)) {
					if (genderC.equals(GENDER_MAN)) {
						rrnoDvC = "3";
					} else if (genderC.equals(GENDER_FMLE)) {
						rrnoDvC = "4";						
					}
				} else if (frnrDv.equals(NTNLY_FRNR)) {
					if (genderC.equals(GENDER_MAN)) {
						rrnoDvC = "7";
					} else if (genderC.equals(GENDER_FMLE)) {
						rrnoDvC = "8";						
					}
				}
				break;
			case YY_1900:
				if (frnrDv.equals(NTNLY_KRN)) {
					if (genderC.equals(GENDER_MAN)) {
						rrnoDvC = "1";
					} else if (genderC.equals(GENDER_FMLE)) {
						rrnoDvC = "2";						
					}
				} else if (frnrDv.equals(NTNLY_FRNR)) {
					if (genderC.equals(GENDER_MAN)) {
						rrnoDvC = "5";
					} else if (genderC.equals(GENDER_FMLE)) {
						rrnoDvC = "6";						
					}
				}
				break;
			case YY_1800:
				if (frnrDv.equals(NTNLY_KRN)) {
					if (genderC.equals(GENDER_MAN)) {
						rrnoDvC = "9";
					} else if (genderC.equals(GENDER_FMLE)) {
						rrnoDvC = "0";						
					}
				}
				break;
			}
		}
		
		return rrnoDvC;
	}
	
	/**
	 * 주민등록번호 관련 개인정보 반환
	 * @param String 주민등록번호
	 * @return Map<String, String> 생년월일 (YYYYMMDD), 내외국인구분
	 */
	public static Map<String, String> getRrnoPsnlInfo(String rrno) {
		Map<String, String> rrnoDvInfo = new HashMap<>();
		if (!StringUtil.isEmptyTrim(rrno)) {
			rrno = rrno.replace("-", "");
			String rrnoDvC = getRrnoDvC(rrno);
			String frontRrno = getFrontRrno(rrno);
			rrnoDvInfo.put(KEY_GENDER_C, getGenderC(rrnoDvC));
			switch (rrnoDvC) {
				case "1":
				case "2":
					// 1900년대생/남,녀/내국인
					rrnoDvInfo.put(KEY_BIRTH, YY_1900.concat(frontRrno));
					rrnoDvInfo.put(KEY_FRNR_C, NTNLY_KRN);
					break;
				case "3":
				case "4":
					// 2000년대생/남,녀/내국인
					rrnoDvInfo.put(KEY_BIRTH, YY_2000.concat(frontRrno));
					rrnoDvInfo.put(KEY_FRNR_C, NTNLY_KRN);
					break;
				case "5":
				case "6":
					// 1900년대생/남,녀/외국인
					rrnoDvInfo.put(KEY_BIRTH, YY_1900.concat(frontRrno));
					rrnoDvInfo.put(KEY_FRNR_C, NTNLY_FRNR);
					break;
				case "7":
				case "8":
					// 2000년대생/남,녀/외국인
					rrnoDvInfo.put(KEY_BIRTH, YY_2000.concat(frontRrno));
					rrnoDvInfo.put(KEY_FRNR_C, NTNLY_FRNR);
					break;
				case "9":
				case "0":
					// 1800년대생/남,녀/내국인
					rrnoDvInfo.put(KEY_BIRTH, YY_1800.concat(frontRrno));
					rrnoDvInfo.put(KEY_FRNR_C, NTNLY_KRN);
					break;
				default:
					rrnoDvInfo.put(KEY_BIRTH, CmnConsts.EMPTY);
					rrnoDvInfo.put(KEY_FRNR_C, CmnConsts.EMPTY);
					break;
					
			}
		} else {
			rrnoDvInfo.put(KEY_BIRTH, CmnConsts.EMPTY);
			rrnoDvInfo.put(KEY_FRNR_C, CmnConsts.EMPTY);
			rrnoDvInfo.put(KEY_GENDER_C, CmnConsts.EMPTY);			
		}		
		return rrnoDvInfo;
	}
	
	/**
	 * 주민등록번호 구분 코드 반환
	 * @param String 주민등록번호
	 * @return String 주민등록번호 구분 코드
	 * @example "9401018010101" -> "8"
	 */
	private static String getRrnoDvC(String rrno) {
		String rrnoDvC = CmnConsts.EMPTY;
		if (!StringUtil.isEmptyTrim(rrno) && rrno.length() > 7) {
			rrnoDvC = rrno.substring(6, 7);
		}
		return rrnoDvC;
	}
	
	/**
	 * 주민등록번호 구분 코드 반환
	 * @param String 주민등록번호 구분 코드
	 * @return String 성별코드
	 * @example "1" -> "1" / "2" -> "2" / "5" -> "1"
	 */
	private static String getGenderC(String rrnoDvC) {
		String genderC = CmnConsts.EMPTY;
		if (!StringUtil.isEmptyTrim(rrnoDvC)) {
			int rrnoDvFlag = (Integer.parseInt(rrnoDvC) % 2);
			if (rrnoDvFlag > 0) {
				genderC = GENDER_MAN;
			} else if (rrnoDvFlag == 0) {
				genderC = GENDER_FMLE;				
			}
		}
		return genderC;
	}
	
	/**
	 * 주민등록번호 앞 6자리 반환
	 * @param String 주민등록번호
	 * @return String 주민등록번호 앞 6자리
	 * @example "9401018010101" -> "940101"
	 */
	private static String getFrontRrno(String rrno) {
		String frontRrno = CmnConsts.EMPTY;
		if (!StringUtil.isEmptyTrim(rrno) && rrno.length() > 6) {
			frontRrno = rrno.substring(0, 6);
		}
		return frontRrno;
	}
}
