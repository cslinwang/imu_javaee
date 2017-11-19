package web2017.team4.wanglin.Ref;

import java.io.*;

public class ClassAnalyzer {
	public static StringBuffer sb = new StringBuffer();
	public static byte[] analyzeConstant_tag;
	public static String[] analyzeConstant_utf8;
	public static DataOutputStream dataout;

	public static void main(String[] args) {
		DataInputStream input = null;
		try {
			FileOutputStream out = new FileOutputStream(
					"");
			BufferedOutputStream buffout = new BufferedOutputStream(out);
			dataout = new DataOutputStream(buffout);

			input = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream(
									"F:\\SoftWare\\Program\\Pro-Sw\\Note++\\WorkSpace\\practice\\HelloWorld.class")));
			// 获取文件大小
			FileSize(new DataInputStream(
					new BufferedInputStream(
							new FileInputStream(
									"F:\\SoftWare\\Program\\Pro-Sw\\Note++\\WorkSpace\\practice\\HelloWorld.class"))));
			// 解析数据
			analyze(input);
		} catch (Exception e) {
			System.out.println("解析失败！");
		} finally {
			try {
				input.close();
				dataout.close();
			} catch (Exception e) {
			}
		}
	}

	public static void FileSize(DataInputStream input) throws IOException {
		int length = 0; // 长度，字节，B
		double kblength = 0.0D; // 长度，千字节，KB
		while (input.read() != -1)
			++length;
		kblength = length / 1024.0D;
		System.out.println("文件大小（字节）：" + length + "\n文件大小（KB）：" + kblength);
		input.close();
	}

	public static void analyze(DataInputStream input) throws IOException {
		// 读取幻数
		int magic = u4(input);
		if (magic == 0xCAFEBABE) // -889275714
			System.out.println("magic number = 0xCAFEBABE -----标准class文件");
		else {
			throw new RuntimeException("无效的幻数！");
		}
		// 读取副、主版本号
		int minor_ver = u2(input);
		int major_ver = u2(input);
		System.out.println("Version = " + major_ver + "." + minor_ver);
		add("    常规信息    ");
		add("Minor version:    " + minor_ver);
		add("Major version:    " + major_ver);
		// 读取常量池表中表项的个数
		short const_pool_count = u2(input);
		System.out.println("constant pool size = " + const_pool_count);
		add("Constant pool count:    " + const_pool_count);
		// 读取每个常量
		analyzeConstant_tag = new byte[const_pool_count]; // 存储常量数据类型
		analyzeConstant_tag[0] = 0; // 系统保留，class中不存在
		for (int i = 1; i < const_pool_count; ++i)
			analyzeConstant(input, i); // 分析常数
		jiexitmp(); // 解析tmp文件
		// 读取Class的声明中使用的修饰符掩码并解析
		short access_flags = u2(input);
		System.out.print("access_flags = " + access_flags);
		String access_flags_16 = "0x" + Integer.toHexString(access_flags);
		int[] access = { 0x0001, 0x0010, 0x0020, 0x0200, 0x0400 };
		String[] access_str = { "public", "final", "", "interface", "abstract" }; // NO.2--super
		String access_tmp = "";
		for (int i = 0; i < access.length; i++) {
			if ((access_flags & access[i]) == access[i]) {
				if (i == 0)
					access_tmp += access_str[i];
				else if (i != 2)
					access_tmp += " " + access_str[i];
			}
		}
		System.out.println(" [" + access_tmp + " ]");
		add("Access flags:    " + access_flags_16 + " [" + access_tmp + " ]");
		// 读取类或者接口的全限定名称
		short this_class_index = u2(input);
		short super_class_index = u2(input);
		System.out.println("This class = " + this_class_index);
		System.out.println("Super class = " + super_class_index);
		add("This class:    " + this_class_index);
		add("Super class:    " + super_class_index);
		// read interfaces count:
		short interfaces_count = u2(input);
		System.out.println("超接口个数 = " + interfaces_count);
		add("Interfaces count:    " + interfaces_count);
		// read each interface:
		for (int i = 1; i <= interfaces_count; i++) {
			short interface_index = u2(input);
			System.out.println("No. " + i + " interface index = "
					+ interface_index);
		}
	}

	public static byte u1(DataInputStream input) throws IOException {
		return input.readByte();
	}

	public static Short u2(DataInputStream input) throws IOException {
		return input.readShort();
	}

	public static int u4(DataInputStream input) throws IOException {
		return input.readInt();
	}

	public static long u8(DataInputStream input) throws IOException {
		return input.readLong();
	}

	public static void add(String str) throws IOException {
		sb.append(str + "\n");
	}

	public static void analyzeConstant(DataInputStream input, int index)
			throws IOException {
		// 用于读：
		byte n8;
		short n16;
		int n32;
		long n64;
		float f;
		double d;
		byte[] buffer;
		byte tag = input.readByte(); // 读取数据类型标签
		analyzeConstant_tag[index] = tag; // 存储常量数据类型
		System.out.println("\n常量索引 = " + index + ", 数据类型标签 = " + (int) tag);
		switch (tag) {
		case 1: // utf-8 string
			System.out.println(" 常量类型 = Utf8 //Utf8存储格式"); // Utf8存储格式
			n16 = u2(input);
			System.out.println("     length = " + n16);
			dataout.writeShort(n16);
			buffer = new byte[n16];
			input.readFully(buffer); // 数组读满才返回
			System.out.println("      value = " + new String(buffer));
			dataout.writeUTF(new String(buffer));
			break;
		case 3: // integer
			System.out.println(" 常量类型 = Integer //Integer存储格式"); // Integer存储格式
			n32 = u4(input);
			System.out.println("      value = " + n32);
			dataout.writeInt(n32);
			break;
		case 4: // float
			System.out.println(" 常量类型 = Float //Float存储格式"); // Float存储格式
			f = u4(input);// input.readFloat();
			System.out.println("      value = " + f);
			dataout.writeFloat(f);
			break;
		case 5: // long
			System.out.println(" 常量类型 = Long //Long存储格式"); // Long存储格式
			n64 = u8(input);
			System.out.println("      value = " + n64);
			dataout.writeLong(n64);
			break;
		case 6: // double
			System.out.println(" 常量类型 = Double //Double存储格式"); // Double存储格式
			d = u8(input);
			System.out.println("      value = " + d);
			dataout.writeDouble(d);
			break;
		case 7: // class or interface reference
			System.out.println(" 常量类型 = Class //类索引"); // 类索引
			n16 = u2(input);
			System.out.println("      index = " + n16 + " （在哪里可以找到类名）");
			dataout.writeShort(n16);
			break;
		case 8: // string
			System.out.println(" 常量类型 = String //字符串索引"); // 字符串索引
			n16 = u2(input);
			System.out.println("      index = " + n16);
			dataout.writeShort(n16);
			break;
		case 9: // field reference
			System.out.println(" 常量类型 = Fieldref //领域参数"); // 领域参数
			n16 = u2(input);
			System.out.println("class index = " + n16 + " （在哪里可以找到类名）");
			dataout.writeShort(n16);
			n16 = u2(input);
			System.out.println("nameAndType = " + n16 + " （在哪里可以找到的名称和类型）");
			dataout.writeShort(n16);
			break;
		case 10: // method reference
			System.out.println(" 常量类型 = Methodref //方法参考"); // 方法参考
			n16 = u2(input);
			System.out.println("class index = " + n16 + " （在哪里可以找到类）");
			dataout.writeShort(n16);
			n16 = u2(input);
			System.out.println("nameAndType = " + n16 + " （在哪里可以找到名称和类型）");
			dataout.writeShort(n16);
			break;
		case 11: // interface method reference
			System.out.println(" 常量类型 = InterfaceMethodref //接口方法参考值"); // 接口方法参考值
			n16 = u2(input);
			System.out.println("class index = " + n16 + " （在哪里可以找到接口）");
			dataout.writeShort(n16);
			n16 = u2(input);
			System.out.println("nameAndType = " + n16 + " （在哪里可以找到名称和类型）");
			dataout.writeShort(n16);
			break;
		case 12: // name and type reference
			System.out.println(" 常量类型 = NameAndType //名称和类型"); // 名称和类型
			n16 = u2(input);
			System.out.println(" name index = " + n16 + " （在哪里可以找到这个名字）");
			dataout.writeShort(n16);
			n16 = u2(input);
			System.out.println(" descripter = " + n16 + " （在哪里可以找到描述符）");
			dataout.writeShort(n16);
			break;
		default:
			throw new RuntimeException("Invalid constant pool flag: " + tag);
		} // end switch
	}

	public static void jiexitmp() {
		DataInputStream input = null;
		try {
			input = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream(
									"C:\\Documents and Settings\\Administrator\\桌面\\解析class文件\\ReadClass.tmp")));
			/********** analyzeConstant_tag[]存储常量池表中常量数据类型(共11种) **********/
			int[] tagSpecies = new int[11]; // 存储常量池表中常量各种数据类型的计数
			int const_pool_count = analyzeConstant_tag.length; // 读取常量池表中表项的个数
			for (int i = 0; i < const_pool_count; i++) // 对数据类型的计数数组进行赋值
			{
				System.out.println(analyzeConstant_tag[i]); // 按顺序输出各种数据的类型
				switch (analyzeConstant_tag[i]) {
				case 1:
					++tagSpecies[0];
					break;
				case 3:
					++tagSpecies[1];
					break;
				case 4:
					++tagSpecies[2];
					break;
				case 5:
					++tagSpecies[3];
					break;
				case 6:
					++tagSpecies[4];
					break;
				case 7:
					++tagSpecies[5];
					break;
				case 8:
					++tagSpecies[6];
					break;
				case 9:
					++tagSpecies[7];
					break;
				case 10:
					++tagSpecies[8];
					break;
				case 11:
					++tagSpecies[9];
					break;
				case 12:
					++tagSpecies[10];
					break;
				}
			}
			for (int i = 0; i < tagSpecies.length; i++)
				System.out.println("数量" + tagSpecies[i]);/*
														 * analyzeConstant_utf8
														 * = new String[
														 * analyzeConstant_utf8_num
														 * ]; int j = 0; for(int
														 * i
														 * =0;i<const_pool_count
														 * ;i++)
														 * if(analyzeConstant_tag
														 * [i]==1)
														 * analyzeConstant_utf8
														 * [j++] = "r"; for(int
														 * i
														 * =0;i<analyzeConstant_utf8
														 * .length;i++)
														 * System.out
														 * .println("NO."+i+" "+
														 * analyzeConstant_utf8
														 * [i]);
														 */
		} catch (Exception e) {
			System.out.println("解析失败！");
		} finally {
			try {
				input.close();
			} catch (Exception e) {
			}
		}
	}

} // End