 package com.oracle.service;

import java.util.List;

import com.oracle.entity.Movie;

public interface MovieService {
	List<Movie> allRunningMoviesService();
	Movie searchMovieServiceByCode(int code);

}