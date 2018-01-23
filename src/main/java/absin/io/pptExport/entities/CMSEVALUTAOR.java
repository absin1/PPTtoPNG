/**
 * 
 */
package absin.io.pptExport.entities;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author ISTAR-SERVER-PU-1
 *
 */
public class CMSEVALUTAOR {
	String key;
	String value;
	
	public CMSEVALUTAOR() {
		super();
	}
	public CMSEVALUTAOR(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}	
	
	@XmlElement(name = "key")
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	@XmlElement(name = "value")
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
