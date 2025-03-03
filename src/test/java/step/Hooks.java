package step;

import  io.cucumber.java.*;
import static helper.utility.quitDriver;
import static helper.utility.startDriver;

public class Hooks {

    @Before
    public void beforeTest() {
        System.out.println("Bot Running");
        startDriver();
    }

    @After
    public void afterTest() throws InterruptedException {
        System.out.println("Finish");
        quitDriver();
    }
}
