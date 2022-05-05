package pjh.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * 멤버 case 변환 테스트 VO : snake_case
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SnakeCase {
	/* 타임스탬프 */
	@JsonProperty("time_stamp")
//	private String timeStamp;
	private String time_stamp;

//	public String getTimeStamp() {
//		return timeStamp;
//	}
//
//	public void setTimeStamp(String timeStamp) {
//		this.timeStamp = timeStamp;
//	}

	public String getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}

	@Override
	public String toString() {
		return "Snake_Case [time_stamp=" + time_stamp + "]";
	}
}
