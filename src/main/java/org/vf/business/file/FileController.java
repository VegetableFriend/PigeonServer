package org.vf.business.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vf.business.file.slice.FileSliceService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    FileService fileService;

    @Autowired
    FileSliceService fileSliceService;

    @RequestMapping(value = "/precreate", method = RequestMethod.POST)
    public File filePreCreate(@RequestParam Map<String, Object> allParams) {
        String fileName = (String)allParams.get("file_name");
        int fileSize = (Integer)allParams.get("file_size");
        List md5List = (List)allParams.get("md5_list");

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
