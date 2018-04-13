/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pschool.semillero.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rm-rf
 */
@Entity
@Table(name = "persona", catalog = "test_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByPersonaPersona", query = "SELECT p FROM Persona p WHERE p.personaPersona = :personaPersona")
    , @NamedQuery(name = "Persona.findByPersonaDocumento", query = "SELECT p FROM Persona p WHERE p.personaDocumento = :personaDocumento")
    , @NamedQuery(name = "Persona.findByPersonaNombre", query = "SELECT p FROM Persona p WHERE p.personaNombre = :personaNombre")
    , @NamedQuery(name = "Persona.findByPersonaApellido", query = "SELECT p FROM Persona p WHERE p.personaApellido = :personaApellido")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "personaPersona", nullable = false)
    private Integer personaPersona;
    @Size(max = 45)
    @Column(name = "personaDocumento", length = 45)
    private String personaDocumento;
    @Size(max = 45)
    @Column(name = "personaNombre", length = 45)
    private String personaNombre;
    @Size(max = 45)
    @Column(name = "personaApellido", length = 45)
    private String personaApellido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioPersona")
    private List<Usuario> usuarioList;

    public Persona() {
    }

    public Persona(Integer personaPersona) {
        this.personaPersona = personaPersona;
    }

    public Integer getPersonaPersona() {
        return personaPersona;
    }

    public void setPersonaPersona(Integer personaPersona) {
        this.personaPersona = personaPersona;
    }

    public String getPersonaDocumento() {
        return personaDocumento;
    }

    public void setPersonaDocumento(String personaDocumento) {
        this.personaDocumento = personaDocumento;
    }

    public String getPersonaNombre() {
        return personaNombre;
    }

    public void setPersonaNombre(String personaNombre) {
        this.personaNombre = personaNombre;
    }

    public String getPersonaApellido() {
        return personaApellido;
    }

    public void setPersonaApellido(String personaApellido) {
        this.personaApellido = personaApellido;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaPersona != null ? personaPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.personaPersona == null && other.personaPersona != null) || (this.personaPersona != null && !this.personaPersona.equals(other.personaPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pschool.semillero.entity.Persona[ personaPersona=" + personaPersona + " ]";
    }
    
}
