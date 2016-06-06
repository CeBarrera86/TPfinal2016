package Heart;

import Beat.ControllerInterface;

public class HeartTestDrive {

    public static void main (String[] args) {
		play();
    }
    public static void play(){
    	HeartModel heartModel;
    	heartModel = HeartModel.obtenerSingleton();
        ControllerInterface model = new HeartController(heartModel);
    }
}
