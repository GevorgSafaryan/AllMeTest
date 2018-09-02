package page.usersprofile;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import constants.Constants;
import driver.BaseDriver;
import page.login.LoginPage;

public class UsersProfile extends BaseDriver{
	
	JavascriptExecutor jsx = (JavascriptExecutor)driver;
	
	@FindBy(id = Constants.AVATAR)
	WebElement avatar;
	@FindBy(id = Constants.LOGOUT_LINK)
	WebElement logoutLink;
	@FindBy(id = Constants.MY_PROFILE)
	WebElement myProfile;
	@FindBy(xpath = Constants.POST_PHOTO_ICON)
	WebElement postPhotoIcon;
	@FindBy(id = Constants.PHOTO_UPLOAD)
	WebElement photoUpload;
	@FindBy(id = Constants.POST_BUTTON)
	WebElement postButton;
	@FindBy(xpath = Constants.POST_COUNT)
	WebElement postCount;
	
	//Constructor
	public UsersProfile(WebDriver driver) {
		super(driver);
	}
	
	public boolean avatarIsDisplayed() {
		return avatar.isDisplayed();
	}
	public String getUserPageTitle(){
		return driver.getTitle();
	}
	
	public void clickOnUserAvatar(){
		this.avatar.click();
	}
	
	public LoginPage clickOnLogout(){
		this.logoutLink.click();
		return new LoginPage(driver);
	}
	
	public void goToMyProfile(){
		this.myProfile.click();
	}
	
	public void choosePhotoForPost() throws IOException, InterruptedException{
		this.postPhotoIcon.click();
		Thread.sleep(10000);
		this.photoUpload.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Runtime.getRuntime().exec("C:\\Users\\Gevor\\Desktop\\AllMe\\FileUploader.exe");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		jsx.executeScript("window.scrollBy(0,450)", "");
	}
	
	public void clickOnPostButton(){
		this.postButton.click();
	}

	public int postsCount() {
		return this.driver.findElements(By.xpath(Constants.POST_COUNT)).size();
	}
}