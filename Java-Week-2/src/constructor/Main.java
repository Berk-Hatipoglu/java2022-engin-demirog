package constructor;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------------");



        Product product = new Product(1,"MacBook","Laptop",4,"Uzay Grisi");

        ProductManager productManager = new ProductManager();

        productManager.Add(product);

        System.out.println("--------------------------------------");
    }
}
