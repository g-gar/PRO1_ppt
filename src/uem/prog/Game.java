package uem.prog;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
	
	public GameOption generateOptionUser() {
		GameOption selected = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("OPCION USUARIO!");
		System.out.print("Opcion: ");
		try {
			String input = "";
			while ((input = sc.nextLine()) != null && input.length() > 0 && (selected = GameOptionUtils.parse(input)) == null) {
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
	
	public GameOption generateOptionMachine() {
		Integer rn = GameOptionUtils.generateRandomInt(GameOption.values().length, 0);
		GameOption selected = GameOption.values()[rn];
		return selected;
	}
	
	public Boolean checkWinner(GameOption optionUser, GameOption optionMachine) {
		Boolean result = false;
		GameOption[] options = new GameOption[2];
		
		if (optionUser.equals(optionMachine)) {
			return null;
		} else {
			switch (optionUser) {
				case PIEDRA:
					options = new GameOption[]{GameOption.TIJERAS, GameOption.PAPEL};
					break;
				case PAPEL:
					options = new GameOption[]{GameOption.PIEDRA, GameOption.TIJERAS};
					break;
				case TIJERAS:
					options = new GameOption[]{GameOption.PAPEL, GameOption.PIEDRA};
					break;
			}
		}
		int pos = Arrays.asList(options).indexOf(optionMachine);
		if (pos < 0) {
			throw new NullPointerException("" + pos + " & " + optionUser + " & " + optionMachine);
		} else {
			return pos == 0 ? true : false; //TODO: add more options and set this to pos <= x ? true : false
		}
	}
	
	public static void main(String[] args) {
		
		Game juego = new Game();
		GameOption optionUser;
		GameOption optionMachine;
		
		while ((optionUser = juego.generateOptionUser()) != null) {
			optionMachine = juego.generateOptionMachine();
			
			Boolean result = juego.checkWinner(optionUser, optionMachine);
			StringBuilder sb = new StringBuilder("")
					.append(result == null 
						? "empate " 
						: result
							? "gana usuario " 
							: "gana maquina "
					)
					.append(optionUser + " vs " + optionMachine);
			log(sb.toString());
			
		}

	}
	
	public static void log(String string) {
		System.out.println(string);
	}

}
