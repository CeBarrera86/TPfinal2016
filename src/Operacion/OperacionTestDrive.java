package Operacion;

import Beat.ControllerInterface;

public class OperacionTestDrive {

    public static void main (String[] args) {
		play();
    }
    public static void play(){
    	OperacionModel operacionModel = new OperacionModel();
        ControllerInterface model = new OperacionController(operacionModel);
        OperacionView operacionView = new OperacionView(model);
    	operacionView.setVisible(true);
    }
}