/**
 * 
 */
package absin.io.pptExport.entities;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author vaibhaverma
 *
 */
public class CMSList {
	
	String list_type;
	String mergedAudioURL;
	int mergedAudioDuration;
	ArrayList<CMSTextItem> items;

	
	public CMSList() {
		super();
	}

	public CMSList(ArrayList<CMSTextItem> items, String list_type, String mergedAudioURL, int mergedAudioDuration) {
		super();
		this.items = items;
		this.list_type = list_type;
		this.mergedAudioURL = mergedAudioURL;
		this.mergedAudioDuration = mergedAudioDuration;
	}

	public int getMergedAudioDuration() {
		return mergedAudioDuration;
	}

	public void setMergedAudioDuration(int mergedAudioDuration) {
		this.mergedAudioDuration = mergedAudioDuration;
	}

	public ArrayList<CMSTextItem> getItems() {
		return items;
	}

	@XmlElement(name = "li")
	public void setItems(ArrayList<CMSTextItem> items) {
		this.items = items;
	}

	public String getList_type() {
		return list_type;
	}

	@XmlAttribute(name = "list_type")
	public void setList_type(String list_type) {
		this.list_type = list_type;
	}

	@XmlAttribute(name = "merged_audio")
	public String getMergedAudioURL() {
		if (mergedAudioURL == null || mergedAudioURL.isEmpty()) {
			return "none";
		}
		return mergedAudioURL;
	}

	public void setMergedAudioURL(String mergedAudioURL) {
		this.mergedAudioURL = mergedAudioURL;
	}

}