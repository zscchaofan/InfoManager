package cn.cclookme.info.model.user;

public class TeacherInfo implements java.io.Serializable {
    private String teacherCardid;

    private String name;

    private Integer sexid;

    private String password;

    private String academy;

    private String birthday;

    private String nativePlace;

    private String entryYear;

    private String leavingYear;

    private Integer status;

    public String getTeacherCardid() {
        return teacherCardid;
    }

    public void setTeacherCardid(String teacherCardid) {
        this.teacherCardid = teacherCardid == null ? null : teacherCardid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSexid() {
        return sexid;
    }

    public void setSexid(Integer sexid) {
        this.sexid = sexid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy == null ? null : academy.trim();
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

    public String getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(String entryYear) {
        this.entryYear = entryYear == null ? null : entryYear.trim();
    }

    public String getLeavingYear() {
        return leavingYear;
    }

    public void setLeavingYear(String leavingYear) {
        this.leavingYear = leavingYear == null ? null : leavingYear.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}