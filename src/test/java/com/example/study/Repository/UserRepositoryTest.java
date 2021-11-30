package com.example.study.Repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {



    @Autowired //dependency Injection DI : 직접개체를 만들지 않고 spring이 관리하고 그것을 주입시키겠다.
    private UserRepository userRepository; // = new UserRepository();

    @Test
    public void create(){
        // String sql = insert into user(%s, %s, $d) value (account, email,age);
        User user = new User(); //주입받아 쓰는게 아니라 이건 여러 파라미터가 들어갈 수 있기에 직접 객체를 생성해서 쓴다.
        //user.setId(); autoIncrement이기에 쓰지 않는다.
        user.setAccount("TestUser03");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreateAt(LocalDateTime.now());
        user.setCreateBy("admin");
        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);

    }

    @Test
    @Transactional
    public void read(){ //@RequestParam Long id

        //user table의 user을 모두 가져오겠다.
//        Optional<User> user = userRepository.findById(1L); //2번째 low
        Optional<User> user = userRepository.findByAccount("TestUser03");

        user.ifPresent(selectUser ->{
            selectUser.getOrderDetailList().stream().forEach(detail ->{
                System.out.println(detail.getItem()); //.getItemId()를 쓰지 않는다. 왜냐 이제 mapped = "item"을 해놓았기에 getItem()만으로 객체를 바로 끌고온다.
            });
        });

    }
    @Test
    @Transactional //databases delete 밑에 이 부분을 실행시키더라도 롤백시켜줌
    public void update(){
        Optional<User> user = userRepository.findById(2L); //2번 low

        user.ifPresent(selectUser ->{
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional //databases delete 밑에 이 부분을 실행시키더라도 롤백시켜줌
    public void delete(){
        Optional<User> user = userRepository.findById(4L); //2번 low


        user.ifPresent(selectUser ->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(4L);


        if(deleteUser.isPresent()){
            System.out.println("데이터 존재 : " + deleteUser.get());
        }else{
            System.out.println("데이터 삭제 데이터없음");
        }
    }
}
