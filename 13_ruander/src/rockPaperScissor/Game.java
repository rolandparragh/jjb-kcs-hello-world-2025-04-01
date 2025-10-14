package rockPaperScissor;

import java.util.Map;

public class Game {
	
	
	private static final Map<String, String> WIN_MAP = Map.of(
	        "Kő", "Olló",
	        "Papír", "Kő",
	        "Olló", "Papír"
	    );
	
	public static String decideWinner(String player, String computer) {
        if (player.equals(computer)) {
            return "Döntetlen!";
        }
        if (WIN_MAP.get(player).equals(computer)) {
            return "Te nyertél!";
        } else {
            return "A Számítógép nyert!";
        }
    }

}
