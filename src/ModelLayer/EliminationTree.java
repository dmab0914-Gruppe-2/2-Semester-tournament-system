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
	private ArrayList<LinkedList<Match>> adjMatches; //Adjacent matches to every match within "matches". ID 0, will contain all matches adjacent to match with ID 0 in the "matches" list.
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
			adjMatches = new ArrayList<>();
			rounds = new ArrayList<>();
			generateTree(calculateHeight(calculateNodes(startMatches)));
		}
		System.out.println("Heihgt: " + calculateHeight(calculateNodes(startMatches)));
		System.out.println("matches: " + matches.size());
		System.out.println("adjMatches: " + adjMatches.size());
	}

	private Match generateTree(int height) {
		while(matches.size() < calculateNodes(startMatches)) {
			Match match = new Match();
			matches.add(match);
			LinkedList<Match> list = new LinkedList<>();
			int index = matches.indexOf(match);
			adjMatches.add(index, list);
			adjMatches.get(index).add(generateTree(height - 1));
			adjMatches.get(index).add(generateTree(height - 1));
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
}
