package commandLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandExecutor {

	public String execute(String command) {
		StringBuffer outcome = new StringBuffer();
		Runtime runtime = Runtime.getRuntime();
		
		try {
			Process process = runtime.exec(command);
			process.waitFor();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = "";
			while ((line = reader.readLine()) != null) {
				outcome.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return outcome.toString();
	}
}

