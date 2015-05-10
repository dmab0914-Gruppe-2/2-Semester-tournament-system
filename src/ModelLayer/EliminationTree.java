/**
 * 
 */
package ModelLayer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jacob
 *
 */
public class EliminationTree {

	private ArrayList<Match> matches; //Should be changed to contain Matches when created.
	private ArrayList<LinkedList<Match>> childrenMatches; //children matches to another match. ID 0, will contain all matches adjacent to match with ID 0 in the "matches" list.
	private ArrayList<ArrayList<Match>> rounds; //ID 0 will be round 1, ID 1 will be round 2. and so on..
	private int startMatches; //Number of matches in first round.

	/**
	 * Generates the tree depended on the amount of matches in the first round. 
	 * @param startMatches	Start matches in round 1.
	 */
	public EliminationTree(int startMatches) {
		this.startMatches = startMatches;
		if(startMatches % 2 == 0) {
			matches = new ArrayList<>();
			childrenMatches = new ArrayList<>();
			rounds = new ArrayList<>();
			generateTree(calculateHeight(calculateNodes(startMatches)));
		}
		System.out.println("");
		System.out.println("Height: " + calculateHeight(calculateNodes(startMatches)));
		System.out.println("matches: " + matches.size());
		System.out.println("adjMatches: " + childrenMatches.size());
		System.out.println("Rounds size: " + rounds.size());
		for(LinkedList<Match> l : childrenMatches) {
			System.out.println(l.size());
		}
		for(ArrayList<Match> l : rounds) {
			System.out.println(l.size());
		}
	}

	private Match generateTree(int height) { //TODO add to rounds list
		if(height != 0) {
			System.out.println("Height: " + height);
			Match match = new Match();
			matches.add(match);
			int index = matches.indexOf(match);
			System.out.println("Index: " + index);
			LinkedList<Match> list = new LinkedList<>();
			childrenMatches.add(index, list);
			childrenMatches.get(index).add(generateTree(height - 1));
			childrenMatches.get(index).add(generateTree(height - 1));
			if(rounds.isEmpty()) {
				for(int i = 0; i < calculateHeight(calculateNodes(startMatches)); i++) {
					rounds.add(i, new ArrayList<>());
				}
			}
			rounds.get(height -1).add(match);
			return match;
		}
		return null;
	}

	/**
	 * Calculates the total amount of matches in the tree given from the amount of nodes farthest out.
	 * @param matches
	 * @return	The total amount of nodes in the tree.
	 */
	private int calculateNodes(int matches) {
		return matches * 2 -1;
	}

	/**
	 * Calculates the height of the tree, depending on how many nodes it contain.
	 * @param matchesInTree matches in the tree.
	 * @return	The height of the tree.
	 */
	private int calculateHeight(int nodesInTree) {
		if(nodesInTree == 0) {
			return 0;
		}
		else if(nodesInTree % 2 != 0) {
			return 1 + calculateHeight(nodesInTree - 1);
		}
		return calculateHeight(nodesInTree / 2);
	}
	
	public ArrayList<Match> getMatchesInRound(int round) {
		return rounds.get(round - 1);
	}
	
	public Match getParent(Match match) {
		for(int i = 0; i < childrenMatches.size(); i++) {
			for(int ii = 0; ii < childrenMatches.get(i).size(); ii++) {
				if(childrenMatches.get(i).get(ii) == match) {
					return matches.get(i);
				}
			}
		}
		return null;
	}
	
	public List<Match> getChildren(Match match) {
		int i = matches.indexOf(match);
		if(i != -1) {
			return childrenMatches.get(i);
		}
		return null;
	}
}
