package com.needtostudy.gongzza;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Controller
public class MainController {

    @Autowired
    private String imageDirectoryPath;

    @GetMapping("")
    private String main() throws Exception {
        return "index";
    }

    @GetMapping("images")
    @ResponseBody
    public byte[] getImage(@RequestParam String fileName, HttpServletRequest request) throws Exception {
        File file = new File(request.getSession().getServletContext().getRealPath(imageDirectoryPath) + File.separator + fileName);
        InputStream is = new FileInputStream(file);
        return IOUtils.toByteArray(is);
    }

    @PostMapping("images")
    @ResponseBody
    public ResponseEntity<String> setImage(@RequestParam String fileName, @RequestParam MultipartFile imageFile, HttpServletRequest request) throws Exception {
        if (imageFile == null)
            return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);

        FileManager.changeImage(imageFile, request.getSession().getServletContext().getRealPath(imageDirectoryPath) + File.separator + fileName);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }
}
