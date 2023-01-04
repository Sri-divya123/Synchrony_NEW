package com.synchrony.Synchrony.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.synchrony.Synchrony.Entites.ImageEntitiy;

@Repository
public interface ImageRepo extends JpaRepository<ImageEntitiy, Long>{
	
	Optional<ImageEntitiy> findByName(String imageName);
	
	@Query(value = "delete from image_entitiy ie where ie.NAME= ?1",nativeQuery = true)
	Optional<ImageEntitiy> deleteImageByName(String imageName);
	
}
