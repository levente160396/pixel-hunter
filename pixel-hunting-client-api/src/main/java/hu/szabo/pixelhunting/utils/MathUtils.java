package hu.szabo.pixelhunting.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(MathUtils.class);

	private MathUtils() {
	}

	public static int roundNumber(Integer number) {
		
		if(null == number) {
			return 0;
		}
		
		int digitLenght = checkDigitLenght(number.intValue());

		double doubleValue = Math.ceil(number.doubleValue());

		switch (digitLenght) {
		case 0:
			return 0;
		case 1:
			return (int) ((doubleValue + 9) / 10) * 10;
		case 2:
			return (int) ((doubleValue + 9) / 10) * 10;
		case 3:
			return (int) ((doubleValue + 99) / 100) * 100;
		case 4:
			return (int) ((doubleValue + 999) / 1000) * 1000;
		case 5:
			return (int) ((doubleValue + 9999) / 10000) * 10000;
		case 6: 
			return (int) ((doubleValue + 99999) / 100000) * 100000;
		default:
			LOGGER.error("Failed to round number, because length bigger then 5 digits! Value: ", doubleValue);

			return (int) ((doubleValue + 9999) / 10000) * 10000;
		}
	}

	public static int checkDigitLenght(int number) {
		int length = 0;
		long temp = 1;
		while (temp <= number) {
			length++;
			temp *= 10;
		}

		return length;
	}
}
