package com.green.bookshop3.common.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import net.coobird.thumbnailator.Thumbnails;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;


@Controller
public class FileDownloadController {

//    private static String CURR_IMAGE_REPO_PATH = "/home/ec2-user/shopping/file_repo";
private static String CURR_IMAGE_REPO_PATH = "C:/shopping/file_repo";
    @RequestMapping("/download")
    @SuppressWarnings(value = "warn")
    protected void download(@RequestParam("fileName") String fileName,
                            @RequestParam("goods_id") String goods_id,
                            HttpServletResponse response) throws Exception {

        OutputStream out = response.getOutputStream();


        String encodedfileName = new String(fileName.getBytes(), "UTF-8");
        String filePath=CURR_IMAGE_REPO_PATH+"/"+goods_id+"/"+encodedfileName;

        System.out.println("filePath : " +filePath);
        File image=new File(filePath);

        response.setHeader("Cache-Control","no-cache");
        response.addHeader("Content-disposition", "attachment; fileName="+encodedfileName);
        FileInputStream in=new FileInputStream(image);
        byte[] buffer=new byte[1024*8];

        try{
            while(true){
                int count=in.read(buffer); //버퍼에 읽어들인 문자개수
                if(count==-1)  //버퍼의 마지막에 도달했는지 체크
                    break;
                out.write(buffer,0,count);
            }
        }catch (Exception e){
            System.out.println("유니코드 문자 관련 예외이나 실행에는 지장없음, 향후 처리 예정");
        }


        in.close();
        out.close();
    }


    @RequestMapping("/thumbnails.do")
    @SuppressWarnings(value = "warn")
    protected void thumbnails(@RequestParam("fileName") String fileName,
                              @RequestParam("goods_id") String goods_id,
                              HttpServletResponse response) throws Exception {


        OutputStream out = response.getOutputStream();

        String encodedfileName = new String(fileName.getBytes(), "UTF-8");
        String filePath=CURR_IMAGE_REPO_PATH+"/"+goods_id+"/"+encodedfileName;

       // String filePath=CURR_IMAGE_REPO_PATH+"/"+goods_id+"/"+fileName;
        //System.out.println("filePath : " +filePath);

        File image=new File(filePath);


        try{
            if (image.exists()) {
                Thumbnails.of(image).size(121,154).outputFormat("png").toOutputStream(out);
            }
            byte[] buffer = new byte[1024 * 8];
            out.write(buffer);
        }catch (Exception e){
            System.out.println("유니코드 문자 관련 예외이나 실행에는 지장없음, 향후 처리 예정");
        }






        out.close();


    }





}
