public class YearUtilities {
	
	public boolean isLeap(int year) {
		boolean isLeap = false;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					isLeap = true;
				}
			} else {
				isLeap = true;
			}
		}
		return isLeap;
	}
	
	public boolean isLeap2(int year) {
		boolean isLeap = false;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					isLeap = true;
				} else {
					isLeap = false;
				}
			} else {
				isLeap = true;
			}
		} else {
			isLeap = false;
		}
		return isLeap;
	}

}