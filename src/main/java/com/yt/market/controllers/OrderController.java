package com.yt.market.controllers;

import com.yt.market.entities.Order;
import com.yt.market.entities.User;
import com.yt.market.services.OrderService;
import com.yt.market.services.UserService;
import com.yt.market.utils.Cart;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private UserService userService;
    private OrderService orderService;
    private Cart cart;

    @GetMapping
    public String showAllOrders(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        List<Order> orders = orderService.findAllByUserId(user.getId());
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/create")
    public String showOrderPage(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "create_order";
    }

    @PostMapping("/confirm")
    @ResponseBody
    public String confirmOrder(Principal principal,
                               @RequestParam(name = "address") String address,
                               @RequestParam(name = "receiver_name") String receiverName,
                               @RequestParam(name = "phone_number") String phone) {
        User user = userService.findByUsername(principal.getName());
        Order order = new Order(user, cart, address);
        orderService.save(order);
        return "Ваш заказ #" + order.getId();
    }
}
