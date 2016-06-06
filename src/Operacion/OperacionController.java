package Operacion;

import Beat.BeatModel;
import Beat.ControllerInterface;
import Beat.DJView;
import Heart.HeartModel;
import Strategy.StrategyView;

public class OperacionController implements ControllerInterface {
	OperacionModelInterface model;
	DJView view;
	OperacionView opview;
  
	public OperacionController(OperacionModelInterface model, boolean vistaOp) {
		this.model = model;
		if(!vistaOp){
			view = new DJView(this, new OperacionAdapter(model));
        	view.createView();
        	view.createControls(true);
			view.disableStopMenuItem();
			view.disableStartMenuItem();
		}
		else{
			view = new DJView(this, new OperacionAdapter(model));
        	view.createView();
        	view.createControls(false);
			view.disableStopMenuItem();
			view.disableStartMenuItem();
			opview = new OperacionView(this, model);                      //Habilita esta parte..
			opview.setVisible(true);
		}
	}
	
	public OperacionController(OperacionModel model, StrategyView view) {
		this.view = view;
		this.view.disableStopMenuItem();
		this.view.enableStartMenuItem();
		this.model = model;
		this.model.initialize();
	}
		
	public void start() {}
 
	public void stop() {
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}
    
	public void increaseBPM() {
		
	}
    
	public void decreaseBPM() {
		
	}
		
 	public void setBPM(int bpm) {
 		model.setBPM(bpm);
 	}
 	
 	public void setBPMdead() {
 		model.setBPMdead();
 	}
}