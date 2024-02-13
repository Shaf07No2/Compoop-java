// package com.qa.baetraining.controller;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.test.context.jdbc.Sql;
// import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
// import org.springframework.test.web.servlet.MockMvc;

// import com.qa.baetraining.domain.*;
// import com.fasterxml.jackson.databind.ObjectMapper;


// @SpringBootTest
// @AutoConfigureMockMvc

// @Sql(scripts = {"classpath:testSchema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

// @ActiveProfiles("test")
// public class MovieControllerIntegrationTest {
	
// 	@Autowired
// 	private MockMvc mvc;
	
// 	@Autowired
// 	private ObjectMapper mapper;
	
// 	@Test
// 	public void getByIdTest() throws Exception {
// 		Movie movieResult = new Movie(1L, "Inception", 2010, 5, true);
// 		String movieResultAsJSON = mapper.writeValueAsString(movieResult);

// 		mvc.perform(get("/getById/1").contentType(MediaType.APPLICATION_JSON).content(movieResultAsJSON))
// 				.andExpect(status().isOk()).andExpect(content().json(movieResultAsJSON));
// 	}
	
// 	@Test
// 	public void getByMovieTitleTest() throws Exception {
// 		Movie movieResult = new Movie(1L, "Inception", 2010, 5, true);
// 		String movieResultAsJSON = mapper.writeValueAsString(movieResult);

// 		mvc.perform(get("/findMovie/Inception").contentType(MediaType.APPLICATION_JSON).content(movieResultAsJSON))
// 				.andExpect(status().isOk()).andExpect(content().json(movieResultAsJSON));
// 	}
	
// 	@Test
// 	public void getByRatingTest() throws Exception {
// 		Movie title = new Movie(1L, "Inception", 2010, 5, true);
// 		List<Movie> output = new ArrayList<>();
// 		output.add(title);
// 		String outputAsJSON = mapper.writeValueAsString(output);

// 		mvc.perform(get("/findByRating/5").contentType(MediaType.APPLICATION_JSON))
// 				.andExpect(status().isOk()).andExpect(status().isOk()).andExpect(content().json(outputAsJSON));
// 	}
	
// 	@Test
// 	public void getByYearTest() throws Exception {
// 		Movie title = new Movie(1L, "Inception", 2010, 5, true);
// 		List<Movie> output = new ArrayList<>();
// 		output.add(title);
// 		String outputAsJSON = mapper.writeValueAsString(output);

// 		mvc.perform(get("/findByYear/2010").contentType(MediaType.APPLICATION_JSON))
// 				.andExpect(status().isOk()).andExpect(status().isOk()).andExpect(content().json(outputAsJSON));
// 	}
	

// 	@Test
// 	public void getAllTest() throws Exception {
// 		Movie movie = new Movie(1L, "Inception", 2010, 5, true);
// 		List<Movie> output = new ArrayList<>();
// 		output.add(movie);
// 		String outputAsJSON = mapper.writeValueAsString(output);
		
// 		mvc.perform(get("/allMovies")
// 				.contentType(MediaType.APPLICATION_JSON))
// 		.andExpect(status().isOk())
// 		.andExpect(content().json(outputAsJSON));
// 	}


// 	@Test
// 	public void createTest() throws Exception {
// 		Movie entry = new Movie("DD", 1997, 2, true);
// 		String entryAsJSON = mapper.writeValueAsString(entry);
		
// 		Movie result = new Movie(2L, "DD", 1997, 2, true);
// 		String resultAsJSON = mapper.writeValueAsString(result);
		
// 		mvc.perform(post("/addMovie")
// 				.contentType(MediaType.APPLICATION_JSON)
// 				.content(entryAsJSON))
// 		.andExpect(status().isResetContent())
// 		.andExpect(content().json(resultAsJSON));
// 	}
// 	@Test
// 	public void updateTest() throws Exception {
// 		Movie updated = new Movie("Jimmy", 2010, 5, true);
// 		String updatedAsJSON = mapper.writeValueAsString(updated);
		
// 		Movie updateResult = new Movie(1L, "Jimmy", 2010, 5, true);
// 		String resultAsJSON = mapper.writeValueAsString(updateResult);
		
// 		mvc.perform(put("/updateMovie/1")
// 				.contentType(MediaType.APPLICATION_JSON)
// 				.content(updatedAsJSON))
// 		.andExpect(status().isCreated())
// 		.andExpect(content().json(resultAsJSON));

// 	}
	
// 	@Test
// 	public void removeMovieTest() throws Exception {
// 		mvc.perform(delete("/deleteById/1").contentType(MediaType.APPLICATION_JSON))
// 				.andExpect(status().isOk());
// 	}

// 	@Test
// 	public void getBySeenTest() throws Exception {
// 		Movie movieEntry = new Movie(1L, "Inception", 2010, 5, true);
// 		List<Movie> output = new ArrayList<>();
// 		output.add(movieEntry);
// 		String outputAsJSON = mapper.writeValueAsString(output);

// 		mvc.perform(get("/allMovies/findBySeen").contentType(MediaType.APPLICATION_JSON))
// 				.andExpect(status().isOk()).andExpect(status().isOk()).andExpect(content().json(outputAsJSON));
// 	}
// }












