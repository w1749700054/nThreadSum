package java7_5.chapter2;


import java.util.ArrayList;
import java.util.List;

public class ProductListGenerator {
    public List<Product> generator(int size){
        List<Product> productList=new ArrayList<>();
        for(int i=0;i<size;i++){
            Product product=new Product();
            product.setName("product-"+i);
            product.setPrice(10);
            productList.add(product);
        }
        return productList;
    }
}
