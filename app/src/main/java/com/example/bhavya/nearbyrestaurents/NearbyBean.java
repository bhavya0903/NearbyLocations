package com.example.bhavya.nearbyrestaurents;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by Bhavya on 04-09-2017.
 */

public class NearbyBean implements  Comparator<NearbyBean> {


    String PlaceName;

    public Double getRating() {
        return Rating;
    }

    public void setRating(Double rating) {
        Rating = rating;
    }

    Double Rating;


//    public String getRating() {
//        return Rating;
//    }
//
//    public void setRating(String rating) {
//        Rating = rating;
//    }
//




    public String getPlaceName() {
        return PlaceName;
    }

    public void setPlaceName(String placeName) {
        PlaceName = placeName;
    }


    @Override
    public int compare(NearbyBean o1, NearbyBean o2) {
        Double rating1 = o1.getRating();
        Double rating2 = o2.getRating();
        Double rating = rating1 -rating2;
        int diff = rating.intValue();
        return (diff == 0) ? o1.getRating().compareTo(o2.getRating()) : diff;
    }
}
