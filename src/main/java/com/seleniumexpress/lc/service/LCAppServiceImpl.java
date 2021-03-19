package com.seleniumexpress.lc.service;

import org.springframework.stereotype.Service;

@Service
public class LCAppServiceImpl implements LCAppService {

	public final String LCAppString = "FLAMES";
	
	@Override
	public String calculateLove(String userName, String crushName) {
		// TODO Auto-generated method stub
		int userAndCrushNameCount = (userName+crushName).toCharArray().length;
		int formulaCount = LCAppString.length();
		
		int rem = userAndCrushNameCount % formulaCount;
		
		char resultChar = LCAppString.charAt(rem);
		
		String result = whatsBetweenUs(resultChar);
		
		return result;

	}

	@Override
	public String whatsBetweenUs(char calculationResult) {
		String result = null;
		if(calculationResult == 'F') {
			result = LoveCalculatorConstants.F_CHAR_MEANING;
		} else if(calculationResult == 'L') {
			result = LoveCalculatorConstants.L_CHAR_MEANING;
		} else if(calculationResult == 'A') {
			result = LoveCalculatorConstants.A_CHAR_MEANING;
		} else if(calculationResult == 'M') {
			result = LoveCalculatorConstants.M_CHAR_MEANING;
		} else if(calculationResult == 'E') {
			result = LoveCalculatorConstants.E_CHAR_MEANING;
		} else if(calculationResult == 'S') {
			result = LoveCalculatorConstants.S_CHAR_MEANING;
		} 
		return result;
	}

}
