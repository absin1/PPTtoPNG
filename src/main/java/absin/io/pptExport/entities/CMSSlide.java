package absin.io.pptExport.entities;


import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamResult;


/**
 * @author vaibhaverma
 *
 *///
@XmlRootElement(name = "slide")
public class CMSSlide {
	int Id;
	int order_id;
	String image_BG;
	String transition = "zoom";
	CMSTitle title;
	CMSTitle2 title2;
	CMSParagraph paragraph;
	List<CMSHTMLTable> tables = new ArrayList<CMSHTMLTable>();
	CMSList list;
	CMSImage image;
	CMSVideo video;
	String background = "null";
	String backgroundTransition = "zoom";
	String position;
	String templateName;
	String teacherNotes;
	String studentNotes;
	String audioUrl;
	int slideDuration;
	Integer fragmentCount;
	String slide_type="INFORMATION_ONLY";
	String evaluatorType;
	List<CMSEVALUTAOR> evaluators = new ArrayList<CMSEVALUTAOR>();

	public CMSSlide() {
		ArrayList<CMSTextItem> items = new ArrayList<CMSTextItem>();
		items.add(new CMSTextItem("", ""));
		items.add(new CMSTextItem("", ""));
		items.add(new CMSTextItem("", ""));
		items.add(new CMSTextItem("", ""));
		items.add(new CMSTextItem("", ""));
		list = new CMSList();
		list.setItems(items);

		title = new CMSTitle();
		title2 = new CMSTitle2();
		paragraph = new CMSParagraph();
	}

	public CMSSlide(String[] options) {
		ArrayList<CMSTextItem> items = new ArrayList<CMSTextItem>();
		for (String option : options) {
			try {
				if (option.startsWith("#####")) {
					items.add(new CMSTextItem(option.replace("#####", ""), 1));
				} else {
					items.add(new CMSTextItem(option, 0));
				}
			} catch (Exception e) {
				items.add(new CMSTextItem(option, 0));
			}
		}

		items.add(new CMSTextItem("", ""));
		items.add(new CMSTextItem("", ""));
		list = new CMSList();
		list.setItems(items);
	}

	


	
	@XmlAttribute
	public String getSlide_type() {
		return slide_type;
	}

	public void setSlide_type(String slide_type) {
		this.slide_type = slide_type;
	}

	@XmlElement(name = "id")
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	@XmlElement(name = "order_id")
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	@XmlElement(name = "slide_audio")
	public String getAudioUrl() {
		if (audioUrl == null || audioUrl.isEmpty()) {
			return "none";
		}
		return audioUrl;
	}

	public void setAudioUrl(String audio_url) {
		this.audioUrl = audio_url;
	}

	@XmlElement(name = "duration")
	public int getSlideDuration() {
		if(slideDuration == 0) {
			return 5000;
		}
		return slideDuration;
	}

	public void setSlideDuration(int slide_duration) {
		this.slideDuration = slide_duration;
	}

	@XmlElement(name = "student_notes")
	public String getStudentNotes() {
		if (studentNotes == null || studentNotes.trim().equalsIgnoreCase("")) {
			return "Not Available";
		}
		return studentNotes;
	}

	public void setStudentNotes(String studentNotes) {
		this.studentNotes = studentNotes;
	}

	@XmlElement(name = "teacher_notes")
	public String getTeacherNotes() {
		if (teacherNotes == null || teacherNotes.trim().equalsIgnoreCase("")) {
			return "Not Available";
		}
		return teacherNotes;
	}

	public void setTeacherNotes(String teacherNotes) {
		this.teacherNotes = teacherNotes;
	}

	public String getTemplateName() {
		return templateName;
	}

	@XmlAttribute(name = "template")
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public CMSTitle getTitle() {
		return title;
	}

	@XmlElement(name = "h1")
	public void setTitle(CMSTitle title) {
		this.title = title;
	}

	public CMSParagraph getParagraph() {
		return paragraph;
	}

	@XmlElement(name = "p")
	public void setParagraph(CMSParagraph paragraph) {
		this.paragraph = paragraph;
	}

	public List<CMSHTMLTable> getTables() {
		return tables;
	}

	@XmlElement(name = "tables")
	public void setTables(List<CMSHTMLTable> tables) {
		this.tables = tables;
	}

	public CMSList getList() {
		return list;
	}

	@XmlElement(name = "ul")
	public void setList(CMSList list) {
		this.list = list;
	}

	public CMSImage getImage() {
		if (image == null) {
			CMSImage img = new CMSImage();
			img.setUrl("/content/media_upload?getfile=ToDo.png");
			img.setTitle("To Do");
			img.setDescription("Place filler Image");
			return img;
		} else {
			return image;
		}
	}

	@XmlElement(name = "img")
	public void setImage(CMSImage image) {
		this.image = image;
	}

	public CMSVideo getVideo() {
		return video;
	}

	@XmlElement(name = "video")
	public void setVideo(CMSVideo video) {
		this.video = video;
	}

	@XmlAttribute(name = "position")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@XmlAttribute(name = "transition")
	public String getTransition() {
		return transition.toLowerCase();
	}

	public void setTransition(String transition) {
		this.transition = transition;
	}

	@XmlAttribute(name = "background")
	public String getBackground() {
		return background.toLowerCase();
	}

	public void setBackground(String background) {
		this.background = background.toLowerCase();
	}

	@XmlAttribute(name = "background_transition")
	public String getBackgroundTransition() {
		return backgroundTransition.toLowerCase();
	}

	public void setBackgroundTransition(String backgroundTransition) {
		this.backgroundTransition = backgroundTransition.toLowerCase();
	}
	
	public String toString() {
		StringWriter out = new StringWriter();
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(CMSSlide.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(this, new StreamResult(out));
			return out.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
			return "";
		}
	}

	@XmlAttribute(name = "image_bg")
	public String getImage_BG() {
		return image_BG;
	}

	public void setImage_BG(String image_BG) {
		this.image_BG = image_BG;
	}

	@XmlElement(name = "h2")
	public CMSTitle2 getTitle2() {
		return title2;
	}

	public void setTitle2(CMSTitle2 title2) {
		this.title2 = title2;
	}
	
	@XmlAttribute(name = "fragmentCount")
	public Integer getFragmentCount() {
		return fragmentCount;
	}

	public void setFragmentCount(Integer fragmentCount) {
		this.fragmentCount = fragmentCount;
	}

	@XmlElement(name = "evaluatorType")
	public String getEvaluatorType() {
		return evaluatorType;
	}

	public void setEvaluatorType(String evaluatorType) {
		this.evaluatorType = evaluatorType;
	}

	@XmlElement(name = "evaluators")
	public List<CMSEVALUTAOR> getEvaluators() {
		return evaluators;
	}

	public void setEvaluators(List<CMSEVALUTAOR> evaluators) {
		this.evaluators = evaluators;
	}

}