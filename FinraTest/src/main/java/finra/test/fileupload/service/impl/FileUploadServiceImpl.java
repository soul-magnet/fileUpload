package finra.test.fileupload.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import finra.test.fileupload.dao.FileBaseDAO;
import finra.test.fileupload.domain.MetadataFileBase;
import finra.test.fileupload.service.FileUploadService;
import finra.test.fileupload.vo.UplodedDocVO;

/**
 * @author emily.topka on 7/17/17
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

	private static final Logger LOG = LoggerFactory.getLogger(FileUploadServiceImpl.class);

	@Autowired
	private FileBaseDAO fileRepo;

	@Override
	@Transactional
	public UplodedDocVO persistFile(MultipartFile file, UplodedDocVO metaData) throws IOException {
		
		MetadataFileBase documentData = new MetadataFileBase();
		String path = saveFileToPath(file.getBytes(), file.getOriginalFilename());

		documentData.setUploadTime(metaData.getUploadTime());
		documentData.setCategoryId(metaData.getCategoryId());
		documentData.setFileName(file.getOriginalFilename());
		documentData.setPath(path);
		MetadataFileBase savedDocumentData = fileRepo.save(documentData);
		metaData.setFileId(savedDocumentData.getId());
		metaData.setFileName(file.getOriginalFilename());
		metaData.setPath(documentData.getPath());

		LOG.info("path: " + path);
		return metaData;
	}

	private String saveFileToPath(byte[] file, String fileName) throws IOException {

		File dir = new File("EmilyTempFile");
		if (!dir.exists())
			dir.mkdirs();

		// Create the file on server
		File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
		stream.write(file);
		stream.close();

		return serverFile.getAbsolutePath();
	}
}
