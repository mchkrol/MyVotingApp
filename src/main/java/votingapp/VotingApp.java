package votingapp;

import java.util.Scanner;

public class VotingApp {

    private static final Scanner scanner = new Scanner(System.in);


    private VotingApp() {
    }

    public static void main(String[] args) { //TODO: gitlab i jarka?
        String command = "";
        ExecuteCommandService executeCommandService = new ExecuteCommandService(scanner);
        while (!"exit".equals(command)) {
            System.out.print("Enter command (vote/add/display/exit): ");
            command = scanner.nextLine();
            executeCommandService.executeCommand(command);
        }
    }
}
