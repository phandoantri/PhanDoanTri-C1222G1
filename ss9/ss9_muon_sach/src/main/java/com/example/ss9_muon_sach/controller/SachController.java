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
@RequestMapping("/sach")
public class SachController {
    @Autowired
    private IBookService iSachService;
    @Autowired
    private IOrderService iNguoiMuonService;

    @GetMapping()
    public String showListSach(Model model) {
        model.addAttribute("bookList", iSachService.getAll());
        return "/sach/list";
    }

    @GetMapping("/{id}/muon")
    public String muonSach(@PathVariable int id) throws ExceptionWhenBorrowError {
        Book book = iSachService.finById(id);
        if (book.getQuantity() == 0) {
            throw new ExceptionWhenBorrowError();
        }
        book.setQuantity(book.getQuantity() - 1);
        Order order = new Order();
        int code = (int) (Math.random() * (99999 - 10000) + 10000);
        order.setCode(code);
        long time = System.currentTimeMillis();
        order.setDate(new java.sql.Date(time));
        List<Order> orderList = book.getOrderList();
        orderList.add(order);
        book.setOrderList(orderList);
        iNguoiMuonService.save(order);
        iSachService.save(book);
        return "redirect:/sach";
    }

    @ExceptionHandler(ExceptionWhenBorrowError.class)
    public String handleException(Exception exception) {
        return "/sach/whenBorrowError";
    }

    @GetMapping("/{id}/tra")
    public String traForm(@PathVariable int id, Model model) {
        model.addAttribute("code",iSachService.finById(id));
        return "/sach/checkCode";
    }

    @GetMapping("/traSach")
    public String traSach(@RequestParam(value = "ma") int ma,@RequestParam(value = "id")int id) throws ExceptionWhenPayError {
        List<Order> orderList = iNguoiMuonService.getAll();
        Book book = iSachService.finById(id);
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getCode() == ma) {
                book.setQuantity(book.getQuantity()+1);
                iSachService.save(book);
                return "redirect:/sach";
            }
        }
        throw new ExceptionWhenPayError();
    }

    @ExceptionHandler(ExceptionWhenPayError.class)
    public String ExceptionWhenError(Exception exception) {
        return "/sach/whenPayError";
    }

}
