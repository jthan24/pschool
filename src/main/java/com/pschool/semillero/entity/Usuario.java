/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pschool.semillero.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rm-rf
 */
@Entity
@Table(name = "usuario", catalog = "test_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsuarioUsuario", query = "SELECT u FROM Usuario u WHERE u.usuarioUsuario = :usuarioUsuario")
    , @NamedQuery(name = "Usuario.findByUsuarioNombre", query = "SELECT u FROM Usuario u WHERE u.usuarioNombre = :usuarioNombre")
    , @NamedQuery(name = "Usuario.findByUsuarioNmUsuario", query = "SELECT u FROM Usuario u WHERE u.usuarioNmUsuario = :usuarioNmUsuario")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuarioUsuario", nullable = false)
    private Integer usuarioUsuario;
    @Size(max = 45)
    @Column(name = "usuarioNombre", length = 45)
    private String usuarioNombre;
    @Size(max = 45)
    @Column(name = "usuarioNmUsuario", length = 45)
    private String usuarioNmUsuario;
    @JoinColumn(name = "usuarioPersona", referencedColumnName = "personaPersona", nullable = false)
    @ManyToOne(optional = false)
    private Persona usuarioPersona;

    public Usuario() {
    }

    public Usuario(Integer usuarioUsuario) {
        this.usuarioUsuario = usuarioUsuario;
    }

    public Integer getUsuarioUsuario() {
        return usuarioUsuario;
    }

    public void setUsuarioUsuario(Integer usuarioUsuario) {
        this.usuarioUsuario = usuarioUsuario;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioNmUsuario() {
        return usuarioNmUsuario;
    }

    public void setUsuarioNmUsuario(String usuarioNmUsuario) {
        this.usuarioNmUsuario = usuarioNmUsuario;
    }

    public Persona getUsuarioPersona() {
        return usuarioPersona;
    }

    public void setUsuarioPersona(Persona usuarioPersona) {
        this.usuarioPersona = usuarioPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioUsuario != null ? usuarioUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioUsuario == null && other.usuarioUsuario != null) || (this.usuarioUsuario != null && !this.usuarioUsuario.equals(other.usuarioUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pschool.semillero.entity.Usuario[ usuarioUsuario=" + usuarioUsuario + " ]";
    }
    
}
