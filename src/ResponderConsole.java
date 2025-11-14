import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResponderConsole {
    private static final String DEFAULT_SENDER = "Unit Bravo";
    private final List<Message> outbox = new ArrayList<>();
    private boolean alertEnabled = true;

    public static void main(String[] args) {
        new ResponderConsole().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Responder Console ===");
        System.out.println("Commands: [M] create message  [S] send last  [P] print outbox  [T] toggle alert  [H] help  [Q] quit");

        boolean running = true;
        while (running) {
            System.out.print("\nEnter command: ");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            char cmd = Character.toUpperCase(line.charAt(0));

            switch (cmd) {
                case 'M':
                    createMessage(sc);
                    break;
                case 'S':
                    sendLastMessage();
                    break;
                case 'P':
                    printOutbox();
                    break;
                case 'T':
                    toggleAlert();
                    break;
                case 'H':
                    printHelp();
                    break;
                case 'Q':
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command. Press H for help.");
            }
        }

        sc.close();
        System.out.println("\nResponder console finished. Screenshot the terminal to show interactivity.");
    }

    private void createMessage(Scanner sc) {
        System.out.print("Recipient (for demo only): ");
        String recipient = sc.nextLine().trim();
        System.out.print("Message content: ");
        String content = sc.nextLine().trim();
        String composed = (recipient.isEmpty() ? "" : "To " + recipient + " - ") + content;
        Message msg = new Message(DEFAULT_SENDER, composed);
        outbox.add(msg);
        System.out.println("Message created and saved to outbox.");
        msg.display();
    }

    private void sendLastMessage() {
        if (outbox.isEmpty()) {
            System.out.println("Outbox empty. Create a message first (M).");
            return;
        }
        Message last = outbox.get(outbox.size() - 1);
        System.out.println("Sending last message:");
        last.display();

        // simple delivery simulation
        DeliverySimulator.deliver(last);

        if (alertEnabled) {
            System.out.println("[Alert] Playing alert sound (simulated).");
        } else {
            System.out.println("[Alert] Alert is muted.");
        }
    }

    private void printOutbox() {
        if (outbox.isEmpty()) {
            System.out.println("Outbox is empty.");
            return;
        }
        System.out.println("Outbox messages:");
        for (int i = 0; i < outbox.size(); i++) {
            System.out.print((i + 1) + ". ");
            outbox.get(i).display();
        }
    }

    private void toggleAlert() {
        alertEnabled = !alertEnabled;
        System.out.println("Alert enabled: " + alertEnabled);
    }

    private void printHelp() {
        System.out.println("M = create message (stores to outbox)");
        System.out.println("S = send last message (simulates delivery + optional alert)");
        System.out.println("P = print all messages in outbox");
        System.out.println("T = toggle alert on/off");
        System.out.println("Q = quit");
    }

    private static class DeliverySimulator {
        static void deliver(Message m) {
            System.out.println("[Network] Simulating broadcast...");
            System.out.println("[Network] Delivered to: Local first responders");
            System.out.println("[Network] Delivered to: Nearby users");
            System.out.println("[Network] Delivery complete.");
        }
    }
}