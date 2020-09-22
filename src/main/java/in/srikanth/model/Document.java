package in.srikanth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "doc_table")

public class Document {
	@Id
	@Column(name = "doc_id")
	private Integer docId;
	@Column(name = "doc_name")
	private String docName;
	@Column(name = "doc_data")
	@Lob // this means byte[]+@Lob=BLOB in database
	private byte[] docData;
} 