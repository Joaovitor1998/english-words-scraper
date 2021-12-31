package com.joaovitor.newsscraper.exceptions;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundError.class)
    public ModelAndView NotFoundExceptionHandler(NotFoundError e, HttpServletResponse res) {
        String word = e.getWord();
        String message = "Couldn't find the word \"" + word + "\".";
        String details = "Try searching it somewhere else. It may be a proper name.";
        NotFoundErrorDetails notFoundDetails = new NotFoundErrorDetails(
                word, message, details);

        res.addHeader("Not-Found", "Word \"" + word + "\" couldn't be found.");

        ModelAndView mav = new ModelAndView();
        mav.addObject("notFound", notFoundDetails);
        mav.setViewName("wordNotFound");
        return mav;
    }
}
