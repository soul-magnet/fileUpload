package finra.test.fileupload.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import finra.test.fileupload.domain.MetadataFileBase;


/**
 * @author emily.topka on 7/17/17
 */
@Repository
public interface FileBaseDAO extends JpaRepository<MetadataFileBase,Long>{

}
