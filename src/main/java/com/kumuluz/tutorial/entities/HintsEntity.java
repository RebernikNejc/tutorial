package com.kumuluz.tutorial.entities;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hints", schema = "public", catalog = "d9fksifgpu2qos")
public class HintsEntity {
    private Integer id;
    private Integer position;
    private Integer x;
    private Integer y;
    private String content;
    private Integer status;
    private PageEntity pageByPage;
    private String placement;
    private Integer mode;
    private String ref;

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
    @Column(name = "x", nullable = true)
    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    @Basic
    @Column(name = "y", nullable = true)
    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        HintsEntity that = (HintsEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(position, that.position) &&
                Objects.equals(x, that.x) &&
                Objects.equals(y, that.y) &&
                Objects.equals(content, that.content) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position, x, y, content, status);
    }

    @ManyToOne
    @JoinColumn(name = "page", referencedColumnName = "id")
    @JsonbTransient
    public PageEntity getPageByPage() {
        return pageByPage;
    }

    public void setPageByPage(PageEntity pageByPage) {
        this.pageByPage = pageByPage;
    }

    @Basic
    @Column(name = "placement")
    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    @Basic
    @Column(name = "mode")
    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    @Basic
    @Column(name = "ref")
    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
