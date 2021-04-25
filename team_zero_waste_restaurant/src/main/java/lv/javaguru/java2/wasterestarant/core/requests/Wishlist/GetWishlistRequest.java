package lv.javaguru.java2.wasterestarant.core.requests.Wishlist;

//Nataliya

public class GetWishlistRequest {

    private Long clientID;

    public GetWishlistRequest(Long clientID) {
        this.clientID = clientID;
    }

    public Long getClientID() {
        return clientID;
    }
}
