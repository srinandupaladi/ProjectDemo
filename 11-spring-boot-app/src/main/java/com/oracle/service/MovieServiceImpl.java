 package com.oracle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Component;

import com.oracle.dao.MovieDao;
import com.oracle.entity.Movie;
import com.oracle.exceptiions.ApplicationException;
@Component
public class MovieServiceImpl implements MovieService {
    @Autowired
	private MovieDao movieDao;
	@Override
	public List<Movie> allRunningMoviesService() {
		return movieDao.allRunningMovies();
	}
	@Override
	public Movie searchMovieServiceByCode(int code) {
		List< Movie> movies=movieDao.allRunningMovies();
		Movie m=null;
		try {
			m = movies.stream().
					filter(p->p.getMovieCode()==code).
					findFirst().get();
		} catch (Exception e) {
			e.printStackTrace();
			String msg="The resource "+code+" Not found";
			//re throwing the exception
			throw new ApplicationException(msg);
		}

		return m;
	}

}