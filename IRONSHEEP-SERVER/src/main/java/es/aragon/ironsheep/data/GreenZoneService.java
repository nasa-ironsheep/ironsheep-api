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
//		 Process p = Runtime.getRuntime().exec("python c:/git/backend/image.py 100.75 1.5");
//		 } catch (IOException e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 }

		return response;

	}

}
