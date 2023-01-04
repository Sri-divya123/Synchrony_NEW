package com.synchrony.Synchrony.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.synchrony.Synchrony.Entites.ImageEntitiy;
import com.synchrony.Synchrony.Entites.ResponseData;
import com.synchrony.Synchrony.Services.ImageService;

@RestController
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@RequestMapping(method=RequestMethod.POST , path="/image")
	public ResponseData uploadImage(@RequestParam("image") MultipartFile image) throws Exception
	{
		ImageEntitiy ie=imageService.uploadImage(image);
		String url=ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").path(ie.getName()).toString();
		
		return new ResponseData(ie.getName(), url, image.getContentType(), image.getSize());
		
	}
	
	@RequestMapping(method=RequestMethod.GET , path="/image/{imageName}")
	public ResponseEntity<?> getImageByName(@PathVariable String imageName) throws Exception
	{
		byte b[]=imageService.getImageByName(imageName);
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(b);
		
	}
	@RequestMapping(method=RequestMethod.DELETE , path="/image/{imageName}")
	public ResponseEntity<?> deleteImage(@PathVariable String imageName) throws Exception
	{
		byte b[]=imageService.deleteImage(imageName);
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(b);
	}
	
//	@RequestMapping(method=RequestMethod.DELETE , path="/image/{imageName}")
//	public String deleteImage(@PathVariable String imageName) throws Exception
//	{
//		String s=imageService.deleteImage(imageName);
//		
//		return s;
//	}

}
