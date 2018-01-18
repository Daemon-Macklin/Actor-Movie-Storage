/**
 * Method to manage list of actors
 *  @author Daemon-Macklin  Niall-Mulcahy
 */
public class Actors extends MyList {

	public Actors(){
		super();
	}

	/**
	 * Views all actors
	 * @return String of all actors
	 */
	public String view(){
		String str = "";
		MyObject<Actor> actor = head;
		if(head == null){
			str = "No Actors to view";
		}
		else{
		while(actor.getNext() != null){
			str = str + "[" + actor.getCurrent().toString() + "]";
			actor = actor.getNext();
		}
		str = str + "[" + actor.getCurrent().toString() + "]";
		}
		return str;
	}

	public Actor[] getObjects(){
		int count = countThroughObject();
		MyObject<Actor> object = head;
		Actor[] objects;
		objects = new Actor[count];
		while(object != null){
			for(int i =0; i < objects.length; i++){
				objects[i] = object.getCurrent();
				object = object.getNext();
			}
		}
		return objects;
	}

    /**
     * Method to generte unique identifiers
     * @return new id
     */
    public int idGen(){
        MyObject<Actor> current = tail;
        int id;
        if(tail == null){
            id = 1;
        }
        else {
            id = current.getCurrent().getId() + 1;
        }
        return id;
    }
	
    /**
     * Method to update a actors name
     * @param id of actor
     * @param newName name that will be set
     */
	public void updateName(int id, String newName){
		MyObject<Actor> actor = head;
		while(actor.getNext() != null){
			if(actor.getCurrent().getId() == id){
				actor.getCurrent().setName(newName);
			}
			actor = actor.getNext();
		}
		if(actor.getCurrent().getId() == id){
			actor.getCurrent().setName(newName);
		}
	}
	
	/**
	 * Method to update actors nationality
	 * @param id
	 * @param newNationality
	 */
	public void updateNationality(int id,String newNationality){
		MyObject<Actor> actor = head;
		while(actor.getNext() != null){
			if(actor.getCurrent().getId() == id){
				actor.getCurrent().setNationality(newNationality);
			}
			actor = actor.getNext();
		}
		if(actor.getCurrent().getId() == id){
			actor.getCurrent().setNationality(newNationality);
		}
	}
	
	/**
	 * Method to update actors DOB
	 * @param id
	 * @param newDOB
	 */
	public void updateDOB(int id,String newDOB){
		MyObject<Actor> actor = head;
		while(actor.getNext() != null){
			if(actor.getCurrent().getId() == id){
				actor.getCurrent().setDateOfBirth(newDOB);
			}
			actor = actor.getNext();
		}
		if(actor.getCurrent().getId() == id){
			actor.getCurrent().setDateOfBirth(newDOB);
		}
	}
	
	/**
	 * Method to update actors Gender
	 * @param id
	 * @param newGender
	 */
	public void updateGender(int id, String newGender){
		MyObject<Actor> actor = head;
		while(actor.getNext() != null){
			if(actor.getCurrent().getId() == id){
				actor.getCurrent().setGender(newGender);
			}
			actor = actor.getNext();
		}
		if(actor.getCurrent().getId() == id){
			actor.getCurrent().setGender(newGender);
		}
	}

	/**
	 * Method to get actor by id
	 * @param id
	 * @return actor
	 */
	public MyObject<Actor> getActor(int id){
		MyObject<Actor> actor = head;
		while(actor.getNext() != null){
			if(actor.getCurrent().getId() == id){
				return actor;
			}
            actor = actor.getNext();
        }
		if(actor.getCurrent().getId() == id){
			return actor;
		}
		return null;
	}

	/**
	 * Method to get actor by name
	 * @param name
	 * @return actor
	 */
	public MyObject<Actor> getActorByName(String name){
		MyObject<Actor> actor = head;
		while(actor.getNext() != null){
			if(actor.getCurrent().getName().equalsIgnoreCase(name)){
				return actor;
			}
			actor = actor.getNext();
		}
		if(actor.getCurrent().getName().equalsIgnoreCase(name)){
			return actor;
		}

		int x = name.length();
		actor = head;
		while(actor.getNext() != null){
			if(actor.getCurrent().getName().substring(0, x).equalsIgnoreCase(name)){
				return actor;
			}
            actor = actor.getNext();
        }
		if(actor.getCurrent().getName().substring(0, x).equalsIgnoreCase(name)){
			return actor;
		}
		return null;
	}

	/**
	 * Method to get actor by nationality
	 * @param nat
	 * @return array of actors
	 */
	public Actor[] getActorsNationality(String nat){
		int count = countThroughObject();
		MyObject<Actor> object = head;
		Actor[] objects;
		int num = 0;
		objects = new Actor[count];
		while(object != null){
			for(int i =0; i < objects.length; i++){
				if(object.getCurrent().getNationality().equalsIgnoreCase(nat)) {
					objects[i] = object.getCurrent();
					num += 1;
				}
				object = object.getNext();
			}
		}
		Actor[] actors;
		if(objects != null) {
            actors = new Actor[num];
            int j =0;
            for (int i = 0; i < objects.length; i++) {
            	if(objects[i] != null) {
					actors[j] = objects[i];
					j+=1;
				}
            }
            return actors;
        }
		return null;
	}
}


