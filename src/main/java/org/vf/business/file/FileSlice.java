package org.vf.business.file;

enum FileSliceStatus {
    FILE_SLICE_STATUS_NOT_UPLOAD,
    FILE_SLICE_STATUS_UPLOADED
}

public class FileSlice {
    private int fileSliceID;

    private int fid;

    private String fileSliceMD5;

    private FileSliceStatus fileSliceStatus;

    public int getFileSliceID() {
        return fileSliceID;
    }

    public void setFileSliceID(int fileSliceID) {
        this.fileSliceID = fileSliceID;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFileSliceMD5() {
        return fileSliceMD5;
    }

    public void setFileSliceMD5(String fileSliceMD5) {
        this.fileSliceMD5 = fileSliceMD5;
    }

    public FileSliceStatus getFileSliceStatus() {
        return fileSliceStatus;
    }

    public void setFileSliceStatus(FileSliceStatus fileSliceStatus) {
        this.fileSliceStatus = fileSliceStatus;
    }
}
