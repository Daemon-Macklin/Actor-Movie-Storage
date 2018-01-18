/**
 * Method to manage list of movies
 *  @author Daemon-Macklin  Niall-Mulcahy
 */
public class Movies extends MyList {

	public Movies() {
		super();
	}

	/**
	 * Views all movies
	 *
	 * @return retuns String of movies
	 */
	public String view() {
		String str = "";
		MyObject<Movie> movie = head;
		while (movie.getNext() != null) {
			str = str + "\n[" + movie.getCurrent().toString() + "]\n";
			movie = movie.getNext();
		}
		str = str + "\n[" + movie.getCurrent().toString() + "]\n";
		return str;
	}

	/**
	 * Method to generate id
	 * @return
	 */
	public int idGen() {
		MyObject<Movie> current = tail;
		int id;
		if (tail == null) {
			id = 1;
		} else {
			id = current.getCurrent().getId() + 1;
		}
		return id;
	}

	/**
	 * Method to find movie based on id
	 * @param id
	 * @return movie
	 */
	public MyObject find(int id){
		MyObject<Movie> before = head;
		while(before.getNext() != null){
			if(before.getCurrent().getId() == id){
				return before;
			}
			before = before.getNext();
		}
		if(before.getCurrent().getId() == id){
			return before;
		}
		return null;
	}

	/**
	 * Method to update title of movie
	 * @param id movie id
	 * @param newTitle
	 */
	public void updateTitle(int id, String newTitle) {
		MyObject<Movie> movie = head;
		while (movie.getNext() != null) {
			if (movie.getCurrent().getId() == id) {
				movie.getCurrent().setTitle(newTitle);
			}
			movie = movie.getNext();
		}
		if (movie.getCurrent().getId() == id) {
			movie.getCurrent().setTitle(newTitle);
		}
	}

	/**
	 * Method to update the release dte of a movie
	 * @param id movie id
	 * @param newRelease
	 */
	public void updateRelease(int id, String newRelease) {
		MyObject<Movie> movie = head;
		while (movie.getNext() != null) {
			if (movie.getCurrent().getId() == id) {
				movie.getCurrent().setRelease(newRelease);
			}
			movie = movie.getNext();
		}
		if (movie.getCurrent().getId() == id) {
			movie.getCurrent().setRelease(newRelease);
		}
	}

	/**
	 * Method to update the rating of a movie
	 * @param id
	 * @param newRating
	 */
	public void updateRating(int id, int newRating) {
		MyObject<Movie> movie = head;
		while (movie.getNext() != null) {
			if (movie.getCurrent().getId() == id) {
				movie.getCurrent().setRating(newRating);
			}
			movie = movie.getNext();
		}
		if (movie.getCurrent().getId() == id) {
			movie.getCurrent().setRating(newRating);
		}
	}

	/**
	 * Method to update the genre of a movie
	 * @param id
	 * @param newGenre
	 */
	public void updateGenre(int id, String newGenre) {
		MyObject<Movie> movie = head;
		while (movie.getNext() != null) {
			if (movie.getCurrent().getId() == id) {
				movie.getCurrent().setGenre(newGenre);
			}
			movie = movie.getNext();
		}
		if (movie.getCurrent().getId() == id) {
			movie.getCurrent().setGenre(newGenre);
		}
	}

	/**
	 * Method to update the plot of a movie
	 * @param id
	 * @param newPlot
	 */
	public void updatePlot(int id, String newPlot) {
		MyObject<Movie> movie = head;
		while (movie.getNext() != null) {
			if (movie.getCurrent().getId() == id) {
				movie.getCurrent().setPlot(newPlot);
			}
			movie = movie.getNext();
		}
		if (movie.getCurrent().getId() == id) {
			movie.getCurrent().setPlot(newPlot);
		}
	}

	/**
	 * Method to update the location of a movie's image
	 * @param id
	 * @param newImg
	 */
	public void updateImg(int id, String newImg) {
		MyObject<Movie> movie = head;
		while (movie.getNext() != null) {
			if (movie.getCurrent().getId() == id) {
				movie.getCurrent().setImgUrl(newImg);
			}
			movie = movie.getNext();
		}
		if (movie.getCurrent().getId() == id) {
			movie.getCurrent().setImgUrl(newImg);
		}
	}

	/**
	 * Method to get all the movie objects
	 * @return
	 */
	public Movie[] getObjects() {
		int count = countThroughObject();
		MyObject<Movie> object = head;
		Movie[] objects;
		objects = new Movie[count];
		while (object != null) {
			for (int i = 0; i < objects.length; i++) {
				objects[i] = object.getCurrent();
				object = object.getNext();
			}
		}
		return objects;
	}

	/**
	 * Method to get movies by id
	 * @param id
	 * @return
	 */
	public Movie getMovieById(int id){
	    MyObject<Movie> object = head;
	    while(object.getNext() != null){
	        if(object.getCurrent().getId() == id){
	            return object.getCurrent();
            }
            object = object.getNext();
        }
        if(object.getCurrent().getId() == id){
            return object.getCurrent();
        }
        return null;
    }

	/**
	 * Method to get a movie by name
	 * @param name
	 * @return
	 */
	public Movie getMovieByName(String name){
        MyObject<Movie> movie = head;
        while(movie.getNext() != null){
            if(movie.getCurrent().getTitle().equalsIgnoreCase(name)){
                return movie.getCurrent();
            }
            movie = movie.getNext();
        }
        if(movie.getCurrent().getTitle().equalsIgnoreCase(name)){
            return movie.getCurrent();
        }

        int x = name.length();
        movie = head;
        while(movie.getNext() != null){
            if(movie.getCurrent().getTitle().substring(0, x).equalsIgnoreCase(name)){
                return movie.getCurrent();
            }
            movie = movie.getNext();
        }
        if(movie.getCurrent().getTitle().substring(0, x).equalsIgnoreCase(name)){
            return movie.getCurrent();
        }
        return null;
    }

	/**
	 * Method to get movies based on genre
	 * @param genre
	 * @return array of movies
	 */
	public Movie[] getMovieByGenre(String genre){
        MyObject<Movie> movie = head;
        int count = countThroughObject();
        Movie[] movies = new Movie[count];
        int index = 0;
        while(movie != null){
            String movieGenre = movie.getCurrent().getGenre();
            if(genre.equalsIgnoreCase(movieGenre)){
                movies[index] = movie.getCurrent();
                index +=1;
            }
            movie = movie.getNext();
        }
	Movie[] finalMovies;
		if(movies != null) {
		finalMovies = new Movie[index];
		int j =0;
		for (int i = 0; i < movies.length; i++) {
			if(movies[i] != null) {
				finalMovies[j] = movies[i];
				j+=1;
			}
		}
		return finalMovies;
	}
		return null;
}

	/**
	 * Method to get movies in a year
	 * @param year
	 * @return array of movies
	 */
    public Movie[] getMovieByYear(String year){
	    MyObject<Movie> movie = head;
	    int count = countThroughObject();
        Movie[] movies = new Movie[count];
	    int index = 0;
        while(movie != null){
            String movieRelease = movie.getCurrent().getRelease().substring(6);
            if(year.equalsIgnoreCase(movieRelease)){
                movies[index] = movie.getCurrent();
                index +=1;
            }
            movie = movie.getNext();
        }
	Movie[] finalMovies;
		if(movies != null) {
		finalMovies = new Movie[index];
		int j =0;
		for (int i = 0; i < movies.length; i++) {
			if(movies[i] != null) {
				finalMovies[j] = movies[i];
				j+=1;
			}
		}
		return finalMovies;
	}
		return null;
    }
}















