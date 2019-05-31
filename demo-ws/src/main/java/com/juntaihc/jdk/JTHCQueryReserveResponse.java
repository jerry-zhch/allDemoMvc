
package com.juntaihc.jdk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="JTHC_Query_ReserveResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "jthcQueryReserveResult"
})
@XmlRootElement(name = "JTHC_Query_ReserveResponse")
public class JTHCQueryReserveResponse {

    @XmlElement(name = "JTHC_Query_ReserveResult")
    protected String jthcQueryReserveResult;

    /**
     * ��ȡjthcQueryReserveResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJTHCQueryReserveResult() {
        return jthcQueryReserveResult;
    }

    /**
     * ����jthcQueryReserveResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJTHCQueryReserveResult(String value) {
        this.jthcQueryReserveResult = value;
    }

}
