package Operacion;

import java.util.*;
import javax.sound.midi.*;

import Beat.BPMObserver;
import Beat.BeatObserver;

public class OperacionModel implements OperacionModelInterface, Runnable {
	Sequencer sequencer;
	ArrayList beatObservers = new ArrayList();
	ArrayList bpmObservers = new ArrayList();
	int time = 2000;
    int bpm;
    Sequence sequence;
    Track pista;
	Thread thread;

	public OperacionModel() {
		thread = new Thread(this);
		thread.start();
	}

	public void run() {
		beep();
		for(;;) {
			if(bpm>0){
				bpm=bpm-10;
				setBPM(bpm);
				notifyBeatObservers();
				if(bpm==0){
					System.out.println("Your patient is dead!");
					setBPMdead(220);
				}
			}
			else{
				
			}
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

	}

	@Override
	public void on() {
		
	}

	@Override
	public void off() {

	}

	@Override
	public void setBPM(int bpm) {
		this.bpm = bpm;		
		notifyBPMObservers();
		sequencer.setTempoInBPM(bpm);
	}

	public void setBPMdead(int bpm){
		sequencer.setTempoInBPM(320);
	}
	
	@Override
	public int getBPM() {
		return bpm;
	}
	
	public void sonarbeep(Track pista, int nota, int pos, int vol) throws InvalidMidiDataException{
	     ShortMessage on = new ShortMessage( );
	     on.setMessage(ShortMessage.NOTE_ON,  0, nota, vol);
	     pista.add(new MidiEvent(on, pos));
	        
	     ShortMessage off = new ShortMessage( );
	     off.setMessage(ShortMessage.NOTE_OFF, 0, nota, vol);
	     pista.add(new MidiEvent(off, pos));     
	}
	
	public void beep(){
		try{     
            sequencer = MidiSystem.getSequencer( );
            sequence = new Sequence(Sequence.PPQ, 4);
            pista = sequence.createTrack();
            
            sequencer.open( );  
            sequencer.setSequence(sequence);
            setBPM(60);
            ShortMessage ins = new ShortMessage( );
            ins.setMessage(ShortMessage.PROGRAM_CHANGE,  0, 5, 0);
            pista.add(new MidiEvent(ins, 0));
            for (int n=0;n< 64;n++){
                sonarbeep(pista, 67, n, 120);
            }
            sequencer.start( );
      }catch(Exception e){
        e.printStackTrace();
      }
    }
	    
}


