package ua.kiev.snigarenko.SpringBootMVCMySQLBlogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.kiev.snigarenko.SpringBootMVCMySQLBlogs.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

	@Query(value = "select * from Post p where p.title like %:keyword% or p.anons like %:keyword% or p.full_text like %:keyword%", nativeQuery=true)
	List<Post> findByKeyword(@Param("keyword") String keyword);

}
