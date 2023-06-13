package xxx.yc;

public class Middle {
	private String tag_list;//��������
	private String title;//����
	private String desc;//����
	private String img_url;//������Ƭ
	
	private String music_name;//���ּ���
	private String audio_author;//����
	private String audio_album;//������
	
	
	private String forward;//����
	private String post_date;//Ӱ����Ϣ
	private String subtitle;//��������
	private String share_url;//����ҳ������
	

	
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
		return "ONE�в� [��������=" + tag_list + ", ����=" + title + ", ����=" + desc + ", ������Ƭ=" + img_url
				+ ", ���ּ�=" + music_name +" �� "+  audio_author +" ح "+  audio_album+ ", ����=" + forward 
				+ ", Ӱ����Ϣ="  +"������"+ post_date +"��"+ ", ��������=" + subtitle +", ��������="+ share_url + "]";
	
	}


}

	
