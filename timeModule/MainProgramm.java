import java.util.Arrays;

public class MainProgramm {
	public static void main(String [] args) {
		
		Time24Module t24 = new Time24Module();
		Time12Module t12 = new Time12Module();

		Watch watch = new Watch(Arrays.asList(t24, t12)); // List.of не работает для java младше 9 версии, а у меня 1.8(( 
		
		watch.displayTime();
		
		watch.nextModule();
		
		watch.displayTime();

	}
}
