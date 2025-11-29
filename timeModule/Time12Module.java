import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time12Module implements TimeModule {
	public String getCurrentTime() {
		LocalTime now = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		return now.format(formatter).toString();
	}
}
