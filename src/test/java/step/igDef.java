package step;

import io.cucumber.java.en.*;
import pages.igLogic;

public class igDef {

    igLogic allpage;
    String hashtag;
    int actionMode;

    public igDef() {
        this.allpage = new igLogic();
    }

    // ==================== NEW FLOW METHODS ====================

    @Given("user start the bot")
    public void userStartBot() {
        System.out.println("\n========================================");
        System.out.println("   INSTAGRAM AUTOMATION BOT STARTED");
        System.out.println("========================================\n");

        // Get hashtag from system property (set by RunBot)
        this.hashtag = System.getProperty("hashtag", "purwokerto");
        System.out.println("Target Hashtag: #" + this.hashtag);
    }

    @And("user login to Instagram")
    public void userLoginToInstagram() throws InterruptedException {
        System.out.println("\n--- STEP 1: LOGIN TO INSTAGRAM ---");

        // Open login page
        allpage.loginpage();
        Thread.sleep(2000);

        // Input credentials
        allpage.inputusername("usernamelu");
        Thread.sleep(1000);

        allpage.inputpassword("pwlu");
        Thread.sleep(1000);

        // Click login
        allpage.clickLoginButton();
        Thread.sleep(3000);

        // Handle popups
        allpage.clicknotnow();
        Thread.sleep(2000);

        allpage.clicknotnownotif();
        Thread.sleep(2000);

        // Verify login success
        allpage.verifyHomePage();
        System.out.println("✓ Login successful!\n");
    }

    @When("user scrape targets by hashtag with min {int} likes and {int} comments")
    public void userScrapeTargetsByHashtag(int minLikes, int minComments) throws Exception {
        System.out.println("\n--- STEP 2: SCRAPING TARGETS ---");
        System.out.println("Hashtag: #" + this.hashtag);
        System.out.println("Min Likes: " + minLikes);
        System.out.println("Min Comments: " + minComments + "\n");

        String outputPath = System.getProperty("user.dir") + "\\src\\test\\java\\helper\\target\\link.txt";

        allpage.scrapeTargetsByHashtag(this.hashtag, minLikes, minComments, outputPath);

        System.out.println("✓ Scraping completed!\n");
    }

    @Then("user selects action mode")
    public void userSelectsActionMode() {
        System.out.println("\n--- STEP 3: SELECT ACTION MODE ---");

        // Get action mode from system property (set by RunBot)
        String modeInput = System.getProperty("actionMode", "1");
        this.actionMode = Integer.parseInt(modeInput);

        String actionName = (actionMode == 1) ? "Auto Like + Comment" : "Auto Follow + DM";
        System.out.println("Selected Action: " + actionName + "\n");
    }

    @And("execute selected action")
    public void executeSelectedAction() throws Exception {
        System.out.println("\n--- STEP 4: EXECUTING ACTION ---");

        String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\helper\\target\\link.txt";

        switch (actionMode) {
            case 1 -> {
                System.out.println("Running: Auto Like + Comment\n");
                allpage.likeAndCommentFromFile(filePath);
            }
            case 2 -> {
                System.out.println("Running: Auto Follow + DM\n");
                allpage.followAndDMFromFile(filePath);
            }
            default -> {
                System.out.println("Invalid action mode!");
            }
        }
    }

    @Then("finish bot task")
    public void finishBotTask() {
        System.out.println("\n========================================");
        System.out.println("   BOT TASK COMPLETED SUCCESSFULLY");
        System.out.println("========================================\n");
    }
}
