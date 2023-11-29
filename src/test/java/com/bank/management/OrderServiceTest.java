package com.bank.management;

import com.bank.management.entity.CommandOrder;
import com.bank.management.repository.CommandOrderRepository;
import com.bank.management.service.CommandOrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderServiceTest {

    @Mock
    private CommandOrderRepository orderRepository;

    @InjectMocks
    private CommandOrderService orderService = new CommandOrderService();

    @BeforeEach
    void setMockData() {
        List<CommandOrder> mockOrders = new ArrayList<>();
        mockOrders.add(new CommandOrder());
        when(orderRepository.findAll()).thenReturn(mockOrders);
    }

    @DisplayName("Test orderService and repository")
    @Test
    void testGetAllOrders() {
        assertEquals(1, orderService.getAllOrders().size());
    }
}
