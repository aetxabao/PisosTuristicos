package edu.masanz.da.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "data")
public class PisosTuristicos {

    private List<Piso> pisos;

    public PisosTuristicos() {
        pisos = new ArrayList<>();
    }

    @XmlElement(name="piso")
    public List<Piso> getListaPisos() {
        return pisos;
    }

    public void setEstudiantes(List<Piso> pisos) {
        this.pisos = pisos;
    }

}
