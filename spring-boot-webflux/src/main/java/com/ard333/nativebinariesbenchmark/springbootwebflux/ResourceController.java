package com.ard333.nativebinariesbenchmark.springbootwebflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(resourceService.findById(id));
	}

	@GetMapping("/page/{page}/{size}")
	public ResponseEntity<?> findByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
		return ResponseEntity.ok(resourceService.findByPage(page, size));
	}

	@GetMapping("/resource-string/{resourceString}/page/{page}/{size}")
	public ResponseEntity<?> findByResourceString(@PathVariable("resourceString") String resourceString, @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
		return ResponseEntity.ok(resourceService.findByResourceString(resourceString, page, size));
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Resource resource) {
		resourceService.create(resource);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Resource resource) {
		resourceService.update(id, resource);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		resourceService.delete(id);
		return ResponseEntity.ok().build();
	}
}
