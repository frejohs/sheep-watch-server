package sw.server.simulator;

import sw.server.GpsData;
import sw.server.Message;
import sw.server.Message.MessageType;
import sw.server.MessageBuffer;
import sw.server.ServerCLI;

public class InputSimulator implements Runnable {

	private ServerCLI ui;
	volatile private boolean run;
	private volatile MessageBuffer buffer;
	private int nOfDailyUpdates = 3;
	private int nOfSheep = 10000;
	private int alarmInterval = 30; // hours

	private long sheepId;
	private long msgId;

	public InputSimulator(ServerCLI ui, MessageBuffer buffer) {
		this.buffer = buffer;
		this.ui = ui;
	}

	public void run() {
		run = true;
		while (run) {
			buffer.put(generateMessage());

			try {
				Thread.sleep(getUpdateInterval());
			} catch (InterruptedException e) {
				run = false;
				return;
			}
		}
	}

	public long getUpdateInterval() {
		return 3600000 / (nOfSheep * nOfDailyUpdates) / 24;
	}

	public void stop() {
		run = false;
	}

	private Message generateMessage() {
		return new Message(msgId++, sheepId++, MessageType.UPDATE, 0, 0, new GpsData(), 0, 0);
	}

}
