package com.example.java8;

/**
 * @Author: gaobo.gb@alibaba-inc.com
 * @Date: 2018/11/05
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateFormat工具类，用ThreadLocal解决DateFormat多线程问题
 *
 */
public class DateFormatUtil {

	private String pattern;

	public DateFormatUtil(String pattern) {
		this.pattern = pattern;
	}

	private final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {

		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat(pattern);
		}
	};

	public final String format(Date date) {
		return df.get().format(date);
	}

	public Date parse(String source) throws ParseException {
		return df.get().parse(source);
	}
}