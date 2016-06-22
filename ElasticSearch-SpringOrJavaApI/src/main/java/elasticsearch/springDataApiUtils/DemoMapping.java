package elasticsearch.springDataApiUtils;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

/***
* @ClassName: DemoMapping 
* @Description: TODO(SpringDataMapping项目启动时创建) 
* @author Yashiro 
* @date 2016-6-3 下午02:32:18 
*/
@Document(indexName = "demoMappingIndex",//索引名称
		  type = "demoMappingType",//索引类型
		  shards = 5,//分片数
		  replicas = 1,//副本数
		  indexStoreType = "fs",//存储方式 fs为磁盘，memory为缓存方式
		  refreshInterval = "-1")
public class DemoMapping implements Serializable{

	private static final long serialVersionUID = -7867644570796197130L;

	@Id
	private String id;
	
	@Field(type=FieldType.String,index=FieldIndex.not_analyzed)
	private String sex;
	
	@Field(type=FieldType.String,index=FieldIndex.not_analyzed)
	private String age;
	
	@Field(type=FieldType.String,index=FieldIndex.not_analyzed)
	private String adress;
	
	@Field(type=FieldType.Date,index=FieldIndex.not_analyzed,format = DateFormat.date_hour_minute_second_millis)
	private Date data;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}
