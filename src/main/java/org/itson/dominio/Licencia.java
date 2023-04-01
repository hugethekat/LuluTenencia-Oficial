/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author xeron
 */
@Entity
@Table(name = "Licencias")
public class Licencia extends Tramite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Estado")
    private boolean estado;

    @Column(name = "Discapacitado")
    private boolean discapacitado;

    @Column(name = "Vigencia")
    private int vigencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
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
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + ", estado=" + estado + ", discapacitado=" + discapacitado + ", vigencia=" + vigencia + '}';
    }

    public Licencia(Long id, boolean estado, boolean discapacitado, int vigencia) {
        this.id = id;
        this.estado = estado;
        this.discapacitado = discapacitado;
        this.vigencia = vigencia;
    }

    public Licencia(boolean estado, boolean discapacitado, int vigencia) {
        this.estado = estado;
        this.discapacitado = discapacitado;
        this.vigencia = vigencia;
    }

    public Licencia() {
    }

    

}
