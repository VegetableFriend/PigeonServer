package org.vf.business.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FileService {
    @Autowired
    FileDAO fileDAO;

    public File filePrecreate(String fileName, int fileSize) {
        File file = new File(fileName, fileSize);
        return this.fileDAO.filePrecreate(file);
    }

    public void fileCreate(int fid, String md5) {
        this.fileDAO.fileCreate(fid, md5);
    }

    public List<File> getFileList(int uid) {
        return this.fileDAO.getFileList(uid);
    }
}
