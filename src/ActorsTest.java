import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for MyList Class
 *
 *  @author Daemon-Macklin  Niall-Mulcahy
 *
 */

public class ActorsTest {

    private Actor actor1;
    private Actor actorInvalid;
    private MyObject<Actor> node1;
    private MyObject<Actor> node2;
    private Actors test = new Actors();

    /**
     * Set up test fixtures
     *
     * Called before every test method
     */
    @Before
    public void setUp() {
        actor1 = new Actor("Jim Carey","Canada","02/02/1989","M",1);
        actorInvalid = new Actor("Valid name is 30 chars to hereANYTHINGAFTERTHEREISTOOLONG"
                ,"Valid name is 30 chars to hereANYTHINGAFTERTHEREISTOOLONG","02/02/18888989"
                , "kek", 2);
        node1 = new MyObject<>(actor1,null,null);
        node2 = new MyObject<>(actorInvalid,null, node1);
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
     * Test the count
     */
    @Test
    public void testCount(){
        test.addObject(node1);
        assertEquals(1, test.countThroughObject());
    }
    /**
     * Test the add
     */
    @Test
    public void testadd() {
        assertNotNull(node1);
        assertEquals(0, test.countThroughObject());
        test.addObject(node1);
        assertEquals(1, test.countThroughObject());
    }


    /**
     * Test is empty method for actors
     */
    @Test
    public void testIsEmpty() {
        assertEquals(true, test.isEmpty());
    }
}

