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
	//BeatObserver
	void registerObserver(BeatObserver o);
	void removeObserver(BeatObserver o);
	//BPMObserver
	void registerObserver(BPMObserver o);
	void removeObserver(BPMObserver o);
	//CuerpoObserver
	void registerObserver(CuerpoObserver o);
	void removeObserver(CuerpoObserver o);
	void setBPMdead();
	void recomenzar();
}