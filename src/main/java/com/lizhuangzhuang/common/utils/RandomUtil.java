package com.lizhuangzhuang.common.utils;


import java.util.Random;


/** 
 * @ClassName: RandomUtil 
 * @Description: TODO
 * @author: lenovo
 * @date: 2019年6月17日 上午8:44:42  
 */
public class RandomUtil {
	//方法1：返回min-max之间的随机整数（包含min和max值），例如返回1-3之间的随机数，那么返回1或2或3都是正确的，返回4就不对。 (5分)
	public static int random(int min, int max){
		Random r=new Random();
		return (r.nextInt(max-min+1)+min);
	}
	//方法2：在最小值min与最大值max之间截取subs个不重复的随机数。例如在1-10之间取3个不重复的随机数，那么[2,6,9]是对的，[3,5,5]则不对，因为5重复了。应用场景：在100篇文章中随机取10篇文章，月考可能会使用到。 (8分)
	@SuppressWarnings("null")
	public static int[] subRandom (int min, int max, int subs){
		Random r=new Random();
		int[] a = null;
		for (int i = 0; i < subs; i++) {
			int b=(r.nextInt(max-min+1)+min);
			if(i!=0&&b!=a[i-1]) {
				a[i]=b;
			}
			a[i]=b;
		}
		/*Set<Integer> s=new HashSet<Integer>();
		while (s.size()!=subs) {
			s.add((r.nextInt(max-min+1)+min));
		}
		Iterator<Integer> iterator = s.iterator();
		int i=0;
		while(iterator.hasNext()) {
			Integer next = iterator.next();
			a[0]=next;
			i++;
		}*/
		return a;
	}
	//方法3：返回1个1-9,a-Z之间的随机字符。 (8分)
	public static char randomCharacter (){
		Random r=new Random();
		String str="123456789abcdefghijklmnopqrstovwsyzABCDEFGHIJKLMNOPQRSTOVWXYZ";
		char zf=str.charAt(r.nextInt(str.length()));
		return zf;
	}
	//方法4：返回参数length个字符串(5分)，方法内部要调用randomCharacter()方法 (4分)
	public static String randomString(int length){
		String zf="";
		for (int i = 0; i < length; i++) {
			zf+=randomCharacter();
		}
		return zf;
	}
}
