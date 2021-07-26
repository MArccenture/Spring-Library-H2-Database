//package springLibrary;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
////Any class annotated with @ControllerAdvice becomes a controller-advice and three
//// types of method are supported:
////
////        Exception handling methods annotated with @ExceptionHandler.
////        Model enhancement methods (for adding additional data to the model) annotated with
////@ModelAttribute. Note that these attributes are not available to the exception handling views.
////        Binder initialization methods (used for configuring form-handling) annotated with
////@InitBinder.
//@ControllerAdvice
//public class BookNotFoundAdvice {
////    @ResponseBody signals that this advice is rendered straight into the response body.
////
////    @ExceptionHandler configures the advice to only respond if an EmployeeNotFoundException is thrown.
////
////    @ResponseStatus says to issue an HttpStatus.NOT_FOUND, i.e. an HTTP 404.
//
//
//    @ResponseBody
//    @ExceptionHandler(BookNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    String bookNotFoundHandler(BookNotFoundException exception){
//       // The body of the advice generates the content.
//        // In this case, it gives the message of the exception.
//        return exception.getMessage();
//    }
//}
