package com.hgkimer.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Class, id 타입>를 상속하면 자동으로 CRUD에 필요한 메서드를 생성해 준다.
// PostsRepositoryTess.java 파일에 보면 아무 메서드도 정의 안했는데 CRUD 가능.
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
