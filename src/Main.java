/**
 * 
 */


import CtrLayer.EliminatorController;

import java.util.ArrayList;

/**
 * @author Jacob
 *
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EliminatorController eliminatorController = new EliminatorController();
		eliminatorController.generateSETournament(eliminatorController.generateDummyTeams(), new ArrayList<Integer>());
	}
}
