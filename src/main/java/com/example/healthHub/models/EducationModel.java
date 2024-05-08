package com.example.healthHub.models;


import jakarta.persistence.*;

@Entity
@Table(name = "TB_Education")
public class EducationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String university;
    private String course;
    private String experience;
    @ManyToOne
    @JoinColumn(name = "fk_professional", referencedColumnName = "id")
    private UserProfessionalModel fk_professional;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public UserProfessionalModel getFk_professional() {
        return fk_professional;
    }

    public void setFk_professional(UserProfessionalModel fk_professional) {
        this.fk_professional = fk_professional;
    }
}
