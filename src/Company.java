/**
 * CaseName�����ϻ�����֯�ṹ -> ��˾����ģ��
 * Time��20180622
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
	 * ��ʼ��driver
	 * */
	public void InitDriver(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ZJ\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://101.251.248.154/view/auth/login.html");
		driver.manage().window().maximize();
	}
	
	/**
	 * �����
	 * */
	public void InputBox(){
		WebElement user = driver.findElement(By.id("name"));
		user.sendKeys("zhaojie0523");
		user.clear();
		user.sendKeys("zhaojie0523");
		// ��ȡ�����Ĭ����ʾ��Ϣ
		String user_info = user.getAttribute("placeholder");
		System.out.println(user_info);
		// ��ȡ���������
		String user_value = user.getAttribute("value");
		System.out.println(user_value);
		// �ж�������Ƿ�Ϊ������״̬
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
		 * ��֤��˾����
		 * */
		WebElement comName = driver.findElement(By.className("comeComName"));
		System.out.println(comName.getText());
			

		/**
		 * �㼶��λϵͳ����ť
		 * */ 
		WebElement element = driver.findElement(By.className("menuB"));
		List<WebElement> elements = element.findElements(By.tagName("li"));
		elements.get(1).click();
	}
	
	public void comStructure(){
		/**
		 * ��λ��֯�ṹ��ť
		 * */ 
		WebElement element = driver.findElement(By.className("workbenchL_menu"));
		List<WebElement> elements = element.findElements(By.tagName("li"));
		for(WebElement e: elements)
			System.out.println(e.getText());
		elements.get(0).click();
		
		/**
		 * ��˾����ť
		 * */ 
		driver.findElement(By.xpath("//*[@id='73']/a")).click();
	}
	
	public static void main(String[] args) {
		/**
		 * ʵ��������
		 * */
		Company action = new Company();
		action.InitDriver();
		action.InputBox();
		action.comStructure();
	}

}
