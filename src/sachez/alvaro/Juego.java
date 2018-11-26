package sachez.alvaro;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Juego {
	
	public JuegoOption pedirOpcionUsuario() {
		JuegoOption selected = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("OPCION USUARIO!");
		System.out.print("Opcion: ");
		try {
			String input = "";
			while ((input = sc.nextLine()) != null && input.length() > 0 && (selected = JuegoOptionUtils.parse(input)) == null) {
				if (selected == null) {
					System.out.println("OPCION USUARIO!");
					System.out.print("Opcion: ");
				} else {
					System.out.println("Has escogido: " + selected);
				}
			}
		} catch (Exception e) {}
		
		return selected;
	}
	
	public Integer generateRandomInt(Integer maxValue, Integer minValue) {
		Random random = new Random();
		return random.nextInt() * (maxValue - minValue + 1) - minValue;
	}
	
	public JuegoOption generarOpcionOrdenador() {
		Integer rn = new Random().nextInt(JuegoOption.values().length);
		JuegoOption selected = JuegoOption.values()[rn];
		return selected;
	}
	
	public Boolean checkWinner(JuegoOption opcionUsuario, JuegoOption opcionMaquina) {
		Boolean result = false;
		JuegoOption[] options = new JuegoOption[2];
		
		if (opcionUsuario.equals(opcionMaquina)) {
			return null;
		} else {
			switch (opcionUsuario) {
				case PIEDRA:
					options = new JuegoOption[]{JuegoOption.TIJERAS, JuegoOption.PIEDRA};
					break;
				case PAPEL:
					options = new JuegoOption[]{JuegoOption.PIEDRA, JuegoOption.TIJERAS};
					break;
				case TIJERAS:
					options = new JuegoOption[]{JuegoOption.PAPEL, JuegoOption.TIJERAS};
					break;
			}
		}
		int pos = Arrays.asList(options).indexOf(opcionMaquina);
		if (pos < 0) {
			throw new NullPointerException();
		} else {
			return pos == 0 ? true : false; //TODO: add more options and set this to pos <= x ? true : false
		}
	}
	
	public static void main(String[] args) {
		
		Juego juego = new Juego();
		JuegoOption opcionUsuario;
		JuegoOption opcionMaquina;
		
		while ((opcionUsuario = juego.pedirOpcionUsuario()) != null) {
			opcionMaquina = juego.generarOpcionOrdenador();
			
			Boolean result = juego.checkWinner(opcionUsuario, opcionMaquina);
			StringBuilder sb = new StringBuilder("")
					.append(result == null 
						? "empate " 
						: result
							? "gana usuario " 
							: "gana maquina "
					)
					.append(opcionUsuario + " vs " + opcionMaquina);
			log(sb.toString());
			
		}

	}
	
	public static void log(String string) {
		System.out.println(string);
	}

}
