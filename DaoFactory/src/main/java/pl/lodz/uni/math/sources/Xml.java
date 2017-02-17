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
import pl.lodz.uni.math.user.User;

/**
 *
 * @author Wojciech
 */
public class Xml implements DaoSource{
    
    public static final Logger logger = Logger.getLogger(Xml.class.getName());
    private static Xml instance = null;
    private User mockUser;

    public static Xml getInstance() {
        if (instance == null) {
            instance = new Xml();
        }
        return instance;
    }
    
    private Xml(){}

    @Override
    public User selectUserById(Integer id) {
        mockUser = EasyMock.createMock(User.class);
        EasyMock.expect(mockUser.getId()).andReturn(id);
        EasyMock.expect(mockUser.getName()).andReturn("UserXML");
        EasyMock.replay(mockUser);

        logger.info(mockUser.getId() + " " + mockUser.getName());
        return mockUser;
    }

    @Override
    public List<User> selectAllUsers() {
        mockUser = EasyMock.createMock(User.class);
        List<User> mockList = EasyMock.createMock(ArrayList.class);
        EasyMock.expect(mockList.size()).andReturn(1);
        EasyMock.expect(mockList.get(0)).andReturn(mockUser);

        EasyMock.replay(mockList);

        return mockList;

    }
}