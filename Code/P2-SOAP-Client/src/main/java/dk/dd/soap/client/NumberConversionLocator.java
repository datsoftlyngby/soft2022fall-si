/**
 * NumberConversionLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package dk.dd.soap.client;

public class NumberConversionLocator extends org.apache.axis.client.Service implements dk.dd.soap.client.NumberConversion {
    

    public NumberConversionLocator() {
    }


    public NumberConversionLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public NumberConversionLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for NumberConversionSoap
    private java.lang.String NumberConversionSoap_address = "https://www.dataaccess.com/webservicesserver/numberconversion.wso";

    public java.lang.String getNumberConversionSoapAddress() {
        return NumberConversionSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String NumberConversionSoapWSDDServiceName = "NumberConversionSoap";

    public java.lang.String getNumberConversionSoapWSDDServiceName() {
        return NumberConversionSoapWSDDServiceName;
    }

    public void setNumberConversionSoapWSDDServiceName(java.lang.String name) {
        NumberConversionSoapWSDDServiceName = name;
    }

    public dk.dd.soap.client.NumberConversionSoapType getNumberConversionSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(NumberConversionSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getNumberConversionSoap(endpoint);
    }

    public dk.dd.soap.client.NumberConversionSoapType getNumberConversionSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            dk.dd.soap.client.NumberConversionSoapBindingStub _stub = new dk.dd.soap.client.NumberConversionSoapBindingStub(portAddress, this);
            _stub.setPortName(getNumberConversionSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setNumberConversionSoapEndpointAddress(java.lang.String address) {
        NumberConversionSoap_address = address;
    }


    // Use to get a proxy class for NumberConversionSoap12
    private java.lang.String NumberConversionSoap12_address = "https://www.dataaccess.com/webservicesserver/numberconversion.wso";

    public java.lang.String getNumberConversionSoap12Address() {
        return NumberConversionSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String NumberConversionSoap12WSDDServiceName = "NumberConversionSoap12";

    public java.lang.String getNumberConversionSoap12WSDDServiceName() {
        return NumberConversionSoap12WSDDServiceName;
    }

    public void setNumberConversionSoap12WSDDServiceName(java.lang.String name) {
        NumberConversionSoap12WSDDServiceName = name;
    }

    public dk.dd.soap.client.NumberConversionSoapType getNumberConversionSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(NumberConversionSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getNumberConversionSoap12(endpoint);
    }

    public dk.dd.soap.client.NumberConversionSoapType getNumberConversionSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            dk.dd.soap.client.NumberConversionSoapBinding12Stub _stub = new dk.dd.soap.client.NumberConversionSoapBinding12Stub(portAddress, this);
            _stub.setPortName(getNumberConversionSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setNumberConversionSoap12EndpointAddress(java.lang.String address) {
        NumberConversionSoap12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (dk.dd.soap.client.NumberConversionSoapType.class.isAssignableFrom(serviceEndpointInterface)) {
                dk.dd.soap.client.NumberConversionSoapBindingStub _stub = new dk.dd.soap.client.NumberConversionSoapBindingStub(new java.net.URL(NumberConversionSoap_address), this);
                _stub.setPortName(getNumberConversionSoapWSDDServiceName());
                return _stub;
            }
            if (dk.dd.soap.client.NumberConversionSoapType.class.isAssignableFrom(serviceEndpointInterface)) {
                dk.dd.soap.client.NumberConversionSoapBinding12Stub _stub = new dk.dd.soap.client.NumberConversionSoapBinding12Stub(new java.net.URL(NumberConversionSoap12_address), this);
                _stub.setPortName(getNumberConversionSoap12WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("NumberConversionSoap".equals(inputPortName)) {
            return getNumberConversionSoap();
        }
        else if ("NumberConversionSoap12".equals(inputPortName)) {
            return getNumberConversionSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.dataaccess.com/webservicesserver/", "NumberConversion");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.dataaccess.com/webservicesserver/", "NumberConversionSoap"));
            ports.add(new javax.xml.namespace.QName("http://www.dataaccess.com/webservicesserver/", "NumberConversionSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("NumberConversionSoap".equals(portName)) {
            setNumberConversionSoapEndpointAddress(address);
        }
        else 
if ("NumberConversionSoap12".equals(portName)) {
            setNumberConversionSoap12EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
