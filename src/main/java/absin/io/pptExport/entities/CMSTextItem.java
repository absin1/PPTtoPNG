/**
 * 
 */
package absin.io.pptExport.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author vaibhaverma
 *
 */
@XmlRootElement(name = "li")
public class CMSTextItem {
	String text;
	int id;
	CMSList list;
	String description;
	String fragmentAudioUrl;
	int fragmentDuration;
	String type = "circle";
	
	public CMSTextItem() {
		super();
	}

	public CMSTextItem(String text) {
		super();
		this.text = text;

	}

	public CMSTextItem(String text, String desc) {
		super();
		this.text = text;
		this.description = desc;
	}

	public CMSTextItem(String text, String desc, String audioUrl, int fragmentDuration) {
		super();
		this.text = text;
		this.description = desc;
		this.fragmentAudioUrl = audioUrl;
		this.fragmentDuration = fragmentDuration;
	}

	public CMSTextItem(String text, int id) {
		super();
		this.text = text;
		this.id = id;
	}

	
	@XmlAttribute(name = "list_type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;

	}

	@XmlElement(name = "p")
	public void setText(String text) {
		this.text = text;
	}

	@XmlElement(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CMSList getList() {
		return list;
	}

	@XmlElement(name = "ul")
	public void setList(CMSList list) {
		this.list = list;
	}

	public String getIndex(int kamini) {
		return (kamini - 1) * 200 + "px";

	}

	public String getIndexLeft(int kamini) {
		if (kamini == 5) {
			return "100px";
		} else {
			return "95px";
		}

	}

	
	@XmlElement(name = "fragment_audio")
	public String getFragmentAudioUrl() {
		if (fragmentAudioUrl == null) {
			return "";
		}
		return fragmentAudioUrl;
	}

	public void setFragmentAudioUrl(String fragmentAudioUrl) {
		this.fragmentAudioUrl = fragmentAudioUrl;
	}

	@XmlElement(name = "fragment_duration")
	public int getfragmentDuration() {
		return fragmentDuration;
	}

	public void setfragmentDuration(int fragmentDuration) {
		this.fragmentDuration = fragmentDuration;
	}

	@XmlElement(name = "description")
	public String getDescription() {
		if (null == description) {
			return "NO_DESC";
		} else {
			return description;
		}
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlTransient
	public String getDescriptionMinified() {
		String desc = "";
		if (null == description) {
			desc = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.";
		} else {
			desc = description;
		}

		return desc.substring(0, 100);

	}

}