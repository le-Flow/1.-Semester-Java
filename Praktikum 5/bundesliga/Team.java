package bundesliga;


import java.util.HashMap;
import java.util.Map;

/**
 * The class team represents a team. Furthermore, it contains a static store of all created teams
 */ 
public class Team {

    private static Map<String, Team> teamStore = new HashMap<>();


    /** The name of the team */
    private final String name;
    private String key;

    /**
     * The Constructor of the team class. Checks if there is already a 
     * team whose key matches the passed name. Writes the new team in 
     * the team store.
     * 
     * @param name the name of the new team
     * @throws IllegalArgumentException if there is already a 
     * team whose key matches the passed name. 
     * @throws IllegalArgumentException if name is null or empty
     */
    
    public Team(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be null or empty.");
        }
        String key = Helper.getKeyByName(name).toUpperCase().replaceAll("\\s", "");
        if (teamStore.containsKey(key)) {
            throw new IllegalArgumentException("A team with the same key already exists.");
        }
        this.name = name;
        this.key = key;
        teamStore.put(key, this);
    }

    public String getName() {
        return name.trim();
    }

    public String getKey() {
        return key;
    }

    /**
     * Returns a statement whether there is a team in the static team-store whose 
     * key matches the passed name
     * 
     * @param name the name of the team 
     * @return a statement whether there is a team in the team-store whose 
     * key matches the passed name
     * @throws IllegalArgumentException if name is null or empty
     */
    public static boolean contains(String name){
        //TODO: Implementieren Sie die Methode entsprechend des JavaDocs 
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be null or empty.");
        }
        String key = Helper.getKeyByName(name).toUpperCase().replaceAll("\\s", "");
        return teamStore.containsKey(key);
    }

    /**
     * Fetches the matching team from the static team-store based on the name passed. 
     * 
     * @param name the name of the team
     * @return the team that matches the given name
     * @throws IllegalArgumentException if name is null or empty
     * @throws IllegalArgumentException if no team for the name is found
     */
    public static Team getTeam(String name){
        //TODO: Implementieren Sie die Methode entsprechend des JavaDocs 
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be null or empty.");
        }
        String key = Helper.getKeyByName(name).toUpperCase().replaceAll("\\s", "");
        if (!teamStore.containsKey(key)) {
            throw new IllegalArgumentException("No team found for the given name.");
        }
        return teamStore.get(key);
    }

    /**
     * Removes a team with the given name from the team store
     * 
     * @param name the name of the team that should be removed
     */
    public static void removeTeam(String name){
        //TODO: Implementieren Sie die Methode entsprechend des JavaDocs
        String key = Helper.getKeyByName(name).toUpperCase().replaceAll("\\s", "");
        teamStore.remove(key);
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Team other = (Team) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    

    


    
}
