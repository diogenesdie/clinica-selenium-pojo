package com.exemplo.clinic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().clearResolutionCache(); 
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver();
    }

    @Test
    public void testAgendarConsultaComCpf() {
        driver.get("http://localhost:8080");

        driver.findElement(By.name("nome")).sendKeys("Maria da Silva");
        driver.findElement(By.name("cpf")).sendKeys("12345678900");
        driver.findElement(By.name("dataHora")).sendKeys("2025-07-10 09:00");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement mensagem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mensagem")));
        assertTrue(mensagem.getText().contains("Maria da Silva"));
        assertTrue(mensagem.getText().contains("12345678900"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
