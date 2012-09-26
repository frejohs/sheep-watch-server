package sw.server.simulator;

import sw.server.Message;
import sw.server.Server;

public class InputSimulator {

	private boolean run;
	private Server server;

	public void main(String[] args) {
		InputSimulator sim = new InputSimulator();
		sim.run();

	}

	public void run() {
		run = true;
		server = new Server();
		while (run) {

			server.processMessage(generateMessage());

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
