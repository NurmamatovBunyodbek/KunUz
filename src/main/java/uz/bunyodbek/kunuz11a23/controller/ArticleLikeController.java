package uz.bunyodbek.kunuz11a23.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.bunyodbek.kunuz11a23.dto.ArticleLikeDto;
import uz.bunyodbek.kunuz11a23.model.ArticleLike;
import uz.bunyodbek.kunuz11a23.model.Result;
import uz.bunyodbek.kunuz11a23.service.ArticleLikeService;

import java.util.List;

@RestController
@RequestMapping("/articlelike")
public class ArticleLikeController {

    @Autowired
    ArticleLikeService articleLikeService;

    @GetMapping()
    public List<ArticleLike> getArticleLike() {
        return articleLikeService.getAll();
    }

    @GetMapping("/{id}")
    public ArticleLike getArticleLike(@PathVariable Integer id) {
        return articleLikeService.getById(id);
    }

    @PostMapping()
    public Result addArticleLike(@RequestBody ArticleLikeDto articleLikeDto) {
        return articleLikeService.create(articleLikeDto);
    }

    @PutMapping("/{id}")
    public Result updateArticleLike(@PathVariable Integer id, @RequestBody ArticleLikeDto articleLikeDto) {
        return articleLikeService.uptade(id, articleLikeDto);
    }
    @DeleteMapping("/{id}")
    public Result deleteArticleLike(@PathVariable Integer id) {
        return articleLikeService.delete(id);
    }
}
