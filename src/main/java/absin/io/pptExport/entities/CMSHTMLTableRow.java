/**
 * 
 */
package absin.io.pptExport.entities;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Vaibhav
 *
 */
public class CMSHTMLTableRow {
	ArrayList<String> cells = new ArrayList<String>();

	@XmlElement(name = "cell")
	public ArrayList<String> getCells() {
		return cells;
	}

	public void setCells(ArrayList<String> cells) {
		this.cells = cells;
	}
	
	
	
}
