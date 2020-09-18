package in.srikanth.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.srikanth.model.WhUserType;

public interface WhUserTypeRepository extends JpaRepository<WhUserType, Serializable> {
}