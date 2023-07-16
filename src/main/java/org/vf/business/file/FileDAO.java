package org.vf.business.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vf.business.mappers.FileMapper;

@Component
public class FileDAO {

    @Autowired
    FileMapper fileMapper;
    File filePrecreate(File file) {
        this.fileMapper.preCreateFile(file, file.getFileName(), file.getFileSize());

        return file;
    }
}
