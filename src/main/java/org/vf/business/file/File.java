package org.vf.business.file;

enum FileStatus {
    FILE_STATUS_PRECREATE(0),
    FILE_STATUS_UPLOADING(1),
    FILE_STATUS_CREATED(2);

    public final int statusValue;

    private FileStatus(int statusValue) {
        this.statusValue = statusValue;
    }
};

public class File {
    private int fid;

    private String fileMD5;

    private String fileFirst128BytesMD5;

    private int fileStatus;

    private int fileSize;

    private String fileName;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFileMD5() {
        return fileMD5;
    }

    public void setFileMD5(String fileMD5) {
        this.fileMD5 = fileMD5;
    }

    public int getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(int fileStatus) {
        this.fileStatus = fileStatus;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    File(String fileName, int fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileStatus = FileStatus.FILE_STATUS_PRECREATE.statusValue;
    }
}
