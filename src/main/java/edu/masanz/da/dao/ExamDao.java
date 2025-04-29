package edu.masanz.da.dao;

import edu.masanz.da.dto.*;
import edu.masanz.da.io.XmlLoader;

import java.util.*;

public class ExamDao {
    private List<Piso> pisos;

    public ExamDao() {
        pisos = XmlLoader.loadPisos().getListaPisos();
    }

    public List<String> getZonas() {
        List<String> zonas = new ArrayList<>();
        for (Piso piso : pisos) {
            String zona = piso.getZona();
            if (!zonas.contains(zona)) {
                zonas.add(zona);
            }
        }
        Collections.sort(zonas);
        return zonas;
    }

    public Map<String, List<Piso>> getPisosMunicipios(String filtroZona) {
        Map<String, List<Piso>> pisosMunicipios = new TreeMap<>();
        if (filtroZona == null || filtroZona.isEmpty()) {
            return pisosMunicipios;
        }
        for (Piso piso : pisos) {
            String zona = piso.getZona();
            if (zona.equals(filtroZona)) {
                String municipio = piso.getMunicipio();
                if (!pisosMunicipios.containsKey(municipio)) {
                    pisosMunicipios.put(municipio, new ArrayList<>());
                }
                pisosMunicipios.get(municipio).add(piso);
            }
        }
        return pisosMunicipios;
    }

}
