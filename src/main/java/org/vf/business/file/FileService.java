package org.vf.business.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileService {
    @Autowired
    FileDAO fileDAO;

    public File filePrecreate(String fileName, int fileSize) {
        File file = new File(fileName, fileSize);
        return this.fileDAO.filePrecreate(file);
    }
}
