package lv.javaguru.java2.wasterestarant.core.requests.product;
//AndrejsB
public class RemoveProductRequest {

    private String productNameToRemove;

    public RemoveProductRequest(String productNameToRemove) {
        this.productNameToRemove = productNameToRemove;
    }

    public String getProductNameToRemove() {
        return productNameToRemove;
    }
}