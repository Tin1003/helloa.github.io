package vn.techmaster.bai10.service;
import vn.techmaster.bai10.entity.Person;

import vn.techmaster.bai10.exception.StorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;


@Service
public class StoreService {
    @Value("${upload.path}")
    private String path;
        public void uploadFile(MultipartFile file){
            if( file.isEmpty()){
                throw new StorageException(" thất bại lưu vào file tron");
            }
            String filename = file.getOriginalFilename();
            try {
                var is = file.getInputStream();
                Files.copy(is, Paths.get(path + filename), StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException e) {
                var msg = String.format("Failed to store file %s", filename);
                throw new StorageException(msg, e);
            }

        }
        public String getPathName(Optional<Person> person){
            String fileName = null;
            if(person.isPresent()){
                fileName = person.get().getPhoto().getOriginalFilename();
            }
            return fileName;
        }
    
}
