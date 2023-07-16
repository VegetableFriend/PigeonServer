package org.vf.business.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.vf.business.file.File;

public interface FileMapper {
    @Options(useGeneratedKeys = true, keyProperty = "File.fid", keyColumn = "fid")
    @Insert("insert into files(filename, filesize) values(#{fileName}, #{fileSize})")
    void preCreateFile(@Param("File") File file,
                       @Param("fileName") String fileName,
                       @Param("fileSize")int fileSize);
}
