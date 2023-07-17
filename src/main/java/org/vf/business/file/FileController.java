package org.vf.business.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vf.business.file.slice.FileSliceService;

import java.util.List;

@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    FileService fileService;

    @Autowired
    FileSliceService fileSliceService;

    @RequestMapping(value = "/precreate", method = RequestMethod.POST)
    public File filePreCreate(@RequestParam("file_name") String fileName,
                              @RequestParam("file_size") int fileSize,
                              @RequestParam("md5_list") List<String> md5List) {
        File file = this.fileService.filePrecreate(fileName, fileSize);
        this.fileSliceService.createFileSlices(file, md5List);

        return file;
    }

//    @RequestMapping(value = "create", method = RequestMethod.POST)
//    public File fileCreate() {
//
//    }
}
