package org.vf.business.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("file")
public class FileController {

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/precreare", method = RequestMethod.POST)
    public File filePreCreate(@RequestPart("fileName") String fileName,
                              @RequestPart("fileSize") int fileSize) {
        return this.fileService.filePrecreate(fileName, fileSize);
    }
}
