package lv.javaguru.java2.wasterestarant.core.services.wishlist;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.wishlist.GetWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.responses.wishlist.GetWishlistResponse;
import lv.javaguru.java2.wasterestarant.core.domain.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

//Nataliya

@RunWith(MockitoJUnitRunner.class)

public class GetWishlistServiceTest {

    @Mock
    private Database database;
    @InjectMocks
    GetWishlistService service;

    @Test
    public void shouldReturnAllDishes() {
        GetWishlistRequest request = new GetWishlistRequest(13L);
        OrderItem orderItem1 = new OrderItem("Risotto with mushrooms", 1);
        OrderItem orderItem2 = new OrderItem("Risotto with shrimps", 1);
        Mockito.when(database.getWishlistByClientID(13L))
                .thenReturn(List.of(orderItem1, orderItem2));
        GetWishlistResponse response = service.execute(request);
        assertEquals(response.getWishlist().size(), 2);
    }

}