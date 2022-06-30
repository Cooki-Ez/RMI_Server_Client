package common;

import common.communciation.MultiplicationRequest;
import common.communciation.MultiplicationResponse;
import common.communciation.EchoRequest;
import common.communciation.EchoResponse;
import common.iHelpers.IMultiplication;
import common.iHelpers.IEcho;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteService extends UnicastRemoteObject implements IEcho, IMultiplication{

    public RemoteService() throws RemoteException {
    }

    @Override
    public EchoResponse echo(EchoRequest request) throws RemoteException {
        return new EchoResponse(request.getRequest());
    }

    @Override
    public MultiplicationResponse add(MultiplicationRequest request) throws RemoteException {
        return new MultiplicationResponse(request.getParameter1().multiply(request.getParameter2()));
    }
}
