package eu.glowacki.jaxws.api.composite;

import java.math.BigInteger;
import java.util.Set;

import javax.xml.bind.annotation.XmlType;

@XmlType( //
		name = "AddResponseMessage", // name of the XmlType should be different from the name of the class
		namespace = "http://glowacki.eu/composite" //
)
public final class PersonResponse {

	public Set<Person> result;

	/**
	 * empty parameterless constructor is required for unmarshalling
	 */
	public PersonResponse() {
	}

	public PersonResponse(Set result) {
		this.result = result;
	}
}