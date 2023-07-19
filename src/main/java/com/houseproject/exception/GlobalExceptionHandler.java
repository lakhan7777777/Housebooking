package com.houseproject.exception;




import com.houseproject.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
@ControllerAdvice//When you annotate a class with @ControllerAdvice, it acts as a global exception handler for all the controllers in your Spring application
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {//any exception in the blog it will go to this blos .. it act like a catch block



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


//This code defines a class named GlobalExceptionHandler that is annotated with @ControllerAdvice. This annotation tells Spring that this class contains exception handling logic for all controllers in the application.
//
//The GlobalExceptionHandler class extends the ResponseEntityExceptionHandler class provided by Spring, which contains several methods for handling common exceptions that may be thrown by controllers.
//
//The @ExceptionHandler annotation is used to define methods that handle specific exceptions. In this code, there are two such methods.
//
//The first method handles the ResourceNotFoundException exception. When this exception is thrown, the handleResourceNotFoundException method is called. The method takes two arguments: the exception object and a WebRequest object. The ErrorDetails object is then created with the exception message, a description of the request, and the current date. Finally, the ResponseEntity is returned with the ErrorDetails object and a HttpStatus of NOT_FOUND.
//
//The second method handles all other exceptions that are not handled by the first method. When any other exception is thrown, the handleGlobalException method is called. It takes the same arguments as the first method and creates an ErrorDetails object with the exception message, a description of the request, and the current date. The ResponseEntity is then returned with the ErrorDetails object and a HttpStatus of INTERNAL_SERVER_ERROR.
//
//Overall, this code provides a centralized location for handling exceptions thrown by controllers in the application. The GlobalExceptionHandler class can handle specific exceptions and provide a customized response to the client.
//
//
//
//
//2jr18cs030Lakhan Rajput
//This annotation tells Spring that this class contains exception handling logic for all controllers in the application. not able to understand this
//When you annotate a class with @ControllerAdvice, it acts as a global exception handler for all the controllers in your Spring application. This means that any exceptions that are thrown from any controller in your application will be intercepted by this class.
