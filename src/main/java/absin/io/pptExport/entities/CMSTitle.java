/**
 * 
 */
package absin.io.pptExport.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author Vaibhav
 *
 */
public class CMSTitle {

	private String text;
	private String fragmentAudioUrl;
	private int fragmentDuration;

	public CMSTitle() {
		super();
	}

	public CMSTitle(String text, String fragmentAudioUrl, int fragmentDuration) {
		super();
		this.text = text;
		this.fragmentAudioUrl = fragmentAudioUrl;
		this.fragmentDuration = fragmentDuration;
	}

	public CMSTitle(String text) {
		super();
		this.text = text;
	}

	@XmlValue
	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
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

}
