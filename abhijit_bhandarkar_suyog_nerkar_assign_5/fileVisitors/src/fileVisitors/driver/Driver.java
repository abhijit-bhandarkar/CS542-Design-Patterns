package fileVisitors.driver;

import fileVisitors.store.Results;
import fileVisitors.util.*;
import fileVisitors.visitor.*;

import java.io.File;

public class Driver {

	public static void main(String[] args) {
		int debug = -1;

		if (args.length == 3) {
			if (args[0].equals("${arg0}")) {
				System.err.println("ERROR: Need a INPUT file as an argument, got " + args[0]);
				System.exit(1);
			} else if (args[1].equals("${arg1}")) {
				System.err.println("ERROR: Need a OUTPUT file as an argument, got " + args[1]);
				System.exit(1);
			} else if (args[2].equals("${arg2}")) {
				System.err.println("ERROR: Need a Debug Level as an argument, got " + args[2]);
				System.exit(1);
			} else {
				String in = args[0], out = args[1];

				// Debug level validations
				try {
					debug = Integer.parseInt(args[2]);
				} catch (NumberFormatException e) {
					System.err.println("ERROR: Need a Debug Level as a number argument, got " + args[2]);
					e.printStackTrace();
					System.exit(1);
				}

				if ((debug < 0) || (debug > 4)) {
					System.err.println("ERROR: Need a Debug Level in [0 - 4] , got " + debug);
					System.exit(1);
				}

        MyLogger.setDebugValue(debug);
        MyLogger.writeMessage("SUCCESS: I have got all I need, let's proceed. \n" +
                "- Reading input from          : " + in + "\n" +
                "- Output will be written to   : " + out + "\n" +
                "- Debug level set to          : " + MyLogger.getDebugValue() + "\n\n",
            MyLogger.DebugLevel.IN_RUN
        );


				File file = new File(args[0]);
				if (file.length() == 0) {
					MyLogger.writeMessage("Input file is Missing or Empty, provide proper input", MyLogger.getDebugValue());
					System.exit(1);
				}

				// Create instances
				Results res = new Results();
				// Tree instance implementing TreeBuilder Interface.
				TreeBuilder tree = new BinarySearchTree();

				// Visitor instances.
        VisitorI popVis = new PopulateVisitor(in);
        VisitorI palHlt = new PalindromeHighlight();
        VisitorI pl = new PrimeLength();
        VisitorI pt = new PrintTree(res, out);

        // Accept visitors one by one to operate on same tree instance
				tree.accept(popVis);
        tree.accept(palHlt);
				tree.accept(pl);
				tree.accept(pt);
			}
		} else {
			// MyLogger not initialized yet, so need sys error.
			System.err.println("ERROR: Unexpected commandline arguments, got " + args.length + " args." +
					"\n- ADVICE: Please provide proper arguments to command listed below." +
					"\n- EXPECTED: ant -buildfile src/build.xml run -Darg0=<INPUT FILE NAME> -Darg1=<OUTPUT FILE NAME>" +
					" -Darg2=<LOGGER LEVEL>");
			System.exit(1);
		}
	}
}
