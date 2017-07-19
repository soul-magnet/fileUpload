package finra.test.fileupload.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author emily.topka on 7/17/17
 */
@Entity
@Table(name="file")
public class MetadataFileBase {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String categoryId;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String path;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryId() {
		return categoryId;
	}

	public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}


}
