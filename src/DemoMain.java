import java.util.Scanner;

public class DemoMain {
    public static void main(String[] args) {
        AppController app = new AppController();
        app.startApp();

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("\nInteractive demo — commands: [S] send SOS  [R] restart info  [H] help  [Q] quit");

        while (running) {
            System.out.print("\nEnter command: ");                  
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            char cmd = Character.toUpperCase(line.charAt(0));

            switch (cmd) {
                case 'S':
                    System.out.print("Confirm send SOS? (y/n): ");
                    String confirm = sc.nextLine().trim();
                    if (confirm.equalsIgnoreCase("y")) {
                        app.sendSOS();
                        System.out.println("SOS sent.");
                    } else {
                        System.out.println("Canceled.");
                    }
                    break;
                case 'R':
                    System.out.println("Re-displaying app info:");
                    app.startApp();
                    break;
                case 'H':
                    System.out.println("Commands: S = send SOS (with confirm), R = restart/show info, Q = quit");
                    break;
                case 'Q':
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command. Press H for help.");
            }
        }

        sc.close();
        System.out.println("\nDemo finished. Take screenshots of the terminal showing the actions.");
    }
}