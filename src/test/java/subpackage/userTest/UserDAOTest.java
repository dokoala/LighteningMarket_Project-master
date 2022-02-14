package subpackage.userTest;

import com.project.lighteningmarket.user.domain.UserVO;
import com.project.lighteningmarket.user.persistence.UserDAO;
import com.project.lighteningmarket.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring_config/applicationContext.xml"})
public class UserDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(UserDAOTest.class);

    @Inject
    private UserDAO userDAO;

    // 회원 가입 Test
    @Test
    public void testCreate() throws Exception {
            UserVO userVO = new UserVO();
            userVO.setId("test1");
            userVO.setPassword("tjdwo135");
            userVO.setName("정성재");
            userVO.setNickname("거북");
            userVO.setEmail("dtc1674@naver.com");
            userVO.setpNumber("01075746799");

            userDAO.signup(userVO);
    }

//    // 회원 조회 테스트 1 : 아이디만
//    @Test
//    public void testReadMember() throws Exception {
//        userDAO.readMember("user00");
//    }

}
