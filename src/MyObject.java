/**
 * MyObject class, object containing object and link to next and pervious MyObject in list
 *  @author Daemon-Macklin  Niall-Mulcahy
 * @param <T> type of object being stored
 */

public class MyObject<T> {

    private T current;
    private MyObject next;
    private MyObject before;

    /**
     * Constructor for MyObject
     * @param current object
     * @param next next MyObject
     */
    public MyObject(T current, MyObject next, MyObject before){
        this.setCurrent(current);
        this.setNext(next);
        this.setBefore(before);
    }


    /*
     Getters and setters
     */
    public void setCurrent(T current){

        this.current = current;

    }

    public void setNext(MyObject next){

        this.next = next;

    }

    public T getCurrent(){

        return this.current;
    }

    public MyObject getNext(){

        return this.next;
    }


	public MyObject getBefore() {

        return before;
	}

	public void setBefore(MyObject before) {
		this.before = before;
	}
}

