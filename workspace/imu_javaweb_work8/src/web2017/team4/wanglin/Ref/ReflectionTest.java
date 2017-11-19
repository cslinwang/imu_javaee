package web2017.team4.wanglin.Ref;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {

	public static void main(String[] args) {
		/*
		 * Class 类的实例表示正在运行的 Java 应用程序中的类和接口。 Constructor
		 * 提供关于类的单个构造方法的信息以及对它的访问权限。 getModifiers(): 返回此类或接口以整数编码的 Java
		 * 语言修饰符。修饰符由 Java 虚拟机的public、protected、private、final、static、abstract 和
		 * interface 对应的常量组成；它们应当通过 Modifier 类的方法来解码。 Modifier 类提供了 static
		 * 方法和常量，对类和成员访问修饰符进行解码。 getSimpleName(): 返回源代码中给出的基础类的简称。
		 * 如果基础类是匿名的则返回一个空字符串。
		 */
		Class c = null;
		try {
			// 根据传入的类的全名来创建Class对象,注意必须是全名
			c = Class.forName("web2017.team4.wanglin.test.Person");
			// 得到包路径
			System.out.println("package" + c.getPackage().getName() + ";\n");
			// 得到类修饰符
			System.out.print(Modifier.toString(c.getModifiers()));
			// 得到类名
			System.out.print("class" + c.getSimpleName());
			// 得到父类名
			System.out.print("extends" + c.getSuperclass().getSimpleName());
			// 得到类实现的接口数组
			Class[] inters = c.getInterfaces();
			if (inters.length > 0) {
				System.out.print("implements");
				for (int i = 0; i < inters.length; i++) {
					System.out.print(inters[i].getSimpleName());
					if (i < inters.length) {
						System.out.print(",");
					}
				}
			}
			System.out.println("{");
			// 获取类属性
			printField(c);
			// 获取类构造器
			printConstrutor(c);
			// 获取方法
			printMethods(c);
			System.out.println("}");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void printConstrutor(Class c) {
		Constructor[] cs = c.getConstructors();
		for (int i = 0; i < cs.length; i++) {
			System.out.println();
			System.out.print("\t");
			// 得到整数形式构造函数修饰符，使用Modifier进行解码
			System.out.print(Modifier.toString(cs[i].getModifiers()) + " ");
			// 得到方法名
			System.out.print(cs[i].getName() + "(");
			// 得到方法参数数组
			Class[] paras = cs[i].getParameterTypes();
			for (int j = 0; j < paras.length; j++) {
				System.out.println(paras[j].getSimpleName() + " arg" + j);
				if (j < paras.length - 1) {
					System.out.print(",");
				}
			}

			System.out.print(")");
			System.out.println("{");
			System.out.println("\t\t\\\\方法体");
			System.out.println("\t}");
		}
	}

	/*
	 * getDeclaredFields(): 返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示
	 * 的类或接口所声明的所有字段，包括公共、保护、默认（包）访问 和私有字段，但不包括继承的字段。
	 */

	public static void printField(Class c) {
		// 得到属性数组
		Field[] f = c.getDeclaredFields();
		for (int i = 0; i < f.length; i++) {
			System.out.print("\t");
			// 得到整数形式属性修饰符，使用Modifier进行解码
			System.out.print(Modifier.toString(f[i].getModifiers()) + " ");
			// 得到属性类型
			System.out.print(f[i].getType().getSimpleName() + " ");
			// 得到属性名
			System.out.println(f[i].getName() + ";");

		}
	}

	public static void printMethods(Class c) {
		// 得到方法数组
		Method[] md = c.getMethods();
		for (int i = 0; i < md.length; i++) {
			System.out.println();
			System.out.print("\t");
			// 得到整数形式方法修饰符，使用Modifier进行解码
			System.out.print(Modifier.toString(md[i].getModifiers()) + " ");
			// 得到方法返回类型
			System.out.print(md[i].getGenericReturnType() + " ");
			// 得到方法名
			System.out.print(md[i].getName() + "(");
			// 得到方法参数数组
			Class[] paras = md[i].getParameterTypes();
			for (int j = 0; j < paras.length; j++) {
				System.out.print(paras[j].getSimpleName() + " arg" + j);
				if (j < paras.length - 1) {
					System.out.print(",");
				}
			}
			System.out.print(")");
			// 得到抛出的异常类数组
			Class[] exceps = md[i].getExceptionTypes();
			if (exceps.length > 0) {
				System.out.print("throws");
				for (int k = 0; k < exceps.length; k++) {
					System.out.print(exceps[k].getSimpleName());
					if (k < exceps.length - 1) {
						System.out.print(",");
					}
				}
			}
			System.out.println("{");
			System.out.println("\t\t\\\\方法体");
			System.out.println("\t}");
		}
	}

}
