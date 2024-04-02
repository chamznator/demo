package com.digimaint_sample.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VideoPageTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Set up the WebDriver (e.g., ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        // Quit the WebDriver
        driver.quit();
    }

    @Test
    public void testVideoPage() {
        // Navigate to the video page
        driver.get("http://localhost:8080/video");

        // Check if the video iframe is present
        WebElement videoIframe = driver.findElement(By.tagName("iframe"));
        assertTrue(videoIframe.isDisplayed());

        // Check if the video source is correct
        String videoSrc = videoIframe.getAttribute("src");
        assertTrue(videoSrc.contains("https://www.youtube.com/embed/VIDEO_ID"));
    }
}