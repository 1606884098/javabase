package base.java1dataType;

import java.math.BigDecimal;

public class DataType {
    public static void main(String[] args) {
        /**
         * 二进制数的一位包含的信息或2个选项中特别指定1个的需要信息量称为一比特，
         * 是表示信息的最小单位，只有两种状态：0和1。1位即1bit 只能表示 0或1 （二进制存储）.一个字节(byte)为8个比特，
         * 一个英文字母通常占用一个字节，一个汉字通常占用两个字节。
         *
         * 1.基本数据类型
         *  1.1整数型
         *      byte 1b 8bit -128 ~ 127 默认值0
         *      Short 2b 16bit -32768 ~ 32678 默认值0
         *      Int 4b 32bit  -2,147,483,648 ~ 2,147,483,647 默认值0
         *      long 8bit 64bit  -9,223,372,036,854,775,808~+9,223,372,036,854,775,807 默认值0L
         *  1.2浮点型
         *      float 4b 32bit  -3,40292347E+38 ~ +3,40292347E+38 默认值0
         *      double 8b 64bit -1.79769313486231576E+308 ~ 1.79769313486231576E+308 默认值0
         *  1.3布尔类型
         *      boolean 1b 8bit true/false 默认值false
         *  1.4字符
         *      char 2b 16bit 默认值为空 /u0000 是一个空的字符，它与null和""不同，是特殊的“空”
         *
         */
       //Integer integer=null;
       //Integer a=integer+12;//报空指针异常 所以定义包装类型时 建议默认值 包括数据的字段也建议默认值

        Long a1=12320l;
        //Long a4=null;

        Double a3=(double)a1;
       // Double a5=(double)a4;
        Double a2=(double)(a1/(double)100);
        System.out.println(a2);

        Long s=13240l;
        String aaa= BigDecimal.valueOf(s).divide(new BigDecimal(100)).toPlainString()+"%";
        System.out.println(aaa);

        String rate="33333333333.3330000";
        Double rateDouble=Double.valueOf(rate)*100;//这里剩100 不要到BigDecimal那边乘100
        System.out.println(rateDouble);


        String rateBig= BigDecimal.valueOf(rateDouble).divide(new BigDecimal(100)).toPlainString()+"%";
        System.out.println(rateBig);

        String rateBig1= BigDecimal.valueOf(rateDouble).toPlainString()+"%";
        System.out.println(rateBig1);


        Double rateBig2=Double.parseDouble(rate);
        String rateBig3= BigDecimal.valueOf(rateBig2).toPlainString()+"%";
        System.out.println(rateBig3);
    }
}
