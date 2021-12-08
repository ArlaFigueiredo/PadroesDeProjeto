package observer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckpointNotifyLogger implements CheckpointObserver{
	
	@Override
	public void notifyCheckpoint(CheckpointNotifyEvent e) {
		SimpleDateFormat fd = new SimpleDateFormat("hh:mm:ss:SSSS");
		String data = fd.format(new Date());
		System.err.println("NOTIFY LOGGER");
		System.err.println("[" + data + "] " + "Um checkpoint de " + e.getTipoCheckpoint() + " foi efetuado. " + e.getCHDisciplinas());
	}

}
