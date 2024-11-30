package model;


import java.io.Serializable;

public class Alumno implements Serializable {
    private double rating;
    private int age;
    private String name;
    private String gender;
    private String email;
    private String phone;
    private double calification;
    private String higherGrade;
    private boolean FCTs;

    public Alumno() {
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getCalification() {
        return calification;
    }

    public void setCalification(double calification) {
        this.calification = calification;
    }

    public String getHigherGrade() {
        return higherGrade;
    }

    public void setHigherGrade(String higherGrade) {
        this.higherGrade = higherGrade;
    }

    public boolean isFCTs() {
        return FCTs;
    }

    public void setFCTs(boolean FCTs) {
        this.FCTs = FCTs;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "rating=" + rating +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", calification=" + calification +
                ", higherGrade='" + higherGrade + '\'' +
                ", FCTs=" + FCTs +
                '}';
    }
}
