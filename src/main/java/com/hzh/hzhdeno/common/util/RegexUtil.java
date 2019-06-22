package com.hzh.hzhdeno.common.util;

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	public static Pattern pattern = Pattern.compile("(([01]\\d|2[0-3]):[0-5]\\d)-(([01]\\d|2[0-3]):[0-5]\\d)");

	/**
	 * 检查是否合法的时间格式 HH:mm-HH:mm
	 */
	public static String[] parseTime(String str) {
		if (StringUtil.isEmpty(str)) {
			return null;
		}
		String[] times = str.split(",");

		TreeSet<String> ts = new TreeSet<String>();
		for (String time : times) {
			if (StringUtil.isNotEmpty(time)) {
				ts.add(time);
			}
		}
		String[] tmp = new String[ts.size() * 2];
		int i = 0;
		for (String time : ts) {
			Matcher matcher = pattern.matcher(time);
			if (matcher.matches()) {
				tmp[i++] = matcher.group(1);
				tmp[i++] = matcher.group(3);
			}
		}
		String[] rs = new String[i];
		for (i = 0; i < rs.length; i++) {
			rs[i] = tmp[i];
		}
		return rs;
	}

	public static String getLastMatchString(String text, String regex) {
		Pattern p = Pattern.compile(regex, 2);
		Matcher m = p.matcher(text);
		if (m.find())
			return m.group(m.groupCount());
		else
			return null;
	}

	public static String getMatchString(String text, String regex, int pos) {
		Pattern p = Pattern.compile(regex, 2);
		Matcher m = p.matcher(text);
		if (m.find())
			return m.group(pos);
		else
			return null;
	}
}
