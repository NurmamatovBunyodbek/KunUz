package uz.bunyodbek.kunuz11a23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bunyodbek.kunuz11a23.dto.ArticleDto;
import uz.bunyodbek.kunuz11a23.model.Article;
import uz.bunyodbek.kunuz11a23.model.Result;
import uz.bunyodbek.kunuz11a23.repository.ArticleRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArticleService {

   @Autowired
   ArticleRepo articleRepo;

   public List<Article> getAll(){
       List<Article> all = articleRepo.findAll();
       return all;
   }

   public Article getById(UUID id){
       Optional<Article> articleOptional = articleRepo.findById(id);
       return articleOptional.get();
   }

   public Result create(ArticleDto articleDto){
       Article article = new Article();
       article.setTitle(articleDto.getTitle());
       article.setDescription(articleDto.getDescription());
       article.setContent(articleDto.getContent());
       article.setSharedcount(articleDto.getSharedcount());
       article.setImageid(articleDto.getImageid());
       article.setModeratorId(articleDto.getModeratorId());
       article.setRegionId(articleDto.getRegionId());
       article.setCategoryId(articleDto.getCategoryId());
       article.setPublisherId(articleDto.getPublisherId());
       article.setStatus(articleDto.getStatus());
       article.setCreateDate(articleDto.getCreateDate());
       article.setPublishedDate(articleDto.getPublishedDate());
       article.setVisible(articleDto.getVisible());
       article.setViewCount(articleDto.getViewCount());
       articleRepo.save(article);
       return new Result(true,"Created");
   }

   public Result update(UUID id, ArticleDto articleDto){
       Optional<Article> articleOptional = articleRepo.findById(id);
       if (articleOptional.isPresent()){
           Article article = articleOptional.get();
           article.setTitle(articleDto.getTitle());
           article.setDescription(articleDto.getDescription());
           article.setContent(articleDto.getContent());
           article.setSharedcount(articleDto.getSharedcount());
           article.setImageid(articleDto.getImageid());
           article.setModeratorId(articleDto.getModeratorId());
           article.setRegionId(articleDto.getRegionId());
           article.setCategoryId(articleDto.getCategoryId());
           article.setPublisherId(articleDto.getPublisherId());
           article.setStatus(articleDto.getStatus());
           article.setCreateDate(articleDto.getCreateDate());
           article.setPublishedDate(articleDto.getPublishedDate());
           article.setVisible(articleDto.getVisible());
           article.setViewCount(articleDto.getViewCount());
           articleRepo.save(article);
           return new Result(true,"Updated");
       }
       return new Result(false,"Not found");
   }

   public Result delete(UUID id){
       articleRepo.deleteById(id);
       return new Result(true,"Deleted");
   }
}
