package uz.bunyodbek.kunuz11a23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bunyodbek.kunuz11a23.dto.CommentDto;
import uz.bunyodbek.kunuz11a23.model.Article;
import uz.bunyodbek.kunuz11a23.model.Comment;
import uz.bunyodbek.kunuz11a23.model.Profile;
import uz.bunyodbek.kunuz11a23.model.Result;
import uz.bunyodbek.kunuz11a23.repository.ArticleRepo;
import uz.bunyodbek.kunuz11a23.repository.CommentRepo;
import uz.bunyodbek.kunuz11a23.repository.ProfileRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;
    @Autowired
    ProfileRepo profileRepo;
    @Autowired
    ArticleRepo articleRepo;

    public List<Comment> getAllComment() {
        return commentRepo.findAll();
    }


    public Comment getBYIDComment(Long id) {
        Optional<Comment> commentOptional = commentRepo.findById(id);
        return commentOptional.get();
    }

    // create
    public Result create(CommentDto commentDto) {

        Comment comment = new Comment();
        Optional<Profile> optionalProfile = profileRepo.findById(commentDto.getProfileId());
        Profile profile = optionalProfile.get();
        comment.setProfile(profile);
        comment.setContent(commentDto.getContent());
        Optional<Article> articleOptional = articleRepo.findById(commentDto.getArticleId());
        Article article = articleOptional.get();
        comment.setArticle((List<Article>) article);
        comment.setReplyId(commentDto.getReplyId());
        comment.setVisible(commentDto.getVisible());
        commentRepo.save(comment);
        return new Result(true, "Saqlandi");

    }


    // update
    public Result update(Long id, CommentDto commentDto) {
        Optional<Comment> optionalComment = commentRepo.findById(id);
        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            Optional<Profile> optionalProfile = profileRepo.findById(commentDto.getProfileId());
            Profile profile = optionalProfile.get();
            comment.setProfile(profile);
            comment.setContent(commentDto.getContent());
            Optional<Article> articleOptional = articleRepo.findById(commentDto.getArticleId());
            Article article = articleOptional.get();
            comment.setArticle((List<Article>) article);
            comment.setReplyId(commentDto.getReplyId());
            comment.setVisible(commentDto.getVisible());
            commentRepo.save(comment);
            return new Result(true, "O'zgartirildi");
        }
        return new Result(false, "Topilmadi");
    }


    // delete
    public Result del(Long id) {
        commentRepo.deleteById(id);
        return new Result(true, "Deleted");
    }




}
