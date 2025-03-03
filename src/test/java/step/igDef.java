package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.igLogic;

import java.io.IOException;

public class igDef {

    public igDef() {
        this.allpage = new igLogic();
    }

    //HomePage homepage;
    igLogic allpage;


    @Given("user is on login page")
    public void userIsOnLoginPage() {
        allpage.loginpage();
    }

    @When("user input log in username {string}")
    public void userInputLogInUsername(String username) throws InterruptedException {
        Thread.sleep(1000);
        allpage.inputusername(username);
    }

    @And("user input log in password {string}")
    public void userInputLogInPassword(String password) throws InterruptedException {
        Thread.sleep(1000);
        allpage.inputpassword(password);
    }

    @And("user click sign in button")
    public void userClickSignInButton() throws InterruptedException {
        Thread.sleep(1000);
        allpage.clickLoginButton();
    }

    @And("user click not now button")
    public void userClickNotNowButton() throws InterruptedException {
        Thread.sleep(2000);
        allpage.clicknotnow();
    }

    @And("user click not now button notification")
    public void userClickNotNowButtonNotification() throws InterruptedException {
        Thread.sleep(2000);
        allpage.clicknotnownotif();
    }

    @Then("verify user is on home page")
    public void userInOnHomePage() throws InterruptedException {
        Thread.sleep(3000);
        allpage.verifhome();
        Thread.sleep(2000);
    }

    @When("user go to target link")
    public void userGoToTargetLink() {
        allpage.gototarget();
    }

    @And("user click button komen")
    public void userClickKolomKomen() throws InterruptedException {
        Thread.sleep(1000);
        allpage.clickbuttonkomen();
    }

    @And("type emoji")
    public void typeEmoji() throws InterruptedException {
        allpage.emoji();
    }

    @Then("type komen {string}")
    public void postKomen(String komentar) throws InterruptedException {
        Thread.sleep(2000);
        allpage.inputkomen(komentar);
    }

    @And("user click post button")
    public void userClickPostButton() throws InterruptedException {
        Thread.sleep(2000);
        allpage.clickPostButton();
        Thread.sleep(8000);
    }

    @When("get link from file")
    public void getLinkFromFile() throws IOException, InterruptedException {
        allpage.getlink();
    }

    @When("get link from second file")
    public void getLinkFromSecondFile() throws IOException, InterruptedException {
        allpage.getsecondlink();
    }

    @When("get link from like file")
    public void getLinkFromLikeFile() throws IOException, InterruptedException {
        allpage.getlikelink();
    }

    @When("get link from komen file")
    public void getLinkFromKomenFile() throws IOException, InterruptedException {
        allpage.getkomenlink();
    }

    @When("get link from dm file")
    public void getLinkFromDmFile() throws IOException, InterruptedException {
        allpage.getdmlink();
    }
}