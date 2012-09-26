package sw.server;

public class Message {

	public enum MessageType {
		UPDATE, ALARM
	};

	private final int messageId;
	private final int sheepId;
	private final MessageType type;
	private final int timeSent;
	private final int timeReceived;
	private final GpsData gpsData;
	private final int pulse;
	private final double temperature;

	public Message(int messageId, int sheepId, MessageType type, int timeSent,
			int timeReceived, GpsData gpsData, int pulse, double temperature) {
		super();
		this.messageId = messageId;
		this.sheepId = sheepId;
		this.type = type;
		this.timeSent = timeSent;
		this.timeReceived = timeReceived;
		this.gpsData = gpsData;
		this.pulse = pulse;
		this.temperature = temperature;
	}

	public int getMessageId() {
		return messageId;
	}

	public int getSheepId() {
		return sheepId;
	}

	public MessageType getType() {
		return type;
	}

	public int getTimeSent() {
		return timeSent;
	}

	public int getTimeReceived() {
		return timeReceived;
	}

	public GpsData getGpsData() {
		return gpsData;
	}

	public int getPulse() {
		return pulse;
	}

	public double getTemperature() {
		return temperature;
	}
}
