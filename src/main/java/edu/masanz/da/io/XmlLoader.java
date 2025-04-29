package edu.masanz.da.io;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import edu.masanz.da.dto.*;

public class XmlLoader {
    private static String inputPisosXml = "src/main/resources/data/PisosTuristicos.xml";

    public static PisosTuristicos loadPisos() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PisosTuristicos.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            PisosTuristicos pisosTuristicos = (PisosTuristicos) unmarshaller.unmarshal(new File(inputPisosXml));
            return pisosTuristicos;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        testPisos();
    }

    private static void testPisos() {
        PisosTuristicos pisosTuristicos = loadPisos();
        if (pisosTuristicos != null) {
            for (Piso piso : pisosTuristicos.getListaPisos()) {
                System.out.println(piso);
            }
            System.out.println("Total estudiantes: " + pisosTuristicos.getListaPisos().size());
        } else {
            System.out.println("Error loading estudiantes.");
        }
    }
}
