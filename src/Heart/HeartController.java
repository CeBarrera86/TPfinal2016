package Heart;

import Beat.ControllerInterface;
import Beat.DJView;
import Strategy.StrategyView;

public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	DJView view;
  
	public HeartController(HeartModelInterface model) {
		this.model = model;
		view = new DJView(this, new HeartAdapter(model));
        view.createView();
        view.createControls(true);
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}
	
	public HeartController(StrategyView view){
		this.view = view;
		this.model = HeartModel.obtenerSingleton();
		this.view = view;
		this.view.disableStopMenuItem();
		this.view.disableStartMenuItem();
	}
  
	public void start() {
		model.on();
	}
 
	public void stop() {
		model.off();
	}
    
	public void increaseBPM() {
		HeartModel.obtenerSingleton();
        //System.out.println(model.getBPM());
		view.updateBPM();
	}
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {}

	@Override
	public void setBPMdead() {
		// TODO Auto-generated method stub
		
	}
}



