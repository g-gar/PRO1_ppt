package sachez.alvaro;

public class JuegoOptionUtils {

	public static JuegoOption parse(String string) {
		JuegoOption selected = null;
		switch (string.toLowerCase()) {
			case "piedra":
				selected = JuegoOption.PIEDRA; break;
			case "papel":
				selected = JuegoOption.PAPEL; break;
			case "tijeras":
				selected = JuegoOption.TIJERAS; break;
		}
		return selected;
	}
	
}
