
package com.project.lighteningmarket.commons.images.controller;

import com.project.lighteningmarket.commons.images.domain.ImageDTO;
import com.project.lighteningmarket.commons.images.persistence.ImageDAO;
import com.project.lighteningmarket.commons.images.service.ImageService;
import com.project.lighteningmarket.commons.upload.controller.UploadController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageDAO imageDAO;

    // 일반적인 매핑
    @RequestMapping(value="/product/productRegister", method=RequestMethod.GET)
    public void uploadForm(){

    }

    // 이미지 저장(text)
    @RequestMapping(value="/saveImage", method=RequestMethod.POST)
    public String saveImage(ImageDTO imageDTO) {
        try {
            Map<String, Object> hmap = new HashMap<String, Object>();
            hmap.put("img", imageDTO.getImgFile().getBytes());
            imageService.saveImage(hmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/product/productRegister";
    }

    // 이미지 불러오기
    @RequestMapping(value="/viewImage", method=RequestMethod.GET)
    public String loadImage() throws Exception {

        String A = imageService.loadImage();
        System.out.println(A);
        return "redirect:/product/productRegister";
    }


    /**
     * 이미지태그의 src 컨트롤러
     * @return
     */
    @RequestMapping(value="/getByteImage")
    public ResponseEntity<byte[]> getByteImage(){
        Map<String, Object> map = null;
        try {
            map = imageDAO.getByteImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] imageContent = (byte[]) map.get("img");
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }

    // image test
    public static byte[] imageToByteArray (String filePath) throws Exception
    {
        byte[] returnValue = null;

        ByteArrayOutputStream baos = null;
        FileInputStream fis = null;

        try
        {
            baos = new ByteArrayOutputStream();
            fis  = new FileInputStream(filePath);

            byte[] buf = new byte[1024];
            int read = 0;

            while ((read=fis.read(buf, 0, buf.length)) != -1)
            {
                baos.write(buf, 0, read);
            }

            returnValue = baos.toByteArray();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (baos != null)
            {
                baos.close();
            }
            if (fis != null)
            {
                fis.close();
            }
        }
        return returnValue;
    }

}

