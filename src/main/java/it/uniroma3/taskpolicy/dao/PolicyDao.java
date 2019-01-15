package it.uniroma3.taskpolicy.dao;

import it.uniroma3.taskpolicy.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyDao extends JpaRepository<Policy,Long> {
}
