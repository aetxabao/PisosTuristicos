package edu.masanz.da.io;

import edu.masanz.da.dto.PisosTuristicos;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlSaver {
    private static String inputPisosXml = "src/main/resources/data/PisosTuristicos.xml";
    private static String outputPisosXml = "src/main/resources/data/pisos.xml";
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

    public static boolean saveEstudiantes(PisosTuristicos pisosTuristicos) {
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(PisosTuristicos.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            jaxbMarshaller.marshal(estudiantes, System.out);
            jaxbMarshaller.marshal(pisosTuristicos, new File(outputPisosXml));
        }catch (JAXBException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PisosTuristicos pisosTuristicos = loadPisos();
        saveEstudiantes(pisosTuristicos);
    }
}
