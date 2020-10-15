package base.java3oop.oop1notion.InnerClass;

/**
 * Recompile(ctrl+shift+f9)
 * 编译后的为:Body$Heart.class和Body.class两个字节码文件
 */
public class Body {//外部类

    private String name="外部类成员变量";//外部类的成员变量

    public class Heart{//内部类
        private String name="内部类成员变量";//内部类的成员变量
        public void beat(){//内部类方法
            System.out.println("碰碰跳！");
            System.out.println("我叫"+name);//正确写法，内部访问外部，随意访问
        }
        public void variable(){//内部类的变量访问
            String name="内部类方法局部变量";
            System.out.println(name);//局部变量，就近原则
            System.out.println(this.name);//内部类成员变量
            //System.out.println(super.name);//错误写法，内部类和外部类不是继承关系 内部类的父类是Object
            System.out.println(Body.this.name);//外部类的成员变量
        }
    }


    public void methodBody(){//外部类方法
        System.out.println("外部类方法！");
        new Heart().beat();//匿名对象
    }

    public void partClass(){//外部类的成员方法
        final String name="局部内部类的成员变量";

        class Finger{//局部内部类
            public void partClassMethod(){
                System.out.println(name);
            }
        }

        Finger finger=new Finger();//需要使用局部内部类现在这里创建对象，然后使用
        finger.partClassMethod();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
