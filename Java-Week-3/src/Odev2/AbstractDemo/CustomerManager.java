package Odev2.AbstractDemo;

public class CustomerManager {
    BaseDatabaseManager databaseManager;

    public void getCustomers() {
        databaseManager.getData();
    }
}
