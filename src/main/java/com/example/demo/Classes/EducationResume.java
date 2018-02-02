package com.example.demo.Classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class EducationResume {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String degreetype;

    private String degreesubject;

    private String schoolplace;

    private String degreeyear;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDegreetype() {
        return degreetype;
    }

    public void setDegreetype(String degreetype) {
        this.degreetype = degreetype;
    }

    public String getDegreesubject() {
        return degreesubject;
    }

    public void setDegreesubject(String degreesubject) {
        this.degreesubject = degreesubject;
    }

    public String getSchoolplace() {
        return schoolplace;
    }

    public void setSchoolplace(String schoolplace) {
        this.schoolplace = schoolplace;
    }

    public String getDegreeyear() {
        return degreeyear;
    }

    public void setDegreeyear(String degreeyear) {
        this.degreeyear = degreeyear;
    }
}
