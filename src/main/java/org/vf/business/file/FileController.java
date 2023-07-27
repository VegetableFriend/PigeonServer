package org.vf.business.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.vf.business.filepart.FileSliceService;

import java.io.IOException;
import java.net.MalformedURLException;
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

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public Resource processUpload(@RequestPart("filepath") String filePath) {
        java.io.File destFile = new java.io.File(filePath);

        try {
            return new UrlResource(destFile.toURI());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<File> getFileList(int uid) {
        return this.fileService.getFileList(uid);
    }
}
