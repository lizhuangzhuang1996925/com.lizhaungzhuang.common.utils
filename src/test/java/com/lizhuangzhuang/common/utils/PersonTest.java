package com.lizhuangzhuang.common.utils;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

/** 
 * @ClassName: PersonTest 
 * @Description: TODO
 * @author: lenovo
 * @date: 2019年6月17日 上午9:20:43  
 */
public class PersonTest {
	/*//姓名属性值调用StringUtil.generateChineseName()创建（4分）
	年龄属性值调用RandomUtil.random()创建，必须在1-120岁之间（4分）
	介绍属性值调用StringUtil.randomChineseString()创建，字数为140个随机汉字（4分）
	注册日期属性值模拟2010年1月1日至今任意随机时间（4分）。
	批量生成1万个，并在控制台输出（4分）*/
	@Test
	public void test() throws UnsupportedEncodingException {
		Date created = new Date();
		Random r=new Random();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < 10000; i++) {
			//注册日期属性值模拟2010年1月1日至今任意随机时间（4分）。
			created.setYear((r.nextInt(2019-2010+1)+2010-1900));
			created.setMonth(r.nextInt(12)+1);
			if(created.getMonth()==1||created.getMonth()==3||created.getMonth()==5||created.getMonth()==7||created.getMonth()==8||created.getMonth()==10||created.getMonth()==12) {
				created.setDate(r.nextInt(31)+1);
			}else {
				created.setDate(r.nextInt(30)+1);
			}
			//判断闰年平年
			if((created.getYear()%400==0)&&(created.getYear()%100==0)){
				if(created.getMonth()==2) {
					created.setDate(r.nextInt(28)+1);
				}
			}else {
				created.setDate(r.nextInt(29)+1);
			}
			Person person=new Person(StringUtil.generateChineseName(), RandomUtil.random(1, 120), StringUtil.randomChineseString(120),sf.format(created) );
			System.out.println(i+","+person);
		}
	}
	@Test
	public void randomChineseStringTest() throws UnsupportedEncodingException {
		StringUtil.randomChineseString(600);
	}

}
