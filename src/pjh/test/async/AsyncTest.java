package pjh.test.async;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 디렉토리 관련 테스트
 */
class AsyncTest {
	long startTime;
	SaladMarket priceFinder;
	
	@BeforeEach
	void init() {
		priceFinder = new SaladMarket();
		startTime = System.nanoTime();
//		System.out.println("시작시간 : " + startTime);		
	}
	
	@Test
	@DisplayName("샐러드 가격 정보 출력")
	void findSaladPrice() {
		for (String priceInfo : priceFinder.findSaladInfo()) {
			System.out.println(priceInfo);
		}
	}
	
	@Test
	@DisplayName("기본 동기 호출")
	void makeSaladSync() {
		System.out.println("[동기 호출] 샐러드 가게 인력난으로 혼자 주문받고, 샐러드를 만들고 있습니다. 샐러드 만들기 시작합니다!");
		priceFinder.makeSaladSequencial();
		
		long endTime = (System.nanoTime() - startTime) / 1_000_000;
        System.out.println("[동기 호출] 완료 시간:  " + endTime + " msecs");		
	}
	
	@Test
	@DisplayName("Future를 활용한 비동기 호출")
	void makeSaladAsyncFuture() {
		System.out.println("[Future 비동기 호출] 샐러드 가게 인력이 충분합니다. 1명이 주문받고, n명이 주문들어오는대로 샐러드를 만들고 있습니다. 샐러드 만들기 시작합니다!");
		priceFinder.makeSaladAsyncFuture();
		
		long endTime = (System.nanoTime() - startTime) / 1_000_000;
        System.out.println("[Future 비동기 호출] 완료 시간:  " + endTime + " msecs");		
	}
	
	@Test
	@DisplayName("CompletableFuture를 활용한 비동기 호출")
	void makeSaladAsyncCompletableFuture() {
		System.out.println("[CompletableFuture 비동기 호출] 샐러드 가게 인력이 충분합니다. 1명이 주문받고, n명이 주문들어오는대로 샐러드를 만들고 있습니다. 샐러드 만들기 시작합니다!");
		priceFinder.makeSaladAsyncCompletableFuture();
		
		long endTime = (System.nanoTime() - startTime) / 1_000_000;
        System.out.println("[CompletableFuture 비동기 호출] 완료 시간:  " + endTime + " msecs");		
	}
}
