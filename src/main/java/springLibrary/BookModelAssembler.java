//package springLibrary;
//
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
//
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.RepresentationModelAssembler;
//import org.springframework.stereotype.Component;
////Before we can understand the value of @Component,
//// we must first understand a little bit about the Spring ApplicationContext.
//// This is where Spring holds instances of objects that it has identified to
//// be managed and distributed automatically. These are called beans. Bean management
//// and the opportunity for dependency injection are some of Spring's main features.
////
////        Using the Inversion of Control principle, Spring collects bean instances
////        from our application and uses them at the appropriate time. We can show
////        bean dependencies to Spring without needing to handle the setup and instantiation
////        of those objects.
////
////        The ability to use annotations like @Autowired to inject Spring-managed
////        beans into our application is a driving force for creating powerful
////        and scalable code in Spring.
////
////        So, how do we tell Spring about the beans we would like for it to
////        manage for us? We should take advantage of Spring's automatic bean
////        detection by using stereotype annotations on our classes.
//
////@Component is an annotation that allows Spring to automatically detect our custom beans.
////
////        In other words, without having to write any explicit code, Spring will:
////
////        Scan our application for classes annotated with @Component
////Instantiate them and inject any specified dependencies into them
////        Inject them wherever needed
//// NB: @Controller, @Service @Repository are all types of the generalised @Component tag
//@Component
// class BookModelAssembler implements RepresentationModelAssembler<Book, EntityModel<Book>> {
//
//    @Override
//    public EntityModel<Book> toModel(Book bookEntity) {
//        return EntityModel.of(bookEntity,
//
//                linkTo(methodOn(BookController.class).one(bookEntity.getBookId())).withSelfRel(),
//                linkTo(methodOn(BookController.class).all()).withRel("books"));
//    }
//}
////    This simple interface has one method: toModel().
////        It is based on converting a non-model object
////        (Book) into a model-based object (EntityModel<Book>).
////        All the code you saw earlier in the controller can be moved into this class.
////        And by applying Spring Framework’s @Component annotation,
////        the assembler will be automatically created when the app starts.