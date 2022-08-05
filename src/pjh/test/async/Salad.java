package pjh.test.async;

public class Salad {
	private String name;
	private int waitTime;
	private String finishYn;	
	
	public Salad(String name, int waitTime) {
		super();
		this.name = name;
		this.waitTime = waitTime;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWaitTime() {
		return waitTime;
	}
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	public String getFinishYn() {
		return finishYn;
	}
	public void setFinishYn(String finishYn) {
		this.finishYn = finishYn;
	}
	@Override
	public String toString() {
		return "Salad [name=" + name + ", waitTime=" + waitTime + ", finishYn=" + finishYn + "]";
	}	
}
