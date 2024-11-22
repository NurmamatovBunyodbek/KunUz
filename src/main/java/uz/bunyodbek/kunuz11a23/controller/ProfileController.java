package uz.bunyodbek.kunuz11a23.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.bunyodbek.kunuz11a23.dto.ProfileDto;
import uz.bunyodbek.kunuz11a23.model.Profile;
import uz.bunyodbek.kunuz11a23.model.Result;
import uz.bunyodbek.kunuz11a23.service.ProfileService;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {


    @Autowired
    ProfileService profileService;

    @GetMapping
    public List<Profile> getA() {
        List<Profile> list = profileService.getAllL();
        return list;
    }

    @GetMapping("/{id}")
    public Profile getBYID(@PathVariable Long id) {
        Profile byid = profileService.getBYID(id);
        return byid;
    }

    @PostMapping
    public Result create(@RequestBody ProfileDto profileDto) {
        Result result = profileService.add(profileDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody ProfileDto profileDto) {
        Result result = profileService.update(id, profileDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result dele(@PathVariable Long id) {
        Result result = profileService.del(id);
        return result;
    }


}
