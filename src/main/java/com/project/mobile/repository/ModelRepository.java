package com.project.mobile.repository;

import com.project.mobile.models.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ModelRepository extends JpaRepository<Model,Long> {

    List<Model> findAllByBrandId(Long id);

    Model findByName(String name);
}
