package org.vf.business.file.slice;

enum FileSliceStatus {
    FILE_SLICE_STATUS_NOT_UPLOAD(0),
    FILE_SLICE_STATUS_UPLOADED(1);

    public final int statusValue;

    private FileSliceStatus(int statusValueValue) {
        this.statusValue = statusValueValue;
    }
}

public class FileSlice {
    private int fileSliceID;

    private int fid;

    private String fileSliceMD5;

    private int fileSliceStatus;

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

    public int getFileSliceStatus() {
        return fileSliceStatus;
    }

    public void setFileSliceStatus(int fileSliceStatus) {
        this.fileSliceStatus = fileSliceStatus;
    }

    FileSlice(int fid, String fileSliceMD5) {
        this.fid = fid;
        this.fileSliceMD5 = fileSliceMD5;
        this.fileSliceStatus = FileSliceStatus.FILE_SLICE_STATUS_NOT_UPLOAD.statusValue;
    }
}
