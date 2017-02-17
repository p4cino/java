/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.sources;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.easymock.EasyMock;
import static pl.lodz.uni.math.sources.WebService.logger;
import pl.lodz.uni.math.user.User;

/**
 *
 * @author Wojciech
 */
public class Database implements DaoSource {

    public static final Logger logger = Logger.getLogger(Database.class.getName());
    private static Database instance = null;
    private User mockUser = EasyMock.createMock(User.class);

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    
    private Database(){}

    @Override
    public User selectUserById(Integer id) {
        mockUser = EasyMock.createMock(User.class);
        EasyMock.expect(mockUser.getId()).andReturn(id);
        EasyMock.expect(mockUser.getName()).andReturn("UserDB");
        EasyMock.replay(mockUser);

        logger.info(mockUser.getId() + " " + mockUser.getName());
        return mockUser;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> mockList = EasyMock.createMock(ArrayList.class);
        EasyMock.expect(mockList.size()).andReturn(1);
        EasyMock.expect(mockList.get(0)).andReturn(mockUser);

        EasyMock.replay(mockList);

        return mockList;

    }

}
