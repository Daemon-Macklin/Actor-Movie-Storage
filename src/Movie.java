  /**
 * Movie class
 *  @author Daemon-Macklin  Niall-Mulcahy
 *
 */
public class Movie implements Comparable<Movie>{
	
	private String title;
	private String release;
	private String genre;
	private String plot;
	private String imgUrl;
	private int rating;
	private int id;

	
	/**
	 * @param title
	 * @param release
	 * @param genre
	 * @param plot
	 * @param imgUrl
	 * @param rating
	 */
	public Movie(String title, String release, String genre, String plot, String imgUrl, int rating, int id) {
		setTitle(title);
		setRelease(release);
		setGenre(genre);
		setPlot(plot);
		setImgUrl(imgUrl);
		setRating(rating);
		setId(id);
	}
	
	/**
	 * 
	 * @return ToString for object
	 */
	public String toString(){
		return " Title: " + this.getTitle() + " Rating: " + this.getRating()
				+ " Genre: " + this.getGenre()
				+ " Release: "  + this.getRelease() + " ID: "
				+ this.getId() + "\n" + " Plot: " + this.getPlot();
	}
	
	
	/**
	 * @return Id
	 */
	public int getId(){
		return id;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(int id){
		this.id = id;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
        if(this.title == null){
            int maxLength = (title.length() < 40)?title.length():40;
            title = title.substring(0, maxLength);
            this.title = title;
        }
        else{
            if(title.length() < 40){
                this.title = title;
            }
        }
	}
	/**
	 * @return the release
	 */
	public String getRelease() {
		return release;
	}
	/**
	 * @param release the release to set
	 */
	public void setRelease(String release) {
        if(this.release == null){
            int maxLength = (release.length() < 10)?release.length():10;
            if(release.length() <= maxLength){
            this.release = release;
            }
            else{
            	this.release = "Unspecified";
            }
        }
        else{
            if(release.length() < 10){
                this.release = release;
            }
        }
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * @return the plot
	 */
	public String getPlot() {
		return plot;
	}
	/**
	 * @param plot the plot to set
	 */
	public void setPlot(String plot) {
        if(this.plot == null){
            int maxLength = (plot.length() < 100)?plot.length():100;
            plot = plot.substring(0, maxLength);
            this.plot = plot;
        }
        else{
            if(plot.length() < 100){
                this.plot = plot;
            }
        }
	}
	/**
	 * @return the imgUrl
	 */
	public String getImgUrl() {
		return imgUrl;
	}
	/**
	 * @param imgUrl the imgUrl to set
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		if(rating <= 10 && rating >= 0){
		this.rating = rating;
		}
		else{
		this.rating = -1;
		}
	}

	public int compareTo(Movie movie){

		return this.getRating()-movie.getRating();

    }
}

