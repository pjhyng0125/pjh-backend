package pjh.cmn.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import pjh.cmn.consts.CmnConsts;

public class FileUtil {
	/**
	 * 인스턴스화 방지
	 */
	private FileUtil() throws InstantiationException {
		throw new InstantiationException();
	}
	
	/**
	 * 문자열을 입력받아 파일을 생성한다.
	 * @param String str 문자열
	 * @param String filePath 파일명을 포함한 파일경로
	 * @return void
	 * 
	 */
	public static void writeStrToFile(String str, String filePath) {
		BufferedWriter bw = null;		
		try {
			bw = new BufferedWriter(new FileWriter(filePath, false));
			bw.write(str);
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 파일경로를 입력받아 문자열을 반환한다.
	 * @param
	 * @param String filePath 파일명을 포함한 파일경로
	 * @return String
	 * 
	 */
	public static String readFileToStr(String filePath) {
		BufferedReader br = null;
		String str = null;
		
		try {
			br = new BufferedReader(new FileReader(filePath));
			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				str = readLine; 
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return str;
	}
	
	/**
	 * 파일 또는 디렉토리가 존재하는지 확인
	 * @param String pathStr 파일 또는 디렉토리 경로
	 * @return boolean
	 */
	public static boolean isPathExists(String pathStr) {
		File path = new File(pathStr);
		return path.exists();
	}
	
	/**
	 * 파일경로 내 디렉토리 또는 파일명 변경
	 * @param String oldPath 변경 대상 파일경로
	 * @param String oldStr 변경 대상 문자열
	 * @param String newStr 변경할 문자열
	 * @return String 변경된 파일경로
	 */
	public static String renameFilePath(String oldPath, String oldStr, String newStr) {
		String newPath = "";
		if (isPathExists(oldPath)) {
			newPath = oldPath.replace(oldStr, newStr);
			File originFile = new File(oldPath);
			File replaceFile = new File(newPath);
			replaceFile.setExecutable(true, false);
			originFile.renameTo(replaceFile);
		}
		return newPath;
	}
	
	/**
	 * 파일경로에서 파일 구분값 포함여부에 따라 파일 확장자 추가 문자열 반환
	 * @param String filePath 파일경로 
	 * @return String
	 */
	public static String getFileDivPath(String filePath) {
		String fileDiv = "";
		String fileDivPath = filePath;
		if (!filePath.isEmpty()) {
			if (filePath.contains(CmnConsts.TXT_FILE_DIV)) {
				fileDiv = CmnConsts.TXT_FILE_DIV;
			} else if (filePath.contains(CmnConsts.JSON_FILE_DIV)) {
				fileDiv = CmnConsts.JSON_FILE_DIV;
			} else if (filePath.contains(CmnConsts.PDF_FILE_DIV)) {
				fileDiv = CmnConsts.PDF_FILE_DIV;
			}
		}
		if (!fileDiv.equals("")) {
			fileDivPath = fileDivPath.concat(".").concat(fileDiv);				
		}
		return fileDivPath;
	}
	
	/**
	 * 파일 구분값에 따라 파일 확장자 추가 문자열 반환
	 * @param String filePath 파일경로 
	 * @param String fileDiv 파일 구분 문자열
	 * @return String
	 */
	public static String getFileDivPath(String filePath, String fileDiv) {
		return filePath.concat(".").concat(fileDiv);
	}
	
}