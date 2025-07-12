package model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.entity.User;

public interface UserRepository<T> extends JpaRepository<User,Integer> {
	

}
