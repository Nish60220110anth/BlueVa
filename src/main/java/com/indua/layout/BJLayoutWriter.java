package com.indua.layout;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.Document;

import com.indua.BJPackage;

public class BJLayoutWriter {
    private BJPackage _package;
    private final Document _document;

    private BJLayoutWriter(Document _pdocument) {
        this._document = _pdocument;
    }

    public static BJLayoutWriter createInstance(Document _pdocument) {
        return new BJLayoutWriter(_pdocument);
    }

    /**
     * It creates a new document object
     * 
     * @return A new Document object.
     */
    public static Document createDefaultDocument() throws ParserConfigurationException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();

        return docBuilder.newDocument();
    }

    /**
     * It returns the package of the class.
     * 
     * @return The package that the class is in.
     */
    public BJPackage getPackage() {
        return _package;
    }

    /**
     * This function sets the package of the layout writer
     * 
     * @param _ppackage The package to write the layout to.
     * @return The BJLayoutWriter object.
     */
    public BJLayoutWriter setPackage(BJPackage _ppackage) {
        _package = _ppackage;
        return this;
    }

    /**
     * It creates a new transformer object that will transform the document object
     * into a xml with
     * default configuration
     * 
     * @return A Transformer object.
     */
    public Transformer defaulTransform() throws TransformerConfigurationException {

        if (_document == null) {
            throw new IllegalStateException("Document object is not set");
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(new DOMSource(_document));

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");

        return transformer;
    }

}

/*
 * BJLayoutWriter mywriter =
 * BJLayoutWriter.createInstance(BJLayoutWriter.createDefaultDocument()).
 * setPackage(BJPackage).defaultTransform();
 */