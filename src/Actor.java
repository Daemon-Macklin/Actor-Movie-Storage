/**
 * Actor class
 *  @author Daemon-Macklin  Niall-Mulcahy
 *
 */
public class Actor implements Comparable<Actor> {
	
	private String name;
	private String nationality;
	private String dateOfBirth;
	private String gender;
	private int id;
	private Movies movieCredits = new Movies();
	
	/**
	 * Constructor for Actor
	 * @param name
	 */
	public Actor(String name, String nationality, String dateOfBirth, String gender, int id){
		setName(name);
		setNationality(nationality);
		setDateOfBirth(dateOfBirth);
		setGender(gender);
		setId(id);
	}
	
	/**
	 * @return toString 
	 */
	public String toString(){
		return " Name: " + this.getName() + ", Nationality: " + this.getNationality() 
		+ ", Date of Birth: " + this.getDateOfBirth() + ", Gender; " + this.getGender() + ", ID; " + this.getId();
		
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
        if(this.name == null){
            int maxLength = (name.length() < 30)?name.length():30;
            name = name.substring(0, maxLength);
            this.name = name;
        }
        else{
            if(name.length() < 30){
                this.name = name;
            }
        }
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
        if(this.nationality == null){
            int maxLength = (nationality.length() < 30)?nationality.length():30;
            nationality = nationality.substring(0, maxLength);
            this.nationality = nationality;
        }
        else{
            if(nationality.length() < 30){
                this.nationality = nationality;
            }
        }
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
        if(this.dateOfBirth == null){
            int maxLength = (dateOfBirth.length() < 10)?dateOfBirth.length():10;
            if(dateOfBirth.length() <= maxLength){
            this.dateOfBirth = dateOfBirth;
            }
            else{
            	this.dateOfBirth = "Unspecified";
            }
        }
        else{
            if(dateOfBirth.length() < 10){
                this.dateOfBirth = dateOfBirth;
            }
        }
	}

	/**
	 * @return the gender
	 */
	public String getGender() {

		return gender;

	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		if(this.gender == null){
            String finalGender = "";
            if((gender.equalsIgnoreCase("m")) || (gender.equalsIgnoreCase("male"))){
                finalGender = "M";
            }
            else if((gender.equalsIgnoreCase("f")) || (gender.equalsIgnoreCase("female"))){
                finalGender = "F";
            }
            else{
                finalGender = "Unspecified";
            }
            this.gender = finalGender;
        }
        else{
            String finalGender = this.gender;
			if((gender.equalsIgnoreCase("m")) || (gender.equalsIgnoreCase("male"))){
				finalGender = "M";
			}
			else if((gender.equalsIgnoreCase("f")) || (gender.equalsIgnoreCase("female"))){
				finalGender = "F";
			}
            this.gender = finalGender;
        }
	}

	public int compareTo(Actor actor){

		return 0;
	}
}
