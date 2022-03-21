package edu.ntnu.idatt1002.g106.handballapp.mvp.backend;

import java.util.HashMap;
import java.util.Map;

/**
 * This class creates a structure for the results of the matches. The match results are stored using a Map.
 */
public class Results {
    private Map<Integer, Match> matchResults;

    /**
     * Constructor for results
     */
    public Results() {
        matchResults = new HashMap<>();
    }

    /**
     * This method adds a match to the matchResults map.
     * @param match Match to be added
     * @return      Status on whether the match was successfully added, true if yes, else false
     */
    public boolean addMatchToResults(Match match){
        if(match == null || !matchResults.containsKey(match.getMatchID())) return false;
        /*
        for(int existingMatchID : matchResults.keySet()){
            if(existingMatchID == match.getMatchID()){
                return false;
            }
        }
         */
        matchResults.put(match.getMatchID(), match);
        return true;
    }

    /**
     * This method retrieves the map of results.
     * @return Match results map
     */
    public Map<Integer, Match> getMatchResults() {
        return matchResults;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("These are the results of the matches: ");
        for(Match match : this.getMatchResults().values()){
            sb.append("\n").append(match.toString());
        }
        return sb.toString();
    }
}
