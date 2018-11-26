package uem.prog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import uem.prog.Game;
import uem.prog.GameOption;
import uem.prog.GameOptionUtils;

public class MainTest {
	
	private static void checkGenerateOptionMachine() {
		List<Integer> values = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			values.add(GameOptionUtils.generateRandomInt(GameOption.values().length, 0));
		}
		System.out.println(values.stream().filter(e -> e > 2 || e < 0).collect(Collectors.toList()).size());
	}
	
	public static void checkGame() {
		List<List<GameOption>> values = new ArrayList<List<GameOption>>();
		for (int i = 0; i < 100; i++) {
			values.add(new ArrayList() {
				{
					add(GameOption.values()[GameOptionUtils.generateRandomInt(GameOption.values().length, 0)]);
					add(GameOption.values()[GameOptionUtils.generateRandomInt(GameOption.values().length, 0)]);
				}
			});
		}
		
		for (List<GameOption> list : values) {
			System.out.println(list.get(0) + " & " + list.get(1) + ": " + new Game().checkWinner(list.get(0), list.get(1)));
		}
	}
	
	public static void main(String[] args) {
		MainTest test = new MainTest();
		MainTest.checkGenerateOptionMachine();
		MainTest.checkGame();
	}

}
