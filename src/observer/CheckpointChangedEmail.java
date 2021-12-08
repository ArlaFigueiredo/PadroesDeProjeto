package observer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckpointChangedEmail implements CheckpointObserver{
	@Override
	public void notifyStateChanged(CheckpointChangedEvent e) {
		SimpleDateFormat fd = new SimpleDateFormat("hh:mm:ss:SSSS");
		String data = fd.format(new Date());
		System.err.println("NOTIFY E-MAIL");
		System.err.println("[" + data + "] " + "Um checkpoint de " + e.getTipoCheckpoint() + " foi efetuado. " + e.getCHDisciplinas());
	}
}
