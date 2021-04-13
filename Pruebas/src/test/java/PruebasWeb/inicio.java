package PruebasWeb;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class inicio {
	private WebDriver driver;
	By startLocator= new By.ByXPath("//div[3]/div/div/span[2]");
	By BtnoLocator= new By.ByXPath("//div[4]/div/div/button");
	By URLLocator= new By.ByXPath("(//input[@type='text'])[2]");
	By TranscribirLocator= new By.ByXPath("(//input[@type='text'])[2]");
	By CartaLocator= new By.ByXPath("//div[@id='textbox']/p[4]");
	
	@Before
	public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\00375\\eclipse-workspace\\Pruebas\\src\\test\\resources\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://otranscribe.com/");
	
	
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void Caso1InicioAPP() {
		driver.findElement(startLocator).click();
		File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File("C:\\Users\\00375\\eclipse-workspace\\Pruebas\\target"+ "\\Caso1/Ingreso_al_sistema_"+".png"));
			}catch (Exception e) {
				e.printStackTrace();			
			}	
								}			
	@Test
	public void Caso2SeleccionarArchivo() {
		driver.findElement(startLocator).click();
		driver.findElement(BtnoLocator).click();
		driver.findElement(URLLocator).sendKeys("https://www.youtube.com/watch?v=YlA-ArBPoPQ");
		driver.findElement(URLLocator).sendKeys(Keys.ENTER);
		File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File("C:\\Users\\00375\\eclipse-workspace\\Pruebas\\target"+ "\\Caso2/SeleccionarArchivo_"+".png"));
			}catch (Exception e) {
				e.printStackTrace();			
			}
		
	}

	@Test
	public void Caso3SeleccionarCarta() {
		driver.findElement(startLocator).click();
		driver.findElement(BtnoLocator).click();
		driver.findElement(URLLocator).sendKeys("https://www.youtube.com/watch?v=YlA-ArBPoPQ");
		driver.findElement(URLLocator).sendKeys(Keys.ENTER);
		driver.findElement(CartaLocator).sendKeys("Esta es una prueba de escritura de la transcripcion de las carta");
		File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File("C:\\Users\\00375\\eclipse-workspace\\Pruebas\\target"+ "\\Caso3/CompletarTranscripcion_"+".png"));
			}catch (Exception e) {
				e.printStackTrace();			
			}
	}
}
