public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Customer customer = new Customer();
        customer.Id = 1;

        CreditManager creditManager = new CreditManager();
        creditManager.calculate(1);
        creditManager.save();

        CustomerManager customerManager = new CustomerManager(new Customer(), new MilitaryCreditManager());
        customerManager.save();
        customerManager.delete();
        customerManager.giveCredit();

        Company company = new Company();
        company.TaxNumber = "123";
        company.CompanyName = "Bosch";
        company.Id = 10;

        CustomerManager customerManager1 = new CustomerManager(new Person(), new TeacherCreditManager());
        customerManager1.save();
        customerManager1.giveCredit();

        Person person = new Person();
        person.FirstName = "Berk";
        person.Lastname = "Hatipoğlu";
        person.City = "İstanbul";
        person.NationalIdentity = "121";

        Customer c1 = new Customer();
        Customer c2 = new Person();
        Customer c3 = new Company();

        System.out.println();
    }
}

class Customer {
    public int Id;
    public String City;

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public Customer() {
        System.out.println("Müşteri nesnesi başlatıldı");
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}

// Customer'dan kalıtım yapılıyor.
class Person extends Customer {
    public String NationalIdentity;
    public String FirstName;
    public String Lastname;

    public String getNationalIdentity() {
        return NationalIdentity;
    }

    public void setNationalIdentity(String nationalIdentity) {
        NationalIdentity = nationalIdentity;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastName) {
        Lastname = lastName;
    }
}

// Customer'dan kalıtım yapılıyor.
class Company extends Customer {
    public String TaxNumber;
    public String CompanyName;

    public String getTaxNumber() {
        return TaxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        TaxNumber = taxNumber;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

}

class CreditManager {
    public void calculate(int creditType) {
        if (creditType == 1) {
            System.out.println("Öğretmen statüsü için hesaplandı");
        }
        if (creditType == 2) {
            System.out.println("Asker statü için hesaplandı");
        }
    }

    public void save() {
        System.out.println("Kredi verildi");
    }

}

interface ICreditManager {
    void calculate();

    void save();
}

abstract class BaseCreditManager implements ICreditManager {
    public abstract void calculate();

    public void save() {
        System.out.println("Kaydedildi");
    }
}

class TeacherCreditManager extends BaseCreditManager {
    @Override
    public void calculate() {
        System.out.println("Öğretmen kredisi hesaplandı");
    }
}

class MilitaryCreditManager extends BaseCreditManager {
    @Override
    public void calculate() {
        System.out.println("Asker kredisi hesaplandı");
    }
}

class CustomerManager {
    private Customer customer;
    private ICreditManager creditManager;

    public CustomerManager(Customer customer, ICreditManager creditManager) {
        this.customer = customer;
        this.creditManager = creditManager;
    }

    public void save() {
        System.out.println("Müşteri eklendi");
    }

    public void delete() {
        System.out.println("Müşteri silindi");
    }

    public void giveCredit() {
        creditManager.calculate();
        System.out.println("Kredi verildi");
        creditManager.save();
    }
}