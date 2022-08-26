package pjh.test.util.rondom;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 임의의 문자 + 숫자 문자열 생성
 */
class RandomStrTest {
	int randomStrLen = 0;
	
	@BeforeEach
	void initRandomStrLen() {
		// 랜덤 문자열 길이 설정
		randomStrLen = 20;
	}
	
	@Test
	@DisplayName("Random.nextBoolean 을 활용한 랜덤 문자열 생성")
	void createRandomStrUsingRandomBoolean() {
		Random random = new Random();
		StringBuffer randomBuf = new StringBuffer();
		for (int i = 0; i < randomStrLen; i++) {
			// Random.nextBoolean() : 랜던으로 true, false 리턴 (true : 랜덤 소문자 영어, false : 랜덤 숫자)
			if (random.nextBoolean()) {
				// 26 : A-Z 알파벳 개수
				// 97 : letter 'a' 아스키코드
				// (int)(random.nextInt(26)) + 97 : 랜덤 소문자 아스키코드
				randomBuf.append((char)((int)(random.nextInt(26)) + 97));
			} else {
				randomBuf.append(random.nextInt(10));
			}
		}
		String randomStr = randomBuf.toString();
		System.out.println("[createRandomStrUsingRandomBoolean] randomStr : " + randomStr);
		
		assertEquals(getStrLen(randomStr), randomStrLen);
	}
	
	@Test
	@DisplayName("RandomStringUtils.random 을 활용한 랜덤 문자열 생성")
	void createRandomStrUsingUtilsRand() {
		boolean useLetters = true;
		boolean useNumbers = true;
		String randomStr = RandomStringUtils.random(randomStrLen, useLetters, useNumbers);
		
		System.out.println("[createRandomStrUsingUtilsRand] randomStr : " + randomStr);
		
		assertEquals(getStrLen(randomStr), randomStrLen);
	}
	
	@Test
	@DisplayName("RandomStringUtils.randomAlphanumeric 을 활용한 랜덤 문자열 생성")
	void createRandomStrUsingUtilsRandomAlphanumeric() {
		String randomStr = RandomStringUtils.randomAlphanumeric(randomStrLen);
		
		System.out.println("[createRandomStrUsingUtilsRandomAlphanumeric] randomStr : " + randomStr);
		
		assertEquals(getStrLen(randomStr), randomStrLen);
	}
	
	/*
	 * 문자열 개수 반환
	 */
	private int getStrLen(String str) {
		return str != null ? str.length() : 0;		
	}
}
