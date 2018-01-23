/**
 * 
 */
package absin.io.pptExport.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author Vaibhav
 *
 */
@XmlRootElement (name="h2")
public class CMSTitle2 {
	String text;
	String fragmentAudioUrl;
	int fragmentDuration;
	
	
	
	
	public CMSTitle2(String text, String fragmentAudioUrl, int fragmentDuration) {
		super();
		this.text = text;
		this.fragmentAudioUrl = fragmentAudioUrl;
		this.fragmentDuration = fragmentDuration;
	}


	


	public CMSTitle2(String text) {
		super();
		this.text = text;
	}


	public CMSTitle2() {
		super();
	}
	
	
	@XmlValue
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	@XmlAttribute(name="fragment_audio")
	public String getFragmentAudioUrl() {
		return fragmentAudioUrl;
	}
	public void setFragmentAudioUrl(String fragmentAudioUrl) {
		this.fragmentAudioUrl = fragmentAudioUrl;
	}
	
	
	@XmlAttribute(name="fragment_duration")
	public int getFragmentDuration() {
		return fragmentDuration;
	}
	public void setFragmentDuration(int fragmentDuration) {
		this.fragmentDuration = fragmentDuration;
	}
}
