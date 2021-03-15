package com.kumuluz.tutorial.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.ws.rs.core.Link;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "page", schema = "public", catalog = "d9fksifgpu2qos")
public class PageEntity {
    private Integer id;
    private Integer position;
    private String image;
    private Integer status;
    private Collection<HintsEntity> hintsById;
    private TutorialEntity tutorialByTutorial;

    private String first;
    private String prev;
    private String self;
    private String next;
    private String last;

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
    @Column(name = "position", nullable = true)
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Basic
    @Column(name = "image", nullable = true, length = -1)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageEntity that = (PageEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(position, that.position) &&
                Objects.equals(image, that.image) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position, image, status);
    }

    @OneToMany(mappedBy = "pageByPage")
    @OrderBy("position")
    public Collection<HintsEntity> getHintsById() {
        return hintsById;
    }

    public void setHintsById(Collection<HintsEntity> hintsById) {
        this.hintsById = hintsById;
    }

    @ManyToOne
    @JoinColumn(name = "tutorial", referencedColumnName = "id")
    @JsonbTransient
    public TutorialEntity getTutorialByTutorial() {
        return tutorialByTutorial;
    }

    public void setTutorialByTutorial(TutorialEntity tutorialByTutorial) {
        this.tutorialByTutorial = tutorialByTutorial;
    }

    @Transient
    @JsonInclude
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    @Transient
    @JsonInclude
    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    @Transient
    @JsonInclude
    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    @Transient
    @JsonInclude
    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    @Transient
    @JsonInclude
    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
