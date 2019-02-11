package it.uniroma3.taskpolicy.dao;

import it.uniroma3.taskpolicy.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDao extends JpaRepository<Image, Long>, ImageDaoCustom {
}
