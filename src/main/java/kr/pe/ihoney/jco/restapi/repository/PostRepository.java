package kr.pe.ihoney.jco.restapi.repository;

import kr.pe.ihoney.jco.restapi.domain.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>,
        QueryDslPredicateExecutor<Post> {
    Post findByTitle(String title);
}
