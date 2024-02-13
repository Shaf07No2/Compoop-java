// package com.qa.baetraining.service;

// import static org.assertj.core.api.Assertions.assertThat;
// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.test.context.jdbc.Sql;
// import org.springframework.test.context.jdbc.Sql.ExecutionPhase;


// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import com.qa.baetraining.domain.Movie;
// import com.qa.baetraining.repo.MovieRepo;

// @SpringBootTest
// @AutoConfigureMockMvc

// @Sql(scripts = {"classpath:testSchema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

// @ActiveProfiles("test")
// public class MovieServiceTest {
// 	@Autowired
// 	private MovieService service;
	
// 	@MockBean
// 	private MovieRepo repo;
	
// 	@Test
// 	public void testAddMovie() {
// 		final Movie TEST_MOVIE = new Movie ("Superman", 2008, 3, false);
// 		final Movie TEST_SAVED_MOVIE = new Movie ("Superman", 2008, 3, false);
		
// 		Mockito.when(this.repo.saveAndFlush(TEST_MOVIE)).thenReturn(TEST_SAVED_MOVIE);
		
// 		assertThat(this.service.addMovie(TEST_MOVIE)).isEqualTo(TEST_SAVED_MOVIE);
		
// 		Mockito.verify(this.repo,Mockito.times(1)).saveAndFlush(TEST_MOVIE);
// 	}

	
// 	@Test
// 	public void removeMovie() {
// 		Movie testDel = new Movie();
// 		testDel.setId((long) 1);
// 		Mockito.when(repo.findById(testDel.getId())).thenReturn(Optional.of(testDel));
// 		service.deleteById(testDel.getId());
// 		verify(repo).deleteById(testDel.getId());
// }
	
	
// 	@Test
// 	public void testGetById() {
// 		Movie testId = new Movie(); //creates a movie 
// 		when(repo.findById(20L)).thenReturn(Optional.of(testId)); //uses repo method to find ID of 1, if matches then success
// 	}
// 	@Test
// 	public void findBySeenTest() {
// 		List<Movie> movieOutput = new ArrayList<>();
// 		movieOutput.add(new Movie("Titanic", 1997, 4, true));

// 		Mockito.when(this.repo.findBySeen(true)).thenReturn(movieOutput);

// 		assertEquals(movieOutput, this.service.findBySeen(true));

// 		Mockito.verify(this.repo, Mockito.times(1)).findBySeen(true);
// 	}
// 	@Test
// 	public void findByUnSeenTest() {
// 		List<Movie> movieOutput = new ArrayList<>();
// 		movieOutput.add(new Movie("Legacy", 2006, 3, false));

// 		Mockito.when(this.repo.findByUnSeen(false)).thenReturn(movieOutput);

// 		assertEquals(movieOutput, this.service.findByUnSeen(false));

// 		Mockito.verify(this.repo, Mockito.times(1)).findByUnSeen(false);
// 	}
// 	@Test
// 	public void findByYearTest() {
// 		List<Movie> movieOutput = new ArrayList<>();
// 		movieOutput.add(new Movie("Titanic", 1997, 4, true));

// 		Mockito.when(this.repo.findByYear(1997)).thenReturn(movieOutput);

// 		assertEquals(movieOutput, this.service.findByYear(1997));

// 		Mockito.verify(this.repo, Mockito.times(1)).findByYear(1997);
// 	}
// 	@Test
// 	public void findByRatingTest() {
// 		List<Movie> movieOutput = new ArrayList<>();
// 		movieOutput.add(new Movie("Titanic", 1997, 4, true));

// 		Mockito.when(this.repo.findByRating(4)).thenReturn(movieOutput);

// 		assertEquals(movieOutput, this.service.findByRating(4));

// 		Mockito.verify(this.repo, Mockito.times(1)).findByRating(4);
// 	}


// }