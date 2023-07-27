package org.vf.business.filepart;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file_part")
public class FilePartSliceController {
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String processUpload(@RequestPart("file_part") MultipartFile multipartFile) {
        java.io.File destFile = new java.io.File("/Users/vegetablefriend/Desktop/uploads/" + multipartFile.getOriginalFilename());

        try {
            multipartFile.transferTo(destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Receive Success";
    }
}
