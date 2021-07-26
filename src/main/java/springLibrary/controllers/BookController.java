package springLibrary.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springLibrary.repositories.BookRepository;

@Controller
public class BookController {
    private  final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



    @RequestMapping("/books")
    public String getBooks(Model model){
        System.out.println("FindAll BP: " + bookRepository.findAll());
        model.addAttribute("books", bookRepository.findAll());

        return "books/list";
    }
}
