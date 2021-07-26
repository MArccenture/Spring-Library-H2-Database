//package springLibrary;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
////Indicates that a class declares one or more @Bean methods and may be processed by the
//// Spring container to generate
//// bean definitions and service requests for those beans at runtime, for example:
//@Configuration
//public class LoadDatabase {
//
//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//   // Spring Boot will run ALL CommandLineRunner beans once the application context is loaded.
//    //This runner will request a copy of the EmployeeRepository you just created.
////   Using it, it will create two entities and store them.
//    @Bean
//    CommandLineRunner initDatabase(BookRepository repository){
//        return args -> {
//            log.info("Preloading " + repository.save(new Book("Mobys Dick", "Herman", 1999, 10.00)));
//            log.info("Preloading " + repository.save(new Book("Fiestas", "Ernest Hemingway", 1890, 5.00)));
//
//         };
//    }
//
//
//}
