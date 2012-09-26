package sw.server;

import java.util.Scanner;

import sw.server.simulator.InputSimulator;

public class ServerCLI {

	private Server server;
	private Thread serverThread;
	private InputSimulator simulator;
	private Thread simThread;
	private boolean run;

	public static void main(String[] args) {
		ServerCLI sc = new ServerCLI();
		sc.run();
	}

	public void run() {
		startServer();
		startSimulator();

		// init input simulator

		Scanner scanner = new Scanner(System.in);
		run = true;
		while (run) {
			System.out.print("sheepwatch:> ");
			String str = scanner.next();
			if (str.equals("server start")) {
				if (!serverThread.isAlive())
					serverThread.start();
			} else if (str.equals("server stop")) {
				if (serverThread.isAlive()) {
					serverThread.interrupt();
					server.stop();
				}

			} else if (str.equals("sim start")) {
				if (!simThread.isAlive()) {
					simThread.start();
				}

			} else if (str.equals("sim stop")) {
				if (simThread.isAlive()) {
					simThread.interrupt();
					simulator.stop();
				}
			} else if (str.equals("exit") && str.equals("quit")) {
				run = false;
			} else if (str.equals("help")) {

			} else {
				System.out.println("invalid command, try 'help' for help.");
			}
		}
	}

	public void startServer() {
		server = new Server();
		serverThread = new Thread(server);
		serverThread.setDaemon(true);
		serverThread.start();
	}

	public void startSimulator() {
		simulator = new InputSimulator(server.getBuffer());
		simThread = new Thread(simulator);
		simThread.setDaemon(true);
		simThread.start();

	}
}
