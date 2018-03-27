package ru.univeralex.lab5.client_server.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

/**
 * @author - Alexander Kostarev
 */
public class BillingServiceImpl extends UnicastRemoteObject implements BillingService {
    private Hashtable hash;

    public BillingServiceImpl() throws RemoteException {
        super();
        hash = new Hashtable();
    }

    @Override
    public void addNewCard(String personName, String card) throws RemoteException {
        hash.put(card, new Double(0.0));
    }

    @Override
    public void addMoney(String card, double money) throws RemoteException {
        Double d = (Double) hash.get(card);

        if (d != null)
            hash.put(card, new Double(d.doubleValue() + money));
        else throw new NotExistsCardOperation();
    }

    @Override
    public void subMoney(String card, double money) throws RemoteException {
        Double d = (Double)hash.get(card);

        if(d!=null)
            hash.put(card, new Double(d.doubleValue() - money));
        else throw new NotExistsCardOperation();
    }

    @Override
    public double getCardBalance(String card) throws RemoteException {
        Double d = (Double) hash.get(card);

        if(d!=null)
            return d.doubleValue();
        else throw new NotExistsCardOperation();
    }

    public static void main(String[] args) throws Exception{
        System.out.println("initializing BillingService...");

        BillingService service = new BillingServiceImpl();

        String serviceName = "rmi://localhost/BillingService";

        Naming.rebind(serviceName, service);
    }
}
