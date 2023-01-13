/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.finalexam;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Belinda merlansyah_20200140023
 */
@Entity
@Table(name = "personal")
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p"),
    @NamedQuery(name = "Personal.findById", query = "SELECT p FROM Personal p WHERE p.id = :id"),
    @NamedQuery(name = "Personal.findByNik", query = "SELECT p FROM Personal p WHERE p.nik = :nik"),
    @NamedQuery(name = "Personal.findByNama", query = "SELECT p FROM Personal p WHERE p.nama = :nama"),
    @NamedQuery(name = "Personal.findByTl", query = "SELECT p FROM Personal p WHERE p.tl = :tl"),
    @NamedQuery(name = "Personal.findByPhoto", query = "SELECT p FROM Personal p WHERE p.photo = :photo"),
    @NamedQuery(name = "Personal.findByTimestamp", query = "SELECT p FROM Personal p WHERE p.timestamp = :timestamp")})
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nik")
    private Integer nik;
    @Column(name = "nama")
    private String nama;
    @Column(name = "tl")
    @Temporal(TemporalType.DATE)
    private Date tl;
    @Column(name = "photo")
    private String photo;
    @Basic(optional = false)
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public Personal() {
    }

    public Personal(Integer id) {
        this.id = id;
    }

    public Personal(Integer id, Date timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTl() {
        return tl;
    }

    public void setTl(Date tl) {
        this.tl = tl;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pws.finalexam.Personal[ id=" + id + " ]";
    }
    
}
