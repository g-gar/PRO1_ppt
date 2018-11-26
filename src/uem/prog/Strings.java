package uem.prog;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {
	private static List<String> strings = new ArrayList() {
		{
			add("OPCION USUARIO!");
			add("Opcion: ");
			add("Has escogido: %GameOption%");
			add("%int% & %GameOption% & %GameOption%");
			add("empate ");
			add("gana usuario ");
			add("gana maquina ");
			add("%GameOption% vs %GameOption%");
		}
	};
	
	public static String s(int index) {
		return strings.get(index);
	}
	
	public static String s(int index, Object... replacements) {
		String string = s(index);
		for (Object replacement : replacements) {
			String a = findRegexpGroup("(\\%"+ replacement.getClass().getSimpleName() +"\\%)+", string);
			string = string.replace("%"+ replacement.getClass().getSimpleName() +"%", replacement.toString());
		}
		return string;
	}
	
	public static String findRegexpGroup(String regexp, String input) {
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(input);
				
		if (matcher.find()) {
			return matcher.group(1);
		}
		
		return null;
	}
}
