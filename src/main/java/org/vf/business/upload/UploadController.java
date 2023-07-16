package org.vf.business.upload;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController("file")
@CrossOrigin
public class UploadController {
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String processUpload(@RequestPart("file") MultipartFile multipartFile) {
        File destFile = new File("/Users/vegetablefriend/Desktop/uploads/" + multipartFile.getOriginalFilename());

        try {
            multipartFile.transferTo(destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Receive Success";
    }
}