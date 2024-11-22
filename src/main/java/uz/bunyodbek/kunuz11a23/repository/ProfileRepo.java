package uz.bunyodbek.kunuz11a23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bunyodbek.kunuz11a23.model.Profile;

public interface ProfileRepo extends JpaRepository<Profile, Long> {

    boolean existsByEmailAndPhone(String email, String phone);


}
