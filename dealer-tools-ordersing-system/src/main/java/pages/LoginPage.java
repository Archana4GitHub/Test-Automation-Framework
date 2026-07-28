package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	private By emailField = By.id("emailInput");
	private By passwordField = By.id("passwordInput");
	private By captchaField = By.id("captchaInput");
	private By loginButton = By.id("loginBtn");
	private By errorMessage = By.className("error-message");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void enterCaptcha(String captcha) {
		driver.findElement(captchaField).sendKeys(captcha);
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}

	public void loginAs(String email, String password, String captcha) {
		enterEmail(email);
		enterPassword(password);
		enterCaptcha(captcha);
		clickLogin();
	}
}


