package seleniumsessions;

import org.openqa.selenium.By;

public class CustomCssSelector 
{





	//css selector:
	//	By.cssSelector("#input-email");

	//id --> #id
	//class --> .class

	//	id="input-email"
	//tag#id
	//	input#input-email
	//	.form-control
	//tag.class
	//	input.form-control


	//combine id and class
	//	#input-email.form-control
	//	.form-control#input-email

	//	input.form-control#input-email



	//.c1.c2.c3.c4......cn
	//	class="nav-input nav-progressive-attribute"


	//    .nav-input.nav-progressive-attribute
	//    .btn.btn-primary
	//	button.nav-link.contact-btn-nav

	//	By element=By.cssSelector("button.nav-link.contact-btn-nav");

	//	By.className("nav-link contact-btn-nav"); //not a valid 
	//	By.xPath("//button[@class="nav-link contact-btn-nav"]"); //correct
	//	By.cssSelector("nav-link.contact-btn-nav"); //correct
	//	By.className("contact-btn-nav"); //valid
	// By.className(".contact-btn-nav"); // not valid

	// class="cl-card csol-header-form-form-container -container-01 -border"
	//div.cl-card.csol-header-form-form-container.-container-01.-border

	//		By.className(".cl-card.csol-header-form-form-container.-container-01.-border") --Not Valid
	//		By.xpath("//div[@class='cl-card csol-header-form-form-container -container-01 -border')]");
	// By.className("cl-card"); //valid
	//By.cssSelector("div.cl-card.csol-header-form-form-container.-container-01.-border");

	// By.cssSelector(div.cl-card.-container-01.-border) -->  Also Valid

	//button.login-submit
	//button[@class='login-submit'] -- not Valid because it is not complete class.
	//	By.xpath("//button[contains(@class,'login-submit')]");


	//htmltag[attr1='value']
	//input[type='submit']
	//input[@type='submit'] //xpath

	//htmltag[attr1='value'][attr2='value'][attr3='value'] 

	//input[type='submit'] [value='Login'] [class='btn btn-primary]
	//input[@type='submit'or @value='Login' or @class='btn btn-primary] -->xpath

	//contains
	//	input[id*='email']
	//	input[id^='input'] -->starts-with
	//	button[class^='login-submit']
	//	button[class$='login-submit'] -->ends-with

	//parent to child
	//	div.private-form_input-wrapper>input#username  -->direct child
	//div.private-form_input-wrapper input#username -->it gives direct or indirect child
	
//	ul.footer-nav >li >a --> directly associated
	// form#hs-login div -->20 direct/inderect associations
	
	// form#hs-login > div -->8(direct)
	
	//child to parent: Not Available -->Backward Traversing is not allowed in css
	
	//Following-Sibling :  
	// label.control-label + input#input-email
	
	//preceding-sibling : Not Available
	
	//Not in CSS:
	//form-contro private-form_control login-email
	//form-control private-form_control login-password m-bottom-3
	// input.form-control.private-form_control:not(#username) -->exclude id username
	//input.form-control:not(.input-lg)
	
	//comma in CSS:
	// input#username,input#password,button#loginBtn,button#ssoBtn,input#remember -->5
	
	// No text support in CSS
	
	//nth-of-type
//	ul.footer-nav li:nth-of-type(5)>a -->for 5th li
//	ul.footer-nav li:nth-of-type(n)>a --> for n all li
	
	//                     xpath                                  CSS Selector
	//1. Syntax:            Hard                                       Simple
	//2. backward:          possible                                   NA
	//3. performance:       same                                      same
	//4. comma, not :       NA                                        available
	//5. text():            available                                  NA
	//6. Sibling:           available                                 only forward sibling
	//7. indexing:          better functions                           available but not simple
	//8. dynamic ele:       yes                                        yes
	
	
	
	
	
	
	

	















}

