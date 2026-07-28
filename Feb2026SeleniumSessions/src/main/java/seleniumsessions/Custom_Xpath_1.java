package seleniumsessions;

import org.openqa.selenium.By;

public class Custom_Xpath_1 {

	public static void main(String[] args) {

		//xpath : address of the element inside POM

		//htmltag[@attr='value']

		//input[@id='input-email']
		//*[@id='input-email']

		//input[@type='submit']

		//htmltag[@attr1='value1' and @attr2='value2']

		//input[@value='Login' and @type='submit']
		//input[@value='Login' or @type='submit']
		//input[@type='text' and @name='email']

		//input[@placeholder='E-Mail Address']

		//*[@id] --All elements having ID

		//dynamic ids:
		//		<input id="test_123">
		//		<input id="test_456">
		//		<input id="test_563">
		//		<input id="test_783">

		//contains():

		//htmltag[contains(@attr,'value')]
		//input[contains(@id,'test_')]

		//input[contains(@placeholder,'E-Mail')]

		//contains() with multiple attributes:

		////htmltag[contains(@attr1,'value') and contains(@attr2, 'value')]

		//input[contains(@placeholder,'E-Mail') and contains(@id,'input')]

		//input[contains(@placeholder,'E-Mail') and contains(@id,'input') and contains(@name,'email')]

		//one attr with contains and one without contains

		//input[contains(@id,'email') and @type='text']
		//input[@type='text' and contains(@id,'email') ]

		//a[@class='list-group-item'] --> to capture all links use findElements

		//text(): used for span, any label or any links
		//htmltag[text()='value']

		//a[text()='Register']

		//h2[text()='Returning Customer']

		//text() and @attribute
		//htmltag[text()='value' and @attr='value']
		//a[text()='Gift Cards' and @data-csa-c-id='rdvmgn-bxvj7p-gayeem-irkgu3']


		//contains() with text():
		//htmltag[contains(text(),'value')]
		//span[contains(text(),'Kitchen')]

		//a[contains(text(),'Gift') and contains(@href,'/gift-cards')]

		//starts-with:
		//a[starts-with(text(),'Gift')]
		//a[starts-with(text(),'Amazon')]

		//Indexing : indexing or positioning
		//	(//input[@type='text'])[2]

		//    By emailId = By.xpath("(//input[@type='text'])[2]"); --> indexing

		//    (//input[@type='text'])[position()=1] -->positioning

		// (//div[@class='navFooterLinkCol navAccessibility'])[1]//a

		//		(//div[@class='navFooterLinkCol navAccessibility'])[4]//a

		//last():

		//(//input[@type='text' or @type='email' or @type='tel' or @type='password'])[last()]
		//		(//input[@type='text' or @type='email' or @type='tel' or @type='password'])[last()-1]

		//				((//div[@class='navFooterLinkCol navAccessibility'])[4]//a)[last()]

		//						((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()]

		//								((//div[@class='navFooterLinkCol navAccessibility'])[last()-1]//a)[last()]

		//										(//a[starts-with(text(),'Amazon')])[last()-1]

		//parent to child:
		//  (//div[@class='form-group'])[1]/input[contains(@id,'email')]
		//nav[@class='sc-662dedcb-0 fMAcTI']//a

		// (/) -->  direct child element
		// (//) --> direct + indirect child elements both
		
		
		//form[@class="msf"]/div --1
		//form[@class="msf"]//div  --8
		
		//span[@class="cl-input-wrapper"]/child::input
		//span[@class="cl-input-wrapper"]/child::input --1 or few
		
		//span[@class="cl-input-wrapper"]//child::input --more than 1


		
		//child to parent: Backward Traversing
		//input[@name='email']/../..   --> for each label to parent add /..
		
		//input[@name='email']/parent::span --> 1
		                                              //  both same result because parent tag will give only immediate parent
		//input[@name='email']//parent::span -->1  
		
		//input[@name='email']/ancestor::span  --> 2  grandparents all span




	}

}
