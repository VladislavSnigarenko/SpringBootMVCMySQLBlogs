package ua.kiev.snigarenko.SpringBootMVCMySQLBlogs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.kiev.snigarenko.SpringBootMVCMySQLBlogs.models.Post;
import ua.kiev.snigarenko.SpringBootMVCMySQLBlogs.service.PostService;

@Controller
public class BlogController {

	@Autowired
	PostService postService;
	
	@RequestMapping
	public String greeting(){
		return "index";
	}

	@RequestMapping("blog")
	public String blogList(Model model) {
		model.addAttribute("posts", postService.findAll());
		return "blogs";
	}
	
	@RequestMapping("about")
	public String about() {
		return "about";
	}
	
	@RequestMapping("add")
	public String add(Model model) {
		model.addAttribute("post", new Post());
		return "blog-add";
	}
	
	@RequestMapping("edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		if (!postService.isPostExists(id)){
	        return "redirect:/blog";
		} else {
			Post post = postService.getById(id);
			model.addAttribute("post", post);
			return "blog-edit";
		}
	}
	
	@RequestMapping("view/{id}")
	public String view(@PathVariable Long id, Model model) {
		if (!postService.isPostExists(id)){
	        return "redirect:/blog";
		} else {
			Post post = postService.getById(id);
			model.addAttribute("post", post);
			return "blog-view";
		}
	}	

	@RequestMapping("delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		if (!postService.isPostExists(id)){
	        return "redirect:/blog";
		}
		Post post = postService.getById(id);
		postService.delete(post);		
        return blogList(model);        
	}	

	@RequestMapping("view")
	public String viewGet(@ModelAttribute Post post) {
		post.setViews(post.getViews() + 1);
		postService.save(post);
        return "redirect:/blog";
	}	
	
	@PostMapping("/save")
	public String save(@ModelAttribute Post post) {
		postService.save(post);
        return "redirect:/blog";
	  }

	@RequestMapping("/search")
	public String search(@RequestParam("keyword") String keyword, Model model) {
		model.addAttribute("posts", postService.findByKeyword(keyword));
		return "blogs";
	}
	
}
