package springapplication.springapplication.Repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import springapplication.springapplication.Model.UserModel;


public interface UserResponse extends JpaRepository <UserModel,Integer>
{
    
}
