import static io.restassured.RestAssured.*;

import com.maycur.thirdapitest.front.dto.AuthLoginDto;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import org.testng.annotations.*;
import io.restassured.response.*;
import java.util.Map;

/**
 * Create by HuQiuYue on 2019-04-10
 */

public class TestDemo {

    @Test(groups = {"humuzi"})
    public void getHttpsTest(){
        Response response = given().config((RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation())))
                .params("q","自动化测试","start",0,"count",2)
                .get("https://api.douban.com/v2/book/search");
        response.print();
    }

    //请求的参数除了可以用.params(“key”,"value","key","value"....)把所有参数都放在params()里面，也可以用param("key","value")形式。
    @Test(groups = {"xigua"})
    public void getHttpsTest2(){
        Response response = given().config((RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation())))
                .param("q","全部")
                .param("start",0)
                .param("count",2)
                .get("https://api.douban.com/v2/movie/search");
        response.print();

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        Headers headers = response.getHeaders();
        System.out.println(headers.toString());

        String contentType = response.getContentType();
        System.out.println(contentType);

        System.out.println(headers.hasHeaderWithName("fasdfaf"));

        System.out.println(headers.exist());


        System.out.println(response.getBody().toString());

        Map<String,String> cookies = response.cookies();
        for(String key:cookies.keySet()){
            System.out.println(cookies.get(key));
        }


//        ArrayList<String> subTitles = response.jsonPath().get("movie.name");
//        for(int i = 0;i <subTitles.size();i++)
//            System.out.println(subTitles.get(i));
//
//        String subtitle = response.jsonPath().get("movie.name[0]");
//        System.out.println(subtitle);
//
//
//
//        ArrayList<ArrayList<String>> tagTitles = response.jsonPath().get("movie.name.casts");
//        for(int i = 0;i < tagTitles.size();i++){
//            for(int j = 0; j< tagTitles.get(i).size();j++)
//                System.out.println(tagTitles.get(i).get(j));
//        }

        String title = response.getBody().jsonPath().get("movie.name.findAll{name->name = \"天使之城\"}").toString();
        System.out.println(title);

        String author = response.getBody().jsonPath().get("movie.findAll{it.name == \"天使之城\"}.directors").toString();
        System.out.println(author);

    }

    @Test(groups = {"xigua"})
    public void postTest(){


        Response response = given().accept(ContentType.JSON)
                .body("username=18267148256&password=hqy945688")
                .post("https://passport.baidu.com/v2/api/?login");
        response.print();
    }

    @Test(groups = {"xigua"})
    public void postTest2(){
        Response response = given().contentType("application/x-www-form-urlencoded")
                .param("username","18267148256")
                .param("password","hqy945688")
                .post("https://passport.baidu.com/v2/api/?login");
        response.print();
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

    }

}
