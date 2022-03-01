package bcp.test.util;

import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectUtil {

	// singleton
	private static PageObjectUtil obj = null;
	private long wdwTimeOut = 5L;

	private PageObjectUtil() {
	}

	public static PageObjectUtil getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new PageObjectUtil();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public void seleniumClick(WebDriver webDriver, final String xpath, int pos) {
		By by = By.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);

			if (we.isDisplayed()) {
				we.click();
				sleep(1.5);
			}
		}
	}

	public String seleniumGetText(WebDriver webDriver, final String xpath, int pos) {
		By by = By.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);
		String texto = "";
		int count = 1;
		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			do {
				texto = we.getText();
				sleep(1.5);
				count++;
			} while (texto.isEmpty() || count == 10);
		}
		return texto;
	}

	public void seleniumEscribir(WebDriver webDriver, final String path, int pos, String valor) {
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			int count=0;
			do {
				we.click();
				sleep(0.25);
				we.clear();
				we.sendKeys(valor);
				sleep(1.5);
				count++;
			}while(!we.isDisplayed() || count==5);	
		}
	}

	public boolean seleniumEsVisible(WebDriver webDriver, final String xpath, int pos) {
		By by = By.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			return we.isDisplayed();
		}
		
		return false;
	}

	public void seleniumSelectCombo(WebDriver webDriver, final String path, String valor) {
		By by = By.xpath(path);

		WebElement we = webDriver.findElement(by);

		if (we.isDisplayed()) {
			we.click();
			Select select = new Select(we);
			select.selectByVisibleText(valor);
			sleep(1);
		}
	}

	public WebElement seleniumGetWebElement(WebDriver webDriver, final String xpath, int pos) {
		By by = By.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			return we;
		} else
			return null;
	}

	public void seleccionarDatepicker(WebDriver driver, String xpathFecha, String fecha) {
		String mes = fecha.split("-")[1];
		mes = GeneralUtil.obtenerMes(mes);

		String mesMostrado = seleniumGetText(driver, xpathFecha, 0);

		while (mesMostrado.compareTo(mes) != 0) {
			seleniumClick(driver, "//span[text()='Next']", 0);
			sleep(1);
			mesMostrado = seleniumGetText(driver, xpathFecha, 0);
		}
	}

	public void seleniumScrolltoElementJScript(WebDriver webDriver, final String xpath, int pos) {
		By by = By.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			JavascriptExecutor jse1 = (JavascriptExecutor) webDriver;
			jse1.executeScript("arguments[0].scrollIntoView(false); arguments[0].scrollIntoView({block: 'center'});",
					we);
			sleep(1);
		}
	}

	public void sleep(double seg) {
		long miliseg = (new Double(seg * 1000)).longValue();

		try {
			// System.out.println("sleep:\t\t" + seg + " seg... <--> " + miliseg +
			// "miliseg...");
			Thread.sleep(miliseg);
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}


}
