package br.com.cursojsf.listeners;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class MyPhaseListener implements  PhaseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -284189317128925805L;

	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("Antes da fase: " + event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("Depois da fse: " + event.getPhaseId());
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
