/**
 * 
 */
package CtrLayer;

import java.util.ArrayList;

import ModelLayer.EliminationTree;
import ModelLayer.Match;

/**
 * @author Jacob
 *
 */
public class EliminationController {
	
	EliminationTree elim;

	/**
	 * 
	 */
	public EliminationController() {
		// TODO Auto-generated constructor stub
		elim = new EliminationTree(8);
		printTree();
	}
	
	private void printTree() { //TODO Care enough to actually finish this.
		for(Match m : elim.getMatchesInRound(1)) {
			System.out.println(m);
		}
	}

}
