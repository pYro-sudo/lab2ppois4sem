package by.losik.lab2ppois4sem.controller;

import by.losik.lab2ppois4sem.model.*;
import by.losik.lab2ppois4sem.service.XMLParserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class XMLController {
    private static final Logger logger = LoggerFactory.getLogger(Form.class);
    private final XMLParserService xmlParserService = new XMLParserService();

    public void saveXML() {
        try{
            xmlParserService.saveXML();
        }
        catch (Exception e){
            logger.error("Data was not saved.", e);
        }
    }

    protected List<Form> showXML() {
        try{
            return xmlParserService.showXML();
        }
        catch (Exception e){
            logger.error("Parsing error.", e);
            return new ArrayList<>();
        }
    }
}
