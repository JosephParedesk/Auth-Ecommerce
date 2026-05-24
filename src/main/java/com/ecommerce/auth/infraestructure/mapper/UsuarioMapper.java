package com.ecommerce.auth.infraestructure.mapper;

import com.ecommerce.auth.domain.model.Usuario;
import com.ecommerce.auth.infraestructure.driver_adapters.jpa_repository.UsuarioData;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioData tousuarioData(Usuario usuario){
        return new UsuarioData(
                usuario.getCedula(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getContrasena(),
                usuario.getTelefono(),
                usuario.getEdad(),
                usuario.getRol()

        );

    }

    public Usuario toUsuario(UsuarioData usuarioData){
        return  new Usuario(
                usuarioData.getCedula(),
                usuarioData.getNombre(),
                usuarioData.getCorreo(),
                usuarioData.getContrasena(),
                usuarioData.getTelefono(),
                usuarioData.getEdad(),
                usuarioData.getRol()
        );
    }
}
