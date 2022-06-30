package eu.glowacki.jaxws.client.composite;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.client.composite.proxy.AddRequestMessage;
import eu.glowacki.jaxws.client.composite.proxy.AddResponseMessage;
import eu.glowacki.jaxws.client.composite.proxy.CompositeImplService;
import eu.glowacki.jaxws.client.composite.proxy.IComposite;
import eu.glowacki.jaxws.client.delayed.proxy.ServiceException_Exception;

public class JunitTest {

	public static AddResponseMessage response;
	public static AddResponseMessage responseDate;

	static {
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
	}

	@BeforeClass
	static public void setup() throws MalformedURLException, ServiceException_Exception  {

		URL wsdl = new URL(eu.glowacki.jaxws.api.composite.IComposite.URI + IService.WSDL_SUFFIX);
		CompositeImplService service = new CompositeImplService(wsdl);
		IComposite proxy = service.getICompositePort();
		
		AddRequestMessage request = new AddRequestMessage();
		request.setValue("Olsen");
		response = proxy.add(request);
		

		AddRequestMessage requestDate = new AddRequestMessage();
		requestDate.setValue("01/01/1999");
		responseDate = proxy.add(requestDate);

	}

	@Test
	public void testsurname() {

		assertEquals(response.getResult().get(0).getFirstName(), "Elizabeth");
		assertEquals(response.getResult().get(0).getSurname(), "Olsen");
		assertEquals(response.getResult().get(0).getBirthDate(), "01/01/1990");

		assertEquals(response.getResult().get(1).getFirstName(), "Jessica");
		assertEquals(response.getResult().get(1).getSurname(), "Olsen");
		assertEquals(response.getResult().get(1).getBirthDate(), "01/01/1990");

	}

	@Test
	public void testdate() {

		assertEquals(responseDate.getResult().get(0).getFirstName(), "Jennifer");
		assertEquals(responseDate.getResult().get(0).getSurname(), "Lawrence");
		assertEquals(responseDate.getResult().get(0).getBirthDate(), "01/01/1999");

	}

}
