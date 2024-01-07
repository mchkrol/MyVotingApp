package votingapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExecuteCommandService {

    private static final String UNRECOGNIZED_COMMAND = "Unrecognized command\n";

    private static final Map<String, Long> candidates = new HashMap<>();
    private static final Map<String, Boolean> voters = new HashMap<>();

    private final Scanner scanner;

    ExecuteCommandService(Scanner scanner) {
        this.scanner = scanner;
    }

    void executeCommand(String command) {  //TODO: łańcuchy ifów na switche/obiektowe switche?
        if ("vote".equals(command)) {
            vote();
        } else if ("display".equals(command)) {
            display();
        } else if ("add".equals(command)) {
            add();
        } else if (!"exit".equals(command)){
            System.out.print(UNRECOGNIZED_COMMAND);
        }
    }

    private void vote() {
        System.out.print("Enter your name: ");
        String voter = scanner.nextLine();
        if (!voters.containsKey(voter)) {
            System.out.print("You are not registered to vote!\n");
        } else if (Boolean.TRUE.equals(voters.get(voter))) {
            System.out.print("You have already voted!\n");
        } else {
            vote(voter);
        }
    }

    private void vote(String voter) {
        System.out.print("Enter your candidate's name: ");
        String candidate = scanner.nextLine();
        if (!candidates.containsKey(candidate)) {
            System.out.print("Your candidate is not registered!\n");
        } else {
            candidates.replace(candidate, candidates.get(candidate) + 1L);
            voters.replace(voter, true);
        }
    }

    private static void display() {
        System.out.print("Candidates and their votes numbers:\n");
        System.out.print(candidates);
        System.out.print("\n");
        System.out.print("Voters and if they have already voted:\n");
        System.out.print(voters);
        System.out.print("\n");
    }

    private void add() {
        System.out.print("Who would you like to add (candidate/voter)? ");
        String command = scanner.nextLine();
        if ("candidate".equals(command)) {
            addCandidate();
        } else if ("voter".equals(command)) {
            addVoter();
        } else {
            System.out.print(UNRECOGNIZED_COMMAND);
        }
    }

    private void addCandidate() {
        System.out.print("Enter candidate's name: ");
        String candidate = scanner.nextLine();
        if (candidates.containsKey(candidate)) {
            System.out.print("The candidate is already registered!\n");
        } else {
            candidates.put(candidate, 0L);
        }
    }

    private void addVoter() {
        System.out.print("Enter voter's name: ");
        String voter = scanner.nextLine();
        if (voters.containsKey(voter)) {
            System.out.print("The voter is already registered!\n");
        } else {
            voters.put(voter, false);
        }
    }
}
