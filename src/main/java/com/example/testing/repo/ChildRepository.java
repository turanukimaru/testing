package com.example.testing.repo;

import com.example.testing.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DB接続をきちんと作ればテストも作成できる。
 */
@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
  List<Child> findByDummyId(Long dummyId);
}
