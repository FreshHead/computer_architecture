package ru.univeralex.lab5.client_server.rmi;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author - Alexander Kostarev
 */
public class BillingClient {
    public static void main(String[] args) throws Exception {
        String objectName = "rmi://" + "localhost" + "/BillingService";
        System.out.println("Starting...\n");

        BillingService bs = (BillingService) Naming.lookup(objectName);
        System.out.println("done");

        for (int i = 0; i < 10000; i++) {
            try {
                bs.addMoney("1", 1);
            } catch (RemoteException e) {
                bs.addNewCard("Piter", "1");
            }

            try {
                bs.addMoney("2", 1);
            } catch (RemoteException e) {
                bs.addNewCard("Stefan", "2");
            }

            try {
                bs.addMoney("3", 1);
            } catch (RemoteException e) {
                bs.addNewCard("Nataly", "3");
            }

            System.out.println("1:" + bs.getCardBalance("1"));
            System.out.println("2:" + bs.getCardBalance("2"));
            System.out.println("3:" + bs.getCardBalance("3"));
        }
    }
}
