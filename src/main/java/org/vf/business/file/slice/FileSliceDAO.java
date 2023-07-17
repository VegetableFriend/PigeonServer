package org.vf.business.file.slice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vf.business.file.File;
import org.vf.business.mappers.FileSliceMapper;

import java.util.List;
@Component
public class FileSliceDAO {

    @Autowired
    FileSliceMapper fileSliceMapper;
    public void createFileSlices(File file, List<FileSlice> sliceList) {
        this.fileSliceMapper.batchInsertSlices(sliceList);
    }
}
