package Beat;
  
public class DJTestDrive {

    public static void main (String[] args) {
        play();
    }
    public static void play(){
    	BeatModelInterface model = new BeatModel();
		ControllerInterface controller = new BeatController(model);
    }
}
