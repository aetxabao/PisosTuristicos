package edu.masanz.da.controller;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import io.javalin.http.Context;

import edu.masanz.da.dto.*;
import edu.masanz.da.service.ExamService;

public class ExamController {

    private static String ZONA0 = "Cuenca de Pamplona";

    // app.get("/", ExamController::ejercicio);
    public static void ejercicio(Context context) {
        String zona = "-";
        List<String> zonas = ExamService.getZonas();
        if (context.queryParam("zona") != null) {
            zona = context.queryParam("zona");
        }else{
//            zona = zonas.get(0);
            zona = ZONA0;
        }
        Map<String, List<Piso>> pisosMunicipios = ExamService.getPisosMunicipios(zona);
        Map<String, Object> model = new HashMap<>();
        model.put("zona", zona);
        model.put("zonas", zonas);
        model.put("pisosMunicipios", pisosMunicipios);
        context.render("/templates/ejercicio.ftl", model);
    }

}
