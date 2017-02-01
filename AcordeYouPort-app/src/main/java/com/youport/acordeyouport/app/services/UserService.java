/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youport.acordeyouport.app.services;

import com.youport.acordeyouport.app.facade.UserFacade;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Luis Castañeda <luis.castaneda at acorde.com.ve>
 */
public class UserService implements UserDetailsService {

    private UserFacade userFacadeEjb;

    public UserService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.youport.acordeyouport.app.entity.User user = userFacadeEjb.find(username);

        if (user != null) {

            //Obtiene la colección de Authorities a partir de la lista de profiles
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            if (user.getIdUserType().getType() != null) {
                authorities.add(new SimpleGrantedAuthority(user.getIdUserType().getType()));
            }
            User userDetails = new User(username, (user.getPassword() != null) ? user.getPassword() : "", true, true, true, true, authorities);
            //
            return userDetails;
        } else {
            throw new UsernameNotFoundException("USERNAME " + username + " NOT FOUND");
        }
    }

    /**
     * @param userFacadeEjb the userFacadeEjb to set
     */
    public void setUserFacadeEjb(UserFacade userFacadeEjb) {
        this.userFacadeEjb = userFacadeEjb;
    }

}
