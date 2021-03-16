package data;

public class ColorPicker {
	
	public enum Choices {
		Black,
		White,
		Red,
		Green,
		Blue;
	}
	
	static Choices choice = Choices.Black;
	
	public static Choices getColor() {
		return choice;
	}
	
	public static void setChoice(Choices colorChoice) {
		ColorPicker.choice = colorChoice;
	}
}