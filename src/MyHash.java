/**
 * Class for a hashmap for movies
 *  @author Daemon-Macklin  Niall-Mulcahy
 */

public class MyHash{

    private Movie[] hashTable;

    /**
     * Constructor
     * @param size size of table(10)
     */
    public MyHash(int size){

        hashTable = new Movie [size];

    }

    /**
     * Gets size of table
     * @return
     */
    public int size(){

        return hashTable.length;
    }

    /**
     * Method to add item to table
     * @param item
     * @return
     */
    public int addItem(Movie item){
        boolean foundPlace = false;
        int found = -1;
        while(!foundPlace) {
            if (hashTable[0] == null) {
                hashTable[0] = item;
                found = 0;
                foundPlace = true;
            }
            else {
                int i = this.hashFunction(item.getTitle());
                while (i < hashTable.length) {
                    if (hashTable[i] == null) {
                        hashTable[i] = item;
                        return i;
                    }
                        i += 1;
                }
                System.out.println("Hash full");
                return -1;
            }
        }
        return found;
    }

    /**
     * Hash function to generate key based on length of string
     * @param title
     * @return
     */
    private int hashFunction(String title) {
        int key = title.length();
        key = key%hashTable.length;
        return key;
    }

    /**
     * Method to find the location of an item in list
     * @param item
     * @return
     */
    public int findObjectLocation(Movie item){
            int key = hashFunction(item.getTitle());
                for (int i = key;  i < hashTable.length; i++) {
                    if (hashTable[i] != null) {
                        if (hashTable[i].getId() == item.getId()) {
                            return i;
                        }
                    }
                }
                for(int k = 0; k < key; k++){
                    if(hashTable != null) {
                        if (hashTable[k].getId() == item.getId()) {
                            return k;
                        }
                    }
                }
        return -1;
    }

    /**
     * Method to get the load factor of the table
     * @return
     */
    public double loadFactor(){
        double usedSpots = 0;
        double loadFactor;
        for(int i = 0; i < hashTable.length;i++){
            if(hashTable[i] != null){
                usedSpots += 1;
            }
        }
        loadFactor = (usedSpots/hashTable.length);
        return loadFactor;
    }

    /**
     * Method to view the items in the table
     * @return
     */
    public String view(){
        String str = "";
        if(isEmpty()){
            str = "Hash empty";
        }
        else {
            str = str + "====================\nHash Table\n--------------------" +
                    "\nLoad Factor: "+loadFactor()+"\n====================\n";
            for(int i=0;i<hashTable.length;i++)
                str = str + i + ". "+hashTable[i] + ", \n";
        }
        return str;
    }

    /**
     * Method to get item from table
     * @param i
     * @return
     */
    public Movie getItem(int i){

        return hashTable[i];

    }

    /**
     * Method to check if list is empty
     * @return
     */
    public boolean isEmpty(){
        if(hashTable[0]==null){
            return true;
        }
        return false;
    }
}