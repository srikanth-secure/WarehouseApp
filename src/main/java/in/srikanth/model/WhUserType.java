package in.srikanth.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class WhUserType {
	@Id
	@Column(name = "wh_id_col")
	@GeneratedValue(generator = "whusertype")
	@SequenceGenerator(name = "whusertype", sequenceName = "whusertype_seq")
	private Integer id;
	@Column(name = "wh_type_col")
	private String userType;
	@Column(name = "wh_code_col")
	private String userCode;
	@Column(name = "wh_for_col")
	private String userFor;
	@Column(name = "wh_email_col")
	private String userEmail;
	@Column(name = "wh_contact_col")
	private String userContact;
	@Column(name = "wh_id_type_col")
	private String userIdType;
	@Column(name = "wh_if_other_col")
	private String ifOther;
	@Column(name = "wh_id_number_col")
	private String idNumber;
}