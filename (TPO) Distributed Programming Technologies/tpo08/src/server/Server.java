package server;

import common.RMI_Info;
import common.RemoteService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server{

    private static Registry rmiRegistry;

    public static void main(String[] args) {
        try {
            rmiRegistry = LocateRegistry.createRegistry(RMI_Info.RMI_PORT);
            RemoteService service = new RemoteService();
            rmiRegistry.rebind(RMI_Info.SERVICE_OBJECT_NAME, service);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.println("server started");
    }
}
