package pjh.test.async;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BatchAsyncTest extends Thread {

	public static void main(String[] args) {

		BatchAsyncTest test = new BatchAsyncTest();
		test.run();
	}

	@Override
	public void run() {

		super.run();

		int i = 1;

		while (true) {
			try {
				long startTime = System.currentTimeMillis();

				System.out.println("★★★★★★★★★★★★★★★★★[" + i + "] 메인 프로세스 시작 ★★★★★★★★★★★★★★★★★★");

				batchProcess(i);

				System.out.println("★★★★★★★★★★★★★★★★★[" + i + "] 메인 프로세스 종료 (소요시간 = "
						+ (System.currentTimeMillis() - startTime) + "msec )★★★★★★★★★★★★★★★★★★\n\n");

				Thread.sleep(3000);

				i++;

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}
	}

	public void batchProcess(final int repeatCnt) {

		// 쓰레드 결과 리턴 받기 위한 future
		final List<Future<Map<String, Object>>> futureList = new ArrayList<Future<Map<String, Object>>>();

		// DB로 부터 가져온 첨부서류 리스트
		List<String> jobList = new ArrayList<String>();
		jobList.add("DA001");
		jobList.add("DB001");
		jobList.add("DB034");
		jobList.add("DC094");
		jobList.add("DH001");

		for (final String docuCd : jobList) {

			try {
				
				// 쓰레드풀
				ExecutorService executor = Executors.newFixedThreadPool(1);

				// DMS 일괄전송
				Callable<Map<String, Object>> callable = new Callable<Map<String, Object>>() {

					@Override
					public Map<String, Object> call() {

						Map<String, Object> map = new HashMap<String, Object>();

						map.put("청약서류", docuCd);

						// DMS 전송하는 부분만 별도 쓰레드로 분리 (이 부분이 현재 2초가 소요됨)
						int result = sendDms(docuCd);

						map.put("DMS리턴코드", "수신대기");

						if (result == 0) {
							map.put("DMS리턴코드", "정상");
						}

						return map;
					}
				};

				System.out.println("[" + repeatCnt + "] DMS 일괄 전송 by executor......................." + docuCd);

				Future<Map<String, Object>> future = executor.submit(callable);
				futureList.add(future);
				executor.shutdown();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// DMS전송결과 가져오기
		if (futureList.size() > 0) {

			for (Future<Map<String, Object>> future : futureList) {

				try {

					Map<String, Object> resultMap = future.get();

					System.out.println("[" + repeatCnt + "] DMS 전송결과 수신 from future : " + resultMap.toString());

				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}

		// 전송결과 테이블 업데이트
		for (final String docuCd : jobList) {
			System.out.println("[" + repeatCnt + "] 청약서류 UPDATE PLANSTATUS................... " + docuCd);
		}
	}

	public int sendDms(String docuCd) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}