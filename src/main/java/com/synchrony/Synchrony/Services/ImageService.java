package com.synchrony.Synchrony.Services;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.synchrony.Synchrony.Entites.ImageEntitiy;
import com.synchrony.Synchrony.repositories.ImageRepo;
import com.synchrony.Synchrony.util.ImageUtils;

@Service
public class ImageService {

	@Autowired
	private ImageRepo imageRepo;

	public ImageEntitiy uploadImage(MultipartFile image) throws Exception{
		
		String imageName=StringUtils.cleanPath(image.getOriginalFilename());
		if(imageName.contains(".."))
		{
			throw new Exception("fileName contains invalid path sequence "+imageName);
		}
		Random r=new Random();
		long l=r.nextLong(1000);
		ImageEntitiy ie=new ImageEntitiy(l,imageName, image.getContentType(), ImageUtils.compressImage(image.getBytes()));
		
		return imageRepo.save(ie);
	}

	public byte[] getImageByName(String imageName) throws Exception {
		// TODO Auto-generated method stub
		Optional<ImageEntitiy> ie=imageRepo.findByName(imageName);
		if(ie.isEmpty())
		{
			throw new Exception("fileName "+imageName+" is not present");
		}
		byte[] b=ImageUtils.decompressImage(ie.get().getImageData());
		return b;
	}

	public byte[] deleteImage(String imageName) throws Exception {
		// TODO Auto-generated method stub
		Optional<ImageEntitiy> ie=imageRepo.findByName(imageName);
		imageRepo.deleteImageByName(imageName);
		if(ie.isEmpty())
		{
			throw new Exception("fileName "+imageName+" is not present");
		}
		byte[] b=ImageUtils.decompressImage(ie.get().getImageData());
		return b;
	}
	
//	public String deleteImage(String imageName) throws Exception {
//		// TODO Auto-generated method stub
//		imageRepo.deleteImageByName(imageName);
//		return "success";
//	}
}
