package in.srikanth.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.srikanth.model.Document;

public interface DocumentRepo extends JpaRepository<Document, Integer> {

	@Query("SELECT docId, docName FROM Document")
	List<Object[]> getDocumentIdAndNames();
}