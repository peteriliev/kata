
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

        
            package com.iliev.peter.kata.conventions.xsd;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://conventions.kata.peter.iliev.com/xsd".equals(namespaceURI) &&
                  "ArrayOfInteger".equals(typeName)){
                   
                            return  com.iliev.peter.kata.conventions.xsd.ArrayOfInteger.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://conventions.kata.peter.iliev.com/xsd".equals(namespaceURI) &&
                  "ISortTestSet".equals(typeName)){
                   
                            return  com.iliev.peter.kata.conventions.xsd.ISortTestSet.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    