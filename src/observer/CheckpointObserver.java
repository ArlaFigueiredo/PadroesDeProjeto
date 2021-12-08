package observer;


public interface CheckpointObserver {
	
	public void notifyStateChanged(CheckpointChangedEvent e);

}
