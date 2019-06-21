package com.myspringtest.test.business.model;


import javax.persistence.*;

/**
 * @author xcr
 */
@Table(name = "`usertest`")
public class UserTest {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`class`")
    private String myclass;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return class
     */
    public String getMyClass() {
        return myclass;
    }

    /**
     * @param myclass
     */
    public void setClass(String myclass) {
        this.myclass = myclass == null ? null : myclass.trim();
    }
}