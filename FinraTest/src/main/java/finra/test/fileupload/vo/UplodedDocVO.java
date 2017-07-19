package finra.test.fileupload.vo;

import java.util.Date;

/**
 * @author emily.topka on 7/17/17
 */
public class UplodedDocVO {
    private Long fileId;
    private String categoryId;
    private String fileName;
    private String path;
    private Date fileUploadTime;

    public UplodedDocVO() {}

    public UplodedDocVO(Long fileId, String categoryId, String fileName, String docId, Date fileUploadTime) {
        this.fileId = fileId;
        this.categoryId = categoryId;
        this.fileName = fileName;
        this.path = docId;
        this.fileUploadTime = fileUploadTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Date getUploadTime() {
        return fileUploadTime;
    }

    public void setUploadTime(Date fileUploadTime) {
        this.fileUploadTime = fileUploadTime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

	@Override
	public String toString() {
		return "FileVO [fileId=" + fileId + ", categoryId=" + categoryId + ", fileName=" + fileName + ", path=" + path
				+ ", fileUploadTime=" + fileUploadTime + "]";
	}

   
}
