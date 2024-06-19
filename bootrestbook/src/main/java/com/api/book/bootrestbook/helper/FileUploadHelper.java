package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

//	public final String UPLOAD_DIR = "/Users/yunusiqbalsiddique/Documents/springBoot/bootrestbook/src/main/resources/static/image";

//	public final String UPLOAD_DIR=new ClassPathResource("static/image").getFile().getAbsolutePath();
	
	public final String UPLOAD_DIR;
	
	public FileUploadHelper() throws IOException
	{
		File uploadDirResource = new ClassPathResource("static/image").getFile();
        
        // Ensure the directory exists
        if (!uploadDirResource.exists()) {
            uploadDirResource.mkdirs();
        }
        
        // Set the upload directory path
        this.UPLOAD_DIR = uploadDirResource.getAbsolutePath();
	}
	
	public boolean uplaodFile(MultipartFile multiPartFile) {
		boolean f = false;
		try {
//			InputStream is = multiPartFile.getInputStream();
//			byte data[] = new byte[is.available()];
//			is.read(data);
//			
//			//write 
//			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+multiPartFile.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			fos.close();

			Files.copy(multiPartFile.getInputStream(),
					Paths.get(UPLOAD_DIR + File.separator + multiPartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);

			f = true;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
	}
}
