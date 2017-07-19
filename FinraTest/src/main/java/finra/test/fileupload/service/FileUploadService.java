package finra.test.fileupload.service;

import org.springframework.web.multipart.MultipartFile;

import finra.test.fileupload.vo.UplodedDocVO;

import java.io.IOException;

/**
 * @author emily.topka 7/17/17
 */
public interface FileUploadService {
	
	UplodedDocVO persistFile(MultipartFile file, UplodedDocVO metaData) throws IOException;
}
