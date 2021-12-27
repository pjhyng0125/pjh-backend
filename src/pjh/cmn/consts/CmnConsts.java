package pjh.cmn.consts;

/**
 * 공통 상수
 */
public class CmnConsts {	
	/* 파일 생성 공유 디렉토리 루트 경로 */
	public static final String SHARE_ROOT_PATH = "C:\\pjh\\works\\eclipse\\pjh-backend\\share\\";
	
	/* TEXT 디렉토리, 파일구분 */
	public static String EMPTY = "";
	
	/* 기본 문자 인코딩 */
	public static String DEFAULT_CHARSET = "UTF-8";
	
	/** 파일 구분 */
	public static class FILE_DIV {
		/* TEXT 디렉토리, 파일구분 */
		public static String TXT = "txt";
		
		/* JSON 디렉토리, 파일구분 */
		public static String JSON = "json";
		
		/* PDF 디렉토리, 파일구분 */
		public static String PDF = "pdf";
		
		/* IMG 디렉토리 */
		public static String IMG = "img";
		
		/* PNG 파일구분 */
		public static String PNG = "png";
		
		/* JPG 파일구분 */
		public static String JPG = "jpg";
		
		/* XML 디렉토리 */
		public static String XML = "xml";
	}
	
	/* 금액 자르기 단위 */
	public static class AM_CUT_UNIT {
		/* 십만원 */
		public static int HUNDRED_THOUSAND = 5;
		
		/* 만원 */
		public static int TEN_THOUSAND = 4;
		
		/* 천원 */
		public static int THOUSAND = 3;
		
		/* 십원 */
		public static int TEN = 2;
		
		/* 십원 */
		public static int ONE = 1;
	}
	
	/* 객체 타입 구분 */
	public static class TYPE_DIV {
		/* 숫자 */
		public static String INTEGER = "Integer";
		
		/* 문자열 */
		public static String STRING = "String";
		
		/* Boolean */
		public static String BOOLEAN = "Boolean";
	}
}
