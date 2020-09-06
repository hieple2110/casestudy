package Entity;

public class Students implements Comparable<Students>{
    public String idStudent;
    private String name;
    private String gender;
    private String numberPhone;
    private String mark1;
    private String mark2;
    private String mark3;
    private String mark4;
    private String avgMark;

    public Students() {
    }

    public Students(String id, String name, String gender, String numberPhone, String avgMark) {
        this.idStudent = id;
        this.name = name;
        this.gender = gender;
        this.numberPhone = numberPhone;
        this.avgMark = avgMark;
    }

    public Students(String id, String name, String gender, String numberPhone , String mark1, String mark2, String mark3, String mark4, String avgmark) {
        this.idStudent = id;
        this.name = name;
        this.numberPhone = numberPhone;
        this.gender = gender;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.mark4 = mark4;
        this.avgMark = avgmark;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getMark1() {
        return mark1;
    }

    public void setMark1(String mark1) {
        this.mark1 = mark1;
    }

    public String getMark2() {
        return mark2;
    }

    public void setMark2(String mark2) {
        this.mark2 = mark2;
    }

    public String getMark3() {
        return mark3;
    }

    public void setMark3(String mark3) {
        this.mark3 = mark3;
    }

    public String getMark4() {
        return mark4;
    }

    public void setMark4(String mark4) {
        this.mark4 = mark4;
    }

    public String getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(String avgMark) {
        this.avgMark = avgMark;
    }

    @Override
    public int compareTo(Students o) {
      return o.getAvgMark().compareTo(getAvgMark());
    }
}
