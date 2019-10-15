package com.movie.moviebookingservice.service.impl;

import com.movie.moviebookingservice.model.*;
import com.movie.moviebookingservice.service.MovieBookingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.*;

@Service
public class MovieBookingServiceImpl implements MovieBookingService {
    private static final List<City> allMoviesForAllCities = createDummyData();
    @Override
    public List<City> getAllMoviesForAllCities(){
        return this.allMoviesForAllCities;
    }

    private static List<City> createDummyData() {
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

    private static List<Theater> getTheaterList() {
        ArrayList<String> theaterNameList = new ArrayList<String>(Arrays.asList("PVR", "INOX", "EROS", "Cinemax"));
        final int[] theaterId = {0};
        ArrayList<Theater> theaterList = new ArrayList<>(theaterNameList.size());
        theaterNameList.forEach(theater -> {
            List<Show> showList = getShowList();
            theaterList.add(new Theater(theater, ++theaterId[0], showList));
        });
        return theaterList;
    }

    private static List<Show> getShowList() {
        ArrayList<String> showNameList = new ArrayList<String>(Arrays.asList("Movie-1[9AM]", "Movie-2[12PM]", "Movie-3[3PM]", "Movie-4[6PM]"));
        final int[] showId = {0};
        ArrayList<Show> showList = new ArrayList<>(showNameList.size());
        showNameList.forEach(show -> {
            List<Seat> seatList = getSeatList();
            showList.add(new Show(show, ++showId[0], seatList));
        });
        return showList;
    }

    private static ArrayList<Seat> getSeatList() {
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

    public SelectedSeat bookSelectedSeat(SelectedSeat selectedSeat){
        String seatNotBooked = "Not Booked";
        City c = getAllMoviesForAllCities().stream().filter(city -> city.getCityId() == selectedSeat.getCityId()).findFirst().get();
        if(c == null){
            selectedSeat.setBookingStatus(seatNotBooked);
        } else{
            Theater t = c.getTheaterList().stream().filter(theater -> theater.getTheaterId() == selectedSeat.getTheaterId()).findFirst().get();
            if(t == null){
                selectedSeat.setBookingStatus(seatNotBooked);
            } else{
                Show s = t.getShowList().stream().filter(show -> show.getShowId() == selectedSeat.getShowId()).findFirst().get();
                if(s == null){
                    selectedSeat.setBookingStatus(seatNotBooked);
                } else{
                    Seat s1 = s.getSeatList().stream().filter(seat -> seat.getSeatNumber() == selectedSeat.getSeatNumber()).findFirst().get();
                    if(s1 == null){
                        selectedSeat.setBookingStatus(seatNotBooked);
                    } else{
                        if(s1.getBookingStatus().equals("inprogress")){
                            selectedSeat.setBookingStatus("not booked. As, some other user is booking the same seat");
                        } else{
                            s1.setBookingStatus("inprogress");
                            try {
                                // User is completing payment
                                sleep(60000);
                                String seatBooked = "booked";
                                s1.setBookingStatus(seatBooked);
                                selectedSeat.setBookingStatus(seatBooked);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

        return selectedSeat;
    }
}
