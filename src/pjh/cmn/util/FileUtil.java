package pjh.cmn.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pjh.cmn.consts.CmnConsts;

public class FileUtil {
	private final static String SHARE_ROOT_PATH = CmnConsts.SHARE_ROOT_PATH;
	private final static String TXT_ROOT_PATH = SHARE_ROOT_PATH.concat(CmnConsts.FILE_DIV.TXT).concat(File.separator);
	private final static String PDF_ROOT_PATH = SHARE_ROOT_PATH.concat(CmnConsts.FILE_DIV.PDF).concat(File.separator);
	private final static String IMG_ROOT_PATH = SHARE_ROOT_PATH.concat(CmnConsts.FILE_DIV.IMG).concat(File.separator);
	private final static String JSON_ROOT_PATH = SHARE_ROOT_PATH.concat(CmnConsts.FILE_DIV.JSON).concat(File.separator);
	private final static String XML_ROOT_PATH = SHARE_ROOT_PATH.concat(CmnConsts.FILE_DIV.XML).concat(File.separator);
	
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
		return pathStr != null ? new File(pathStr).exists() : false;
	}
	
	/**
	 * 파일경로 내 디렉토리 또는 파일명 변경
	 * @param String oldPath 변경 대상 파일경로
	 * @param String oldStr 변경 대상 문자열
	 * @param String newStr 변경할 문자열
	 * @return String 변경된 파일경로
	 */
	public static String renameFilepath(String oldPath, String oldStr, String newStr) {
		String newPath = "";
		if (isPathExists(oldPath)) {
			newPath = oldPath.replace(oldStr, newStr);
			File originFile = new File(oldPath);
			File replaceFile = new File(newPath);
			replaceFile.setExecutable(true, false);
			originFile.renameTo(replaceFile);
		} else {
			System.out.println("[" + oldPath + "file is alreay existed.");
		}
		return newPath;
	}
	
	/**
	 * 파일명과 파일구분(확장자)을 합친 파일절대경로 반환 (파일구분이 정의되지 않았다면 share 루트 반환)
	 * @param String fileName 파일명
	 * @param String fileDiv 파일구분 확장자
	 * @return String
	 */
	public static String getFullFilepath(String fileName, String fileDiv) {
		String fullFilepath = "";
		if (!StringUtil.isEmptyTrim(fileName) &&
			!StringUtil.isEmptyTrim(fileDiv)) {
			if (fileDiv.equals(CmnConsts.FILE_DIV.TXT)) {
				fullFilepath = TXT_ROOT_PATH;
			} else if (fileDiv.equals(CmnConsts.FILE_DIV.JSON)) {
				fullFilepath = JSON_ROOT_PATH;			
			} else if (fileDiv.equals(CmnConsts.FILE_DIV.PDF)) {
				fullFilepath = PDF_ROOT_PATH;			
			} else if (fileDiv.equals(CmnConsts.FILE_DIV.PNG) ||
					fileDiv.equals(CmnConsts.FILE_DIV.JPG)) {
				fullFilepath = IMG_ROOT_PATH;
			} else if (fileDiv.equals(CmnConsts.FILE_DIV.XML)) {
				fullFilepath = XML_ROOT_PATH;			
			} else {
				fullFilepath = SHARE_ROOT_PATH;
			}			
			fullFilepath = fullFilepath.concat(fileName).concat(".").concat(fileDiv);
		}		
		return fullFilepath;
	}
	
	/**
	 * 디렉토리 내 파일 리스트 반환
	 * @param String dirPath 디렉토리 경로
	 * @return List<String> 
	 */
	private static File[] getFileListFromDir(String dirPath) {
		File[] fileList = null;
		if (dirPath != null) {
			fileList = new File(dirPath).listFiles();
		}
		return fileList;
	}
	
	/**
	 * 디렉토리 내 파일명 리스트 반환
	 * @param String dirPath 디렉토리 경로
	 * @return List<String>
	 */
	public static List<String> getFileNameListFromDir(String dirPath) { // TODO: 오버로딩 FILE_DIV param 추가 
		List<String> fileNameList = new ArrayList<>();
		File[] fileList = getFileListFromDir(dirPath);
		if (fileList != null) {
			for (File file : fileList) {
				if (file.isFile()) {
					fileNameList.add(file.getName());
				}
			}
		}		
		return fileNameList;
	}
	
}