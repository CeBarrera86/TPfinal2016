package Operacion;

import java.util.*;

import javax.sound.midi.Sequencer;

import Beat.BPMObserver;
import Beat.BeatObserver;

public class OperacionModel implements OperacionModelInterface, Runnable {
	Sequencer sequencer;
	ArrayList beatObservers = new ArrayList();
	ArrayList bpmObservers = new ArrayList();
	int time = 1000;
    int bpm = 90;
	Random random = new Random(System.currentTimeMillis());
	Thread thread;

	public OperacionModel() {
		thread = new Thread(this);
		thread.start();
	}

	public void run() {
		int lastrate = -1;

		for(;;) {
			bpm=bpm-1;
			notifyBPMObservers();
			notifyBeatObservers();
			/*int change = random.nextInt(10);
			System.out.println(change);
			if (random.nextInt(2) == 0) {
				change = 0 - change;
			}
			int rate = 60000/(time + change);
			if (rate < 120 && rate > 50) {
				time += change;
				notifyBeatObservers();
				if (rate != lastrate) {
					lastrate = rate;
					notifyBPMObservers();
				}
			}*/
			try {
				Thread.sleep(time);
			} catch (Exception e) {}
		}
	}
	public int getOperacionRate() {
		return bpm;
	}

	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}

	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}

	public void notifyBeatObservers() {
		for(int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver)beatObservers.get(i);
			observer.updateBeat();
		}
	}

	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}

	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
	}

	public void notifyBPMObservers() {
		for(int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver)bpmObservers.get(i);
			observer.updateBPM();
		}
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void on() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBPM(int bpm) {
		this.bpm = bpm;

		/*//FIX
		sequencer.setMicrosecondPosition(0);
        sequencer.setTickPosition(0) ; 
            
		sequencer.setTempoInBPM(getBPM());*/
		notifyBPMObservers();
		
	}

	@Override
	public int getBPM() {
		return bpm;
	}
}
