package Operacion;

import Beat.BPMObserver;
import Beat.BeatObserver;

public interface OperacionModelInterface {
	int getOperacionRate();
	void initialize();
	void on();
	void off();
    void setBPM(int bpm);  
	int getBPM();
	void registerObserver(BeatObserver o);
	void removeObserver(BeatObserver o);
	void registerObserver(BPMObserver o);
	void removeObserver(BPMObserver o);
}