package by.losik.lab2ppois4sem.service;

import by.losik.lab2ppois4sem.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XMLParserService {
    private static final Logger logger = LoggerFactory.getLogger(Form.class);
    public static final String XML_FILE_PATH = "data.xml";
    public void saveXML() {
        try{
            FormService formService = new FormService();
            logger.info("Saving in XML at = {}", XML_FILE_PATH);
            List<Form> savedData = formService.findAll();

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("forms");
            rootElement.setAttribute("data", String.valueOf(new Date(System.currentTimeMillis())));
            doc.appendChild(rootElement);

            savedData.forEach(x -> {
                Element formElement = doc.createElement("form");
                rootElement.appendChild(formElement);

                Element idElement = doc.createElement("form-id");
                idElement.setAttribute("value", String.valueOf(x.getId()));
                formElement.appendChild(idElement);

                Element studentElement = doc.createElement("student");
                formElement.appendChild(studentElement);

                addElement(doc, studentElement, "student-id", String.valueOf(x.getStudent().getId()));
                addElement(doc, studentElement, "student-name", x.getStudent().getStudentName());
                addElement(doc, studentElement, "student-surname", x.getStudent().getStudentSurname());
                addElement(doc, studentElement, "student-father-name", x.getStudent().getStudentFatherName());
                addElement(doc, studentElement, "student-number-of-brothers", String.valueOf(x.getStudent().getNumOfBrothers()));
                addElement(doc, studentElement, "student-number-of-sisters", String.valueOf(x.getStudent().getNumOfSisters()));

                Element motherElement = doc.createElement("mother");
                formElement.appendChild(motherElement);

                addElement(doc, motherElement, "mother-id", String.valueOf(x.getMother().getId()));
                addElement(doc, motherElement, "mother-name", x.getMother().getMotherName());
                addElement(doc, motherElement, "mother-surname", x.getMother().getMotherSurname());
                addElement(doc, motherElement, "mother-father-name", x.getMother().getMotherFatherName());
                addElement(doc, motherElement, "mother-salary", String.valueOf(x.getMother().getSalary()));

                Element fatherElement = doc.createElement("father");
                formElement.appendChild(fatherElement);

                addElement(doc, fatherElement, "father-id", String.valueOf(x.getFather().getId()));
                addElement(doc, fatherElement, "father-name", x.getFather().getFatherName());
                addElement(doc, fatherElement, "father-surname", x.getFather().getFatherSurname());
                addElement(doc, fatherElement, "father-father-name", x.getFather().getFatherFatherName());
                addElement(doc, fatherElement, "father-salary", String.valueOf(x.getFather().getSalary()));
            });

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", "4");

            StreamResult result = new StreamResult(new File(XML_FILE_PATH));
            transformer.transform(source, result);
        }
        catch (Exception e){
            logger.error("Data was not saved.", e);
        }
    }
    private void addElement(Document document, Element parent, String tagName, String value) {
        Element element = document.createElement(tagName);
        element.setAttribute("value", value);
        parent.appendChild(element);
    }
    public ObservableList<Form> showXML() {
        try{
            logger.info("Showing from XML at = {}", XML_FILE_PATH);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();

            File xmlFile = new File(XML_FILE_PATH);
            saxParser.parse(xmlFile, handler);

            ObservableList<Form> forms = FXCollections.observableArrayList(handler.getForms());

            logger.debug("All the data was loaded from XML at: " + new File(XML_FILE_PATH).getAbsolutePath());

            return forms;
        }
        catch (Exception e){
            logger.error("Parsing error.", e);
            return null;
        }
    }
    private static class XMLHandler extends DefaultHandler {
        private final List<Form> forms = new ArrayList<>();
        private Form currentForm = null;
        private Student currentStudent = null;
        private Mother currentMother = null;
        private Father currentFather = null;
        private StringBuilder data = null;
        private String currentElement = null;

        public List<Form> getForms() {
            return forms;
        }

        @Override
        public void startElement(String uri, String localName, String currentName, Attributes attributes) {
            data = new StringBuilder();
            currentElement = currentName;

            switch (currentName) {
                case "form" -> currentForm = new Form();
                case "student" -> currentStudent = new Student();
                case "mother" -> currentMother = new Mother();
                case "father" -> currentFather = new Father();
            }

            if (currentForm != null && "form-id".equals(currentName)) {
                currentForm.setId(Integer.parseInt(attributes.getValue("value")));
            } else if (currentStudent != null) {
                switch (currentName) {
                    case "student-id" -> currentStudent.setId(Integer.parseInt(attributes.getValue("value")));
                    case "student-name" -> currentStudent.setStudentName(attributes.getValue("value"));
                    case "student-surname" -> currentStudent.setStudentSurname(attributes.getValue("value"));
                    case "student-father-name" -> currentStudent.setStudentFatherName(attributes.getValue("value"));
                    case "student-number-of-brothers" ->
                            currentStudent.setNumOfBrothers(Integer.parseInt(attributes.getValue("value")));
                    case "student-number-of-sisters" ->
                            currentStudent.setNumOfSisters(Integer.parseInt(attributes.getValue("value")));
                }
            } else if (currentMother != null) {
                switch (currentName) {
                    case "mother-id" -> currentMother.setId(Integer.parseInt(attributes.getValue("value")));
                    case "mother-name" -> currentMother.setMotherName(attributes.getValue("value"));
                    case "mother-surname" -> currentMother.setMotherSurname(attributes.getValue("value"));
                    case "mother-father-name" -> currentMother.setMotherFatherName(attributes.getValue("value"));
                    case "mother-salary" -> currentMother.setSalary(Float.parseFloat(attributes.getValue("value")));
                }
            } else if (currentFather != null) {
                switch (currentName) {
                    case "father-id" -> currentFather.setId(Integer.parseInt(attributes.getValue("value")));
                    case "father-name" -> currentFather.setFatherName(attributes.getValue("value"));
                    case "father-surname" -> currentFather.setFatherSurname(attributes.getValue("value"));
                    case "father-father-name" -> currentFather.setFatherFatherName(attributes.getValue("value"));
                    case "father-salary" -> currentFather.setSalary(Float.parseFloat(attributes.getValue("value")));
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String currentName) {
            switch (currentName) {
                case "form" -> {
                    if (currentForm != null) {
                        forms.add(currentForm);
                        currentForm = null;
                    }
                }
                case "student" -> {
                    if (currentForm != null && currentStudent != null) {
                        currentForm.setStudent(currentStudent);
                        currentStudent = null;
                    }
                }
                case "mother" -> {
                    if (currentForm != null && currentMother != null) {
                        currentForm.setMother(currentMother);
                        currentMother = null;
                    }
                }
                case "father" -> {
                    if (currentForm != null && currentFather != null) {
                        currentForm.setFather(currentFather);
                        currentFather = null;
                    }
                }
            }
        }

        @Override
        public void characters(char[] chars, int start, int length) {
            if (currentElement != null) {
                data.append(new String(chars, start, length).trim());
            }
        }
    }
}
