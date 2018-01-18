/**
 * Driver class
 * @author Daemon-Macklin Niall-Mulcahy
 *
 */

import java.util.Scanner;
import java.io.*;
//import javafx.application.Application;
//import javafx.stage.Stage;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class Driver{

    public Scanner input;
    public Actors actors = new Actors();
	public Movies movies = new Movies();
	public MyHash favourites = new MyHash(10);
	
	 public static void main(String[] args){
		 Driver movie = new Driver();
		  movie.start();
	    }

	 public Driver(){
		 input = new Scanner(System.in);
	 }

	/**
	 * Method to load and run main menu
	 */
	public void start(){
		 try{
		 this.load();
		 }
		 catch(Exception e){
			 System.out.println("Error loading file" + e);
		 }
		 this.runMainMenu();
	 }

	/**
	 * Method that runs main menu
	 */
	public void runMainMenu(){
		 int option = mainMenu();

		 switch(option){
		 case 1:
			 this.addActor();
			 this.runMainMenu();
			 break;
		 case 2:
			 this.addMovie();
			 this.runMainMenu();
			 break;
		 case 3:
			 System.out.println(actors.view());
			 this.runMainMenu();
			 break;
		 case 4:
			 System.out.println(movies.view());
			 this.runMainMenu();
			 break;
		 case 5:
			 System.out.println("Which actor would you like to edit?(id)");
			 int id = this.getIntOption();
			 this.runUpdateActor(id);
			 try{
			 this.saveActor();
			 }
			 catch(Exception e){
				 System.out.println("Error saving file" + e);
			 }
			 this.runMainMenu();
			 break;
		 case 6:
			 System.out.println("Which movie would you like to edit?(id)");
			 int id2 = this.getIntOption();
			 this.runUpdateMovie(id2);
			 try{
				 this.saveMovie();
			 }
			 catch(Exception e){
				 System.out.println("Error saving file" + e);
			 }
			 this.runMainMenu();
             break;
			 case 7:
             	 this.runView();
                 this.runMainMenu();
                 break;
			 case 8:
			 	this.runRemove();
			 	this.runMainMenu();
			 case 9:
			 	this.runSearch();
			 	this.runMainMenu();
			 case 0:
			 	this.runFav();
			 	this.runMainMenu();
		default:
			this.optionError();
			break;
		 }
	 }

	/**
	 *Method that gets users input
	 * @return users input
	 */
	public int mainMenu(){
		System.out.println("Welcome to the Actor-Movie database");
		System.out.println("1) Add actor");
		System.out.println("2) Add movie");
		System.out.println("3) View Actor");
		System.out.println("4) View Movies");
		System.out.println("5) Update Actor");
		System.out.println("6) Update Movie");
		System.out.println("7) View");
		System.out.println("8) Remove");
		System.out.println("9) Search");
		System.out.println("0) Favourites");
		int option = -1;

        while(option < 0 || option > 9){
            option = getIntOption();
            if(option < 0 || option > 9){
                this.optionError();
            }
        }
        return option;

	 }

	/**
	 * Method to add a new actor
	 */
	public void addActor(){
		 this.getStringOption();
		 System.out.println("Name of Actor");
		 String name = this.getStringOption();
		 System.out.println("Nationality of Actor");
		 String nat = this.getStringOption();
		 System.out.println("Gender of Actor(M/F/U)");
		 String gender = this.getStringOption();
		 System.out.println("Date of Birth(DD/MM/YYYY)");
		 String dob = this.getStringOption();
		 int id = actors.idGen();
		 Actor actor = new Actor(name ,nat ,dob ,gender , id);
		 actors.addObject(actor);
		 try{
		 this.saveActor();
		 }
		 catch(Exception e){
			 System.out.println("Error saving to file" + e);
		 }
	 }

	/**
	 * Method to add new movie
	 */
	public void addMovie(){
		 this.getStringOption();
		 System.out.println("Title of Movie");
		 String title = this.getStringOption();
		 System.out.println("When was it relased");
		 String release = this.getStringOption();
		 System.out.println("What genre is it");
		 String genre = this.getStringOption();
		 System.out.println("Plot");
		 String plot = this.getStringOption();
		 System.out.println("imgUrl....no idea how we're gonna do this");
		 String img = this.getStringOption();
		 System.out.println("Movie rating");
		 int rating = this.getIntOption();
		 int id = movies.idGen();
		 Movie movie = new Movie(title, release, genre, plot, img,rating,id);
		 movies.addObject(movie);
		 try{
		 this.saveMovie();
		 }
		 catch(Exception e){
			 System.out.println("Error saving file" + e);
		 }
	 }

	/**
	 * Menu to update actor
	 * @param id actor id
	 */
	public void runUpdateActor(int id){
		 this.getStringOption();
		 int option = updateActor();
		 switch(option){
		 case 1:
			 this.getStringOption();
			 System.out.println("What would you like the new name to be?");
			 String newName = this.getStringOption();
			 actors.updateName(id, newName);
			 break;
		 case 2:
			 this.getStringOption();
			 System.out.println("What would you like the new nationnality to be?");
			 String newNationality = this.getStringOption();
			 actors.updateNationality(id, newNationality);
			 break;
		 case 3:
			 this.getStringOption();
			 System.out.println("What would you like the new gender to be");
			 String newGender = this.getStringOption();
			 actors.updateGender(id, newGender);
			 break;
		 case 4:
			 this.getStringOption();
			 System.out.println("What would you like the new date of birth to be?");
			 String newDob = this.getStringOption();
			 actors.updateDOB(id, newDob);
			 break;
		  default:
		  	this.optionError();
		 }
	 }

	/**
	 * method to get actors choice
	 * @return users choice
	 */
	public int updateActor(){
		 System.out.println("What would you like to update about the actor");
		 System.out.println("1) Name");
		 System.out.println("2) Nationality");
		 System.out.println("3) Gender");
		 System.out.println("4) Date of birth");
		 int option = 0;

	        while(option < 1 || option > 4){
	            option = getIntOption();
	            if(option < 1 || option > 4){
	                this.optionError();
	            }
	        }
	        return option;
	 }

	/**
	 *Method to update movie
	 * @param id movie id
	 */
	public void runUpdateMovie(int id){
		this.getStringOption();
		int option = updateMovie();
		switch (option){
			case 1:
				this.getStringOption();
				System.out.println("What would you like the new title to be?");
				String newtitle = this.getStringOption();
				movies.updateTitle(id, newtitle);
				break;
			case 2:
				this.getStringOption();
				System.out.println("What would you like the new release to be?");
				String newRelease = this.getStringOption();
				movies.updateRelease(id, newRelease);
				break;
			case 3:
				this.getStringOption();
				System.out.println("What would you like the new genre to be");
				String newGenre = this.getStringOption();
				movies.updateGenre(id, newGenre);
				break;
			case 4:
				this.getStringOption();
				System.out.println("What would you like the new date of rating to bed?");
				int newRating = this.getIntOption();
				movies.updateRating(id, newRating);
				break;
			case 5:
				this.getStringOption();
				System.out.println("What would you like the new date of imgurl to bed?");
				String newImg = this.getStringOption();
				movies.updateImg(id, newImg);
				break;
			case 6:
				this.getStringOption();
				System.out.println("What would you like the new date of plot to bed?");
				String plot = this.getStringOption();
				movies.updatePlot(id,plot);
				break;
		}
	 }

	/**
	 * Method to get user input
	 * @return users input
	 */
	public int updateMovie(){
		 System.out.println("What would you like to update about the movie");
		 System.out.println("1) Title");
		 System.out.println("2) release");
		 System.out.println("3) genre");
		 System.out.println("4) rating");
		 System.out.println("5) imgurl");
		 System.out.println("6) plot");
		 int option = 0;

		 while(option < 1 || option > 6){
			 option = getIntOption();
			 if(option < 1 || option > 6){
				 this.optionError();
			 }
		 }
		 return option;
	 }

	/**
	 * Method to remove objects
	 */
	public void runRemove(){
	 	int option = remove();
	 	switch (option){
			case 1:
				System.out.println("Which actor would you like to delete?(id)");
				int actorId = this.getIntOption();
				MyObject actor = actors.getActor(actorId);
				if(actor!= null) {
					actors.removeObject(actor);
				}
				else{
					System.out.println("No actor found");
				}
				break;
			case 2:
				System.out.println("Which movie would you like to delete?(id)");
				int movieId = this.getIntOption();
				MyObject movie = movies.find(movieId);
				if(movie!= null) {
					movies.removeObject(movie);
				}
				else{
					System.out.println("No movie found");
				}
				break;
				default:
					this.optionError();
					break;
		}
	 }

	/**
	 * Menu to get user input
	 * @return use input
	 */
	public int remove(){
		 System.out.println("What would you like to remove?");
		 System.out.println("1) Actor");
		 System.out.println("2) Movie");
		 int option = 0;

		 while(option < 1 || option > 2){
			 option = getIntOption();
			 if(option < 1 || option > 2){
				 this.optionError();
			 }
		 }
		 return option;
	 }

	/**
	 * Selection sort method that sorts movies based on rating
	 * @return
	 */
	public Movie[] moviesByRating(){
	 	Movie[] movieList = movies.getObjects();
		for(int i = 0; i < movieList.length-1; i++){
			int highest = i;

			for(int j = highest+1; j < movieList.length; j++){
				if(movieList[j].getRating() > movieList[highest].getRating()){
					highest = j;
				}
				if(highest != i){
					Movie swap = movieList[i];
					movieList[i] = movieList[highest];
					movieList[highest] = swap;
				}
			}
		}
		return movieList;
	 }

	/*
	 public Actor[] actorsByName(){
	 	Actor[] actorList = actors.getObjects();
		 for(int i = 0; i < actorList.length-1; i++){
			 int highest = i;

			 for(int j = highest+1; j < actorList.length; j++){
				 if(actorList[j].getName().compareToIgnoreCase(actorList[highest].getName()) > 0){
					 highest = j;
				 }
				 if(highest != i){  
					 System.out.println("The if statement works");
					 Actor swap = actorList[i];
					 actorList[i] = actorList[highest];
					 actorList[highest] = swap;
				 }
			 }
		 }
		 return actorList;
	 }

	 */

	/**
	 * Merge sort method to sort actors alphabetically
	 * @param actors array of Actors
	 * @return sorted array of Actors
	 */
	 public Actor[] mergeSortActors(Actor[] actors){
	 	if(actors.length > 1){
			int x = actors.length/2, y = actors.length-x;
			Actor[] xa = new Actor[x];
			Actor[] ya = new Actor[y];
			int i;
	 		for(i = 0; i < x; i++){
	 			xa[i] = actors[i];
			}
			for(int i2 = 0;i2 < y; i2++, i++){
	 			ya[i2] = actors[i];
			}

			mergeSortActors(xa);
	 		mergeSortActors(ya);

	 		i = 0;

	 		int xai =0, yai = 0;

	 		while(xai < xa.length && yai < ya.length) {
				if (actors[i] != null) {
					actors[i] = (xa[xai].getName().compareToIgnoreCase(ya[yai].getName()) > 0)
							? xa[xai++] : ya[yai++];
				}
				i+=1;
			}
				while(xai < xa.length) actors[i++]=xa[xai++];
	 			while(yai < ya.length) actors[i++]=ya[yai++];
			return actors;
		}
		 return actors;
	 }

	/**
	 * Merge sort method to sort movies alphabetically
	 * @param movies array of movies
	 * @return sorted array of movies
	 */
	public Movie[] mergeSortMovies(Movie[] movies){
		if(movies.length > 1){
			int x = movies.length/2, y = movies.length-x;
			Movie[] xa = new Movie[x];
			Movie[] ya = new Movie[y];
			int i;
			for(i = 0; i < x; i++){
				xa[i] = movies[i];
			}
			for(int i2 = 0;i2 < y; i2++, i++){
				ya[i2] = movies[i];
			}

			mergeSortMovies(xa);
			mergeSortMovies(ya);

			i = 0;
			int xai =0, yai = 0;

			while(xai <xa.length&& yai< ya.length) {
				if (movies[i] != null) {
					movies[i++] = (xa[xai].getTitle().compareToIgnoreCase(ya[yai].getTitle()) > 0)
							? xa[xai++] : ya[yai++];
				}
			}
			while(xai < xa.length){
				movies[i++]=xa[xai++];
			}
			while(yai < ya.length){
				movies[i++]=ya[yai++];
			}

		}
		return movies;
	}

	/**
	 * Method to view sorted examples
	 */
	 public void runView(){
	 	int option = view();
	 	switch (option){
			case 1:
				Actor[] alphaActors = this.mergeSortActors(actors.getObjects());
				for(int i = alphaActors.length-1; i > -1; i--){
					System.out.println(alphaActors[i].getName());
				}
				this.runMainMenu();
				break;
			case 2:
				Movie[] ratingMovie = this.moviesByRating();
				for(int i = 0; i < ratingMovie.length; i++){
					System.out.println(ratingMovie[i].getTitle() + ":" + ratingMovie[i].getRating());
				}
				this.runMainMenu();
				break;
			default:
				this.optionError();
				break;
		}
	 }

	/**
	 * Method to get user input
	 * @return users input
	 */
	public int view(){
	 	System.out.println("What would you like to view?");
	 	System.out.println("1) Actors alphabetically");
	 	System.out.println("2) Movies based on rating");
	 	int option = 0;

	 	while(option < 1 || option > 2){
			option = getIntOption();
	 		if(option < 1 || option >2){
	 			this.optionError();
			}
		}
		return option;
	 }

	/**
	 * Method for search options
	 */
	public void runSearch(){
		int option = search();

		switch(option){
			case 1:
				System.out.println("Please give id");
				int id = this.getIntOption();
				 Actor found = actors.getActor(id).getCurrent();
				 if(found != null){
					 System.out.println(found.toString());
				 }
				 else{
					 System.out.println("No actor found");
				 }
				break;
			case 2:
				this.getStringOption();
				System.out.println("Please give name");
				String name = this.getStringOption();
				MyObject<Actor> found2 = actors.getActorByName(name);
				if(found2 != null){
					System.out.println(found2.getCurrent().toString());
				}
				else{
				System.out.println("No Actor found");
				}
				break;
			case 3:
				this.getStringOption();
				System.out.println("What nationality would you like to search");
				String nat = this.getStringOption();
				Actor[] found3 = actors.getActorsNationality(nat);
				if(found3 != null){
					this.mergeSortActors(found3);
					for(int i = found3.length-1; i > -1  ;i--) {
						if (found3[i] != null) {
							System.out.println(found3[i].toString());
						}
					}
				}
				else{
					System.out.println("Actor/actors not found");
				}
				break;
			case 4:
				this.getStringOption();
				System.out.println("Please input an id");
				int movieId = this.getIntOption();
				Movie found4 = movies.getMovieById(movieId);
				if(found4 != null){
					System.out.println(found4.toString());
				}
				else{
					System.out.println("Movie not found");
				}
				break;
			case 5:
				this.getStringOption();
				System.out.println("Please input a title");
				String movieName = this.getStringOption();
				Movie found5 = movies.getMovieByName(movieName);
				if(found5 != null){
					System.out.println(found5.toString());
				}
				else{
					System.out.println("Movie not found");
				}
				break;
			case 6:
				this.getStringOption();
				System.out.println("Please select a year to search(i.e 2005)");
				String movieYear = this.getStringOption();
				Movie found6[] = movies.getMovieByYear(movieYear);
				if(found6 != null){
					this.mergeSortMovies(found6);
					for(int i =0; i < found6.length; i++) {
						if (found6[i] != null) {
							System.out.println(found6[i].toString());
						}
					}
				}
				else{
					System.out.println("Movie/movies not found");
				}
				break;
			case 7:
				this.getStringOption();
				System.out.println("Please select a genre to search");
				String movieGenre = this.getStringOption();
				Movie found7[] = movies.getMovieByGenre(movieGenre);
				if(found7 != null){
					this.mergeSortMovies(found7);
					for(int j =0; j < found7.length; j++) {
						if(found7[j] != null)
						System.out.println(found7[j].toString());
					}
				}
				else{
					System.out.println("Movie/movies not found");
				}
				break;
				default:

					break;
		}

	 }

	/**
	 * Method to get users option
	 * @return users option
	 */
	 public int search(){
		 System.out.println("What would you like to search?");
		 System.out.println("1) Actors by id");
		 System.out.println("2) Actors by name");
		 System.out.println("3) Actors by nationality");
		 System.out.println("4) Movies by id");
		 System.out.println("5) Movies by title");
		 System.out.println("6) Movies by year");
		 System.out.println("7) Movies by genre");

		 int option = 0;

		 while(option < 1 || option > 7){
			 option = getIntOption();
			 if(option < 1 || option >7){
				 this.optionError();
			 }
		 }
		 return option;
	 }

	/**
	 * Method to run hashmap examples
	 */
	 public void runFav(){
	 	int option = fav();

	 	switch (option){
			case 1:
				this.getStringOption();
				System.out.println(favourites.view());
				break;
			case 2:
				this.getStringOption();
				System.out.println("Which movie would you like to search?(id)");
				int id = this.getIntOption();
				Movie movieObject = movies.getMovieById(id);
				if(movieObject != null) {
					int location = favourites.findObjectLocation(movieObject);
					if(location == -1) {
						System.out.println("Movie not in Favourites");
					}
					else{
						System.out.println(favourites.getItem(location));
					}
				}
				else{
					System.out.println("No Movie found");
				}
				break;
			case 3:
				this.getStringOption();
				System.out.println("Which movie would you like to add?(id)");
				int id2 = this.getIntOption();
				Movie movieObject2 = movies.getMovieById(id2);
				if(movieObject2 != null) {
					favourites.addItem(movieObject2);
				}
				else{
					System.out.println("No Movie found");
				}
				try{
					this.saveFavourites();
				}
				catch(Exception e){
					System.out.println("Error saving: " + e);
				}
				break;
		}
	 }

	/**
	 * Method to get user input
	 * @return user input
	 */
	 public int fav(){
		 System.out.println("Favourites");
		 System.out.println("1) View ");
		 System.out.println("2) Search");
		 System.out.println("3) Add");

		 int option = 0;

		 while(option < 1 || option > 3){
			 option = getIntOption();
			 if(option < 1 || option >3){
				 this.optionError();
			 }
		 }
		 return option;
	 }

	    //utility funcions
	 /**
	  * Loads actor and movie data
	  * @throws Exception
	  */
	    @SuppressWarnings("unchecked")
	    public void load() throws Exception
	    {
	        XStream xstream = new XStream(new DomDriver());
	        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("actors.xml"));
	        actors = (Actors) is.readObject();
	        is.close();
	        ObjectInputStream it = xstream.createObjectInputStream(new FileReader("movies.xml"));
	        movies = (Movies) it.readObject();
	        it.close();
			ObjectInputStream in = xstream.createObjectInputStream(new FileReader("favourites.xml"));
			favourites  = (MyHash) in.readObject();
			it.close();
	    }

	    /**
	     * Saves actor data
	     * @throws Exception
	     */
	    public void saveActor() throws Exception
	    {
	        XStream xstream = new XStream(new DomDriver());
	        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("actors.xml"));
	        out.writeObject(actors);
	        out.close();    
	    }
	    
	    /**
	     * Saves movies data
	     * @throws Exception
	     */
	    public void saveMovie() throws Exception
	    {
	        XStream xstream = new XStream(new DomDriver());
	        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("movies.xml"));
	        out.writeObject(movies);
	        out.close();    
	    }

	public void saveFavourites() throws Exception
	{
		XStream xstream = new XStream(new DomDriver());
		ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("favourites.xml"));
		out.writeObject(favourites);
		out.close();
	}
	    /**
	     * Method to get a String with scanner
	     * @return returns The String that was inputed
	     */
	    private String getStringOption() {
	        System.out.print("> ");
	        String text = input.nextLine();
	        return text;
	    }

	    /**
	     * Method to get double with scanner
	     * @return returns The Double that was inputed
	     */
	    private double getDoubleOption(){
	        System.out.println("> ");
	        double option = input.nextDouble();
	        return option;
	    }

	    /**
	     * Method to get int with scanner
	     * @return returns The intager that was inputed
	     */
	    private int getIntOption(){
	        System.out.println("> ");
	        int option = input.nextInt();
	        return option;
	    }


	    /**
	     * Method that prints error message when invalid option is selected
	     */
	    public void optionError(){

	        System.out.println("Invalid option selected");
	    }


}












