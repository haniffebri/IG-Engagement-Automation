package pages;

import static helper.utility.driver;

import helper.utility;
import java.io.*;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class igLogic {

    // ===== LOCATORS =====
    By notnow_button = By.cssSelector("div[role='button']");
    By fill_username = By.xpath("//input[@name='username']");
    By fill_password = By.xpath("//input[@name='password']");
    By notnownotif_button = By.xpath("//button[normalize-space()='Not Now']");
    By verif_profile = By.xpath("//*[@class and contains(concat(' ', normalize-space(@class), ' '), ' x9n4tj2 ')]");
    By like_button = By.xpath("//div[@class='x1ypdohk']//div[@class='x6s0dn4 x78zum5 xdt5ytf xl56j7k']//*[name()='svg']");
    By input_komen_textarea = By.xpath("//textarea");
    By post_komen_button = By.xpath("//div[contains(text(),'Post')]");
    By listemoji = By.cssSelector("svg[aria-label='Emoji']");
    By emojikamera = By.xpath("//*[@class and contains(concat(' ', normalize-space(@class), ' '), ' x1rtvea0 ') and (position() = 486)]//*[@class and contains(concat(' ', normalize-space(@class), ' '), ' x6s0dn4 ')]");
    By emojiikan = By.xpath("//*[@class and contains(concat(' ', normalize-space(@class), ' '), ' x13dflua ') and (position() = 9)]//*[@class and contains(concat(' ', normalize-space(@class), ' '), ' html-div ') and (position() = 3)]/*[@class and contains(concat(' ', normalize-space(@class), ' '), ' x1i10hfl ')]");
    By emojibintang = By.cssSelector("body > div:nth-child(111) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(24) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)");
    By follow_button = By.xpath("//*[@class and contains(concat(' ', normalize-space(@class), ' '), ' x11lfxj5 ')]");
    By dm_button = By.xpath("//div[contains(text(),'Message')]");
    By notnow_button_dm = By.xpath("//button[normalize-space()='Not Now']");
    By input_message = By.cssSelector("p[class='xat24cr xdj266r']");
    By send_message = By.xpath("//div[@aria-label='Send']");
    By dot_three_to_dm = By.cssSelector("svg[aria-label='Options']");
    By send_message_dot_three = By.xpath("//button[normalize-space()='Send message']");

    String shiftEnter = Keys.chord(Keys.SHIFT, Keys.ENTER);

    // ==================== LOGIN METHODS ====================

    public void loginpage() throws InterruptedException {
        driver.get("https://www.instagram.com/accounts/login/");

        // Tunggu sampai halaman benar-benar selesai load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
        );

        Thread.sleep(2500); // Beri waktu untuk konten dinamis Instagram

        // Handle cookie consent popup jika muncul
        try {
            List<WebElement> cookieButtons = driver.findElements(
                    By.xpath(
                            "//button[contains(text(),'Allow') or contains(text(),'Accept') " +
                                    "or contains(text(),'Setuju') or contains(text(),'Terima') " +
                                    "or contains(text(),'Izinkan')]"
                    )
            );
            if (!cookieButtons.isEmpty()) {
                cookieButtons.get(0).click();
                System.out.println("✓ Cookie consent dismissed");
                Thread.sleep(1500);
            }
        } catch (Exception e) {
            System.out.println("No cookie consent popup. Continuing...");
        }
    }

    public void inputusername(String username) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Coba beberapa selector sebagai fallback
        String[] xpaths = {
                "//input[@type='text']",
        };

        WebElement usernameField = null;
        for (String xpath : xpaths) {
            try {
                usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                System.out.println("✓ Username field found using: " + xpath);
                break;
            } catch (Exception e) {
                System.out.println("✗ Selector gagal: " + xpath + ", mencoba berikutnya...");
            }
        }

        if (usernameField == null) {
            throw new RuntimeException("Tidak dapat menemukan field username setelah mencoba semua selector!");
        }

        usernameField.clear();
        Thread.sleep(500);
        usernameField.sendKeys(username);
    }

    public void inputpassword(String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String[] xpaths = {
                "//input[@type='password']",
        };

        WebElement passwordField = null;
        for (String xpath : xpaths) {
            try {
                passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                System.out.println("✓ Password field found using: " + xpath);
                break;
            } catch (Exception e) {
                System.out.println("✗ Selector gagal: " + xpath + ", mencoba berikutnya...");
            }
        }

        if (passwordField == null) {
            throw new RuntimeException("Tidak dapat menemukan field password setelah mencoba semua selector!");
        }

        passwordField.clear();
        Thread.sleep(500);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String[] xpaths = {
                "//form[@id = 'login_form']//*[(name() = 'div') and (position() = 1)]//*[(name() = 'div') and (position() = 1)]//*[(name() = 'div') and (position() = 1)]//*[(name() = 'div') and (position() = 3)]//*[(name() = 'div') and (position() = 1)]//*[(name() = 'div') and (position() = 1)]//*[(name() = 'div') and (position() = 1)]",
        };

        for (String xpath : xpaths) {
            try {
                WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                System.out.println("✓ Login button found using: " + xpath);
                loginBtn.click();
                return;
            } catch (Exception e) {
                System.out.println("✗ Login button selector gagal: " + xpath + ", mencoba berikutnya...");
            }
        }

        throw new RuntimeException("Tidak dapat menemukan tombol Login setelah mencoba semua selector!");
    }

    public void clicknotnow() {
        try {
            List<WebElement> buttons = driver.findElements(notnow_button);

            if (!buttons.isEmpty()) {
                WebDriverWait wait = new WebDriverWait(utility.getDriver(), Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOfElementLocated(notnow_button));
                Thread.sleep(2000);
                buttons.get(0).click();
                System.out.println("✓ 'Not Now' button clicked");
            } else {
                System.out.println("'Not Now' button not found. Continuing...");
            }
        } catch (Exception e) {
            System.out.println("✗ Error clicking 'Not Now': " + e.getMessage());
        }
    }

    public void clicknotnownotif() {
        try {
            List<WebElement> buttons = driver.findElements(notnownotif_button);

            if (!buttons.isEmpty()) {
                Thread.sleep(1000);
                buttons.get(0).click();
                System.out.println("✓ 'Not Now Notification' button clicked");
            } else {
                System.out.println("'Not Now Notification' button not found. Continuing...");
            }
        } catch (Exception e) {
            System.out.println("✗ Error clicking 'Not Now Notification': " + e.getMessage());
        }
    }

    public void verifyHomePage() {
        driver.findElement(verif_profile);
        System.out.println("✓ Home page verified");
    }

    // ==================== SCRAPING METHODS ====================

    public void scrapeTargetsByHashtag(String hashtag, int minLikes, int minComments, String outputPath)
            throws Exception {
        System.out.println("\n========== SCRAPING TARGET STARTED ==========");
        System.out.println("Hashtag: #" + hashtag);
        System.out.println("Filter: Min " + minLikes + " likes, " + minComments + " comments\n");

        // Step 1: Navigate to hashtag search
        String hashtagUrl = "https://www.instagram.com/explore/tags/" + hashtag + "/";
        driver.get(hashtagUrl);
        Thread.sleep(3000);

        // Step 2: Collect post links
        List<String> postLinks = scrollAndCollectPosts(300);
        System.out.println("\n✓ Total posts collected: " + postLinks.size());

        // Step 3: Filter by engagement
        List<PostData> filteredPosts = filterPostsByEngagement(postLinks, minLikes, minComments);
        System.out.println("\n✓ Filtered posts: " + filteredPosts.size());

        // Step 4: Save to file
        if (filteredPosts.isEmpty()) {
            System.out.println("⚠ No posts meet the criteria!");
            // Create empty file
            new File(outputPath).createNewFile();
        } else {
            savePostLinksToFile(filteredPosts, outputPath);
        }

        System.out.println("========== SCRAPING COMPLETED ==========\n");
    }

    /**
     * Scroll and collect post links from hashtag page
     */
    private List<String> scrollAndCollectPosts(int scrollTimes) throws InterruptedException {
        Set<String> uniqueLinks = new HashSet<>();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        System.out.println("Scrolling and collecting posts...\n");

        for (int i = 0; i < scrollTimes; i++) {
            // Scroll down
            js.executeScript("window.scrollBy(0, window.innerHeight)");
            Thread.sleep(2000);

            // Collect post links
            List<WebElement> postElements = driver.findElements(By.xpath("//a[contains(@href, '/p/')]"));

            for (WebElement elem : postElements) {
                String href = elem.getAttribute("href");
                if (href != null && href.contains("/p/")) {
                    uniqueLinks.add(href);
                }
            }

            if (i % 5 == 0 || i == scrollTimes - 1) {
                System.out.println("  Scroll " + (i + 1) + "/" + scrollTimes + " - Posts: " + uniqueLinks.size());
            }
        }

        return new ArrayList<>(uniqueLinks);
    }

    /**
     * Filter posts by engagement criteria
     */
    private List<PostData> filterPostsByEngagement(List<String> postLinks, int minLikes, int minComments)
            throws InterruptedException {
        List<PostData> validPosts = new ArrayList<>();
        int processed = 0;
        int total = postLinks.size();

        int maxResults = 12;   // Maksimal hasil filter
        int minResults = 12;   // Minimal target hasil

        System.out.println("\nFiltering by engagement (Min: " + minLikes + " likes, " + minComments + " comments)...");
        System.out.println("Target: " + minResults + "-" + maxResults + " valid posts\n");

        for (String postUrl : postLinks) {


            if (validPosts.size() >= maxResults) {
                System.out.println("✓ Max results (" + maxResults + ") reached, stopping filter.");
                break;
            }

            try {
                PostData postData = extractPostData(postUrl);

                if (postData != null && postData.meetsEngagementCriteria(minLikes, minComments)) {
                    validPosts.add(postData);
                    System.out.println(
                            "✓ VALID [" + validPosts.size() + "/" + maxResults + "]: Likes=" + postData.getLikes() + " Comments=" + postData.getComments()
                    );
                } else if (postData != null) {
                    System.out.println("✗ Skip: Likes=" + postData.getLikes() + " Comments=" + postData.getComments());
                }

                processed++;

                if (processed % 10 == 0) {
                    System.out.println(
                            "\n--- Progress: " + processed + "/" + total + " processed, " + validPosts.size() + " valid ---\n"
                    );
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                System.out.println("✗ Failed: " + postUrl);
            }
        }


        if (validPosts.size() < minResults) {
            System.out.println("⚠ Warning: Only " + validPosts.size() + " posts found (target min: " + minResults + ")");
            System.out.println("  Try lowering minLikes/minComments or increase scroll count.");
        } else {
            System.out.println("✓ Target achieved: " + validPosts.size() + " valid posts collected!");
        }

        return validPosts;
    }

    /**
     * Extract post data (likes, comments, owner)
     */
    private PostData extractPostData(String postUrl) throws InterruptedException {
        try {
            driver.get(postUrl);
            Thread.sleep(2000);

            int likes = extractNumber(By.xpath("//*[@class and contains(concat(' ', normalize-space(@class), ' '), ' xe9ewy2 ')]"));
            int comments = extractNumber(By.xpath("//*[@class and contains(concat(' ', normalize-space(@class), ' '), ' x1ypdohk ') and (position() = 4)]"));
            String owner = extractOwner();

            return new PostData(postUrl, likes, comments, owner);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Extract number from element text
     */
    private int extractNumber(By locator) {
        try {
            List<WebElement> elements = driver.findElements(locator);
            if (!elements.isEmpty()) {
                String text = elements.get(0).getText();
                String cleaned = text.replaceAll("[^0-9]", "");
                if (!cleaned.isEmpty()) {
                    return Integer.parseInt(cleaned);
                }
            }
        } catch (Exception e) {
            // Element not found or parse error
        }
        return 0;
    }

    /**
     * Extract post owner username
     */
    private String extractOwner() {
        try {
            WebElement ownerElement = driver.findElement(By.xpath("//*[@class and contains(concat(' ', normalize-space(@class), ' '), ' x1lliihq ')]/*[@class and contains(concat(' ', normalize-space(@class), ' '), ' xt0psk2 ')]//*[@class and contains(concat(' ', normalize-space(@class), ' '), ' _ap3a ')]"));
            return ownerElement.getText();
        } catch (Exception e) {
            return "unknown";
        }
    }

    /**
     * Save post links to file
     */
    private void savePostLinksToFile(List<PostData> posts, String outputPath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

        for (PostData post : posts) {
            writer.write(post.getPostUrl());
            writer.newLine();
        }

        writer.close();
        System.out.println("✓ " + posts.size() + " links saved to: " + outputPath);
    }

    // ==================== ACTION METHODS ====================

    /**
     * Auto Like + Comment from file
     */
    public void likeAndCommentFromFile(String path) throws Exception {
        List<String> links = readLines(path);
        int count = 1;

        System.out.println("\n========== AUTO LIKE & COMMENT STARTED ==========\n");

        while (!links.isEmpty()) {
            String link = links.get(0);
            driver.get(link);
            Thread.sleep(2000);

            // ======== LIKE ========
            boolean likeButtonFound = driver.findElements(like_button).size() > 0;
            if (likeButtonFound) {
                try {
                    driver.findElement(like_button).click();
                    Thread.sleep(3000);
                    System.out.println("✓ Target " + count + " liked");
                } catch (Exception e) {
                    System.out.println("✗ Failed to like target " + count + ": " + e.getMessage());
                }
            } else {
                System.out.println("⚠ Target " + count + " - Like button not found");
            }

            // ======== COMMENT ========
            boolean commentBoxFound = driver.findElements(input_komen_textarea).size() > 0;
            if (commentBoxFound) {
                try {

                    String newLine = Keys.chord(Keys.SHIFT, Keys.ENTER);

                    driver.findElement(input_komen_textarea).click();
                    Thread.sleep(1000);
                    driver.findElement(input_komen_textarea).sendKeys("Warna feed-nya kece parah, photographer handal nih! ");
                    Thread.sleep(1000);
                    driver.findElement(listemoji).click();
                    Thread.sleep(3000);
                    driver.findElement(emojikamera).click();
                    Thread.sleep(3000);
                    driver.findElement(input_komen_textarea).sendKeys(newLine);
                    Thread.sleep(1000);
                    driver.findElement(input_komen_textarea).sendKeys("Sayang banget kalau karya sebagus ini nggak banyak yang liat. ");
                    Thread.sleep(1000);
                    driver.findElement(input_komen_textarea).sendKeys(newLine);
                    Thread.sleep(1000);
                    driver.findElement(input_komen_textarea).sendKeys("Sambil terus berkarya, mampir profil ku yuk :D banyak cupang warna-warni cantik, cocok buat konten aesthetic kamu! ");
                    Thread.sleep(1000);
                    driver.findElement(post_komen_button).click();
                    Thread.sleep(3000);
                    System.out.println("✓ Target " + count + " commented");
                } catch (Exception e) {
                    System.out.println("✗ Failed to comment on target " + count + ": " + e.getMessage());
                }
            } else {
                System.out.println("⚠ Target " + count + " - Comment box not found");
            }

            // Remove processed link and update file
            links.remove(0);
            updateFile(path, links);

            count++;
            Thread.sleep(2000);
        }

        System.out.println("\n========== AUTO LIKE & COMMENT COMPLETED ==========\n");
    }

    /**
     * Auto Follow + DM from file
     */
    public void followAndDMFromFile(String path) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<String> links = readLines(path);
        int count = 1;

        System.out.println("\n========== AUTO FOLLOW & DM STARTED ==========\n");

        while (!links.isEmpty()) {
            String link = links.get(0);
            driver.get(link);
            Thread.sleep(2000);

            // Navigate to profile from post
            try {
                WebElement ownerLink = driver.findElement(By.xpath("//*[@class and contains(concat(' ', normalize-space(@class), ' '), ' x1lliihq ')]/*[@class and contains(concat(' ', normalize-space(@class), ' '), ' xt0psk2 ')]//*[@class and contains(concat(' ', normalize-space(@class), ' '), ' _ap3a ')]"));
                ownerLink.click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("✗ Failed to navigate to profile for target " + count);
                links.remove(0);
                updateFile(path, links);
                count++;
                continue;
            }

            // ======== FOLLOW ========
            try {
                List<WebElement> followBtn = driver.findElements(follow_button);
                if (!followBtn.isEmpty()) {
                    followBtn.get(0).click();
                    Thread.sleep(2000);
                    System.out.println("✓ Target " + count + " followed");
                } else {
                    System.out.println("⚠ Target " + count + " - Already following or button not found");
                }
            } catch (Exception e) {
                System.out.println("✗ Failed to follow target " + count + ": " + e.getMessage());
            }

            // ======== DM ========
            try {
                boolean dmButtonFound = driver.findElements(dm_button).size() > 0;

                if (dmButtonFound) {
                    wait.until(ExpectedConditions.elementToBeClickable(dm_button)).click();
                } else {
                    wait.until(ExpectedConditions.elementToBeClickable(dot_three_to_dm)).click();
                    wait.until(ExpectedConditions.elementToBeClickable(send_message_dot_three)).click();
                }

                Thread.sleep(2000);

                // Handle "Not Now" if appears
                if (driver.findElements(notnow_button_dm).size() > 0) {
                    driver.findElement(notnow_button_dm).click();
                    Thread.sleep(1000);
                }

                // Send message
                if (driver.findElements(input_message).size() > 0) {
                    WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(input_message));
                    inputField.click();
                    Thread.sleep(500);
                    inputField.sendKeys("Halo kak, kontennya keren banget. Kalau lagi pengen lihat ikan cupang cantik buat refreshing mata, mampir ke @h.bettazone ya ^_^ ");
                    Thread.sleep(500);
                    driver.findElement(send_message).click();
                    Thread.sleep(2000);

                    System.out.println("✓ Target " + count + " DM sent");
                } else {
                    System.out.println("⚠ Target " + count + " - DM input not found");
                }
            } catch (Exception e) {
                System.out.println("✗ Failed to send DM to target " + count + ": " + e.getMessage());
            }

            // Remove processed link and update file
            links.remove(0);
            updateFile(path, links);

            count++;
            Thread.sleep(3000); // Longer delay for DM actions
        }

        System.out.println("\n========== AUTO FOLLOW & DM COMPLETED ==========\n");
    }

    // ==================== HELPER METHODS ====================

    private List<String> readLines(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        return java.nio.file.Files.readAllLines(file.toPath());
    }

    private void updateFile(String path, List<String> links) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        for (String remaining : links) {
            writer.write(remaining);
            writer.newLine();
        }
        writer.close();
    }
}