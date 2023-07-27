package org.vf.business.filepart;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.vf.business.filepart.FileSlice;

import java.util.List;
@Mapper
public interface FileSliceMapper {
    @Insert("<script>" +
            "insert into file_slices(fid, file_slice_md5, file_slice_status) values" +
            "<foreach collection='fileSlices' separator=',' item='fileSlice'>" +
                "(#{fileSlice.fid}, #{fileSlice.fileSliceMD5}, #{fileSlice.fileSliceStatus})" +
            "</foreach>" +
            "</script>")
    void batchInsertSlices(@Param("fileSlices") List<FileSlice> fileSlices);
}
