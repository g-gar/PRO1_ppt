package sanchez.alvaro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import sachez.alvaro.Juego;
import sachez.alvaro.JuegoOption;

public class MainTest {
	
	private static void checkGenerarOpcionMaquina() {
		List<Integer> values = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			values.add(new Juego().generateRandomInt(JuegoOption.values().length, 0));
		}
		System.out.println(values.stream().filter(e -> e > 2 || e < 0).collect(Collectors.toList()).size());
	}
	
	
	public static void main(String[] args) {
		MainTest test = new MainTest();
		MainTest.checkGenerarOpcionMaquina();
	}

}
