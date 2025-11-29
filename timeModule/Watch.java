import java.util.List;

public class Watch{
	
	private List<TimeModule> allModules;
	private int currentModuleIndex;
	private TimeModule module;

	public Watch( List<TimeModule> allModules) {
		this.allModules=allModules;
		this.currentModuleIndex=0;
		this.module = allModules.get(0);
	}
	
	public void displayTime() {
		System.out.println(module.getCurrentTime());
	}
	
	public void nextModule() {
		currentModuleIndex = (currentModuleIndex +1) % allModules.size();
		this.module = allModules.get(currentModuleIndex);
	}
}
