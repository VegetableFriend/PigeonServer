package org.vf.business.filepart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vf.business.file.File;

import java.util.ArrayList;
import java.util.List;
@Component
public class FileSliceService {
    @Autowired
    FileSliceDAO fileSliceDAO;

    public void createFileSlices(File file, List<String> md5List) {
        List<FileSlice> fileSlices = this.generateFileSlices(file, md5List);
        this.fileSliceDAO.createFileSlices(file, fileSlices);
    }

    private List<FileSlice> generateFileSlices(File file, List<String> md5List) {
        ArrayList<FileSlice> fileSlices = new ArrayList<>(md5List.size());
        for (String md5 : md5List) {
            FileSlice fileSlice = new FileSlice(file.getFid(), md5);
            fileSlices.add(fileSlice);
        }

        return fileSlices;
    }
}
