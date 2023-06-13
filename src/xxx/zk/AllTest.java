package xxx.zk;

import java.util.ArrayList;

public class AllTest {
	private ArrayList<AllMiddle> allMiddle;
	private ArrayList<AllBottom> allBottom;
	public AllTest() {
		super();
	}
	public AllTest(ArrayList<AllMiddle> allMiddle, ArrayList<AllBottom> allBottom) {
		super();
		this.allMiddle = allMiddle;
		this.allBottom = allBottom;
	}
	public ArrayList<AllMiddle> getAllMiddle() {
		return allMiddle;
	}
	public void setAllMiddle(ArrayList<AllMiddle> allMiddle) {
		this.allMiddle = allMiddle;
	}
	public ArrayList<AllBottom> getAllBottom() {
		return allBottom;
	}
	public void setAllBottom(ArrayList<AllBottom> allBottom) {
		this.allBottom = allBottom;
	}
	@Override
	public String toString() {
		return "All内容 [上部=" + allMiddle + ", 下部=" + allBottom + "]";
	}
	

}
