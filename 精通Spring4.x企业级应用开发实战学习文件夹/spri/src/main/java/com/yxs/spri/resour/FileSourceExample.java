package com.yxs.spri.resour;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @ProjectName: spri
 * @Package: com.yxs.spri.resour
 * @ClassName: FileSourceExample
 * @Author: yuxingsheng
 * @Description: Spring访问文件资源样例
 * 1、PathResource: Spring4.0提供的读取资源文件的新类。使用系统文件路径加载方式加载文件
 * 2、ClassPathResource 使用类路径方式加载文件
 * 3、使用writableResource接口写资源文件 getOutputStream
 * 4、使用Resource接口读取资源文件 getInputStream
 * @Date: 2020/8/27 19:00
 * @Version: 1.0
 */
public class FileSourceExample {
    public static void main(String[] args) throws IOException {
        String filePath="F:\\Program Files (x86)\\Spring\\精通Spring4.x企业级应用开发实战学习文件夹\\spri\\src\\main\\resources\\conf\\file1.txt";
        //使用系统文件路径方式加载文件
        WritableResource res1=new PathResource(filePath);
        //使用类路径方式加载文件
        Resource res2=new ClassPathResource("conf/file1.txt");

        //使用WritableResource接口写文件资源
       OutputStream stream1= res1.getOutputStream();
       stream1.write("欢迎来到Spring读取文件方式".getBytes());
       stream1.close();
       //使用Resource接口读取资源文件
        InputStream ina1=res1.getInputStream();
        InputStream ina2=res2.getInputStream();

      ByteArrayOutputStream baos= new ByteArrayOutputStream();
      int i;
      while((i=ina1.read())!=-1){
          baos.write(i);
      }
      System.out.println(baos.toString());
      System.out.println("res1:"+res1.getFilename());
      System.out.println("res2:"+res2.getFilename());
      //对文件采用特定编码方式访问
      String s=printFile("conf/file1.txt");
      System.out.println(s);
    }
    private static String printFile(String filePath) throws IOException{
        Resource res=new ClassPathResource(filePath);
        EncodedResource encRes=new EncodedResource(res,"UTF-8");
        return FileCopyUtils.copyToString(encRes.getReader());
    }
}
