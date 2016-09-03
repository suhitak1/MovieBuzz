package assignment.edureka.movieapp.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import assignment.edureka.movieapp.model.Movie;

/**
 * Created by suhit_000 on 8/2/2016.
 */
public class MovieAppComparator {

    public static JSONArray sortJSONArray(String jsonString, final String keyName){
        JSONArray sortedJSONArray = new JSONArray();
        try {
            JSONArray jsonArray = new JSONArray(jsonString);

            List<JSONObject> jsonObjects = new ArrayList<JSONObject>();

            for(int i=0; i<jsonArray.length();i++){
                jsonObjects.add(jsonArray.getJSONObject(i));
            }
            Collections.sort(jsonObjects, new java.util.Comparator<JSONObject>() {

                String valA = new String();
                String valB = new String();

                @Override
                public int compare(JSONObject ob1, JSONObject ob2) {
                    try {
                        valA = (String)ob1.get(keyName);
                        valB = (String)ob2.get(keyName);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return -valA.compareTo(valB);
                }
            });

            for (int i=0; i<jsonArray.length();i++){
                sortedJSONArray.put(jsonObjects.get(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sortedJSONArray;
    }

    public static Comparator<Movie> ratingComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie m1, Movie m2) {
            return ((m1.getRating() > m2.getRating()) ? -1 :
                    ((m1.getRating() == m2.getRating()) ? 0 : 1));
        }
    };

}
