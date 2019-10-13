package com.movie.moviebookingservice.service.impl;

import com.movie.moviebookingservice.model.City;
import com.movie.moviebookingservice.model.Seat;
import com.movie.moviebookingservice.model.Show;
import com.movie.moviebookingservice.model.Theater;
import com.movie.moviebookingservice.service.MovieBookingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieBookingServiceImpl implements MovieBookingService {
    List<City> allMoviesForAllCities = createDummyData();
    @Override
    public List<City> getAllMoviesForAllCities(){

        return allMoviesForAllCities;
    }

    private List<City> createDummyData() {
        ArrayList<String> cityNameList = new ArrayList<String>(Arrays.asList("Mumbai", "Delhi", "Pune"));
        //ArrayList<Seat> seatList = getSeatList();
        final int[] cityId = {0};
        ArrayList<City> allMoviesForAllCities = new ArrayList<>(cityNameList.size());
        cityNameList.forEach(city -> {
            List<Theater> theaterList = getTheaterList();
            allMoviesForAllCities.add(new City(city, ++cityId[0], theaterList));
        });
        return allMoviesForAllCities;
    }

    private List<Theater> getTheaterList() {
        ArrayList<String> theaterNameList = new ArrayList<String>(Arrays.asList("PVR", "INOX", "EROS", "Cinemax"));
        final int[] theaterId = {0};
        ArrayList<Theater> theaterList = new ArrayList<>(theaterNameList.size());
        theaterNameList.forEach(theater -> {
            List<Show> showList = getShowList();
            theaterList.add(new Theater(theater, ++theaterId[0], showList));
        });
        return theaterList;
    }

    private List<Show> getShowList() {
        ArrayList<String> showNameList = new ArrayList<String>(Arrays.asList("Movie-1[9AM]", "Movie-2[12PM]", "Movie-3[3PM]", "Movie-4[6PM]"));
        final int[] showId = {0};
        ArrayList<Show> showList = new ArrayList<>(showNameList.size());
        showNameList.forEach(show -> {
            List<Seat> seatList = getSeatList();
            showList.add(new Show(show, ++showId[0], seatList));
        });
        return showList;
    }

    private ArrayList<Seat> getSeatList() {
        ArrayList<Seat> seatList = new ArrayList<>(20);
        ArrayList<String> bookingStatusList = new ArrayList<String>(Arrays.asList("booked", "available", "inprogress"));
        for(int i=0; i<20; i++){
            Seat seat = new Seat(i+1);
            int bookingStatusListLen = bookingStatusList.size();
            String randomStatus = bookingStatusList.get((int) Math.floor(Math.random() * bookingStatusListLen));
            seat.setBookingStatus(randomStatus);
            seatList.add(seat);
        }
        return seatList;
    }
}
