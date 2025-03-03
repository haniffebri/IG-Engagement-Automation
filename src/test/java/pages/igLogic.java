package pages;

import helper.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static helper.utility.driver;

public class igLogic {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    By login_button = By.xpath("//form[@id='loginForm']/div[@class='x9f619 xjbqb8w x78zum5 x168nmei x13lgxp2 x5pf9jr xo71vjh xqui205 x1n2onr6 x1plvlek xryxfnj x1c4vz4f x2lah0s xdt5ytf xqjyukv x1qjc9v5 x1oa3qoh x1nhvcw1']/div[.='Log in']");
    By input_username = By.xpath("//input[@name='username']");
    By input_password = By.xpath("//input[@name='password']");
    By verif_profile = By.xpath("//img[@alt=\"bersamanuansa's profile picture\"]");
    By like_button = By.xpath("//div[@class='x1ypdohk']//div[@class='x6s0dn4 x78zum5 xdt5ytf xl56j7k']//*[name()='svg']");
    By komen_button = By.cssSelector("svg[aria-label='Comment']");
    By input_komen = By.xpath("//textarea");
    By post_button = By.xpath("//div[contains(text(),'Post')]");
    By notnow_button = By.xpath("//div[@role='button']");
    By notnow_button_dm = By.xpath("//button[normalize-space()='Not Now']");
    By notnownotif_button = By.xpath("//button[normalize-space()='Not Now']");
    By listemoji = By.cssSelector("svg[aria-label='Emoji']");
    By selectedemoji = By.xpath("//div[624]//div[1]//div[1]");
    By dm_button = By.xpath("//div[contains(text(),'Message')]");
    By input_message = By.cssSelector("p[class='xat24cr xdj266r']");
    By send_message = By.xpath("//div[normalize-space()='Send']");
    By list_emoji_dm = By.cssSelector("svg[aria-label='Choose an emoji']");
    By selectedemoji_bintang1 = By.cssSelector("div:nth-child(561) div:nth-child(1) span:nth-child(1)");
    By selectedemoji_bintang3 = By.cssSelector("div:nth-child(587) div:nth-child(1) span:nth-child(1)");
    By selectedemoji_queen = By.cssSelector("div:nth-child(266) div:nth-child(1) span:nth-child(1)");
    By selectedemoji_camera = By.cssSelector("body > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1003) > div:nth-child(1) > span:nth-child(1)");
    By selectedemoji_women = By.cssSelector("div:nth-child(208) div:nth-child(1) span:nth-child(1)");
    By selectedemoji_sstt = By.cssSelector("div:nth-child(46) div:nth-child(1) span:nth-child(1)");
    By selectedemoji_Xmelet = By.cssSelector("div:nth-child(42) div:nth-child(1) span:nth-child(1)");
    By selectedemoji_petir = By.cssSelector("div:nth-child(578) div:nth-child(1) span:nth-child(1)");
    By dot_three_to_dm = By.cssSelector("svg[aria-label='Options']");
    By send_message_dot_three = By.xpath("//button[normalize-space()='Send message']");

    String shiftEnter = Keys.chord(Keys.SHIFT, Keys.ENTER);

    public void loginpage() {
        driver.get("https://www.instagram.com/accounts/login/?source=auth_switcher");
    }

    public void inputusername(String value) {
        driver.findElement(input_username).sendKeys(value);
//    System.out.println(value);
    }

    public void inputpassword(String value) {
        driver.findElement(input_password).sendKeys(value);
//    System.out.println(value);
    }

    public void clickLoginButton(){
        driver.findElement(login_button).click();
    }

    public void clicknotnow() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(utility.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[role='button']")));
        Thread.sleep(1000);
        driver.findElement(notnow_button).click();
    }

    public void clicknotnownotif(){
        driver.findElement(notnownotif_button).click();
    }

    public void verifhome(){
        driver.findElement(verif_profile);
    }

    public void gototarget(){
        driver.get("https://www.instagram.com/p/C9jxE7Xp9v9/");
    }

    public void clickbuttonkomen() {
        driver.findElement(input_komen).click();
    }

    public void inputkomen(String value) {
        driver.findElement(input_komen).sendKeys(value);
//    System.out.println(value);
    }

    public void emoji() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(listemoji).click();
        Thread.sleep(3000);
        driver.findElement(selectedemoji).click();
    }

    public void clickPostButton(){
        driver.findElement(post_button).click();
    }

    public void getlink() throws IOException, InterruptedException {
        // Baca semua link dari file
        List<String> links = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("D:\\Pribadi\\ASOKA\\bot-instagram\\bot-instagram\\src\\test\\java\\helper\\ig\\link.txt"));
        String targetLink;
        while ((targetLink = reader.readLine()) != null) {
            links.add(targetLink);
        }
        reader.close();

        // Iterasi melalui setiap link menggunakan loop biasa
        int index = 0;
        while (index < links.size()) {
            String link = links.get(index);
            driver.get(link);
            Thread.sleep(1000);

            boolean likeButtonFound = driver.findElements(like_button).size() > 0;
            boolean commentInputFound = driver.findElements(input_komen).size() > 0;

            if (likeButtonFound) {
                driver.findElement(like_button).click();
                Thread.sleep(500);  // Kurangi waktu tidur jika perlu
                driver.findElement(like_button).click();
                Thread.sleep(3000);
            }

            if (commentInputFound) {
                driver.findElement(input_komen).click();
                Thread.sleep(1000);
                driver.findElement(input_komen).sendKeys("Setiap foto makin cantik! ");
                Thread.sleep(1000);
                driver.findElement(listemoji).click();
                Thread.sleep(5000);
                driver.findElement(selectedemoji).click();
                Thread.sleep(3000);
                driver.findElement(post_button).click();
                Thread.sleep(120000);
            }

            if (!likeButtonFound && !commentInputFound) {
                System.out.println("Tombol like dan kolom komentar tidak ditemukan, lanjut ke link target berikutnya.");
            }

            // Setelah selesai, hapus link dari list dan tulis kembali ke file
            links.remove(index);

            // Tulis kembali link yang tersisa ke file
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Pribadi\\ASOKA\\bot-instagram\\bot-instagram\\src\\test\\java\\helper\\ig\\link.txt"));
            for (String remainingLink : links) {
                writer.write(remainingLink);
                writer.newLine();
            }
            writer.close();
        }
    }

    public void getsecondlink() throws IOException, InterruptedException {
        // Baca semua link dari file
        List<String> links = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("D:\\Pribadi\\ASOKA\\bot-instagram\\bot-instagram\\src\\test\\java\\helper\\ig\\link2.txt"));
        String targetLink;
        while ((targetLink = reader.readLine()) != null) {
            links.add(targetLink);
        }
        reader.close();

        // Iterasi melalui setiap link menggunakan loop biasa
        int index = 0;
        while (index < links.size()) {
            String link = links.get(index);
            driver.get(link);
            Thread.sleep(1000);

            boolean likeButtonFound = driver.findElements(like_button).size() > 0;
            boolean commentInputFound = driver.findElements(input_komen).size() > 0;

            if (likeButtonFound) {
                driver.findElement(like_button).click();
                Thread.sleep(500);  // Kurangi waktu tidur jika perlu
                driver.findElement(like_button).click();
                Thread.sleep(3000);
            }

            if (commentInputFound) {
                driver.findElement(input_komen).click();
                Thread.sleep(1000);
                driver.findElement(input_komen).sendKeys("Setiap foto makin cantik! ");
                Thread.sleep(1000);
                driver.findElement(listemoji).click();
                Thread.sleep(5000);
                driver.findElement(selectedemoji).click();
                Thread.sleep(3000);
                driver.findElement(post_button).click();
                Thread.sleep(120000);
            }

            if (!likeButtonFound && !commentInputFound) {
                System.out.println("Tombol like dan kolom komentar tidak ditemukan, lanjut ke link target berikutnya.");
            }

            // Setelah selesai, hapus link dari list dan tulis kembali ke file
            links.remove(index);

            // Tulis kembali link yang tersisa ke file
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Pribadi\\ASOKA\\bot-instagram\\bot-instagram\\src\\test\\java\\helper\\link2.txt"));
            for (String remainingLink : links) {
                writer.write(remainingLink);
                writer.newLine();
            }
            writer.close();
        }
    }

    public void getlikelink() throws IOException, InterruptedException {
        // Baca semua link dari file
        List<String> links = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("D:\\Pribadi\\ASOKA\\bot-instagram\\bot-instagram\\src\\test\\java\\helper\\ig\\link.txt"));
        String targetLink;
        while ((targetLink = reader.readLine()) != null) {
            links.add(targetLink);
        }
        reader.close();

        // Iterasi melalui setiap link menggunakan loop biasa
        int index = 0;
        while (index < links.size()) {
            String link = links.get(index);
            driver.get(link);
            Thread.sleep(1000);

            boolean likeButtonFound = driver.findElements(like_button).size() > 0;

            if (likeButtonFound) {
                driver.findElement(like_button).click();
                Thread.sleep(500);  // Kurangi waktu tidur jika perlu
                driver.findElement(like_button).click();
                Thread.sleep(10000);
            }

            if (!likeButtonFound) {
                System.out.println("Tombol like tidak ditemukan, lanjut ke link target berikutnya.");
            }

            // Setelah selesai, hapus link dari list dan tulis kembali ke file
            links.remove(index);

            // Tulis kembali link yang tersisa ke file
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Pribadi\\ASOKA\\bot-instagram\\bot-instagram\\src\\test\\java\\helper\\ig\\link.txt"));
            for (String remainingLink : links) {
                writer.write(remainingLink);
                writer.newLine();
            }
            writer.close();
        }
    }
    public void getkomenlink() throws IOException, InterruptedException {
        // read all link from file
        List<String> links = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("D:\\Pribadi\\ASOKA\\bot-instagram\\bot-instagram\\src\\test\\java\\helper\\ig\\link.txt"));
        String targetLink;
        while ((targetLink = reader.readLine()) != null) {
            links.add(targetLink);
        }
        reader.close();

        
        int index = 0;
        while (index < links.size()) {
            String link = links.get(index);
            driver.get(link);
            Thread.sleep(1000);

            boolean commentInputFound = driver.findElements(input_komen).size() > 0;

            if (commentInputFound) {
                driver.findElement(input_komen).click();
                Thread.sleep(1000);
                driver.findElement(input_komen).sendKeys("ketjee kali kakk ");
                Thread.sleep(1000);
                driver.findElement(listemoji).click();
                Thread.sleep(5000);
                driver.findElement(selectedemoji).click();
                Thread.sleep(3000);
                driver.findElement(post_button).click();
                Thread.sleep(120000);
            }

            if (!commentInputFound) {
                System.out.println("Tombol kolom komentar tidak ditemukan, lanjut ke link target berikutnya.");
            }

            // Setelah selesai, hapus link dari list dan tulis kembali ke file
            links.remove(index);

            // Tulis kembali link yang tersisa ke file
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Pribadi\\ASOKA\\bot-instagram\\bot-instagram\\src\\test\\java\\helper\\ig\\link.txt"));
            for (String remainingLink : links) {
                writer.write(remainingLink);
                writer.newLine();
            }
            writer.close();
        }
    }

    public void getdmlink() throws IOException, InterruptedException {
        // Baca semua link dari file
        List<String> links = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("D:\\Pribadi\\ASOKA\\bot-instagram\\bot-instagram\\src\\test\\java\\helper\\ig\\link.txt"));
        String targetLink;
        while ((targetLink = reader.readLine()) != null) {
            links.add(targetLink);
        }
        reader.close();

        // Iterasi melalui setiap link menggunakan loop biasa
        int index = 0;
        while (index < links.size()) {
            String link = links.get(index);
            driver.get(link);
            Thread.sleep(1000);

            boolean dmButtonFound = driver.findElements(dm_button).size() > 0;

            if (dmButtonFound) {
                    WebElement dmButton = wait.until(ExpectedConditions.elementToBeClickable(dm_button));
                    dmButton.click();

                    boolean notnowFound = driver.findElements(notnow_button_dm).size() > 0;
                    if (notnowFound) {
                        Thread.sleep(4000);
                        driver.findElement(notnow_button_dm).click();
                        Thread.sleep(3000);

                        boolean inputColumnFound = driver.findElements(input_message).size() > 0;
                        if (inputColumnFound) {
                            Thread.sleep(1000);
                            WebElement emojiList = wait.until(ExpectedConditions.elementToBeClickable(list_emoji_dm));
                            emojiList.click();

                            Thread.sleep(1000);

                            WebElement star3Emoji = wait.until(ExpectedConditions.elementToBeClickable(selectedemoji_bintang3));
                            star3Emoji.click();

                            WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(input_message));
                            inputField.sendKeys(" ALERT ALERT! TELAH HADIR OBAT MATI GAYA! ");

                            Thread.sleep(2000);

                            driver.findElement(selectedemoji_bintang3).click();
                            Thread.sleep(2000);

                            inputField.sendKeys(shiftEnter);
                            inputField.sendKeys(shiftEnter);
                            inputField.sendKeys("HAI QUEENS! ");

                            WebElement queenEmoji = wait.until(ExpectedConditions.elementToBeClickable(selectedemoji_queen));
                            queenEmoji.click();

                            inputField.sendKeys(shiftEnter);
                            inputField.sendKeys("Udah siap bikin feed Instagram kamu makin aesthetic? ");
                            driver.findElement(selectedemoji_camera).click();
                            Thread.sleep(1000);
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("Kita punya koleksi yang bikin kamu auto jadi selebgram! ");
                            driver.findElement(selectedemoji_women).click();
                            Thread.sleep(1000);
                            inputField.sendKeys(shiftEnter);
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("SPILL DIKIT NIH! ");
                            driver.findElement(selectedemoji_sstt).click();
                            Thread.sleep(1000);
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("- Bahan super nyaman, anti gerah & gak bikin kamu overthinking!");
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("- Model kekinian banget, dijamin gak bakal OOTD clash sama temen ");
                            driver.findElement(selectedemoji_Xmelet).click();
                            Thread.sleep(1000);
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("- Size friendly buat semua body goals kamu!");
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("- Harga masih ramah di kantong, padahal look-nya high end bestie! ");
                            Thread.sleep(1000);
                            driver.findElement(selectedemoji_bintang3).click();
                            Thread.sleep(1000);
                            inputField.sendKeys(shiftEnter);
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("Penasaran sama koleksinya?");
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("Langsung aja cus cek feed atau cek shopee kita ");
                            Thread.sleep(1000);
                            driver.findElement(selectedemoji_bintang3).click();
                            Thread.sleep(1000);
                            driver.findElement(selectedemoji_bintang3).click();
                            Thread.sleep(1000);
                            driver.findElement(selectedemoji_bintang3).click();
                            Thread.sleep(1000);
                            inputField.sendKeys(shiftEnter);
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("Keep in touch with us:");
                            inputField.sendKeys(shiftEnter);
                            driver.findElement(selectedemoji_bintang1).click();
                            Thread.sleep(1000);
                            inputField.sendKeys(" DM: @bersamanuansa");
                            inputField.sendKeys(shiftEnter);
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("*Terms & conditions applied ya sis!");
                            inputField.sendKeys(shiftEnter);
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("P.S: Jangan sampe ketinggalan! Stok terbatas dan bakal sold out in minutes!");
                            driver.findElement(selectedemoji_petir).click();
                            Thread.sleep(1000);

                            WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(send_message));
                            sendButton.click();
                        }

                        if (!inputColumnFound) {
                            System.out.println("Next, gaada kolom input message");
                        }
                    }

                    if (!notnowFound) {
                        System.out.println("Next, gaada notif notnow");
                        Thread.sleep(4000);

                        boolean inputColumnFound = driver.findElements(input_message).size() > 0;
                        if (inputColumnFound) {
                            Thread.sleep(1000);
                            WebElement emojiList = wait.until(ExpectedConditions.elementToBeClickable(list_emoji_dm));
                            emojiList.click();

                            Thread.sleep(1000);

                            WebElement star3Emoji = wait.until(ExpectedConditions.elementToBeClickable(selectedemoji_bintang3));
                            star3Emoji.click();

                            WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(input_message));
                            inputField.sendKeys(" ALERT ALERT! TELAH HADIR OBAT MATI GAYA! ");

                            Thread.sleep(2000);

                            driver.findElement(selectedemoji_bintang3).click();
                            Thread.sleep(2000);

                            inputField.sendKeys(shiftEnter);
                            inputField.sendKeys(shiftEnter);
                            inputField.sendKeys("HAI QUEENS! ");

                            WebElement queenEmoji = wait.until(ExpectedConditions.elementToBeClickable(selectedemoji_queen));
                            queenEmoji.click();

                            inputField.sendKeys(shiftEnter);
                            inputField.sendKeys("Udah siap bikin feed Instagram kamu makin aesthetic? ");
                            driver.findElement(selectedemoji_camera).click();
                            Thread.sleep(1000);
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("Kita punya koleksi yang bikin kamu auto jadi selebgram! ");
                            driver.findElement(selectedemoji_women).click();
                            Thread.sleep(1000);
                            inputField.sendKeys(shiftEnter);
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("SPILL DIKIT NIH! ");
                            driver.findElement(selectedemoji_sstt).click();
                            Thread.sleep(1000);
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("- Bahan super nyaman, anti gerah & gak bikin kamu overthinking!");
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("- Model kekinian banget, dijamin gak bakal OOTD clash sama temen ");
                            driver.findElement(selectedemoji_Xmelet).click();
                            Thread.sleep(1000);
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("- Size friendly buat semua body goals kamu!");
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("- Harga masih ramah di kantong, padahal look-nya high end bestie! ");
                            Thread.sleep(1000);
                            driver.findElement(selectedemoji_bintang3).click();
                            Thread.sleep(1000);
                            inputField.sendKeys(shiftEnter);
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("Penasaran sama koleksinya?");
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("Langsung aja cus cek feed atau cek shopee kita ");
                            Thread.sleep(1000);
                            driver.findElement(selectedemoji_bintang3).click();
                            Thread.sleep(1000);
                            driver.findElement(selectedemoji_bintang3).click();
                            Thread.sleep(1000);
                            driver.findElement(selectedemoji_bintang3).click();
                            Thread.sleep(1000);
                            inputField.sendKeys(shiftEnter);
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("Keep in touch with us:");
                            inputField.sendKeys(shiftEnter);
                            driver.findElement(selectedemoji_bintang1).click();
                            Thread.sleep(1000);
                            inputField.sendKeys(" DM: @bersamanuansa");
                            inputField.sendKeys(shiftEnter);
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("*Terms & conditions applied ya sis!");
                            inputField.sendKeys(shiftEnter);
                            inputField.sendKeys(shiftEnter);

                            inputField.sendKeys("P.S: Jangan sampe ketinggalan! Stok terbatas dan bakal sold out in minutes!");
                            driver.findElement(selectedemoji_petir).click();
                            Thread.sleep(1000);

                            WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(send_message));
                            sendButton.click();
                        }

                        if (!inputColumnFound) {
                            System.out.println("Next, gaada kolom input message");
                        }
                    }
            }

            if (!dmButtonFound) {
                    WebElement dotThree = wait.until(ExpectedConditions.elementToBeClickable(dot_three_to_dm));
                    dotThree.click();

                    WebElement sendMessageOption = wait.until(ExpectedConditions.elementToBeClickable(send_message_dot_three));
                    sendMessageOption.click();

                boolean notnowFound = driver.findElements(notnow_button_dm).size() > 0;
                if (notnowFound) {
                    Thread.sleep(4000);
                    driver.findElement(notnow_button_dm).click();
                    Thread.sleep(3000);

                    boolean inputColumnFound = driver.findElements(input_message).size() > 0;
                    if (inputColumnFound) {
                        Thread.sleep(1000);
                        WebElement emojiList = wait.until(ExpectedConditions.elementToBeClickable(list_emoji_dm));
                        emojiList.click();

                        Thread.sleep(1000);

                        WebElement star3Emoji = wait.until(ExpectedConditions.elementToBeClickable(selectedemoji_bintang3));
                        star3Emoji.click();

                        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(input_message));
                        inputField.sendKeys(" ALERT ALERT! TELAH HADIR OBAT MATI GAYA! ");

                        Thread.sleep(2000);

                        driver.findElement(selectedemoji_bintang3).click();
                        Thread.sleep(2000);

                        inputField.sendKeys(shiftEnter);
                        inputField.sendKeys(shiftEnter);
                        inputField.sendKeys("HAI QUEENS! ");

                        WebElement queenEmoji = wait.until(ExpectedConditions.elementToBeClickable(selectedemoji_queen));
                        queenEmoji.click();

                        inputField.sendKeys(shiftEnter);
                        inputField.sendKeys("Udah siap bikin feed Instagram kamu makin aesthetic? ");
                        driver.findElement(selectedemoji_camera).click();
                        Thread.sleep(1000);
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("Kita punya koleksi yang bikin kamu auto jadi selebgram! ");
                        driver.findElement(selectedemoji_women).click();
                        Thread.sleep(1000);
                        inputField.sendKeys(shiftEnter);
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("SPILL DIKIT NIH! ");
                        driver.findElement(selectedemoji_sstt).click();
                        Thread.sleep(1000);
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("- Bahan super nyaman, anti gerah & gak bikin kamu overthinking!");
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("- Model kekinian banget, dijamin gak bakal OOTD clash sama temen ");
                        driver.findElement(selectedemoji_Xmelet).click();
                        Thread.sleep(1000);
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("- Size friendly buat semua body goals kamu!");
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("- Harga masih ramah di kantong, padahal look-nya high end bestie! ");
                        Thread.sleep(1000);
                        driver.findElement(selectedemoji_bintang3).click();
                        Thread.sleep(1000);
                        inputField.sendKeys(shiftEnter);
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("Penasaran sama koleksinya?");
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("Langsung aja cus cek feed atau cek shopee kita ");
                        Thread.sleep(1000);
                        driver.findElement(selectedemoji_bintang3).click();
                        Thread.sleep(1000);
                        driver.findElement(selectedemoji_bintang3).click();
                        Thread.sleep(1000);
                        driver.findElement(selectedemoji_bintang3).click();
                        Thread.sleep(1000);
                        inputField.sendKeys(shiftEnter);
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("Keep in touch with us:");
                        inputField.sendKeys(shiftEnter);
                        driver.findElement(selectedemoji_bintang1).click();
                        Thread.sleep(1000);
                        inputField.sendKeys(" DM: @bersamanuansa");
                        inputField.sendKeys(shiftEnter);
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("*Terms & conditions applied ya sis!");
                        inputField.sendKeys(shiftEnter);
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("P.S: Jangan sampe ketinggalan! Stok terbatas dan bakal sold out in minutes!");
                        driver.findElement(selectedemoji_petir).click();
                        Thread.sleep(1000);

                        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(send_message));
                        sendButton.click();
                    }

                    if (!inputColumnFound) {
                        System.out.println("Next, gaada kolom input message");
                    }
                }

                if (!notnowFound) {
                    System.out.println("Next, gaada notif notnow");
                    Thread.sleep(4000);

                    boolean inputColumnFound = driver.findElements(input_message).size() > 0;
                    if (inputColumnFound) {
                        Thread.sleep(1000);
                        WebElement emojiList = wait.until(ExpectedConditions.elementToBeClickable(list_emoji_dm));
                        emojiList.click();

                        Thread.sleep(1000);

                        WebElement star3Emoji = wait.until(ExpectedConditions.elementToBeClickable(selectedemoji_bintang3));
                        star3Emoji.click();

                        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(input_message));
                        inputField.sendKeys(" ALERT ALERT! TELAH HADIR OBAT MATI GAYA! ");

                        Thread.sleep(2000);

                        driver.findElement(selectedemoji_bintang3).click();
                        Thread.sleep(2000);

                        inputField.sendKeys(shiftEnter);
                        inputField.sendKeys(shiftEnter);
                        inputField.sendKeys("HAI QUEENS! ");

                        WebElement queenEmoji = wait.until(ExpectedConditions.elementToBeClickable(selectedemoji_queen));
                        queenEmoji.click();

                        inputField.sendKeys(shiftEnter);
                        inputField.sendKeys("Udah siap bikin feed Instagram kamu makin aesthetic? ");
                        driver.findElement(selectedemoji_camera).click();
                        Thread.sleep(1000);
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("Kita punya koleksi yang bikin kamu auto jadi selebgram! ");
                        driver.findElement(selectedemoji_women).click();
                        Thread.sleep(1000);
                        inputField.sendKeys(shiftEnter);
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("SPILL DIKIT NIH! ");
                        driver.findElement(selectedemoji_sstt).click();
                        Thread.sleep(1000);
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("- Bahan super nyaman, anti gerah & gak bikin kamu overthinking!");
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("- Model kekinian banget, dijamin gak bakal OOTD clash sama temen ");
                        driver.findElement(selectedemoji_Xmelet).click();
                        Thread.sleep(1000);
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("- Size friendly buat semua body goals kamu!");
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("- Harga masih ramah di kantong, padahal look-nya high end bestie! ");
                        Thread.sleep(1000);
                        driver.findElement(selectedemoji_bintang3).click();
                        Thread.sleep(1000);
                        inputField.sendKeys(shiftEnter);
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("Penasaran sama koleksinya?");
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("Langsung aja cus cek feed atau cek shopee kita ");
                        Thread.sleep(1000);
                        driver.findElement(selectedemoji_bintang3).click();
                        Thread.sleep(1000);
                        driver.findElement(selectedemoji_bintang3).click();
                        Thread.sleep(1000);
                        driver.findElement(selectedemoji_bintang3).click();
                        Thread.sleep(1000);
                        inputField.sendKeys(shiftEnter);
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("Keep in touch with us:");
                        inputField.sendKeys(shiftEnter);
                        driver.findElement(selectedemoji_bintang1).click();
                        Thread.sleep(1000);
                        inputField.sendKeys(" DM: @bersamanuansa");
                        inputField.sendKeys(shiftEnter);
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("*Terms & conditions applied ya sis!");
                        inputField.sendKeys(shiftEnter);
                        inputField.sendKeys(shiftEnter);

                        inputField.sendKeys("P.S: Jangan sampe ketinggalan! Stok terbatas dan bakal sold out in minutes!");
                        driver.findElement(selectedemoji_petir).click();
                        Thread.sleep(1000);

                        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(send_message));
                        sendButton.click();
                    }

                    if (!inputColumnFound) {
                        System.out.println("Next, gaada kolom input message");
                    }
                }
            }

            // Setelah selesai, hapus link dari list dan tulis kembali ke file
            links.remove(index);

            // Tulis kembali link yang tersisa ke file
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Pribadi\\ASOKA\\bot-instagram\\bot-instagram\\src\\test\\java\\helper\\ig\\link.txt"));
            for (String remainingLink : links) {
                writer.write(remainingLink);
                writer.newLine();
            }
            writer.close();
        }
    }

}