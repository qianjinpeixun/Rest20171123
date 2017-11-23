
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * This class is designed to simulate a Linux bash shell.
 */
public class SimpleShell {

    // Store the current directory
    private static String currentPath = "/";
    // Store the history command lines
    private static List<String> historyList = new ArrayList<>();

    /*
     * This method can handle the absolute path and relative path for cd command
     */
    public static void commandChangePath(String[] lines) {
        String newPath = "";
        // if cd xxx, then enter this directory
        if (lines.length > 1) {
            String path = lines[1];
            if (path.startsWith("/")) {
                newPath = path;
            } else {
                newPath = currentPath + "/" + path;
            }
        } else { // else set to the default folder
            String path = System.getProperty("user.dir");
            newPath = path;
        }
        // start to check if the new folder is valid or not
        try {
            // Through a ls command to test this new folder
            ProcessBuilder processBuilder = new ProcessBuilder("ls");
            processBuilder.directory(new File(newPath));
            processBuilder.redirectErrorStream(false);
            Process p = processBuilder.start();
        } catch (java.io.IOException e) {
            // the new folder is invalid
            System.out.println("invalid directory, please enter again!");
            return;
        }
        // the new folder is valid, set it's value to the current directory
        currentPath = newPath;
    }// end method

    /*
     * This method is designed to list all of the history command lines
     */
    public static void commandHisotry() {
        int no = 0;
        for (String str : historyList) {
            System.out.println(no + " " + str);
            no++;
        }
    }// end method

    /*
     * This method is designed to run the last command in the command lines
     */
    private static void runLastCommand() {
        String c = historyList.get(historyList.size() - 1);
        doCommand(c);
    }// end method

    /*
     * This method is designed to run the specific number in the command lines
     * history
     */
    private static void runCommandByNo(int no) {
        // Firstly, check if the input nubmer is valid
        if (no >= historyList.size()) {
            System.out.println("history number should be between [0 to " + (historyList.size() - 1) + "]");
        } else {
            String c = historyList.get(no);
            doCommand(c);
        }
    }// end method

    /*
     * Analysis the command and dispatch it to different method
     */
    private static void doCommand(String commandLine) {
        List<String> list = new ArrayList<>();
        String[] lines = commandLine.split(" ");
        String command = lines[0];
        // run the last command
        if (command.equals("!!")) {
            runLastCommand();
            return;
        } else if (command.startsWith("!")) {
            String index = command.substring(1, 2);
            int no = Integer.parseInt(index);
            runCommandByNo(no);
            return;
        } else if (command.equals("history")) {
            commandHisotry();
            return;
        } else if (command.startsWith("cd")) {
            commandChangePath(lines);
        } else {
            for (String line : lines) {
                list.add(line);
            }
            runCommand(list);
        }
        historyList.add(commandLine);
    }// end method

    // Run the command using processBuilder object
    private static void runCommand(List<String> list) {
        ProcessBuilder processBuilder = new ProcessBuilder(list);
        try {
            processBuilder.directory(new File(currentPath));
            processBuilder.redirectErrorStream(false);
            // start to run in separate process
            Process p = processBuilder.start();
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String in;
            // read the result
            while ((in = br.readLine()) != null) {
                System.out.println(in);
            }
        } catch (IOException e) {
            // wrong command, operation system could not find this command
            System.out.println("command not found!");
        } catch (Exception e) {
            System.out.println("Fatal errors:");
            e.printStackTrace();
        }
    }// end method

    /*
     * Entrance point
     */
    public static void main(String[] args) {
        String commandLine = null;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        // we break out with <control><C>
        while (true) {
            // read what they entered
            System.out.print("jsh>");
            try {
                commandLine = console.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // is not case sensitive for quit or exit
            if (commandLine.trim().equalsIgnoreCase("exit") || commandLine.trim().equalsIgnoreCase("quit")) {
                System.out.println("Terminating Shell...");
                break;
            }
            // if they entered a return, just loop again
            if (commandLine.equals(""))
                continue;
            // parse the input command line and try to run it in a separate
            // process
            doCommand(commandLine);
        }
    }// end main

}// end class