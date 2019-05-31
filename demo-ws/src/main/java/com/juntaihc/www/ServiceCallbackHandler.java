/**
 * ServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package com.juntaihc.www;


/**
 *  ServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class ServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public ServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public ServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for jTHC_Do_Reserve method
     * override this method for handling normal response from jTHC_Do_Reserve operation
     */
    public void receiveResultjTHC_Do_Reserve(
        ServiceStub.JTHC_Do_ReserveResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from jTHC_Do_Reserve operation
     */
    public void receiveErrorjTHC_Do_Reserve(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for jTHC_Echo method
     * override this method for handling normal response from jTHC_Echo operation
     */
    public void receiveResultjTHC_Echo(
        ServiceStub.JTHC_EchoResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from jTHC_Echo operation
     */
    public void receiveErrorjTHC_Echo(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for jTHC_HBs method
     * override this method for handling normal response from jTHC_HBs operation
     */
    public void receiveResultjTHC_HBs(
        ServiceStub.JTHC_HBsResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from jTHC_HBs operation
     */
    public void receiveErrorjTHC_HBs(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for jTHC_Depts method
     * override this method for handling normal response from jTHC_Depts operation
     */
    public void receiveResultjTHC_Depts(
        ServiceStub.JTHC_DeptsResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from jTHC_Depts operation
     */
    public void receiveErrorjTHC_Depts(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for jTHC_Cancel_Reserve method
     * override this method for handling normal response from jTHC_Cancel_Reserve operation
     */
    public void receiveResultjTHC_Cancel_Reserve(
        ServiceStub.JTHC_Cancel_ReserveResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from jTHC_Cancel_Reserve operation
     */
    public void receiveErrorjTHC_Cancel_Reserve(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for jTHC_Doctors method
     * override this method for handling normal response from jTHC_Doctors operation
     */
    public void receiveResultjTHC_Doctors(
        ServiceStub.JTHC_DoctorsResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from jTHC_Doctors operation
     */
    public void receiveErrorjTHC_Doctors(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for jTHC_Schedule_Remain_TimeSlots method
     * override this method for handling normal response from jTHC_Schedule_Remain_TimeSlots operation
     */
    public void receiveResultjTHC_Schedule_Remain_TimeSlots(
        ServiceStub.JTHC_Schedule_Remain_TimeSlotsResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from jTHC_Schedule_Remain_TimeSlots operation
     */
    public void receiveErrorjTHC_Schedule_Remain_TimeSlots(
        Exception e) {
    }

    /**
     * auto generated Axis2 call back method for jTHC_Query_Reserve method
     * override this method for handling normal response from jTHC_Query_Reserve operation
     */
    public void receiveResultjTHC_Query_Reserve(
        ServiceStub.JTHC_Query_ReserveResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from jTHC_Query_Reserve operation
     */
    public void receiveErrorjTHC_Query_Reserve(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for jTHC_Hospitals method
     * override this method for handling normal response from jTHC_Hospitals operation
     */
    public void receiveResultjTHC_Hospitals(
        ServiceStub.JTHC_HospitalsResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from jTHC_Hospitals operation
     */
    public void receiveErrorjTHC_Hospitals(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for jTHC_Schedules method
     * override this method for handling normal response from jTHC_Schedules operation
     */
    public void receiveResultjTHC_Schedules(
        ServiceStub.JTHC_SchedulesResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from jTHC_Schedules operation
     */
    public void receiveErrorjTHC_Schedules(Exception e) {
    }
}
