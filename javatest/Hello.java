

import java.util.Arrays;

class Hello {
    public static void main(String[] args) {
        // // 字符串的使用（字符串是不可变的，每次操作实际上都创建了新的字符串，原始字符串并没有改变）
        // String str1 = "abcdefghijklmn"; //声明并赋值
        // System.out.println(str1);
        // String str2 = new String("qwe"); //使用构造函数的方式进行声明赋值
        // System.out.println(str2);

        // 字符串的连接
        String str3 = "abc"+"-"+"efg"+'-'+"hij";
        // System.out.println(str3);
        // // 字符串索引的应用
        // System.out.println(str3.indexOf("ef")); // 返回元素在数组中的索引值
        // System.out.println(str3.indexOf("xxx")); //查不到返回-1

        // 替换子串
        System.out.println(str3.replace("efg", "xyz"));
        // 字符串的分隔与连接
        System.out.println(String.join("~", str3.split("-")));

        // 查看原始字符串
        System.out.println(str3);


        // 如果要修改数组的长度，只能创建新的数组进行保存
        char[] dd = {'a','b','c'};
        char[] ee = Arrays.copyOf(dd, 5); // 复制数组并设置长度
        System.out.println(Arrays.toString(ee));

        // 数组的使用（数组的元素个数在声明后无法修改）
        // int[] aa = {1,2,3}; //数组声明和赋值（简化写法）
        // // int[] aa = new int[]{1,2,3} //完整写法
        // // int[] aa = new int[3] //数组声明但是不赋初始值
        // System.out.println(aa); //直接输出数组会乱码
        // System.out.println(Arrays.toString(aa)); //转为字符串不会乱码（直接写这一行，package会在文件头自动补充，应该是插件的作用）

        // // 数组的索引使用
        // char[] dd = {'a','b','c'};
        // // System.out.println(dd[0]);
        // // System.out.println(dd[1]);

        // // System.out.println(dd.length); // 

        // // 数组的遍历
        // for(int i = 0;i<dd.length;i++){
        //     System.out.println(i);
        //     System.out.println(dd[i]);
        // }

        // // 另一种遍历方法
        // for( char item:dd){
        //     System.out.println(item);
        // }

        // // do while循环语句
        // int i =0;
        // do{
        //     System.out.println(i);
        //     i++;
        // }while (i<10);
        // // while循环语句
        // int i = 0;
        // while(i<10){
        //     System.out.println(i);
        //     i++;
        // }

        // // for循环语句
        // for (int i =0;i<10 ;i++){
        //     System.out.println("?");
        // }
        
        // //switch条件判断
        // int count = 100;
        // switch (count) {
        //     case 1:
        //         System.out.println('-');
        //         break;
        //     case 2:
        //         System.out.println('2');
        //         break;
        //     case 5:
        //         System.out.println('5');
        //         break;
        //     case 10:
        //         System.out.println('十');
        //         break;
        //     default:
        //         System.out.println("错");
        // }

        // //条件判断
        // int count = 100;
        // if (count <=60){
        //     System.out.println("差");
        // }else if(count >=80){
        //     System.out.println('优');
        // } else{
        //     System.out.println("average");
        // }

        // System.out.println("hello world!");
        // System.out.println(10 + 1);
        // System.out.println(10 - 1);
        // System.out.println(10 * 1);
        // System.out.println(10 / 1);
        // System.out.println(10 % 1);
        // System.out.println(10.0 / 3);

        // int num = 10;
        // double num1 = 10.2; // 64位 一边声明一边赋值
        // double num2; //先声明，后赋值
        // num2 = 20.3;

        // final int num3 = 10; //final 边声明边赋值，并且声明后不能被修改
        
        // byte num4 = 100; //8位
        // short num5 = 10000; //16位
        // long num6 = 10000L; // 64位

        // float num7 = 100.3F;

        // char letter = '?';

        // boolean b1 = true;
        // boolean b2 = false;

        // System.out.println(1>2);
        // System.out.println(1<2);
        // System.out.println(10<=2);
        // System.out.println(10>=2);
        // System.out.println(10==2);

        // System.out.println(true&& true);
        // System.out.println(true&& false);
        // System.out.println(false&& true); //dead code
        // System.out.println(false&& false);
        // System.out.println(true|| true);
        // System.out.println(true|| false);
        // System.out.println(false|| true);
        // System.out.println(false|| false);
        // System.out.println(!false );
        // System.out.println(!true );

        // boolean condition = false;
        // System.out.println(condition? 1:2); //三元条件运算符
    }
}