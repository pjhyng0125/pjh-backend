package pjh.test.async;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class SaladMarket {

	// Salad List get
	private final List<Salad> saladList = Arrays.asList(
			new Salad("기본", 2000, 1000),
			new Salad("닭가슴살", 4000, 5000),
			new Salad("리코타치즈", 3900, 2000),
			new Salad("오리훈제", 6000, 4000));

	/**
	 * 샐러드 dto 정보 조회
	 * 
	 * @return
	 */
	public List<String> findSaladInfo() {
		return saladList.stream()
				.map(salad -> String.format("%s 샐러드 대기시간은 %d msec", salad.getName(), salad.getWaitTime()))
				.collect(Collectors.toList());
	}

	/**
	 * 샐러드 만들기
	 * 
	 * @param {Salad} 샐러드 dto
	 * @return
	 */
	public Salad makeSalad(Salad salad) {
		String finishYn = "";
		Salad resultSalad = salad;

		// 샐러드 만드는 시간동안 sleep
		int result = delay(salad.getWaitTime());

		if (result == 0) {
			finishYn = "Y";
		} else {
			finishYn = "N";
		}
		
		resultSalad.setFinishYn(finishYn);

		String printStr = String.format("%s 샐러드 만드는 시간 %d msec 소요 되었습니다.", salad.getName(), salad.getWaitTime());
		System.out.println(printStr);
		
		return resultSalad;
	}

	/**
	 * 샐러드 만들기 (기본 동기 호출)
	 * @return
	 */
	public void makeSaladSequencial() {
		saladList.forEach(salad -> {
			makeSalad(salad);			
		});
	}

	/**
	 * 샐러드 만들기 - 비동기 호출 (Future)
	 */
	public void makeSaladAsyncFuture() {
		// 쓰레드 결과 리턴 받기 위한 future
		final List<Future<Salad>> futureList = new ArrayList<>();

		// 샐러드 dto 출력
//		saladList.stream().forEach(salad ->
//			System.out.println(salad.toString())
//		);

		for (final Salad salad : saladList) {
			try {
				// 스레드 풀 생성
				ExecutorService executor = Executors.newFixedThreadPool(1);

				// 스레드 실행 작업 정의
				Callable<Salad> callable = new Callable<>() {

					@Override
					public Salad call() {
						return makeSalad(salad);
					}
				};

//				String printStr = String.format("%s 샐러드 만드는 시간 %d msec 소요될 예정입니다.", salad.getName(),
//						salad.getWaitTime());
//				System.out.println(printStr);

				Future<Salad> future = executor.submit(callable);
				futureList.add(future);
				executor.shutdown();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 샐러드 만들기 완료 체크
		if (futureList.size() > 0) {
			for (Future<Salad> future : futureList) {
				try {
					Salad resultSalad = future.get();
					// 후처리 로직 실행
//					String printStr = String.format("샐러드 완성 정보 입니다. %s", resultSalad.toString());
//					System.out.println(printStr);

				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 샐러드 만들기 (CompletableFuture)
	 */
	public List<Salad> makeSaladAsyncCompletableFuture() {
		List<CompletableFuture<Salad>> completableFutureList = saladList.stream()
				.map(salad -> CompletableFuture.supplyAsync(() -> makeSalad(salad)))
				.collect(Collectors.toList());
		return completableFutureList.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList());
	}

	/**
	 * Salad waitTime 동안 sleep
	 * 
	 * @param waitTime
	 * @return
	 */
	public int delay(int waitTime) {
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
