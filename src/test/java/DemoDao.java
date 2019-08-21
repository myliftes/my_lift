import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.chillax.dto.Area;

public class DemoDao   extends JdbcDaoSupport {
		/*@Autowired
		private JdbcTemplate jt;
	*/	
		//增
		public void save(Area area){
			getJdbcTemplate().update("insert into t_area values (null,?,?)", area.getCity(), area.getDistrict());
		}
		//删
		public void delete(Integer id){
			getJdbcTemplate().update("delete from t_user where id = ? ",id);
			
		}
		public void delete(Area u){
			this.delete(u.getId());
		}
}
