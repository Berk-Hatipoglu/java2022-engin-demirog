package encapsulation;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------------");



        Product product = new Product();

        product.setId(0);
        product.setName("MacBook Pro");
        product.setDescription("Laptop");
        product.setPrice(25.489);
        product.setStock(4);


        ProductManager productManager = new ProductManager();
        productManager.Add(product);



        System.out.println("--------------------------------------");
    }

}
