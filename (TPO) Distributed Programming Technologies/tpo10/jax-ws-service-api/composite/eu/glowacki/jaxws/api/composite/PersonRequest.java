package eu.glowacki.jaxws.api.composite;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlType;

@XmlType( //
		name = "AddRequestMessage", // name of the XmlType should be different from the name of the class
		namespace = "http://glowacki.eu/composite" //
)
public final class PersonRequest {

	public String value;
	//public String surname;
	//public String birthDate;

	/**
	 * empty parameterless constructor is required for unmarshalling
	 */
	public PersonRequest() {
	}

	public PersonRequest(String var) {
		this.value = var;
	}
}