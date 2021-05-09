package lv.javaguru.java2.wasterestarant.core.services.acceptancetests;


import lv.javaguru.java2.wasterestarant.config.RestaurantApplicationConfiguration;
import lv.javaguru.java2.wasterestarant.core.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.wasterestarant.core.requests.wishlist.AddDishToWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.requests.wishlist.GetWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.responses.wishlist.GetWishlistResponse;
import lv.javaguru.java2.wasterestarant.core.services.wishlist.AddDishToWishlistService;
import lv.javaguru.java2.wasterestarant.core.services.wishlist.GetWishlistService;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIApplicationContextBuilder;
import lv.javaguru.java2.wasterestarant.domain.Cart;
import lv.javaguru.java2.wasterestarant.domain.Client;
import lv.javaguru.java2.wasterestarant.domain.OrderItem;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

//Nataliya

public class AcceptanceTest4 {

    private ApplicationContext applicationContext;

    @Before
    public void setup() {
        applicationContext = new AnnotationConfigApplicationContext(RestaurantApplicationConfiguration.class);
    }

    private Client client1;
    private Client client2;

    @Test
    public void getWishlists() {

        List<OrderItem> wishlist1 = new ArrayList<>();
        List<OrderItem> wishlist2 = new ArrayList<>();

        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        cart1.setClientsWishlist(wishlist1);
        cart2.setClientsWishlist(wishlist2);

        client1 = new Client("Oleg", cart1);
        client2 = new Client("Max", cart2);

        getInMemoryDatabaseImpl().save(client1);
        getInMemoryDatabaseImpl().save(client2);

        AddDishToWishlistRequest request1 =
                new AddDishToWishlistRequest(1L, "Tomato soup", 1);

        AddDishToWishlistRequest request2 =
                new AddDishToWishlistRequest(2L, "Hot chicken salad", 1);

        AddDishToWishlistRequest request3 =
                new AddDishToWishlistRequest(1L, "Pasta with shrimps", 1);

        AddDishToWishlistRequest request4 =
                new AddDishToWishlistRequest(2L, "Filet mignon", 1);

        AddDishToWishlistRequest request5 =
                new AddDishToWishlistRequest(2L, "Fried potatoes", 1);

        AddDishToWishlistRequest request6 =
                new AddDishToWishlistRequest(1L, "Cheese cake", 1);

        AddDishToWishlistRequest request7 =
                new AddDishToWishlistRequest(2L, "Brownie", 1);

        getAddDishToWishlistService().execute(request1);
        getAddDishToWishlistService().execute(request2);
        getAddDishToWishlistService().execute(request3);
        getAddDishToWishlistService().execute(request4);
        getAddDishToWishlistService().execute(request5);
        getAddDishToWishlistService().execute(request6);
        getAddDishToWishlistService().execute(request7);

        GetWishlistResponse wishlistResponse1 = getWishlistService().execute(new GetWishlistRequest(1L));
        GetWishlistResponse wishlistResponse2 = getWishlistService().execute(new GetWishlistRequest(2L));

        assertEquals(wishlistResponse1.getWishlist().get(0).getDishName(), "Tomato soup");
        assertEquals(wishlistResponse1.getWishlist().get(1).getDishName(), "Pasta with shrimps");
        assertEquals(wishlistResponse1.getWishlist().get(2).getDishName(), "Cheese cake");
        assertEquals(wishlistResponse1.getWishlist().get(2).getQuantity(), 1);

        assertEquals(wishlistResponse2.getWishlist().get(0).getDishName(), "Hot chicken salad");
        assertEquals(wishlistResponse2.getWishlist().get(1).getDishName(), "Filet mignon");
        assertEquals(wishlistResponse2.getWishlist().get(2).getDishName(), "Fried potatoes");
        assertEquals(wishlistResponse2.getWishlist().get(3).getDishName(), "Brownie");
        assertEquals(wishlistResponse2.getWishlist().get(3).getQuantity(), 1);
    }

    private InMemoryDatabaseImpl getInMemoryDatabaseImpl() {
        return applicationContext.getBean(InMemoryDatabaseImpl.class);
    }


    private AddDishToWishlistService getAddDishToWishlistService() {
        return applicationContext.getBean(AddDishToWishlistService.class);
    }

    private GetWishlistService getWishlistService() {
        return applicationContext.getBean(GetWishlistService.class);
    }

}
