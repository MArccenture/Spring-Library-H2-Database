package springLibrary.controllers;

import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springLibrary.domain.Basket;
import springLibrary.repositories.BasketRepository;
import springLibrary.repositories.BookRepository;

@Controller
public class BasketController {
    private final BasketRepository basketRepository;
    private final BookRepository bookRepository;

    public BasketController(BasketRepository basketRepository, BookRepository bookRepository) {
        this.basketRepository = basketRepository;
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/basket")
    public String getBasket(Model model) {
        model.addAttribute("basket", basketRepository.findAll());

        return "basket/list";
    }



    @PostMapping("/basket/addBook")
    Basket newBook(@RequestBody Basket newBook) {
        return basketRepository.save(newBook);
    }

// Model object used in the form to expose a new Book view template
//    @PostMapping("/addToBasket")
//    //public Basket addToBasket(@RequestBody Basket newBook) {
//        public String addToBasketSubmit(@ModelAttribute Basket book, Model model) {
//        model.addAttribute("addToBasket", book);
//        return "list";
//
//        //return basketRepository.save(newBook);
//    }
//
//    @GetMapping("/addToBasket")
//    public String greetingForm(Model model) {
//        model.addAttribute("addToBasket", new Basket());
//        return "list";
//    }

    @RequestMapping(value = "/addToBasket", method = RequestMethod.GET)
    public ModelAndView showBasket() {
        System.out.println("get method used");
        return new ModelAndView("list", "basket", new Basket());
    }

    @RequestMapping(value = "/addToBasket", method = RequestMethod.POST)
    public
    String addBookToBasket(@ModelAttribute("basket") Basket basket,
                           ModelMap model) {
//        if (result.hasErrors()) {
//            return "error";
//        }
//        model.addAttribute("bookTitle", basket.getBookTitle());
//        model.addAttribute("authorName", basket.getAuthor());
//
//        return "employeeView";
        System.out.println("post method used");
        basketRepository.save(basket);
        model.addAttribute("basket", basketRepository.findAll());

        // return "Hello test : " + basket + basketRepository.findAll().toString();
        return "basket/list";
    }

    @DeleteMapping("/basket/delete/{basketId}")
     String deleteBook(@PathVariable  Long basketId, Model model) {
        System.out.println("Delte mapping : " + basketId);
        if (basketRepository.existsById(basketId)){
            basketRepository.deleteById(basketId);
        }
        else {
            System.out.println("Item does not exist!");
        };
        //basketRepository.save(basket);
        model.addAttribute("basket", basketRepository.findAll());
        return "basket/list";
    }

    @GetMapping("/basket/delete/{basketId}")
    public String deleteItem(@PathVariable Long basketId,Model model) {
        System.out.println("Get mapping : " + basketId);
        Basket basketItem = basketRepository.findById(basketId)
                .orElseThrow();
        basketRepository.delete(basketItem);

        model.addAttribute("basket", basketRepository.findAll());

        return "basket/list";
    }

}
