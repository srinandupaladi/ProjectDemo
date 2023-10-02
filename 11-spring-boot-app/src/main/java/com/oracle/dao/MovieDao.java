package com.oracle.dao;

import java.util.List;

import com.oracle.entity.Movie;

public interface MovieDao {
List<Movie> allRunningMovies();
}