package edu.masanz.da.service;

import edu.masanz.da.dto.*;
import edu.masanz.da.dao.ExamDao;

import java.util.*;

public class ExamService {

    private static ExamDao masDao = new ExamDao();

    public static List<String> getZonas() {
        return masDao.getZonas();
    }

    public static Map<String, List<Piso>> getPisosMunicipios(String zona) {
        return masDao.getPisosMunicipios(zona);
    }

}
