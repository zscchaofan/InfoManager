package cn.cclookme.info.model.schedule;

public class BasicsCourseScheduleExcel implements java.io.Serializable{

    private String courseCode;

    private String specialty;

    private String courseStartTime;

    private String courseEndTime;

    private String courseTeacher;

    private String examinationTime;

    private String schooltime;

    private String yearin;
    
    
    public String getYearin() {
		return yearin;
	}

	public void setYearin(String yearin) {
		this.yearin = yearin;
	}

	public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode == null ? null : courseCode.trim();
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public String getCourseStartTime() {
        return courseStartTime;
    }

    public void setCourseStartTime(String courseStartTime) {
        this.courseStartTime = courseStartTime == null ? null : courseStartTime.trim();
    }

    public String getCourseEndTime() {
        return courseEndTime;
    }

    public void setCourseEndTime(String courseEndTime) {
        this.courseEndTime = courseEndTime == null ? null : courseEndTime.trim();
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher == null ? null : courseTeacher.trim();
    }

    public String getExaminationTime() {
        return examinationTime;
    }

    public void setExaminationTime(String examinationTime) {
        this.examinationTime = examinationTime == null ? null : examinationTime.trim();
    }

    public String getSchooltime() {
        return schooltime;
    }

    public void setSchooltime(String schooltime) {
        this.schooltime = schooltime == null ? null : schooltime.trim();
    }

}
