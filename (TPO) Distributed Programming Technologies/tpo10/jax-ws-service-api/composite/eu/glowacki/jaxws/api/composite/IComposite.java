package eu.glowacki.jaxws.api.composite;

import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService( //
		name = "IComposite", //
		targetNamespace = "http://glowacki.eu/composite" //
)
public interface IComposite {

	public static final String URI = "http://localhost:8080/composite";

	@WebMethod(action = "http://glowacki.eu/composite/add")
	PersonResponse add(PersonRequest request);
	//AddResponse add(AddRequest request);
	
	
	
}