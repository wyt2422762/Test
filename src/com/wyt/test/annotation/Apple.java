package com.wyt.test.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.wyt.test.annotation.FruitColor.Color;

/**
 * 苹果类
 * 
 * @author wyt
 * 
 */
@FruitType("果类")
public class Apple {

	@FruitName("苹果")
	private String name;

	@FruitColor(fruitColor = Color.RED)
	private String color;

	@FruitOpt("生吃")
	public void eat() {

	}

	/**
	 * 注解处理方法
	 */
	public static void annotationHandle(Class<?> clazz) {

		if (clazz.isAnnotationPresent(FruitType.class)) {
			FruitType fruitType = clazz.getAnnotation(FruitType.class);
			String fruitTypeStr = fruitType.value();
			System.out.println("水果类型  = " + fruitTypeStr);
		}

		/**
		 * 获取所有属性
		 */
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {

			if (field.isAnnotationPresent(FruitName.class)) {
				FruitName fruitName = field.getAnnotation(FruitName.class);
				String fruitNameStr = fruitName.value();
				System.out.println("水果名称 = " + fruitNameStr);
			}

			if (field.isAnnotationPresent(FruitColor.class)) {
				FruitColor fruitColor = (FruitColor) field
						.getAnnotation(FruitColor.class);
				String fruitColorStr = fruitColor.fruitColor().toString();
				System.out.println("水果颜色 = " + fruitColorStr);
			}

		}

		/**
		 * 获取所有方法
		 */
		Method[] methods = clazz.getDeclaredMethods();

		for (Method method : methods) {

			if (method.isAnnotationPresent(FruitOpt.class)) {
				FruitOpt fruitOpt = method.getAnnotation(FruitOpt.class);
				String fruitOptStr = fruitOpt.value();
				System.out.println("水果吃法 = " + fruitOptStr);
			}

		}

	}

	public static void main(String[] args) {
		annotationHandle(Apple.class);
	}
}
