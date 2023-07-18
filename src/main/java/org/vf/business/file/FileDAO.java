package org.vf.business.file;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vf.business.mappers.FileMapper;

import java.util.List;

@Component
public class FileDAO {

    @Autowired
    FileMapper fileMapper;
    File filePrecreate(File file) {
        this.fileMapper.preCreateFile(file, file.getFileName(), file.getFileSize());

        return file;
    }

    void fileCreate(int fid, String md5) {
        this.fileMapper.createFile(fid, md5);
    }

    List<File> getFileList(@Param("uid") int uid) {
        return this.fileMapper.getFileList(uid);
    }
}
