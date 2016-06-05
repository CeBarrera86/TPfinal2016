package Operacion;

import Beat.ControllerInterface;
import Beat.DJView;

public class OperacionController implements ControllerInterface {
	OperacionModelInterface model;
	DJView view;
  
	public OperacionController(OperacionModelInterface model) {
		this.model = model;
		view = new DJView(this, new OperacionAdapter(model));
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}
		
	public void start() {}
 
	public void stop() {}
    
	public void increaseBPM() {}
    
	public void decreaseBPM() {
		int bpm = model.getBPM();
		model.setBPM(bpm-1);
	}
		
 	public void setBPM(int bpm) {
 		model.setBPM(bpm);
 	}
}