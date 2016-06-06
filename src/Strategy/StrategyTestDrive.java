package Strategy;

public class StrategyTestDrive {

	public static void main(String[] args) {
		play();
		
	}
	public static void play(){
		StrategyView view = new StrategyView();
		view.createView();
		view.createControls(true);
	}
}
