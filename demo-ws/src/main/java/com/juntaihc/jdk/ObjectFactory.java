
package com.juntaihc.jdk;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.juntaihc package. 
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

    private final static QName _String_QNAME = new QName("http://www.juntaihc.com/", "string");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.juntaihc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JTHCDoReserve }
     * 
     */
    public JTHCDoReserve createJTHCDoReserve() {
        return new JTHCDoReserve();
    }

    /**
     * Create an instance of {@link JTHCDoctorsResponse }
     * 
     */
    public JTHCDoctorsResponse createJTHCDoctorsResponse() {
        return new JTHCDoctorsResponse();
    }

    /**
     * Create an instance of {@link JTHCEcho }
     * 
     */
    public JTHCEcho createJTHCEcho() {
        return new JTHCEcho();
    }

    /**
     * Create an instance of {@link JTHCHBs }
     * 
     */
    public JTHCHBs createJTHCHBs() {
        return new JTHCHBs();
    }

    /**
     * Create an instance of {@link JTHCScheduleRemainTimeSlotsResponse }
     * 
     */
    public JTHCScheduleRemainTimeSlotsResponse createJTHCScheduleRemainTimeSlotsResponse() {
        return new JTHCScheduleRemainTimeSlotsResponse();
    }

    /**
     * Create an instance of {@link JTHCHospitalsResponse }
     * 
     */
    public JTHCHospitalsResponse createJTHCHospitalsResponse() {
        return new JTHCHospitalsResponse();
    }

    /**
     * Create an instance of {@link JTHCDeptsResponse }
     * 
     */
    public JTHCDeptsResponse createJTHCDeptsResponse() {
        return new JTHCDeptsResponse();
    }

    /**
     * Create an instance of {@link JTHCQueryReserveResponse }
     * 
     */
    public JTHCQueryReserveResponse createJTHCQueryReserveResponse() {
        return new JTHCQueryReserveResponse();
    }

    /**
     * Create an instance of {@link JTHCHospitals }
     * 
     */
    public JTHCHospitals createJTHCHospitals() {
        return new JTHCHospitals();
    }

    /**
     * Create an instance of {@link JTHCSchedules }
     * 
     */
    public JTHCSchedules createJTHCSchedules() {
        return new JTHCSchedules();
    }

    /**
     * Create an instance of {@link JTHCQueryReserve }
     * 
     */
    public JTHCQueryReserve createJTHCQueryReserve() {
        return new JTHCQueryReserve();
    }

    /**
     * Create an instance of {@link JTHCCancelReserve }
     * 
     */
    public JTHCCancelReserve createJTHCCancelReserve() {
        return new JTHCCancelReserve();
    }

    /**
     * Create an instance of {@link JTHCCancelReserveResponse }
     * 
     */
    public JTHCCancelReserveResponse createJTHCCancelReserveResponse() {
        return new JTHCCancelReserveResponse();
    }

    /**
     * Create an instance of {@link JTHCHBsResponse }
     * 
     */
    public JTHCHBsResponse createJTHCHBsResponse() {
        return new JTHCHBsResponse();
    }

    /**
     * Create an instance of {@link JTHCSchedulesResponse }
     * 
     */
    public JTHCSchedulesResponse createJTHCSchedulesResponse() {
        return new JTHCSchedulesResponse();
    }

    /**
     * Create an instance of {@link JTHCDoctors }
     * 
     */
    public JTHCDoctors createJTHCDoctors() {
        return new JTHCDoctors();
    }

    /**
     * Create an instance of {@link JTHCScheduleRemainTimeSlots }
     * 
     */
    public JTHCScheduleRemainTimeSlots createJTHCScheduleRemainTimeSlots() {
        return new JTHCScheduleRemainTimeSlots();
    }

    /**
     * Create an instance of {@link JTHCDepts }
     * 
     */
    public JTHCDepts createJTHCDepts() {
        return new JTHCDepts();
    }

    /**
     * Create an instance of {@link JTHCDoReserveResponse }
     * 
     */
    public JTHCDoReserveResponse createJTHCDoReserveResponse() {
        return new JTHCDoReserveResponse();
    }

    /**
     * Create an instance of {@link JTHCEchoResponse }
     * 
     */
    public JTHCEchoResponse createJTHCEchoResponse() {
        return new JTHCEchoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juntaihc.com/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

}
