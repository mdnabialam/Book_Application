package com.book.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	public final String PATH_DIR="N:\\Program By MD NABI ALAM\\All_Project\\BookApplication\\src\\main\\resources\\static\\image";

	public boolean uploadFile(MultipartFile multipartFile) {
		
		boolean f= false;
		
		try {
			/*
			// read File
			InputStream is= multipartFile.getInputStream();
			byte data[]= new byte[is.available()];
			is.read(data);
			
			// write file
			FileOutputStream fos= new FileOutputStream(PATH_DIR+"\\"+multipartFile.getOriginalFilename());
			fos.write(data);
			fos.flush();
			fos.close();
			*/
			Files.copy(multipartFile.getInputStream(),
					Paths.get(PATH_DIR+File.separator+multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			 f=true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

}
