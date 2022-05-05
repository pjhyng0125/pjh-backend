package pjh.vo;

/**
 * 멤버 case 변환 테스트 VO : CamelCase
 */
public class CamelCase {
	/* 타임스탬프 */
	private String timeStamp;

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "CamelCase [timestamp=" + timeStamp + "]";
	}
}
