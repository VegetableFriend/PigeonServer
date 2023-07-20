package org.vf.business.mappers.file;

import org.apache.ibatis.annotations.*;
import org.vf.business.file.File;

import java.util.List;

public interface FileMapper {
    @Options(useGeneratedKeys = true, keyProperty = "File.fid", keyColumn = "fid")
    @Insert("insert into files(filename, filesize) values(#{fileName}, #{fileSize})")
    void preCreateFile(@Param("File") File file,
                       @Param("fileName") String fileName,
                       @Param("fileSize")int fileSize);

    @Update("update files set file_status=2 where fid=#{fid}, file_md5=#{md5}")
    void createFile(@Param("fid") int fid,
                    @Param("file_md5") String md5);

    @Select("select f.fid, f.file_md5, f.file_first_128bytes_md5, f.file_status, f.filename, f.filesize from user_files r join files f using(fid) where r.uid = #{uid}")
    List<File> getFileList(@Param("uid") int uid);
}
