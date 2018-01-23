package absin.io.pptExport.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author vaibhaverma
 *
 */
public class CMSVideo {
	String url;
	String description;
	String title;

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