package finra.test.fileupload.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import finra.test.fileupload.service.FileUploadService;
import finra.test.fileupload.vo.UplodedDocVO;

import java.io.IOException;
import java.util.Date;


/**
 * @author emily.topka on 7/17/17.
 */
@RestController
public class FileUploadController {

    private static final Logger LOG = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping(value = "/file",produces = "application/json")
    public UplodedDocVO uploadFile(@RequestParam MultipartFile file, @RequestParam String categoryId) throws IOException{
        UplodedDocVO metaData = new UplodedDocVO();
        metaData.setUploadTime(new Date());
        metaData.setCategoryId(categoryId);
        LOG.info(metaData.toString());
        return fileUploadService.persistFile(file,metaData);
    }
}
