/**
 * 
 */
package absin.io.pptExport.entities;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author vaibhaverma
 *
 */
@XmlRootElement(name = "lesson")
public class CMSLesson {
	String lessonTitle;
	String lessonDescription = "";
	String type;
	ArrayList<CMSSlide> slides;

	String teacherNotes;
	String studentNotes;
	
	
    String audio_url;

	@XmlElement(name = "teacher_notes")
	public String getTeacherNotes() {
		return teacherNotes;
	}

	public void setTeacherNotes(String teacherNotes) {
		this.teacherNotes = teacherNotes;
	}

	@XmlElement(name = "student_notes")

	public String getStudentNotes() {
		return studentNotes;
	}

	public void setStudentNotes(String studentNotes) {
		this.studentNotes = studentNotes;
	}

	public String getLessonTitle() {
		return lessonTitle;
	}

	@XmlAttribute(name = "h1")
	public void setLessonTitle(String lessonTitle) {
		this.lessonTitle = lessonTitle;
	}

	public String getType() {
		return type;
	}

	@XmlAttribute(name = "lesson_type")
	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<CMSSlide> getSlides() {
		return slides;
	}

	@XmlElement(name = "slide")
	public void setSlides(ArrayList<CMSSlide> slides) {
		this.slides = slides;
	}

	public String getLessonDescription() {
		return lessonDescription;
	}

	@XmlAttribute(name = "description")
	public void setLessonDescription(String lessonDescription) {
		this.lessonDescription = lessonDescription;
	}

	public String getAudio_url() {
		return audio_url;
	}
	@XmlElement(name = "audio_url", required = false)
	public void setAudio_url(String audio_url) {
		this.audio_url = audio_url;
	}

	
}
