package base.java3oop.oop9newFeatures.json;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * what:json使用工具Gson
 * https://github.com/google/gson
 * why:功能更加强大,性能更加出色,使用方式更加便捷和简单
 * JSON是Android SDK官方的库
 * GSON适用于服务端开发
 * GSON比JSON功能更强大
 * how:生成json、读取json将、将json转换成bean
 */
public class ToolGson {
    public static void main(String[] args) throws IOException {
        buildJsonByGsonBean();
        useGson();
    }

    private static void buildJsonByGsonBean() {
        User user = new User();
        user.setName("王小二");
        user.setAge(22);
        user.setBirthday("1990-12-1");
        user.setSchool("蓝翔");
        user.setMajor(new String[]{"理发", "挖掘机"});
        user.setHas_girlfriend(false);
        user.setCar(null);
        user.setHouse(null);
        user.setCommont("这是一个注释:注意:json中没有注释的写法,但是我们可以曲线救国");

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();// 对JSON结果格式化，json格式输出
        // 自定义转换策略  和注解@SerializedName的功能一样但是注解的优先级高
        gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field f) {
                if(f.getName().equals("name")){
                    return "NAME";
                }
                return f.getName();
            }
        });
        // 生成json
        Gson gson = gsonBuilder.create();
        System.out.println(gson.toJson(user));

        //直接生成json
        Gson gson1=new Gson();
        System.out.println(gson1.toJson(user));
    }

    private static void useGson() throws IOException {
        File file = new File(JsonBase.class.getResource("\\base\\java3oop\\oop9newFeatures\\json\\wangxiaoer.json").getFile());
        String content = FileUtils.readFileToString(file, "UTF-8");
        // 无日期转换
        Gson gson = new Gson();
        User user = gson.fromJson(content,User.class);//直接转换成javaBean
        System.out.println(user.toString());
        // 带日期转换
        Gson gson2 = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();//日期是常见格式
        UserDate user2 = gson2.fromJson(content,UserDate.class);
        System.out.println(user2.getBirthday().toString());
        // 集合类解析
        System.out.println(user2.getMajor());//获取到集合
        System.out.println(user2.getMajor().getClass());

    }
}
