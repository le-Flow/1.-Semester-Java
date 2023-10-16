package bundesliga;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * TODO: Ergänzen Sie die Klasse, wo angegeben. Für die Erzeugung eines Schlüssels aus dem Namen 
 * können Sie die Methode getKeyByName() aus der Helper-Klasse verwenden. Schlüssel sollten 
 * grundsätzlich keine Leerzeichen enthalten. Schlüssel sollten auch nur aus Großbuchstaben bestehen.
 * Damit kann sichergestellt werden, dass auch ein String " b UNDES LIGA" der richtigen Liga zugeordnet 
 * wird
 *   
 */

/** represents a league. Furthermore, it contains a static store of all created leagues */ 
public class League {
    
    /** the private static store of all leagues. The key is a String and the value is a league */
    //TODO: Deklarieren und Initialisieren Sie eine statische Map entsprechend des JavaDocs
    private Set<Team> teams;
    private Set<Game> games;
    
    /** The name of the league */
    private String name;

    /** The teams playing in the league */
    /* TODO: Deklarieren und initialisieren Sie teams mit einer passenden Collection.
     * Jedes Team darf nur ein einziges mal in der Collection vorkommen.
     * Die Sortierung ist dabei irrelevant
     */  

    /** The games played in the league */
    /* TODO: Deklarieren und initialisieren Sie games mit einer passenden Collection.
     * Jedes Game darf nur ein einziges mal in der Collection vorkommen.
     * Die Sortierung ist dabei sehr wichtig. Implementieren Sie hierfür 
     * auch die natürliche Ordnung von Game (vgl Game).
     */  
    private static Map<String, League> LeagueStore = new HashMap<>();
    /**
     * The Constructor of the team League. Checks if there is already a 
     * league whose key matches the passed name. Writes the new league in 
     * the league store.
     * 
     * @param name the name of the new team
     * @throws IllegalArgumentException if there is already a 
     * league whose key matches the passed name. 
     * @throws IllegalArgumentException if name is null or empty
     * @throws IllegalArgumentException if league with the given name already exists
     */
    public League(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name is null or empty");
        }
        String trimmedName = name.replaceAll("\\s", "");
        String leagueKey = Helper.getKeyByName(name);
        if (trimmedName.isEmpty()) {
            throw new IllegalArgumentException("name cannot be just whitespace");
        }
        if (LeagueStore.containsKey(leagueKey)) {
            throw new IllegalArgumentException("league with the given name already exists");
        }
        this.name = trimmedName;
        this.teams = new HashSet<>();
        this.games = new HashSet<>();
        LeagueStore.put(leagueKey, this);
    }




    public static void addLeague(League league) {
        if (league == null) {
            throw new IllegalArgumentException("league is null");
        }
        String name = league.getName();
        String leagueKey = Helper.getKeyByName(name);
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("league name is null or empty");
        }
        if (LeagueStore.containsKey(leagueKey)) {
            throw new IllegalArgumentException("league with the given name already exists");
        }
        LeagueStore.put(leagueKey, league);
    }

    /**
     * Adds a team to the local set teams
     * 
     * @param team the team to add
     * @throws IllegalArgumentException if team is null
     * @throws IllegalArgumentException in team is already in Set
     */
    public void addTeam(String teamName) {
        if (teamName == null) {
            throw new IllegalArgumentException("Team name cannot be null");
        }
        String trimmedTeamName = teamName.trim();
        if (trimmedTeamName.isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be empty");
        }
        addTeam(new Team(trimmedTeamName));
    }

    public void addTeam(Team team) {
        if (team == null) {
            throw new IllegalArgumentException("Team cannot be null");
        }
        if (teams.contains(team)) {
            throw new IllegalArgumentException("Team is already in set");
        }
        teams.add(team);
    }

    /**
     * Fetches a team from the static team-store based on the name passed
     * and calls addTeam(Team team) method
     * 
     * @param name the name of the team
     */
    
    /**
     * Adds a game to the local set games
     * 
     * @param game the game to add
     * @throws IllegalArgumentException if game is null
     * @throws IllegalArgumentException in game is already in Set
     */
    public void addGame(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        if (games.contains(game)) {
            throw new IllegalArgumentException("Game is already in set");
        }
        games.add(game);
    }

    

    /**
     * Fetches the matching team from the static team-store based on the name passed. 
     * Checks if team is in local Set teams. If not IllegalArgumentException is thrown.
     * 
     * @param name the name of the team
     * @return the team that matches the name given name
     * @throws IllegalArgumentException if name is null or empty
     * @throws IllegalArgumentException if no team for the name is found
     * @throws IllegalArgumentException if team is not meber of the local Set teams
     */
    public Team getTeam(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        Team team = Team.getTeam(name); // holt das Team vom Team-Store
        if (team == null) {
            throw new IllegalArgumentException("No team found for name: " + name);
        }
        if (!teams.contains(team)) {
            throw new IllegalArgumentException("Team is not a member of the local set");
        }
        return team;
    }

    
    public Table getTable(){
        return getTable(null);
    }

    public Table getTable(Integer matchDay){
        return getTable(matchDay, Table.TableType.BOTH);
    }

    public Table getTable(Integer matchDay, Table.TableType type){
        return new Table(this, matchDay, type);
    }

    public String getName() {
        return name;
    }
    

    /**
     * Returns a statement whether there is a league in the static league-store whose 
     * key matches the passed name
     * 
     * @param name the name of the league 
     * @return a statement whether there is a league in the league-store whose 
     * key matches the passed name
     * @throws IllegalArgumentException if name is null or empty
     */
    public static boolean containsLeague(String name) {
        if (name == null || name.isEmpty() || name == "" || name == " ") {
            throw new IllegalArgumentException("name is null or empty");
        }
        String leagueKey = Helper.getKeyByName(name);
        return LeagueStore.containsKey(leagueKey);
    }

    /**
     * Fetches the matching league from the static league-store based on the name passed. 
     * 
     * @param name the name of the league
     * @return the league that matches the given name
     * @throws IllegalArgumentException if name is null or empty
     * @throws IllegalArgumentException if no league for the name is found
     */
    public static League getLeague(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name is null or empty");
        }
        String leagueKey = Helper.getKeyByName(name);
        League league = LeagueStore.get(leagueKey);
        if (league == null) {
            throw new IllegalArgumentException("no league for the name is found");
        }

        return league;
    }



    /**
     * Removes a league with the given name from the static league-store
     * 
     * @param name the name of the league that should be removed
     */
    public static void removeLeague(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name is null or empty");
        }
        String leagueKey = Helper.getKeyByName(name);
        if (!LeagueStore.containsKey(leagueKey)) {
            throw new IllegalArgumentException("no league for the name is found");
        }
        LeagueStore.remove(leagueKey);
    }


    /**
     * returns a unmodifiable Copy of the local Set teams
     * 
     * @return a unmodifiable Copy of the local Set teams
     */
    public Set<Team> getTeams() {
        return Collections.unmodifiableSet(teams); // gibt eine unveränderliche Kopie der teams-Menge zurück
    }

    /**
     * returns a unmodifiable Copy of the local Set games
     * 
     * @return a unmodifiable Copy of the local Set games
     */
    public Set<Game> getGames() {
        //TODO: Implementieren Sie die Methode entsprechend des JavaDocs
        return Collections.unmodifiableSet(games); // gibt eine unveränderliche Kopie der games-Menge zurück
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
        League other = (League) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
 
}
