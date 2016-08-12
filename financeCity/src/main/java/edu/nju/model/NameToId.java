package edu.nju.model;

import javax.persistence.*;

/**
 * Created by dell on 2016/8/11.
 */
@Entity
@Table(name = "name_to_id", schema = "citi", catalog = "")
public class NameToId {
    private String name;
    private Long id;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NameToId nameToId = (NameToId) o;

        if (name != null ? !name.equals(nameToId.name) : nameToId.name != null) return false;
        if (id != null ? !id.equals(nameToId.id) : nameToId.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
