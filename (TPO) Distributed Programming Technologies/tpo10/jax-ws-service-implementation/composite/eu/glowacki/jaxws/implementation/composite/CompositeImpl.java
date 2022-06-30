package eu.glowacki.jaxws.implementation.composite;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import eu.glowacki.jaxws.api.composite.PersonRequest;
import eu.glowacki.jaxws.api.composite.PersonResponse;
import eu.glowacki.jaxws.api.composite.IComposite;
import eu.glowacki.jaxws.api.composite.Person;

@WebService( //
		name = "IComposite", //
		targetNamespace = "http://glowacki.eu/composite" //
)
public final class CompositeImpl implements IComposite {

	private static final Logger LOGGER = Logger.getAnonymousLogger();
	private HashSet<Person> map = new HashSet<Person>();

	public static void main(String... args) {
		Endpoint.publish(IComposite.URI, new CompositeImpl());
		LOGGER.info("SERVICE STARTED");
	}

	public CompositeImpl() {
		map.add(new Person("Elizabeth", "Olsen", "01/01/1990"));
		map.add(new Person("Jessica", "Olsen", "01/01/1990"));
		map.add(new Person("Jennifer", "Lawrence", "01/01/1999"));
		
	}

	public PersonResponse add(PersonRequest request) {

		HashSet<Person> setOfPeople = new HashSet<Person>();

		for (Person p : map) {
			if (p.surname.equals(request.value) || p.birthDate.equals(request.value)) {
				setOfPeople.add(p);
			}
		}

		return new PersonResponse(setOfPeople);

	}
}