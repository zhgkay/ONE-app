package xxx.zk;

public class AllBottom {
	private String weburl;
	private String user_name;
	private String desc;
	
	public AllBottom() {
		super();
	}

	public AllBottom(String weburl, String user_name, String desc) {
		super();
		this.weburl = weburl;
		this.user_name = user_name;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "All底部 [作者照片=" + weburl + ", 作者名=" + user_name + ", 作者新动态=" + desc + "]";
	}
	
	

}
