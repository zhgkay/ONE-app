package xxx.yc;

import java.util.HashMap;

public class Index {
	
	private String weather;//天气
	private String date;//发布日期
	private String title;//小标题
	private String forward;//内容
	private String img_url;//小标题照片
	private String volume;//,小目录
	private String pic_info;//
	private String words_info;//发言人
	private String share_url;//二级页面链接
	
	

	public Index(String weather, String date, String title, String forward, String img_url, String volume,
			String pic_info, String words_info, String share_url) {
		super();
		this.weather = weather;
		this.date = date;
		this.title = title;
		this.forward = forward;
		this.img_url = img_url;
		this.volume = volume;
		this.pic_info = pic_info;
		this.words_info = words_info;
		this.share_url = share_url;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getPic_info() {
		return pic_info;
	}

	public void setPic_info(String pic_info) {
		this.pic_info = pic_info;
	}

	public String getWords_info() {
		return words_info;
	}

	public void setWords_info(String words_info) {
		this.words_info = words_info;
	}

	public String getShare_url() {
		return share_url;
	}

	public void setShare_url(String share_url) {
		this.share_url = share_url;
	}

	@Override
	public String toString() {
		return "ONE上部 [公布时间=" + date + ",天气=" + weather + ",小标题照片=" + img_url+ ", 小标题="
				+ title + " 丨 " + pic_info+ ", 内容=" + forward + ", 发言人=" + words_info + ", 列表框=" + volume + ",二级页链接="+share_url+"]";
	}

	
	

}
