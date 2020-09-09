package in.srikanth.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.Id;

public class OrderMethod {
	@Id
	@GeneratedValue(generator = "ordermethod")
	@SequenceGenerator(name = "ordermethod", sequenceName = "ordermethod_seq")
	@Column(name = "ord_id_col")
	private Integer id;
	@Column(name = "ord_mode_col")
	private String orderMode;
	@Column(name = "ord_code_col")
	private String orderCode;
	@Column(name = "ord_type_col")
	private String orderType;
	@ElementCollection
	@CollectionTable(name = "ord_acpt_tab", joinColumns = @JoinColumn(name = "ord_id_col"))
	@Column(name = "ord_acpt_col")
	private List<String> orderAcpt;
	@Column(name = "ord_description_col")
	private String description;
}
