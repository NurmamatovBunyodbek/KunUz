package uz.bunyodbek.kunuz11a23.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.bunyodbek.kunuz11a23.dto.CommentDto;
import uz.bunyodbek.kunuz11a23.model.Comment;
import uz.bunyodbek.kunuz11a23.model.Result;
import uz.bunyodbek.kunuz11a23.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getCommentAll() {
        List<Comment> commentList = commentService.getAllComment();
        return commentList;
    }

    @PostMapping
    public Result add(@RequestBody CommentDto commentDto) {
        Result result = commentService.create(commentDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit (@PathVariable Long id , @RequestBody CommentDto commentDto){
        Result result = commentService.update(id, commentDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delet(@PathVariable Long id){
        Result result = commentService.del(id);
        return result;
    }

}
