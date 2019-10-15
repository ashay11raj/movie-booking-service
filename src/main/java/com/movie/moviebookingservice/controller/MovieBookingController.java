package com.movie.moviebookingservice.controller;


import com.movie.moviebookingservice.model.City;
import com.movie.moviebookingservice.model.SelectedSeat;
import com.movie.moviebookingservice.service.MovieBookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moviebookingapi")
public class MovieBookingController {
    Logger logger = LoggerFactory.getLogger(MovieBookingController.class);

    @Autowired
    MovieBookingService movieBookingService;

    @RequestMapping(path = "/getmovies", method = RequestMethod.GET)
    public List<City> getMovies()
    {
        logger.info("inside MovieBookingController getMovie method");
        return movieBookingService.getAllMoviesForAllCities();
    }

    @RequestMapping(path = "/bookmovie", method = RequestMethod.POST)
    public @ResponseBody SelectedSeat bookMovie(@RequestBody SelectedSeat selectedSeat)
    {
        logger.info("inside MovieBookingController bookMovie method");

        return movieBookingService.bookSelectedSeat(selectedSeat);
    }
}
