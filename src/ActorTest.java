import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for Actor Class
 *
 *  @author Daemon-Macklin  Niall-Mulcahy
 *
 */

public class ActorTest {

    private Actor actor1;
    private Actor actorInvalid;


    /**
     * Set up test fixtures
     *
     * Called before every test method
     */
    @Before
    public void setUp() {
        actor1 = new Actor("Jim Carey","Canada","02/02/1989","M",1);
        actorInvalid = new Actor("Valid name is 30 chars to hereANYTHINGAFTERTHEREISTOOLONG"
        		,"Valid name is 30 chars to hereANYTHINGAFTERTHEREISTOOLONG","02/02/18888989","kek", 1);
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
        assertNotNull(actor1); //will test these in testGetters()
        assertEquals("Valid name is 30 chars to here", actorInvalid.getName());
        assertEquals("Valid name is 30 chars to here", actorInvalid.getNationality());
        assertEquals("Unspecified", actorInvalid.getGender());
        assertEquals("Unspecified", actorInvalid.getGender());
    }

    /**
     * Test all getters using valid data
     */
    @Test
    public void testGetters() {
        assertEquals("Jim Carey", actor1.getName());
        assertEquals("Canada", actor1.getNationality());
        assertEquals("02/02/1989", actor1.getDateOfBirth());
        assertEquals("M", actor1.getGender());
    }

    /**
     * Test all setters for Actor
     */
    @Test
    public void testSetters() {
       actor1.setDateOfBirth("081/1111/11111");
       assertEquals("02/02/1989", actor1.getDateOfBirth());
       actor1.setGender("Not a gender");
       assertEquals("M", actor1.getGender());
       actor1.setNationality("This thing is way to long to be a nationality so this will not change");
       assertEquals("Canada", actor1.getNationality());
       actor1.setName("This name is way to long to be a vaiable name or whatever so it won't be changed");
       assertEquals("Jim Carey", actor1.getName());
    }

    /**
     * Test the ToString Method for Actor
     *
     */
    @Test
    public void testToString() {
        assertEquals(
        		 " Name: " + "Jim Carey" + " Nationality: " + "Canada" 
        		+ " Date of Birth: " + "02/02/1989" + " Gender; " + "M" + " ID; " + 1
                , actor1.toString());

    }


}
