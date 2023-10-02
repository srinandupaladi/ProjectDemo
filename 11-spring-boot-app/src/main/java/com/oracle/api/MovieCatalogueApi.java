package com.oracle.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.entity.Movie;
import com.oracle.entity.Review;
import com.oracle.service.MovieService;

//This REST api also  a bean
//Spring shud create the obj,
//We need to configure it
@RestController
@RequestMapping("/movies")
public class MovieCatalogueApi {
	@Autowired
	private MovieService movieService;
//	@GetMapping(produces = "text/html")//MIME
	public String testApi() {
		return "<font color=blue size=10>Api is working</font>";
	}
	/*@GetMapping("/sample")
	public Movie testMovie() {
		return new Movie(1001, "Jawan", "Hindi", "Action",);
	}*/
	@GetMapping
	public List<Movie> allMovies(){
		return movieService.allRunningMoviesService();
	}
	@GetMapping("/{movieCode}")
	public Movie searchByMovieCode( @PathVariable("movieCode") int mCode) {
		return movieService.searchMovieServiceByCode(mCode);
	}
	@PutMapping("/{mCode}")
	public List<Movie> updateMovie(@PathVariable int mCode,@RequestBody Movie m){
		List<Movie> movies=movieService.allRunningMoviesService();
		boolean flag=false;
		int i=0;
		for(;i<movies.size();i++)
		{
			if(movies.get(i).getMovieCode()==mCode) {
				flag=true;
				break;
			}
				
		}
		if(flag) {
			movies.set(i, m);
			
		}
		return movies;
		
	}
	@DeleteMapping("/{mCode}")
	public List<Movie> deleteMovie(@PathVariable int mCode){
		List<Movie> movies=movieService.allRunningMoviesService();
		boolean flag=false;
		int i=0;
		for(;i<movies.size();i++)
		{
			if(movies.get(i).getMovieCode()==mCode) {
				flag=true;
				break;
			}
				
		}
		if(flag) {
			movies.remove(i);
			
		}

		return movies;
	
		
	}
	@PostMapping("/{mCode}")
	public List<Movie> insertMovie(@RequestBody Movie m){
		List<Movie> movies=movieService.allRunningMoviesService();
		movies.add(m);
		return movies;
		
				
	}
	@GetMapping("/{movieCode}/reviews")
	public List<Review> searchByMovieCodeWithRiew(@PathVariable("movieCode") int mcode) {
		List<Movie> movies=movieService.allRunningMoviesService();
		List<Review> lr;
		boolean flag=false;
		int i=0;
		for(;i<movies.size();i++)
		{
			if(movies.get(i).getMovieCode()==mcode) {
				flag=true;
				break;
			}
				
		}
		lr=movies.get(i).getReviews();
			
	
		return lr;
	}
	@GetMapping("/{movieCode}/reviews/{revid}")
	public Review searchByMovieCodeForReview(@PathVariable("movieCode") int mcode,@PathVariable int revid) {
		List<Movie> movies=movieService.allRunningMoviesService();
		List<Review> lr;
		Review r;
		boolean flag=false;
		int i=0;
		for(;i<movies.size();i++)
		{
			if(movies.get(i).getMovieCode()==mcode) {
				flag=true;
				break;
			}
				
		}
		lr=movies.get(i).getReviews();
		
		r=lr.stream().filter(p->p.getRevId()==revid).findFirst().get();
	
		return r;
	}
	@PutMapping("/{mCode}/reviews/{revid}")
	public Review updateMovieReviw(@PathVariable int mCode,@RequestBody Review m,@PathVariable int revid){
		List<Movie> movies=movieService.allRunningMoviesService();
		boolean flag=false;
		List<Review> lr;
		int i=0;
		for(;i<movies.size();i++)
		{
			if(movies.get(i).getMovieCode()==mCode) {
				flag=true;
				break;
			}
				
		}
		lr=movies.get(i).getReviews();
		i=0;
		for(;i<lr.size();i++)
		{
			if(lr.get(i).getRevId()==revid) {
				flag=true;
				break;
			}
				
		}
		if(flag) {
			lr.set(i, m);
			
		}
		
		return lr.get(i);
		
	}
	@DeleteMapping("/{mCode}/reviews/{reviewId}")
	public List<Movie> DeleteReview(@PathVariable int mCode, @PathVariable int reviewId)
	{
		List<Movie> movies = movieService.allRunningMoviesService();
		int j=0;
		List<Review> r1=null;
		for(int i=0;i<movies.size();i++)
		{
			if(movies.get(i).getMovieCode()==mCode) {
				r1=movies.get(i).getReviews();
				for(;j<r1.size();j++)
				{
					if(r1.get(j).getRevId()==reviewId)
					{
						movies.get(i).getReviews().remove(j);
						break;
					}
				}
				
			}
				
				
		}

		
		return movies;
}
}
