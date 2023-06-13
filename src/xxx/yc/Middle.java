package xxx.yc;

public class Middle {
	private String tag_list;//标题类型
	private String title;//标题
	private String desc;//作者
	private String img_url;//标题照片
	
	private String music_name;//音乐集名
	private String audio_author;//歌手
	private String audio_album;//音乐名
	
	
	private String forward;//内容
	private String post_date;//影视信息
	private String subtitle;//发布日期
	private String share_url;//二级页面链接
	

	
	public Middle(String tag_list, String title, String desc, String img_url, String music_name, String audio_author,
			String audio_album, String forward, String post_date, String subtitle, String share_url) {
		super();
		this.tag_list = tag_list;
		this.title = title;
		this.desc = desc;
		this.img_url = img_url;
		this.music_name = music_name;
		this.audio_author = audio_author;
		this.audio_album = audio_album;
		this.forward = forward;
		this.post_date = post_date;
		this.subtitle = subtitle;
		this.share_url = share_url;
	}


	public String getTag_list() {
		return tag_list;
	}


	public void setTag_list(String tag_list) {
		this.tag_list = tag_list;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getImg_url() {
		return img_url;
	}


	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}


	public String getMusic_name() {
		return music_name;
	}


	public void setMusic_name(String music_name) {
		this.music_name = music_name;
	}


	public String getAudio_author() {
		return audio_author;
	}


	public void setAudio_author(String audio_author) {
		this.audio_author = audio_author;
	}


	public String getAudio_album() {
		return audio_album;
	}


	public void setAudio_album(String audio_album) {
		this.audio_album = audio_album;
	}


	public String getForward() {
		return forward;
	}


	public void setForward(String forward) {
		this.forward = forward;
	}


	public String getPost_date() {
		return post_date;
	}


	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}


	public String getSubtitle() {
		return subtitle;
	}


	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

    public String getShare_url() {
		return share_url;
	}


	public void setShare_url(String share_url) {
		this.share_url = share_url;
	}

	
	@Override
	public String toString() {
		return "ONE中部 [标题类型=" + tag_list + ", 标题=" + title + ", 作者=" + desc + ", 标题照片=" + img_url
				+ ", 音乐集=" + music_name +" · "+  audio_author +" 丨 "+  audio_album+ ", 内容=" + forward 
				+ ", 影视信息="  +"——《"+ post_date +"》"+ ", 发布日期=" + subtitle +", 二级链接="+ share_url + "]";
	
	}


}

	
