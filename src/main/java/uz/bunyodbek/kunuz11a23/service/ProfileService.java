package uz.bunyodbek.kunuz11a23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bunyodbek.kunuz11a23.dto.ProfileDto;
import uz.bunyodbek.kunuz11a23.model.Profile;
import uz.bunyodbek.kunuz11a23.model.Result;
import uz.bunyodbek.kunuz11a23.repository.ProfileRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    ProfileRepo profileRepo;


    // get hammasini olish
    public List<Profile> getAllL() {
        List<Profile> all = profileRepo.findAll();
        return all;
    }

    // get Id orqali
    public Profile getBYID(Long id) {
        Optional<Profile> optional = profileRepo.findById(id);
        return optional.get();
    }

    // create
    public Result add(ProfileDto profileDto) {

        boolean exists = profileRepo.existsByEmailAndPhone(profileDto.getEmail(), profileDto.getPhone());
        if (exists) {
            return new Result(false, "Allaqachon yaratilgan");
        }
        Profile profile = new Profile();
        profile.setName(profileDto.getName());
        profile.setSurname(profileDto.getSurname());
        profile.setEmail(profileDto.getEmail());
        profile.setPhone(profileDto.getPhone());
        profile.setPassword(profileDto.getPassword());
        profile.setStatus(profileDto.getStatus());
        profile.setRole(profileDto.getRole());
        profile.setVisible(profileDto.getVisible());
        profile.setCreateddate(profileDto.getCreateddate());
        profile.setPhotoid(profileDto.getPhotoid());
        profileRepo.save(profile);
        return new Result(true, "Created");
    }

    public Result update(Long id, ProfileDto profileDto) {
        Optional<Profile> optional = profileRepo.findById(id);

        if (optional.isPresent()) {
            Profile profile = optional.get();
            profile.setName(profileDto.getName());
            profile.setSurname(profileDto.getSurname());
            profile.setEmail(profileDto.getEmail());
            profile.setPhone(profileDto.getPhone());
            profile.setPassword(profileDto.getPassword());
            profile.setStatus(profileDto.getStatus());
            profile.setRole(profileDto.getRole());
            profile.setVisible(profileDto.getVisible());
            profile.setCreateddate(profileDto.getCreateddate());
            profile.setPhotoid(profileDto.getPhotoid());
            profileRepo.save(profile);
            return new Result(true, "Updated");
        }
        return new Result(false, "Profile not found");
    }

    public Result del(Long id) {
        profileRepo.deleteById(id);
        return new Result(true, "Deleted");
    }


}
