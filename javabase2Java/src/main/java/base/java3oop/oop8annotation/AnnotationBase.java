package base.java3oop.oop8annotation;

/**
 * what:注解就是一种描述数据的数据。也可以说是源代码的元数据
 * jdk自带的注解：
 * @Override 表示覆盖或重写父类的方法；
 * @Deprecated 表示该方法已经过时了。（当方法或是类上面有@Deprecated注解时，
 * 说明该方法或是类都已经过期不能再用，但不影响以前项目使用，提醒你新替代待的
 * 方法或是类。如果程序员不小心使用了它的元素,那么编译器会发出警告信息。）
 * @SuppressWarnings 表示忽略指定警告，比如@Suppvisewarnings("Deprecation")
 * jdk自带四种元注解：@Target、@Retention、@Documented、@Inherited
 * 第三方注解：@Autowired @Service
 * 自定义注解：看作是我们编写的注解，其他的都是他人编写注解
 *
 * 注解的分类：按运行机制（注解存在于程序的那个阶段）将注解分为三类：
 * 源码注解(只在源码存在)、编译注解(在class文件中也存在)、运行时注解(在运行阶段仍然起作用)
 *
 * 解析注解：通过反射获取类、函数或成员上运行时注解信息（值），从而实现动态控制程序运行的逻辑。

 * why:可以代码简洁
 * how:hibernate Table注解的应用
 *
 */
public class AnnotationBase {
    public static void main(String[] args) {
        try {
            Class c=Class.forName("base.java3oop.oop8annotation.User");//使用类加载器加载类
            boolean exists=c.isAnnotationPresent(Table.class);
            if(exists){
                Table t= (Table) c.getAnnotation(Table.class);
                String tableName=t.value();//获取到User上Tablle注解的值
                StringBuilder sql=new StringBuilder();//拼接成一个sql
                sql.append("select * from ").append(tableName).append(";");
                System.out.println(sql.toString());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
