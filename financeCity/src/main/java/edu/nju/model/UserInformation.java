package edu.nju.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by dell on 2016/8/12.
 */
@Entity
@Table(name = "user_information", schema = "citi", catalog = "")
public class UserInformation {
    private int id;
    private byte marriageStatus;
    private byte intention;
    private Byte experience;
    private byte job;
    private Timestamp createdAt;
    private Timestamp updateAt;
    private Byte state;
    private Integer salary;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "marriage_status")
    public byte getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(byte marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    @Basic
    @Column(name = "intention")
    public byte getIntention() {
        return intention;
    }

    public void setIntention(byte intention) {
        this.intention = intention;
    }

    @Basic
    @Column(name = "experience")
    public Byte getExperience() {
        return experience;
    }

    public void setExperience(Byte experience) {
        this.experience = experience;
    }

    @Basic
    @Column(name = "job")
    public byte getJob() {
        return job;
    }

    public void setJob(byte job) {
        this.job = job;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "update_at")
    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @Basic
    @Column(name = "state")
    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Basic
    @Column(name = "salary")
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInformation that = (UserInformation) o;

        if (id != that.id) return false;
        if (marriageStatus != that.marriageStatus) return false;
        if (intention != that.intention) return false;
        if (job != that.job) return false;
        if (experience != null ? !experience.equals(that.experience) : that.experience != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (salary != null ? !salary.equals(that.salary) : that.salary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) marriageStatus;
        result = 31 * result + (int) intention;
        result = 31 * result + (experience != null ? experience.hashCode() : 0);
        result = 31 * result + (int) job;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }
}
