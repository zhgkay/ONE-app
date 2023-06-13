package xxx.yc;

import java.util.ArrayList;

public class Model {
	private Index index;
	private Middle middle;
	
	public Model(Index index, Middle middle) {
		super();
		this.index = index;
		this.middle = middle;
	}
	

	public Model() {
		super();
	}


	public Index getIndex() {
		return index;
	}


	public void setIndex(Index index) {
		this.index = index;
	}


	public Middle getMiddle() {
		return middle;
	}


	public void setMiddle(Middle middle) {
		this.middle = middle;
	}


	@Override
	public String toString() {
		return "Model [index=" + index + ", middle=" + middle + "]";
	}
	

	

}
