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
    public File filePreCreate(@CookieValue("JSESSIONID") String sessionID,
                              @RequestParam("file_name") String fileName,
                              @RequestParam("file_size") int fileSize,
                              @RequestParam("file_md5") String md5,
                              @RequestParam("file_slice_md5_list") List<String> md5List) {
        File file = this.fileService.filePrecreate(fileName, fileSize);
        this.fileSliceService.createFileSlices(file, md5List);

        return file;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void fileCreate(@RequestParam("fid") int fid,
                           @RequestParam("file_md5") String md5) {
        this.fileService.fileCreate(fid, md5);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<File> getFileList(int uid) {
        return this.fileService.getFileList(uid);
    }
}
