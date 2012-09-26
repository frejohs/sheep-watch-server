package sw.server.simulator;

import sw.server.Message;
import sw.server.MessageBuffer;

public class InputSimulator implements Runnable {

	volatile private boolean run;
	private volatile MessageBuffer buffer;

	public InputSimulator(MessageBuffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		run = true;
		while (run) {
//			buffer.put(generateMessage());

			try {
				Thread.sleep((int) (Math.random() * 10 * 3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void stop() {
		run = false;
	}

	private Message generateMessage() {
		// TODO
		return null;

	}

}
