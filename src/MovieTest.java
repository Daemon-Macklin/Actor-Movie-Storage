import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for Movie Class
 *
 *  @author Daemon-Macklin  Niall-Mulcahy
 *
 */

public class MovieTest {

    private Movie movie1;
    private Movie movieInvalid;


    /**
     * Set up test fixtures
     *
     * Called before every test method
     */
    @Before
    public void setUp() {
        movie1 = new Movie( "Taken","07/11/2017","Action", "A plot that is not 100 letters long", "/pics/taken.jpg", 8, 1);
        movieInvalid = new Movie("Star wars the phantom mence","07/11/20177777777777","Sci-Fi"
        		, "Need to write something that is about 100 characters long so I can test something for programming!THIS SHOULD ALL BE GONE WHEN SET!!"
        		,"/pics/starwars.jpg"
        		, 11, 1);
    }

    /**
     * Teardown test fixtures
     *
     * Called after each test method
     */
    @After
    public void tearDown() {

    }

    /**
     * Test the contsructor
     */
    @Test
    public void testConstructor() {
        assertNotNull(movie1); //will test these in testGetters()
        assertEquals("Unspecified", movieInvalid.getRelease());
        assertEquals(-1, movieInvalid.getRating());
    }

    /**
     * Test all getters using valid data
     */
    @Test
    public void testGetters() {
       assertEquals("Taken", movie1.getTitle());
       assertEquals("Action", movie1.getGenre());
       assertEquals("07/11/2017", movie1.getRelease());
       assertEquals("A plot that is not 100 letters long", movie1.getPlot());
       assertEquals(8, movie1.getRating());
       assertEquals("/pics/taken.jpg", movie1.getImgUrl());
       
    }

    /**
     * Test all setters for Movie
     */
    @Test
    public void testSetters() {
        movie1.setTitle("This title is far too long for a title so it will not change"); //Invalid change
        assertEquals("Taken", movie1.getTitle());
        movie1.setRating(20000000);
        assertEquals(-1, movie1.getRating());
        
    }

    /**
     * Test the ToString Method for Movie
     *
     */
    @Test
    public void testToString() {
        assertEquals(
        		" Title: " + "Taken" + " Rating: " + 8 + " Genre: " + "Action"
        		+ " Release: "  + "07/11/2017" + " ID: " + 1
                , movie1.toString());

    }


}
