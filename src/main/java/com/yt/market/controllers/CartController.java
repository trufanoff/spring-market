package com.yt.market.controllers;

import com.yt.market.utils.Cart;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {
    private Cart cart;

    @GetMapping
    public String showCartPage() {
        return "cart";
    }

    @GetMapping("/add/{product_id}")
    public void addToCart(
            @PathVariable(name = "product_id") Long productId,
            HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        cart.addOrIncrement(productId);
        response.sendRedirect(request.getHeader("referer"));
    }

    @GetMapping("/dec/{product_id}")
    public String decrementOrRemoveProduct(@PathVariable(name = "product_id") Long productId) {
        cart.decrementOrRemove(productId);
        return "redirect:/cart";
    }

    @GetMapping("/remove/{product_id}")
    public String removeProduct(@PathVariable(name = "product_id") Long productId) {
        cart.remove(productId);
        return "redirect:/cart";
    }
}
