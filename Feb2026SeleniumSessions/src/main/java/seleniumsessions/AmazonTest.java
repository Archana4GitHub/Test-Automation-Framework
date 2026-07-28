package seleniumsessions;

import java.net.MalformedURLException;
import java.net.URL;

public class AmazonTest {

	public static void main(String[] args) throws InterruptedException {
		BrowserUtil br=new BrowserUtil();
		br.launchBrowser("chrome");
		//br.launchUrl("www.amazon.com");

		try {
			br.launchUrl(new URL("https://www.amazon.com"));
		}
		catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
		String title=br.getpageTitle();
		System.out.println("title is "+title);

		if(title.contains("amazon")) {
			System.out.println("Title Verified: Test Passed");
		}
		else {
			System.out.println("Title Verified:Test Not Passed");
		}

		System.out.println(br.getPageUrl());
		
		br.closeBrowser();

	}

}
