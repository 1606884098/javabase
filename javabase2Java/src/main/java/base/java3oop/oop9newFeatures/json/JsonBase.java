package base.java3oop.oop9newFeatures.json;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * what:Json是一种与开发语言无关的，轻量级的数据格式。全称：javaScript Object Notation
 * 数据结构：
 * Object
 * Array
 * 基本类型：string number true false null
 * why:易读易写，易解析易生产
 */
public class JsonBase {
    public static void main(String[] args) throws IOException {
        jsonObject();
        buildJsonByMap();
        buildJsonByBean();

        readJsonFromFile();
    }
/*    {
            "name" :"王小二",
            "age": 22,
            "birthday" : "1990-12-1",
            "commont":"//注意:json里没有Date这种时间的类型,所以用string;需要了解一下时间戳",
            "school" : "蓝翔",
            "major": ["理发","挖掘机"],
            "has_girlfriend":false,
            "car": null,
            "house": null,
            "commont": "这是一个注释:注意:json中没有注释的写法,但是我们可以曲线救国"
    }*/

    private static void jsonObject() {
        JSONObject wangxiaoer = new JSONObject();
        Object nullObject = null;// 使用nullObject跳过编译器检查
        wangxiaoer.put("name", "王小二");
        wangxiaoer.put("age", 22);
        wangxiaoer.put("birthday", "1990-12-1");
        //wangxiaoer.put("commont","//注意:json里没有Date这种时间的类型,所以用string;需要了解一下时间戳");
        wangxiaoer.put("school", "蓝翔");
        wangxiaoer.put("major", new String[]{"理发", "挖掘机"});
        wangxiaoer.put("has_girlfriend", new String[]{"理发", "挖掘机"});
        wangxiaoer.put("has_girlfriend", false);
        wangxiaoer.put("car", nullObject);
        wangxiaoer.put("house", nullObject);
        wangxiaoer.put("commont", "这是一个注释:注意:json中没有注释的写法,但是我们可以曲线救国");
        System.out.println(wangxiaoer.toString());
    }

    private static void buildJsonByMap() {
        Map<String, Object> wangxiaoer = new HashMap<String, Object>();
        Object nullObject = null;// 使用nullObject跳过编译器检查
        wangxiaoer.put("name", "王小二");
        wangxiaoer.put("age", 22);
        wangxiaoer.put("birthday", "1990-12-1");
        //wangxiaoer.put("commont","//注意:json里没有Date这种时间的类型,所以用string;需要了解一下时间戳");
        wangxiaoer.put("school", "蓝翔");
        wangxiaoer.put("major", new String[]{"理发", "挖掘机"});
        wangxiaoer.put("has_girlfriend", false);
        wangxiaoer.put("car", nullObject);
        wangxiaoer.put("house", nullObject);
        wangxiaoer.put("commont", "这是一个注释:注意:json中没有注释的写法,但是我们可以曲线救国");
        System.out.println(new JSONObject(wangxiaoer));//将map以参数的方式传入 进行构造
    }

    private static void buildJsonByBean() {//推荐使用这种方式来构建json应为javaBean可以重复使用
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
        System.out.println(new JSONObject(user));//将对象user以参数的方式传入 进行构造
    }

    private static void readJsonFromFile() throws IOException {
        File file = new File(JsonBase.class.getResource("\\base\\java3oop\\oop9newFeatures\\json\\wangxiaoer.json").getFile());
        String content = FileUtils.readFileToString(file, "UTF-8");
        JSONObject jsonObject = new JSONObject(content);

        System.out.println("姓名：" + jsonObject.getString("name"));
        System.out.println("年龄：" + jsonObject.getDouble("age"));
        System.out.println("有没有女朋友？：" + jsonObject.getBoolean("has_girlfriend"));

        JSONArray majorArray = jsonObject.getJSONArray("major");//json数组的操作
        for (int i = 0; i < majorArray.length(); i++) {
            System.out.println("专业" + (i + 1) + "：" + majorArray.get(i));
        }

        // 判断属性的值是否为空
        if (!jsonObject.isNull("nickname")) {
            System.out.println("昵称：" + jsonObject.getDouble("nickname"));
        }
    }
}
