package es.aragon.ironsheep.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import es.aragon.ironsheep.data.entities.GreenZone;

public class GreenZoneService {

	public static String PYTHON_PATH = "C:/python27/";
	public static String PYTHON_SCRIPT = "c:/git/backend/image.py";

	public static GreenZone getGreenZone(double lng, double lat) throws Exception {
		GreenZone response = new GreenZone();

		lng = 100.5;
		lat = 1.5;

		// String prg = "import sys\nprint int(sys.argv[1])+int(sys.argv[2])\n";
		// BufferedWriter out = new BufferedWriter(new
		// FileWriter(PYTHON_SCRIPT));
		// out.write(prg);
		// out.close();
		//
		// ProcessBuilder pb = new
		// ProcessBuilder("python",PYTHON_SCRIPT,""+lng,""+lat);
		// Process p = pb.start();
		//
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(p.getInputStream()));
		//
		// System.out.println("value is : "+in.readLine());

//		String pythonScriptPath = PYTHON_SCRIPT;
//		String[] cmd = new String[4];
//		cmd[0] = "python"; // check version of installed python: python -V
//		cmd[1] = pythonScriptPath;
//		cmd[2] = lng + "";
//		cmd[3] = lat + "";
//
//		// create runtime to execute external command
//		Runtime rt = Runtime.getRuntime();
//		Process pr = rt.exec(cmd);
//
//		// retrieve output from python script
//		BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//		String line = "";
//
//		while ((line = bfr.readLine()) != null) {
//			// display each output line form python script
//			System.out.println(line);
//		}

//		 try {
//			 Runtime rt = Runtime.getRuntime();
////			 rt.exec("cmd /c start \"\" \"myshortcut.lnk\"");
//		 Process p = Runtime.getRuntime().exec("cmd /c mkdir c:/1234");
//		 } catch (IOException e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 }
		
//		System.out.println("PYTHON");
//		ProcessBuilder pb = new ProcessBuilder(
//			    "python", PYTHON_SCRIPT, "100.5 1.5"
//			);
//			Process ps = pb.start();
//
//			BufferedReader reader = new BufferedReader(
//			    new InputStreamReader(ps.getInputStream())
//			);
//
//			ps.waitFor();
//			int ec = ps.exitValue();
//			StringBuffer HTTPResponse = new StringBuffer();
//			String inputLine;
//
//			while ((inputLine = reader.readLine()) != null) {
//				System.out.println(inputLine);
////			        logger.debug(String.format("DEBUG!!!: input = %s", inputLine));
//			        HTTPResponse.append(inputLine);
//			}

		executeAsAdministrator("mkdir c:/1234", "");
		
		return response;

	}

}
