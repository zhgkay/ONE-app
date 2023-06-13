package xxx.zk;

public class AllMiddle {
	private String cover;
	private String title;

	public AllMiddle() {
		super();
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public AllMiddle(String cover, String title) {
		super();
		this.cover = cover;
		this.title = title;
	}

	@Override
	public String toString() {
		return "All中部 [图片=" + cover + ", 主题=" + title + "]";
	}

}
