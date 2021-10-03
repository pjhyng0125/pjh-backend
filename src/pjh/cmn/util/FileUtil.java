package pjh.cmn.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	/*
	 * 인스턴스화 방지
	 * */
	private FileUtil() throws InstantiationException {
		throw new InstantiationException();
	}
	
	/*
	 * 문자열을 입력받아 파일을 생성한다.
	 * @param str 문자열
	 * @param filePath 파일명을 포함한 파일경로
	 * @return void
	 * 
	 * */
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
	
	/*
	 * 파일경로를 입력받아 문자열을 반환한다.
	 * @param filePath 파일명을 포함한 파일경로
	 * @return String
	 * 
	 * */
	public static String readFileToStr(String filePath) {
		BufferedReader br = null;
		String str = null;
		
		try {
			br = new BufferedReader(new FileReader(filePath));
			String readLine = null;
			while((readLine = br.readLine()) != null) {
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
	 * @param pathStr
	 * @return boolean
	 */
	public static boolean isPathExists(String pathStr) {
		File path = new File(pathStr);
		return path.exists();
	}
}