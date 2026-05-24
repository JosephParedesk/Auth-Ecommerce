package com.ecommerce.auth.domain.model.gateway;

import com.ecommerce.auth.domain.model.Usuario;

public interface UsuarioGateway {

Usuario guardarUsuario(Usuario usuario);

Usuario buscarUsuarioPorCc (String cedula);

void eliminarUsuarioPorCc (String cedula);

Usuario buscarPorCorreo(String correo);

}
