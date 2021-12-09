package observer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckpointNotifyWhastapp implements CheckpointObserver{
	
	@Override
	public void notifyCheckpoint(CheckpointNotifyEvent e) {
		SimpleDateFormat fd = new SimpleDateFormat("hh:mm:ss:SSSS");
		String data = fd.format(new Date());
		System.err.println("NOTIFY WHATSAPP");
		System.err.println("[" + data + "] " + "A "+ e.getTipoCheckpoint() + " de um checkpoint foi efetuado. \n" + e.getCHDisciplinas());
	}

}
