//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.03.27 a las 12:52:28 AM COT 
//


package com.proyecto.ecoturist.servicio;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.proyecto.ecoturist.servicio package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.proyecto.ecoturist.servicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetServicioRequest }
     * 
     */
    public GetServicioRequest createGetServicioRequest() {
        return new GetServicioRequest();
    }

    /**
     * Create an instance of {@link GetServicioResponse }
     * 
     */
    public GetServicioResponse createGetServicioResponse() {
        return new GetServicioResponse();
    }

    /**
     * Create an instance of {@link Servicio }
     * 
     */
    public Servicio createServicio() {
        return new Servicio();
    }

}
