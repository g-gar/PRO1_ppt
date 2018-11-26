package uem.prog;

import java.util.Random;

public class GameOptionUtils {

	public static GameOption parse(String string) {
		GameOption selected = null;
		switch (string.toLowerCase()) {
			case "piedra":
				selected = GameOption.PIEDRA; break;
			case "papel":
				selected = GameOption.PAPEL; break;
			case "tijeras":
				selected = GameOption.TIJERAS; break;
		}
		return selected;
	}
	
	public static Integer generateRandomInt(Integer maxValue, Integer minValue) {
		Random random = new Random();
		return random.nextInt(maxValue - minValue) + minValue;
	}
}
