package ua.kiev.snigarenko.SpringBootMVCMySQLBlogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.snigarenko.SpringBootMVCMySQLBlogs.models.Post;
import ua.kiev.snigarenko.SpringBootMVCMySQLBlogs.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository; 

	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Transactional
	public void save(Post post) {
		postRepository.save(post);
	}
		
	@Transactional
	public void delete(Post post) {
		postRepository.delete(post);
	}
		
	public Post getById(Long id) {
		return postRepository.getById(id);
	}

	public boolean existsById(Long id) {
		return postRepository.existsById(id);
	}
	
	@Transactional(readOnly = true)
	public boolean isPostExists(Long id) {
		if (postRepository.existsById(id)) {
			return true;
		}
		return false;
	}
	
	public List<Post> findByKeyword(String keyword) {
		return postRepository.findByKeyword(keyword);
	}
	
}
