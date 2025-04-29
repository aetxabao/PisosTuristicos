package edu.masanz.da.dto;

import org.jetbrains.annotations.NotNull;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "piso")
public class Piso implements Comparable<Piso> {

    private long id;
    private String codInscripcion;
    private String nombre;
    private String modalidad;
    private String categoria;
    private String direccion;
    private String localidad;
    private String municipio;
    private String zona;
    private int plazas;
    private String fechaDeInscripcion;

    public Piso() {
        this(0, "", "", "", "",
            "", "", "", "",
            0, "");
    }

    public Piso(long id, String codInscripcion, String nombre, String modalidad, String categoria,
                String direccion, String localidad, String municipio, String zona,
                int plazas, String fechaDeInscripcion) {
        this.id = id;
        this.codInscripcion = codInscripcion;
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.categoria = categoria;
        this.direccion = direccion;
        this.localidad = localidad;
        this.municipio = municipio;
        this.zona = zona;
        this.plazas = plazas;
        this.fechaDeInscripcion = fechaDeInscripcion;
    }


    @XmlAttribute
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlElement(name = "COD_INSCRIPCION")
    public String getCodInscripcion() {
        return codInscripcion;
    }

    public void setCodInscripcion(String codInscripcion) {
        this.codInscripcion = codInscripcion;
    }

    @XmlElement(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "MODALIDAD")
    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    @XmlElement(name = "CATEGORIA")
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @XmlElement(name = "DIRECCION")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlElement(name = "LOCALIDAD")
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @XmlElement(name = "MUNICIPIO")
    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @XmlElement(name = "ZONA")
    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @XmlElement(name = "PLAZAS")
    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    @XmlElement(name = "FECHA_DE_INSCRIPCION")
    public String getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }

    public void setFechaDeInscripcion(String fechaDeInscripcion) {
        this.fechaDeInscripcion = fechaDeInscripcion;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Piso that = (Piso) other;
        return this.id == that.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(@NotNull Piso o) {
        if (o == null) return 1;
        return Long.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return String.format("(%d) %-20s %-20s %s", id, zona, localidad, nombre);
    }
}
