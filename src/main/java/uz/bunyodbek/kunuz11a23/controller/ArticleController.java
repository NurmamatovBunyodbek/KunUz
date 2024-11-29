package uz.bunyodbek.kunuz11a23.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.bunyodbek.kunuz11a23.dto.ArticleDto;
import uz.bunyodbek.kunuz11a23.model.Article;
import uz.bunyodbek.kunuz11a23.model.Result;
import uz.bunyodbek.kunuz11a23.service.ArticleService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping()
    public List<Article> getAllArticles() {
        return articleService.getAll();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable UUID id) {
        return articleService.getById(id);
    }

    @PostMapping()
    public Result addArticle(@RequestBody ArticleDto articleDto) {
        return articleService.create(articleDto);
    }

    @PutMapping("/{id}")
    public Result updateArticle(@PathVariable UUID id, @RequestBody ArticleDto articleDto) {
        return articleService.update(id, articleDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteArticle(@PathVariable UUID id) {
        return articleService.delete(id);
    }
}
