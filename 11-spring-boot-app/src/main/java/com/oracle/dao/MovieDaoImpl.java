 package com.oracle.dao;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.oracle.entity.Movie;
import com.oracle.entity.Review;
@Component
public class MovieDaoImpl implements MovieDao{
	
List<Movie> movies= new ArrayList<>();
{
	//Assume these data pulled from the DB
	//JDBC to be used.....
	Review r1= new Review(991, "MR. A", "Brilliant Movie", 4.5f);
	Review r2= new Review(992, "MR. B", "Excellent", 4.8f);
	Review r3= new Review(993, "MR. C", "Good Movie", 4.6f);
	Review r4= new Review(995, "MR. D", "Nice Movie", 4.9f);
	List<Review> rList1=new ArrayList<>();
	rList1.add(r1);
	rList1.add(r2);
	List<Review> rList2=new ArrayList<>();
	rList2.add(r3);
	rList2.add(r4);
	movies.add(new Movie(101, "Jawan", "Hindi", "Action",rList1));
	movies.add(new Movie(102, "Fast and Furious", "English", "Action",rList2));
	movies.add(new Movie(103, "Interstellar", "English", "SCIFI",rList1));
	movies.add(new Movie(104, "Gravity",  "English", "SCIFI",rList2));
	movies.add(new Movie(105, "Jurasic World", "English", "Adventure",rList1));
}
	@Override
	public List<Movie> allRunningMovies() {
		return movies;
	}

}
