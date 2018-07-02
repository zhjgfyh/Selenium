/**
 * CaseName：线上环境组织结构 -> 公司管理模块
 * Time：20180622
 * Creator: ZJ
 * */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Company {
	
	public WebDriver driver;
	
	/**
	 * 初始化driver
	 * */
	public void InitDriver(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ZJ\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://101.251.248.154/view/auth/login.html");
		driver.manage().window().maximize();
	}
	
	/**
	 * 输入框
	 * */
	public void InputBox(){
		WebElement user = driver.findElement(By.id("name"));
		user.sendKeys("zhaojie0523");
		user.clear();
		user.sendKeys("zhaojie0523");
		// 获取输入框默认提示信息
		String user_info = user.getAttribute("placeholder");
		System.out.println(user_info);
		// 获取输入的内容
		String user_value = user.getAttribute("value");
		System.out.println(user_value);
		// 判断输入框是否为可输入状态
		boolean enable = user.isEnabled();
		System.out.println(enable);
		driver.findElement(By.name("password")).sendKeys("zhaojie0523");
		driver.findElement(By.className("loginBtn")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.className("help")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/**
		 * 验证公司名称
		 * */
		WebElement comName = driver.findElement(By.className("comeComName"));
		System.out.println(comName.getText());
			

		/**
		 * 层级定位系统管理按钮
		 * */ 
		WebElement element = driver.findElement(By.className("menuB"));
		List<WebElement> elements = element.findElements(By.tagName("li"));
		elements.get(1).click();
	}
	
	public void comStructure(){
		/**
		 * 定位组织结构按钮
		 * */ 
		WebElement element = driver.findElement(By.className("workbenchL_menu"));
		List<WebElement> elements = element.findElements(By.tagName("li"));
		for(WebElement e: elements)
			System.out.println(e.getText());
		elements.get(0).click();
		
		/**
		 * 公司管理按钮
		 * */ 
		driver.findElement(By.xpath("//*[@id='73']/a")).click();
	}
	
	public static void main(String[] args) {
		/**
		 * 实例化对象
		 * */
		Company action = new Company();
		action.InitDriver();
		action.InputBox();
		action.comStructure();
	}

}
