package common.iHelpers;

import common.communciation.MultiplicationRequest;
import common.communciation.MultiplicationResponse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMultiplication extends Remote {
    MultiplicationResponse add(MultiplicationRequest request) throws RemoteException;
}
