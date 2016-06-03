package Operacion;

import Beat.BPMObserver;
import Beat.BeatModelInterface;
import Beat.BeatObserver;

public class OperacionAdapter implements BeatModelInterface {
	OperacionModelInterface operacion;
 
	public OperacionAdapter(OperacionModelInterface operacion) {
		this.operacion = operacion;
	}

    public void initialize() {}
  
    public void on() {}
  
    public void off() {}
   
	public int getBPM() {
		return operacion.getOperacionRate();
	}
  
    public void setBPM(int bpm) {}
   
	public void registerObserver(BeatObserver o) {
		operacion.registerObserver(o);
	}
    
	public void removeObserver(BeatObserver o) {
		operacion.removeObserver(o);
	}
     
	public void registerObserver(BPMObserver o) {
		operacion.registerObserver(o);
	}
  
	public void removeObserver(BPMObserver o) {
		operacion.removeObserver(o);
	}
}
