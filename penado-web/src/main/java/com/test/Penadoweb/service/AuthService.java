package com.test.penado.service;

import java.util.List;

import com.test.Penadoweb.exception.PenadoWebException;
import com.test.penado.dto.LoginDTO;
import com.test.penado.dto.ProfileDTO;
import com.test.penado.dto.TokenDTO;



public interface AuthService {

	TokenDTO login(LoginDTO body) throws PenadoWebException;

	List<ProfileDTO> getProfiles(String token);

}
