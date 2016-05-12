package webdriver_chapter1_first_test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NavigateToAUrl {
	
	public static void main(String[] args){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.facebook.com");
		
		if ( !checkLoginOnFacebook(driver) )
		{
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			WebElement aboutLink = driver.findElement(By.linkText("Înscrie-te pe Facebook"));
			aboutLink.click();
			checkSignInForm(driver);
		}
		// findElements -> pune intr-o lista toate elementele care indeplinesc
		//    			conditiile dupa care cauta;
//		List<WebElement> searchBox = driver.findElements(By.className("jsb"));
//		for ( WebElement i : searchBox )
//		{
//			 System.out.println( i.getTagName()  );
//		}
//		
		
//		WebElement searchButton = driver.findElement(By.name("btnK"));
//		searchButton.click();
		
		
	}



	// metoda ce va verifica campurile de login 
	public static Boolean checkLoginOnFacebook(WebDriver driver)
	{
		// caut campul de login pentru email si introduc date pentru logare
		WebElement emailAddressToLogin = driver.findElement(By.name("email"));
		emailAddressToLogin.sendKeys(" cody_cody2007@yahoo.com");
		
		// caut campul de login pentru parola si introduc date pentru logare
		WebElement passwordToLogin = driver.findElement(By.name("pass"));
		passwordToLogin.sendKeys("asdasd");
		
		// caut butonul de login si apas pemtru a ma loga
		WebElement buttonToLogin = driver.findElement(By.id("loginbutton"));
		buttonToLogin.click();
		
		// astept sa se incarce pagina inainte de a verifica daca login-ul a mers sau nu
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// verific daca am intrat pe facebook sau login in-ul a dat fail
		List<WebElement> searchOnFacebookBar = driver.findElements(By.className(("_586i" )));
		
		if ( searchOnFacebookBar.isEmpty() ) 
		{
			System.out.println("login failed");
			return false;
		}	
		else
		{ 
			System.out.println("login successfully");
			for ( WebElement i : searchOnFacebookBar )
			{
				 System.out.println( i.getTagName()  );
			}
		
	}
		
		System.out.println("login test finnished");
		return true;
	}
	
	
	public static void checkSignInForm(WebDriver driver)
	{
		// caut campul cu First Name si introduc date pentru Sign Up
		WebElement firstNameField = driver.findElement(By.name("firstname"));
		firstNameField.sendKeys("Gigel");
		
		// caut campul cu Last Name si introduc date pentru Sign Up
		WebElement lastNameField = driver.findElement(By.name("lastname"));
		lastNameField.sendKeys("Ionel");
		
		// caut campul cu email sau numar telefon si introduc date pentru Sign Up
		WebElement emailOrPhoneNoField = driver.findElement(By.name("reg_email__"));
		emailOrPhoneNoField.sendKeys("IonelGigel@yahoo.com");
		
		// caut campul cu email sau numar telefon si RE-introduc date pentru Sign Up
		WebElement emailOrPhoneNoConfirmationField = driver.findElement(By.name("reg_email_confirmation__"));
		emailOrPhoneNoConfirmationField.sendKeys("IonelGigel@yahoo.com");
				
		// caut campul cu parola si introduc date pentru Sign Up
		WebElement passwordToSignUpField = driver.findElement(By.name("reg_passwd__"));
		passwordToSignUpField.sendKeys("Ion3l&Gig3l");
		
		
		// cautam dropdown-ul de la luna de nastere pentru sign up
		Select monthBirthdayDropdown = new Select(driver.findElement(By.name("birthday_month")));
		monthBirthdayDropdown.selectByVisibleText("mai");
		
		// cautam dropdown-ul de la ziua de nastere pentru sign up
		Select dayBirthdayDropdown = new Select(driver.findElement(By.name("birthday_day")));
		dayBirthdayDropdown.selectByVisibleText("9");
		
		// cautam dropdown-ul de la anul de nastere pentru sign up
		Select yearBirthdayDropdown = new Select(driver.findElement(By.name("birthday_year")));
		yearBirthdayDropdown.selectByVisibleText("2016");
		
		
		// cautam radio button-ul pentru a alege sexul pentru sign up
		WebElement sexRadioButton = driver.findElement(By.id("u_0_f"));
		sexRadioButton.click();
		
		// cautam button-ul pentru a da submit la formular
		WebElement signUpButton = driver.findElement(By.id("u_0_j"));
		signUpButton.click();
		
		
	}
	
}