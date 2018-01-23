package absin.io.pptExport.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author vaibhaverma
 *
 */
public class CMSImage {
	String url;
	String description;
	String title;
	String fragmentAudioUrl;
	int fragmentDuration;
	
	public CMSImage() {
		super();
	}

	public CMSImage(String url, String description, String title) {
		super();
		this.url = url;
		this.description = description;
		this.title = title;
	}

	public CMSImage(String url, String description, String title, String fragmentAudioUrl, int fragmentDuration) {
		super();
		this.url = url;
		this.description = description;
		this.title = title;
		this.fragmentAudioUrl = fragmentAudioUrl;
		this.fragmentDuration = fragmentDuration;
	}

	public String getFragmentAudioUrl() {
		return fragmentAudioUrl;
	}

	@XmlAttribute(name = "fragment_audio")
	public void setFragmentAudioUrl(String fragmentAudioUrl) {
		this.fragmentAudioUrl = fragmentAudioUrl;
	}

	public int getFragmentDuration() {
		return fragmentDuration;
	}

	@XmlAttribute(name = "fragment_duration")
	public void setFragmentDuration(int fragmentDuration) {
		this.fragmentDuration = fragmentDuration;
	}

	public String getUrl() {
		return url;
	}

	@XmlAttribute(name = "url")
	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement(name = "description")
	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	@XmlAttribute(name = "title")
	public void setTitle(String title) {
		this.title = title;
	}

}