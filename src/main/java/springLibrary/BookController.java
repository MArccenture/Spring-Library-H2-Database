//package springLibrary;
//
//import org.springframework.hateoas.CollectionModel;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.IanaLinkRelations;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
//
////@RestController indicates that the data returned by each method will
////        be written straight into the response body instead of rendering a template.
//@RestController
//public class BookController {
//
//    private final BookRepository repository;
//    private final BookModelAssembler assembler;
//
//    public BookController(BookRepository repository, BookModelAssembler assembler) {
//        this.repository = repository;
//        this.assembler = assembler;
//    }
//
//
//
//    // Single Item
//
////    @GetMapping("/books/{id}")
////    Book one(@PathVariable long id){
////
////        return repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
////    }
//
//    // Single Item using EntityModel from Hateous library (which allows us the constructs to define
//    // a RESTful service and then render it in an acceptable format for client consumption
//    // Links used in version below which link to relevant operations:
//    @GetMapping("/books/{id}")
//    EntityModel<Book> one(@PathVariable long id) { //Pathbariable = /books/id
//        Book book = repository.findById(id)
//                .orElseThrow(() -> new BookNotFoundException(id));
//
////        EntityModel<T> is a generic container from Spring
////        HATEOAS that includes not only the data but a collection of links.
//
//        /*return EntityModel.of(book,
//                // the following asks that Spring HATEOAS build a link to the BookController's one() method,
//                // flagged as a self link:
//                linkTo(methodOn(BookController.class).one(id)).withSelfRel(),
//                // the last link asks that Spring HATEOAS build a link to the aggregate root, all(), and
//                // call it books
//                linkTo(methodOn(BookController.class).all()).withRel("books"));*/
//        return assembler.toModel(book);
//// Links include a URI and a relation
//        // Using links the output, the decompressed output shows not only the data elements you saw earlier
//        // (id, name and role), but also a _links entry containing two URIs.
//        // This entire document is formatted using HAL. HAL is a mediatype that allows
//        // for encoding data along with hypermedia controls which alert consumers to other
//        // parts of the API they can navigate toward e.g there is a self link along with a link
//        // back to the aggregate root.
//    }
//
//    // Turn all() aggregate root method into more restful below:
////    @GetMapping("/books")
////    List<Book> all(){
////        return repository.findAll();
////    }
//    @GetMapping("/books")
//    //    CollectionModel<> is another Spring HATEOAS container; it’s aimed at encapsulating
////    collections of book resources—instead of a single resource entity, like EntityModel<>
////    from earlier. CollectionModel<>, too, lets you include links.
//    CollectionModel<EntityModel<Book>> all() {
//
//        List<EntityModel<Book>> books = repository.findAll().stream()
//               /* .map(book -> EntityModel.of(book,
////^ so you fetch all the books then you must map them into a list of <EntityModel<Book>> objects
//                        linkTo(methodOn(BookController.class).one(book.getBookId())).withSelfRel(),
//                        linkTo(methodOn(BookController.class).all()).withRel("books")))*/
//                .map(assembler::toModel)
//                .collect(Collectors.toList());
//
//        return CollectionModel.of(books,
//                linkTo(methodOn(BookController.class).all()).withSelfRel());
//
//    }
//
//
//    @PutMapping("/books/{id}")
//    ResponseEntity<EntityModel<Book>> updateBook(@RequestBody Book newBook,
//                    @PathVariable Long id){
//        Book updatedBook = repository.findById(id)
//                .map(book -> {
//                    book.setName(newBook.getName());
//                    book.setBookId(newBook.getBookId());
//                    book.setBookTitle(newBook.getBookTitle());
//                    book.setBookAuthor(newBook.getBookAuthor());
//                    book.setPrice(newBook.getPrice());
//                    book.setPublicationYear(newBook.getPublicationYear());
//                    return repository.save(book);
//                })
//                .orElseGet(() ->{
//                    newBook.setBookId(id);
//                    return repository.save(newBook);
//                });
//        EntityModel<Book> entityModel = assembler.toModel(updatedBook);
//        return ResponseEntity//
//                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
//   //Since we want a more detailed HTTP response code than 200 OK, we
//                // will use Spring MVC’s ResponseEntity wrapper.
//                // It has a handy static method created() where we can
//                // plug in the resource’s URI.
//                .body(entityModel);
//
//    }
//
//    @PostMapping("/books")
//    ResponseEntity<?> newBook(@RequestBody Book newBook) {
//
//        EntityModel<Book> entityModel = assembler.toModel(repository.save(newBook));
//        //return repository.save(newBook);
////        Spring MVC’s ResponseEntity is used to create an HTTP 201 Created status message.
////                This type of response typically includes a Location response header, and
////        we use the URI derived from the model’s self-related link.
//        // Additionally, return the model-based version of the saved object.
//        return ResponseEntity
//                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
//                .body(entityModel);
//    }
//
//}
