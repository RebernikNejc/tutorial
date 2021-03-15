package com.kumuluz.tutorial.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tutorial", schema = "public", catalog = "d9fksifgpu2qos")
public class TutorialEntity {
    private Integer id;
    private String name;
    private Collection<PageEntity> pagesById;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TutorialEntity that = (TutorialEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "tutorialByTutorial")
    @OrderBy("position")
    public Collection<PageEntity> getPagesById() {
        return pagesById;
    }

    public void setPagesById(Collection<PageEntity> pagesById) {
        this.pagesById = pagesById;
    }
}
