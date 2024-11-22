package uz.bunyodbek.kunuz11a23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bunyodbek.kunuz11a23.dto.ArticleTypeDto;
import uz.bunyodbek.kunuz11a23.model.ArticleType;
import uz.bunyodbek.kunuz11a23.model.Result;
import uz.bunyodbek.kunuz11a23.repository.ArticleTypeRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleTypeService {

    @Autowired
    ArticleTypeRepo articleTypeRepo;

    public List<ArticleType> getAllArticleTypes() {
        return articleTypeRepo.findAll();
    }

    public ArticleType getArticleTypeById(Long id) {
        return articleTypeRepo.findById(id).get();
    }

    public Result create(ArticleTypeDto articleTypeDto) {
        ArticleType articleType = new ArticleType();
        articleType.setCreatedDate(articleTypeDto.getCreatedDate());
        articleType.setVisible(articleTypeDto.getVisible());
        articleType.setOrdernumber(articleTypeDto.getOrdernumber());
        articleType.setNameuz(articleTypeDto.getNameuz());
        articleType.setNameru(articleTypeDto.getNameru());
        articleType.setNameeng(articleTypeDto.getNameeng());
        articleTypeRepo.save(articleType);
        return new Result(true, "Article Type Created Successfully");
    }

    public Result update(ArticleTypeDto articleTypeDto, Long id) {
        Optional<ArticleType> byId = articleTypeRepo.findById(id);
        if (byId.isPresent()) {
            ArticleType articleType = byId.get();
            articleType.setCreatedDate(articleTypeDto.getCreatedDate());
            articleType.setVisible(articleTypeDto.getVisible());
            articleType.setOrdernumber(articleTypeDto.getOrdernumber());
            articleType.setNameuz(articleTypeDto.getNameuz());
            articleType.setNameru(articleTypeDto.getNameru());
            articleType.setNameeng(articleTypeDto.getNameeng());
            articleTypeRepo.save(articleType);
            return new Result(true, "Article Type Updated Successfully");
        }
        return new Result(false, "Article Type Not Found");
    }

    public Result delete(Long id) {
        articleTypeRepo.deleteById(id);
        return new Result(true, "Article Type Deleted Successfully");
    }

}
