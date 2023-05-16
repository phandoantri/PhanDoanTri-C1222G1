package com.example.ss9_muon_sach.controller;

import com.example.ss9_muon_sach.exception.ExceptionWhenBorrowError;
import com.example.ss9_muon_sach.exception.ExceptionWhenPayError;
import com.example.ss9_muon_sach.model.Order;
import com.example.ss9_muon_sach.model.Book;
import com.example.ss9_muon_sach.service.IOrderService;
import com.example.ss9_muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IOrderService iOrderService;

    @GetMapping()
    public String showListSach(Model model) {
        model.addAttribute("bookList", iBookService.getAll());
        return "/book/list";
    }

    @GetMapping("/{id}/borrow")
    public String borrowBook(@PathVariable int id) throws ExceptionWhenBorrowError {
        Book book = iBookService.finById(id);
        if (book.getQuantity() == 0) {
            throw new ExceptionWhenBorrowError();
        }
        book.setQuantity(book.getQuantity() - 1);
        Order order = new Order();
        int code;
        do {
            code = (int) (Math.random() * (99999 - 10000) + 10000);
        } while (iOrderService.findByCode(code)!=false);
        order.setCode(code);
        long time = System.currentTimeMillis();
        order.setDate(new java.sql.Date(time));
        List<Order> orderList = book.getOrderList();
        orderList.add(order);
        book.setOrderList(orderList);
        iOrderService.save(order);
        iBookService.save(book);
        return "redirect:/books";
    }

    @ExceptionHandler(ExceptionWhenBorrowError.class)
    public String handleException(Exception exception) {
        return "/book/whenBorrowError";
    }

    @GetMapping("/{id}/pay")
    public String payForm(@PathVariable int id, Model model) {
        model.addAttribute("code", iBookService.finById(id));
        return "/book/checkCode";
    }

    @GetMapping("/payBook")
    public String payBook(@RequestParam(value = "code") int code, @RequestParam(value = "id") int id) throws ExceptionWhenPayError {
        List<Order> orderList = iOrderService.getAll();
        Book book = iBookService.finById(id);
        if (iOrderService.findByCode(code) == true) {
            book.setQuantity(book.getQuantity() + 1);
            iBookService.save(book);
            return "redirect:/books";
        }
        throw new ExceptionWhenPayError();
    }

    @ExceptionHandler(ExceptionWhenPayError.class)
    public String ExceptionWhenError(Exception exception) {
        return "/book/whenPayError";
    }

}
