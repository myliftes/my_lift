import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chillax.dao.StandardDao;
import com.chillax.dto.Area;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

	//在测试方法执行之前.先创建容器
	//指定spring配置文件位置
	//加载xml配置
	public class Demo{
		@Autowired
		private StandardDao standardDao;
 
		@Test
		public void fun1() throws SQLException{
			Area area  = new Area();
			area.setId(1);
			area.setCity("bos_9527"); 
			area.setDistrict("bos_9527");
			standardDao.addStandard(area);
			System.out.println("aa");
		}
 
    @Test
    public  void test001() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //下面这个千万千万千万要注意，1521/ORCLPDB是斜杠！！！不是:冒号！！！
        String url = "jdbc:oracle:thin:@localhost:1521/ORCLPDB";
        String username = "bos_9527";
        String psw = "bos_9527";
        Connection conn = DriverManager.getConnection(url,username,psw);
 
        String sql = "select * from emp";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getObject(1));
            System.out.println(resultSet.getObject(2));
            System.out.println(resultSet.getObject(3));
        }
        resultSet.close();
        ps.close();
        conn.close();
    }
}
