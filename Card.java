public class Card {

	static int fight(String card1, String card2) {
		/*card1 ga kateba 0 aikode 1 make de 2 wo kaesu*/
		if (card1.equals("Emperor") && card2.equals("Citizen")) {
			return 0;
		} else if (card1.equals("Emperor") && card2.equals("Slave")) {
			return 2;
		} else if (card1.equals("Citizen") && card2.equals("Slave")) {
			return 0;
		} else if (card1.equals("Citizen") && card2.equals("Citizen")) {
			return 1;
		} else if (card1.equals("Slave") && card2.equals("Emperor")) {
			return 0;
		} else if (card1.equals("Slave") && card2.equals("Citizen")) {
			return 2;
		} else if (card1.equals("Citizen") && card2.equals("Emperor")) {
			return 2;
		} else {
			return 1;
		}

	}




}
