package com.umind.utility;

/**
 * Hai Nguyen - 5/26/16.
 */
public class UniUtility {

	public static String toTelex(String from) {

		String[] ori = {"ố", "ồ", "ổ", "ộ", "ỗ", "ế", "ắ", "ằ", "ẳ", "ẵ", "ặ",
				"ấ", "ẩ", "ẫ", "ầ", "ậ", "ớ", "ờ", "ở", "ỡ", "ề", "ể", "ễ",
				"ệ", "ứ", "ừ", "ử", "ữ", "ự", "ợ", "ý", "ỳ", "ỷ", "ỹ", "ỵ",
				"í", "ì", "ị", "ỉ", "ĩ", "ê", "é", "è", "ẻ", "ẽ", "ẹ", "ư",
				"â", "ơ", "ă", "á", "à", "ả", "ã", "ạ", "ú", "ù", "ủ", "ũ",
				"ụ", "ô", "ó", "ò", "ỏ", "õ", "ọ", "đ"};
		String[] neww = {"oos", "oof", "oor", "ooj", "oox", "ees", "aws",
				"awf", "awr", "awx", "awj", "aas", "aar", "aax", "aaf", "aaj",
				"ows", "owf", "owr", "owx", "eef", "eer", "eex", "eej", "uws",
				"uwf", "uwr", "uwx", "uwj", "owj", "ys", "yf", "yr", "yx",
				"yj", "is", "if", "ij", "ir", "ix", "ee", "es", "ef", "er",
				"ex", "ej", "uw", "aa", "ow", "aw", "as", "af", "ar", "ax",
				"aj", "us", "uf", "ur", "ux", "uj", "oo", "os", "of", "or",
				"ox", "oj", "dd"};
		String result = from.toLowerCase();
		for (int i = 0; i < ori.length; i++) {

			result = result.replace(ori[i], neww[i]);
		}

		return result;
	}

	public static String toVN(String from) {

		String[] ori = {"ố", "ồ", "ổ", "ộ", "ỗ", "ế", "ắ", "ằ", "ẳ", "ẵ", "ặ",
				"ấ", "ẩ", "ẫ", "ầ", "ậ", "ớ", "ờ", "ở", "ỡ", "ề", "ể", "ễ",
				"ệ", "ứ", "ừ", "ử", "ữ", "ự", "ợ", "ý", "ỳ", "ỷ", "ỹ", "ỵ",
				"í", "ì", "ị", "ỉ", "ĩ", "ê", "é", "è", "ẻ", "ẽ", "ẹ", "ư",
				"â", "ơ", "ă", "á", "à", "ả", "ã", "ạ", "ú", "ù", "ủ", "ũ",
				"ụ", "ô", "ó", "ò", "ỏ", "õ", "ọ", "đ"};
		String[] neww = {"oos", "oof", "oor", "ooj", "oox", "ees", "aws",
				"awf", "awr", "awx", "awj", "aas", "aar", "aax", "aaf", "aaj",
				"ows", "owf", "owr", "owx", "eef", "eer", "eex", "eej", "uws",
				"uwf", "uwr", "uwx", "uwj", "owj", "ys", "yf", "yr", "yx",
				"yj", "is", "if", "ij", "ir", "ix", "ee", "es", "ef", "er",
				"ex", "ej", "uw", "aa", "ow", "aw", "as", "af", "ar", "ax",
				"aj", "us", "uf", "ur", "ux", "uj", "oo", "os", "of", "or",
				"ox", "oj", "dd"};
		String result = from.toLowerCase();
		for (int i = 0; i < ori.length; i++) {

			result = result.replace(neww[i], ori[i]);
		}

		return result;
	}
}
