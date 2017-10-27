package com.sh.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

	private static final Logger logger = LoggerFactory.getLogger(Test.class);

	@SuppressWarnings("rawtypes")
	private static Class c;
	private static Person person = new Person();
	private static String className = "com.sh.reflect.Person";

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception{
		Class clazz = Person.class;
		createClass();
		createInstance(clazz);
		getConstructors(clazz);
		getMethods(clazz);
		getFields(clazz);
		getOtherInfo(clazz);
		callConstruct(clazz);
		callMethod(clazz);
		callField(clazz);
	}

	/**
	 * 实例化Class的4种方式
	 * 
	 * @author 孙浩
	 * @date 2017年10月19日 下午7:15:55
	 * @Description:
	 * @throws ClassNotFoundException
	 */
	public static void createClass() throws ClassNotFoundException {
		logger.info("Execute createClass()...");

		// method-1-->调用运行时类的.class属性
		c = Person.class;
		logger.info("方法一:调用运行时类的.class属性:" + c.toString());

		// method-2-->通过运行时的类对象，调用getClass()方法
		c = person.getClass();
		logger.info("方法二:通过运行时的类对象，调用getClass()方法:" + c.toString());

		// method-3-->通过调用Class的静态方法forName(String className)
		c = Class.forName(className);
		logger.info("方法三:通过调用Class的静态方法forName(String className):" + c.toString());

		// method-4-->通过类加载器
		c = Person.class.getClassLoader().loadClass(className);
		logger.info("方法四:通过类加载器:" + c.toString());
	}

	/**
	 * 创建对应的运行时类的对象
	 * 
	 * @author 孙浩
	 * @date 2017年10月19日 下午7:25:35
	 * @Description:
	 * @param clazz
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void createInstance(Class clazz) throws Exception {
		logger.info("Execute createInstance()...");

		// method-1-->调用Class的newInstance方法创建运行时类的对象
		person = (Person) clazz.newInstance();
		logger.info("方法一:调用Class的newInstance方法创建运行时类的对象 --person:" + person);

		// method-2-->调用指定的构造器创建运行时类的对象
		Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class, int.class);
		person = (Person) constructor.newInstance("xxx", 0, 1);
		logger.info("方法二:调用指定的构造器(public)创建运行时类的对象 --person: " + person);

		constructor = clazz.getDeclaredConstructor(String.class);
		constructor.setAccessible(true);
		person = (Person) constructor.newInstance("***");
		logger.info("方法二:调用指定的私有构造器(private)创建运行时类的对象 --person: " + person);
	}

	/**
	 * 获取类的构造器
	 * 
	 * @author 孙浩
	 * @date 2017年10月19日 下午7:32:28
	 * @Description:
	 * @param clazz
	 */
	@SuppressWarnings("rawtypes")
	public static void getConstructors(Class clazz) {
		logger.info("Execute getConstructors()");

		logger.info("getConstructors()获取类的public的构造方法");
		Constructor[] constructors = clazz.getConstructors();
		for (int i = 0; i < constructors.length; i++) {
			logger.info("Constructor[" + i + "]:" + constructors[i]);
		}

		logger.info("getDeclaredConstructors()获取类本身自己定义的所有构造方法");
		Constructor[] constructors2 = clazz.getDeclaredConstructors();
		for (int i = 0; i < constructors2.length; i++) {
			logger.info("Constructor[" + i + "]:" + constructors2[i]);
		}
	}

	/**
	 * 获取类的方法
	 * 
	 * @author 孙浩
	 * @date 2017年10月19日 下午7:37:10
	 * @Description:
	 * @param clazz
	 */
	@SuppressWarnings("rawtypes")
	public static void getMethods(Class clazz) {
		logger.info("Execute getMethods()");

		logger.info("getMethods()获取类的public的方法，包括父类的");
		Method[] methods = c.getMethods();
		for (int i = 0; i < methods.length; i++) {
			logger.info("method [" + i + "]:" + methods[i]);
		}

		logger.info("getDeclaredMethods()此方法为获取类本身声明的所有方法，包括private");
		Method[] methods2 = c.getDeclaredMethods();
		for (int i = 0; i < methods2.length; i++) {
			logger.info("method [" + i + "]:" + methods2[i]);
		}
	}

	/**
	 * 获取类属性
	 * 
	 * @author 孙浩
	 * @date 2017年10月19日 下午7:40:18
	 * @Description:
	 * @param clazz
	 */
	@SuppressWarnings("rawtypes")
	public static void getFields(Class clazz) {
		logger.info("Execute getFields()");

		logger.info("getFields()获取类的public属性，包括父类的 ");
		Field[] fields = clazz.getFields();
		for (int i = 0; i < fields.length; i++) {
			logger.info("field [" + i + "]:" + fields[i]);
		}

		logger.info("getDeclaredFields()获取类的本身声明的所有属性，包括private ");
		Field[] fields2 = clazz.getDeclaredFields();
		for (int i = 0; i < fields2.length; i++) {
			logger.info("field [" + i + "]:" + fields2[i]);
		}
	}

	/**
	 * 获取类的其他信息，如包名，父类名，接口，内部类
	 * 
	 * @author 孙浩
	 * @date 2017年10月19日 下午7:47:55
	 * @Description:
	 * @param clazz
	 */
	@SuppressWarnings("rawtypes")
	public static void getOtherInfo(Class clazz) {
		logger.info("Execute getOtherInfo()");

		logger.info("类的包名:" + c.getPackage().getName());

		logger.info("类的父类:" + c.getSuperclass().getName());

		logger.info("类的接口");
		for (Class c : clazz.getInterfaces()) {
			logger.info(c.getName());
		}

		logger.info("类的内部类，包括private");
		for (Class c : clazz.getDeclaredClasses()) {
			logger.info(c.getName());
		}

		logger.info("类的内部类，包括父类的public内部类");
		for (Class c : clazz.getClasses()) {
			logger.info(c.getName());
		}
	}

	/**
	 * 对指定构造方法进行操作
	 * 
	 * @author 孙浩
	 * @date 2017年10月19日 下午7:50:16
	 * @Description:
	 * @param clazz
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void callConstruct(Class clazz) throws Exception {
		logger.info("Execute callConstruct");

		logger.info("对private类型的构造方法进行操作");
		Constructor constructor1 = c.getDeclaredConstructor(String.class);
		constructor1.setAccessible(true);
		person = (Person) constructor1.newInstance("zsmj");
		logger.info("person:" + person);

		logger.info("对public类型的构造方法进行操作");
		Constructor constructor2 = c.getDeclaredConstructor(String.class, int.class, int.class);
		person = (Person) constructor2.newInstance("yyf", 10, 2);
		logger.info("person:" + person);
	}

	/**
	 * 对指定方法进行操作
	 * 
	 * @author 孙浩
	 * @date 2017年10月19日 下午8:00:26
	 * @Description:
	 * @param clazz
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void callMethod(Class clazz) throws Exception {
		logger.info("Execute getMethod()");

		logger.info("getDeclaredMethod()方法获取类本身声明的方法，包括private类型的方法，以setName方法为例:");
		Method m1 = clazz.getDeclaredMethod("setName", String.class);
		m1.setAccessible(true);
		logger.info("修改前的person--" + person);
		m1.invoke(person, "yuasdsf");
		logger.info("修改前后person--" + person);

		logger.info("getMethod()对public类型的方法进行操作，包括父类的方法,以类本身的setAge方法为例:");
		Method m2 = clazz.getMethod("setAge", int.class);
		logger.info("修改前的person--" + person);
		m2.invoke(person, 16);
		logger.info("修改前后person--" + person);

		logger.info("getMethod()对public类型的方法进行操作，包括父类的方法,以父类的setWeight方法为例:");
		Method m3 = clazz.getMethod("setWeight", int.class);
		logger.info("修改前的person--" + person);
		m3.invoke(person, 135);
		logger.info("修改前后person--" + person);

		logger.info("getMethod()对static类型的方法进行操作，以类本身的showWeather静态方法为例:");
		Method m4 = clazz.getMethod("showWeather");
		m4.invoke(null);

		logger.info("获取指定方法的返回值,以类本身的private类型的getName方法为例:");
		Method m5 = c.getDeclaredMethod("getName");
		m5.setAccessible(true);
		String name = (String) m5.invoke(person);
		logger.info("name:" + name);
	}

	/**
	 * 对指定属性进行操作
	 * @author 孙浩
	 * @date 2017年10月19日 下午8:03:11
	 * @Description:
	 * @param clazz
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static void callField(Class clazz) throws Exception {
		logger.info("Execute callField()");

		logger.info("对public类型的属性进行操作，以类本身的public属性id为例");
		Field f1 = c.getField("id");
		int id = (int) f1.get(person);
		logger.info("修改前person对象的id=" + id);
		f1.set(person, 3);
		id = (int) f1.get(person);
		logger.info("修改后person对象的id=" + id);

		// 2.对private类型的属性进行操作，以类本身的private属性age为例:
		logger.info("对private类型的属性进行操作，以类本身的private属性age为例:");
		Field f2 = c.getDeclaredField("age");
		f2.setAccessible(true);
		int age = (int) f2.get(person);
		logger.info("修改前person对象的age=" + age);
		f2.set(person, 12);
		age = (int) f2.get(person);
		logger.info("修改后person对象的age=" + age);

		// 3.对static类型的属性进行操作，以类本身的static属性weather为例:
		logger.info("对static类型的属性进行操作，以类本身的static属性weather为例:");
		Field f3 = c.getDeclaredField("weather");
		f3.setAccessible(true);
		String weather = (String) f3.get(person);
		logger.info("修改前person对象的weather=" + weather);
		// f3.set(person, "今天天气好凉爽！！");
		f3.set(null, "今天天气好凉爽！！");
		weather = (String) f3.get(person);
		logger.info("修改后person对象的weather=" + weather);
	}
}
