/**
 * NumberConversion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package dk.dd.soap.client;

public interface NumberConversion extends javax.xml.rpc.Service {

/**
 * The Number Conversion Web Service, implemented with Visual DataFlex,
 * provides functions that convert numbers into words or dollar amounts.
 */
    public java.lang.String getNumberConversionSoapAddress();

    public dk.dd.soap.client.NumberConversionSoapType getNumberConversionSoap() throws javax.xml.rpc.ServiceException;

    public dk.dd.soap.client.NumberConversionSoapType getNumberConversionSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getNumberConversionSoap12Address();

    public dk.dd.soap.client.NumberConversionSoapType getNumberConversionSoap12() throws javax.xml.rpc.ServiceException;

    public dk.dd.soap.client.NumberConversionSoapType getNumberConversionSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
