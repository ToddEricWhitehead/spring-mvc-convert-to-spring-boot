package com.seleniumexpress.lc.api.fomatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.seleniumexpress.lc.api.Phone;

public class PhoneNumberFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone phone, Locale locale) {
		System.out.println("inside the PhoneNumberFormatter:print()");
		return phone.getCountryCode() + "-" + phone.getUserNumber();
	}

	@Override
	public Phone parse(String text, Locale locale) throws ParseException {
		System.out.println("inside ther parse method of the phone formatter");
		System.out.println("text : "+text);

		Phone phone = new Phone();
		
		String[] phoneNumberArray = text.split("-");
		
		int index = text.indexOf('-');
		if (index == -1) {
			
			phone.setCountryCode("");
			phone.setUserNumber("");
			
		} else if (text.startsWith("-")) {
			
			phone.setCountryCode("91");
			
			if (phoneNumberArray.length<2) {
				phone.setUserNumber("");
				
			} else {			
				phone.setUserNumber(phoneNumberArray[1]);
				
			}
		} else {
			phone.setCountryCode(phoneNumberArray[0]);
			phone.setUserNumber(phoneNumberArray[1]);
		}
		return phone;
	}
//	@Override
//	public Phone parse(String text, Locale locale) throws ParseException {
//		System.out.println("inside ther parse method of the phone formatter");
//		System.out.println("text : "+text);
//		String[] phoneNumberArray = text.split("-");
//		
//		Phone phone = new Phone();
//		if (phoneNumberArray.length==0) {
//			phone.setCountryCode("91");
//		}
//		if (phoneNumberArray.length==1) {
//			phone.setCountryCode(phoneNumberArray[0]);
//		} else if (phoneNumberArray.length>1) {
//			phone.setCountryCode(phoneNumberArray[0]);
//			phone.setUserNumber(phoneNumberArray[1]);
//		}
//		return phone;
//	}

}
