package runner;

import java.io.File;
import java.util.Scanner;

public class RunBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("INSTAGRAM AUTOMATION BOT");

        // === INPUT HASHTAG ===
        System.out.println("SCRAPING CONFIGURATION");
        System.out.print("Enter hashtag (without #): ");
        String hashtag = scanner.nextLine().trim();

        if (hashtag.isEmpty()) {
            hashtag = "purwokerto"; // Default
            System.out.println("Using default: purwokerto");
        }

        System.setProperty("hashtag", hashtag);

        // === SELECT ACTION MODE ===
        System.out.println("ACTION MODE SELECTION");
        System.out.println("1. Auto Like + Comment");
        System.out.println("2. Auto Follow + DM");
        System.out.print("Select mode (1 or 2): ");

        String modeInput = scanner.nextLine().trim();

        // Validate input
        if (!modeInput.equals("1") && !modeInput.equals("2")) {
            System.out.println("Invalid input! Using default mode 1.");
            modeInput = "1";
        }

        System.setProperty("actionMode", modeInput);

        String selectedAction = modeInput.equals("1") ? "Auto Like + Comment" : "Auto Follow + DM";
        System.out.println("\n✓ Configuration complete!");
        System.out.println("  Hashtag: #" + hashtag);
        System.out.println("  Action: " + selectedAction);
        System.out.println("\nStarting bot...\n");

        // === RUN CUCUMBER ===
        try {
            io.cucumber.core.cli.Main.main(new String[]{
                    "--glue", "step",
                    "src/test/java/features",
                    "--plugin", "pretty"
            });
        } catch (Exception e) {
            System.out.println("Failed to run bot: " + e.getMessage());
            e.printStackTrace();
        }

        scanner.close();
    }
}
