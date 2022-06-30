package client;

import common.RMI_Info;
import common.communciation.MultiplicationRequest;
import common.communciation.MultiplicationResponse;
import common.communciation.EchoRequest;
import common.communciation.EchoResponse;
import common.iHelpers.IMultiplication;
import common.iHelpers.IEcho;

import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class Client{
    private static Registry RMI_Registry;

    public static void main(String[] args) {
        Random random = new Random();
        try {
            RMI_Registry = LocateRegistry.getRegistry(RMI_Info.RMI_PORT);
            IEcho iEcho = (IEcho) RMI_Registry.lookup(RMI_Info.SERVICE_OBJECT_NAME);
            EchoRequest echoRequest = new EchoRequest("hello");
            System.out.println("EchoRequest: " + echoRequest);
            EchoResponse echoResponse = iEcho.echo(echoRequest);
            System.out.println("EchoResponse: " + echoResponse);

            IMultiplication addRemoteObj = (IMultiplication) RMI_Registry.lookup(RMI_Info.SERVICE_OBJECT_NAME);
            BigDecimal parameter1 = new BigDecimal(random.nextInt(1999999999));
            BigDecimal parameter2 = new BigDecimal(random.nextInt(1999999999));
            MultiplicationRequest multiplicationRequest = new MultiplicationRequest(parameter1, parameter2);
            MultiplicationResponse multiplicationResponse = addRemoteObj.add(multiplicationRequest);
            System.out.println("MultiplicationRequest: " + multiplicationRequest);
            System.out.println("MultiplicationResponse: " + multiplicationResponse);
        } catch (IOException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}