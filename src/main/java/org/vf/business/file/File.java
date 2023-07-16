package org.vf.business.file;

enum FileStatus {
    FILE_STATUS_PRECREATE,
    FILE_STATUS_UPLOADING,
    FILE_STATUS_CREATED
};

public class File {
    private int fid;

    private String fileMD5;

    private String fileFirst128BytesMD5;

    private FileStatus fileStatus;

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

    public FileStatus getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(FileStatus fileStatus) {
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
    }
}
