package cn.cclookme.info.model.user;

import java.io.Serializable;

public class StudentInfo implements Serializable{
    private String studentCardid;

    private String password;

    private String studentName;

    private Integer sexid;

    private String birthday;

    private String nativePlace;

    private String academy;

    private String specialty;

    private String classname;

    private String enrollmentYear;

    private String graduationYear;

    private String dropoutYear;

    private Integer status;

    public String getStudentCardid() {
        return studentCardid;
    }

    public void setStudentCardid(String studentCardid) {
        this.studentCardid = studentCardid == null ? null : studentCardid.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public Integer getSexid() {
        return sexid;
    }

    public void setSexid(Integer sexid) {
        this.sexid = sexid;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy == null ? null : academy.trim();
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(String enrollmentYear) {
        this.enrollmentYear = enrollmentYear == null ? null : enrollmentYear.trim();
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear == null ? null : graduationYear.trim();
    }

    public String getDropoutYear() {
        return dropoutYear;
    }

    public void setDropoutYear(String dropoutYear) {
        this.dropoutYear = dropoutYear == null ? null : dropoutYear.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}