package uz.bunyodbek.kunuz11a23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bunyodbek.kunuz11a23.dto.ArticleLikeDto;
import uz.bunyodbek.kunuz11a23.model.Article;
import uz.bunyodbek.kunuz11a23.model.ArticleLike;
import uz.bunyodbek.kunuz11a23.model.Profile;
import uz.bunyodbek.kunuz11a23.model.Result;
import uz.bunyodbek.kunuz11a23.repository.ArticleLikeRepo;
import uz.bunyodbek.kunuz11a23.repository.ArticleRepo;
import uz.bunyodbek.kunuz11a23.repository.ProfileRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleLikeService {

    @Autowired
    ArticleLikeRepo articleLikeRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    ArticleRepo articleRepo;

    public List<ArticleLike> getAll(){
        List<ArticleLike> all = articleLikeRepo.findAll();
        return all;
    }

    public ArticleLike getById(Integer id){
        Optional<ArticleLike> byId = articleLikeRepo.findById(id);
        return byId.get();
    }

    public Result create(ArticleLikeDto articleLikeDto){
        ArticleLike articleLike = new ArticleLike();
        articleLike.setCreatedDate(articleLikeDto.getCreatedDate());
        articleLike.setStatus(articleLikeDto.getStatus());
        Optional<Profile> optional = profileRepo.findById(articleLikeDto.getProfileId());
        Profile profile = optional.get();
        articleLike.setProfileId((List<Profile>) profile);
        Optional<Article> articleOptional = articleRepo.findById(articleLikeDto.getArticleId());
        Article article = articleOptional.get();
        articleLike.setArticleId((List<Article>) article);
        articleLikeRepo.save(articleLike);
        return new Result(true,"Created");
    }

    public Result uptade(Integer id ,ArticleLikeDto articleLikeDto){
        Optional<ArticleLike> articleLikeOptional = articleLikeRepo.findById(id);
        if (articleLikeOptional.isPresent()){
            ArticleLike articleLike = articleLikeOptional.get();
            articleLike.setCreatedDate(articleLikeDto.getCreatedDate());
            articleLike.setStatus(articleLikeDto.getStatus());
            Optional<Profile> optional = profileRepo.findById(articleLikeDto.getProfileId());
            Profile profile = optional.get();
            articleLike.setProfileId((List<Profile>) profile);
            Optional<Article> articleOptional = articleRepo.findById(articleLikeDto.getArticleId());
            Article article = articleOptional.get();
            articleLike.setArticleId((List<Article>) article);
            articleLikeRepo.save(articleLike);
            return new Result(true,"Updated");
        }
        return new Result(false,"Not found");
    }

    public Result delete(Integer id){
        articleLikeRepo.deleteById(id);
        return new Result(true,"Deleted");
    }
}
