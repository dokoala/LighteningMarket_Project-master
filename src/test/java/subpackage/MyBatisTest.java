package subpackage;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring_config/applicationContext.xml"})
public class MyBatisTest {

    @Inject
    private SqlSessionFactoryBean sqlSessionFactoryBean;

    @Test
    public void testFactory() {
        System.out.println(sqlSessionFactoryBean);
    }

    @Test
    public void testSession() throws Exception {
        try (SqlSession session = sqlSessionFactoryBean.getObject().openSession()){
            System.out.println(session);
            System.out.println("MyBatis 연결 성공");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("MyBatis 연결 실패");
        }
    }
}
