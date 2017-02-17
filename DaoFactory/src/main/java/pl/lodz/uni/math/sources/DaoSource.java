/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.sources;

import java.util.List;
import pl.lodz.uni.math.user.User;

/**
 *
 * @author Wojciech
 */
public interface DaoSource {
    
    public List<User> selectAllUsers();
    
    public User selectUserById(Integer User);
    
}
