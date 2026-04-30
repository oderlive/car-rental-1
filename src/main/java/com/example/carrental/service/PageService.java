package com.example.carrental.service;
import com.example.carrental.model.Page;
import com.example.carrental.repository.PageRepository;
import org.springframework.stereotype.Service;

@Service
public class PageService {

    private final PageRepository repo;

    public PageService(PageRepository repo) {
        this.repo = repo;
    }

    public Page getBySlug(String slug) {
        return repo.findBySlug(slug).orElse(null);
    }

    public Page save(Page page) {
        return repo.save(page);
    }
}