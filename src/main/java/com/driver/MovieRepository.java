package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {

    // creating databases
    private HashMap<String, Movie> movieMap;

    private HashMap<String, Director> directorMap;

    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository(){
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMovieMapping = new HashMap<String, List<String>>();
    }

    public void saveMovie(Movie movie) {
        movieMap.put(movie.getName(), movie);
    }

    public void saveDirector(Director director) {
        directorMap.put(director.getName(), director);
    }

    public void saveMovieDirectorPair(String movie, String director) {
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            movieMap.put(movie, movieMap.get(movie));
            directorMap.put(director, directorMap.get(director));
            List<String> currentMovies = new ArrayList<>();
            if(directorMovieMapping.containsKey(director)) currentMovies = directorMovieMapping.get(director);
            currentMovies.add(movie);
            directorMovieMapping.put(director, currentMovies);
        }
    }

    public Movie findMovie(String movieName) {
        return movieMap.get(movieName);
    }

    public Director findDirector(String directorName) {
        return directorMap.get(directorName);
    }

    public List<String> findMoviesFromDirector(String director) {
        List<String> movieList = new ArrayList<>();
        if(directorMovieMapping.containsKey(director))
            movieList = directorMovieMapping.get(director);
        return movieList;
    }

    public List<String> findAllMovie() {
       return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director) {
        List<String> movies = new ArrayList<>();
        if(directorMovieMapping.containsKey(director)){
            movies = directorMovieMapping.get(director);
            for(String movie : movies){
                if(movieMap.containsKey(movie))
                    movieMap.remove(movie);
            }
            directorMovieMapping.remove(director);
        }

        if(directorMap.containsKey(director));
    }

    public void deleteAllDirector() {
        HashSet<String> moviesSet = new HashSet<>();

        for(String director: directorMovieMapping.keySet()){
            for(String movie: directorMovieMapping.get(director))
                moviesSet.add(movie);
        }

        for(String movie: moviesSet){
            if(movieMap.containsKey(movie))
                movieMap.remove(movie);
        }
    }
}
