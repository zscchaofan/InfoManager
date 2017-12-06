package cn.cclookme.info.model.score;

public class StudentScore implements java.io.Serializable{
    private String studentId;

    private Double score;

    private String wirteInTime;

    private String startTime;

    private String endTime;

    private Integer isPass;

    private String courseCode;

    private String classroomTeacher;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getWirteInTime() {
        return wirteInTime;
    }

    public void setWirteInTime(String wirteInTime) {
        this.wirteInTime = wirteInTime == null ? null : wirteInTime.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Integer getIsPass() {
        return isPass;
    }

    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode == null ? null : courseCode.trim();
    }

    public String getClassroomTeacher() {
        return classroomTeacher;
    }

    public void setClassroomTeacher(String classroomTeacher) {
        this.classroomTeacher = classroomTeacher == null ? null : classroomTeacher.trim();
    }
}