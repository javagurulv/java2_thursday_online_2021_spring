package lv.javaguru.java2.wasterestarant.core.services.order;

import lv.javaguru.java2.wasterestarant.core.database.order.OrderRepository;
import lv.javaguru.java2.wasterestarant.core.requests.order.GetAllOrdersRequest;
import lv.javaguru.java2.wasterestarant.core.responses.order.GetAllOrdersResponse;
import lv.javaguru.java2.wasterestarant.core.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GetAllOrdersServiceTest {

    @Mock
    private OrderRepository database;
    @InjectMocks
    GetAllOrdersService service;

    @Test
    public void shouldReturnAllOrders() throws ParseException {
        GetAllOrdersRequest request = new GetAllOrdersRequest();

//        List<OrderItem> wishlist1 = new ArrayList<>();
//        wishlist1.add(0, new OrderItem("Brownie", 1));
//        wishlist1.add(0, new OrderItem("Tea", 1));
//
//        List<OrderItem> wishlist2 = new ArrayList<>();
//        wishlist2.add(0, new OrderItem("Cheese cake", 1));
//        wishlist2.add(0, new OrderItem("Latte", 1));

        Order order1 = new Order(1L, new SimpleDateFormat("dd/MM/yyyy").parse("10/05/2021"));
        Order order2 = new Order(2L, new SimpleDateFormat("dd/MM/yyyy").parse("10/05/2021"));
        Mockito.when(database.getAllOrders())
                .thenReturn(List.of(order1, order2));
        GetAllOrdersResponse response = service.execute(request);
        assertEquals(response.getOrders().size(), 2);
    }


}