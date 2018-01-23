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
public class CMSHTMLTable {
	ArrayList<CMSHTMLTableRow> rows = new ArrayList<CMSHTMLTableRow>();
	String title;
	
	
	
	
	@XmlAttribute(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "rows")
	public ArrayList<CMSHTMLTableRow> getRows() {
		return rows;
	}

	public void setRows(ArrayList<CMSHTMLTableRow> rows) {
		this.rows = rows;
	}
	
	
	
}