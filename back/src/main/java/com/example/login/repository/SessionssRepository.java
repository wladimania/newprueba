package com.example.login.repository;

import com.example.login.entity.SessionsEntity;
import com.example.login.entity.dto.SesionsInfoInterface;
import com.example.login.entity.dto.SessionInfoDTO;
import com.example.login.util.SessionsInterface;
import com.example.login.util.sesiones.UsuarioInterfa;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@Repository
public interface SessionssRepository extends JpaRepository<SessionsEntity,Integer> {
    List<SessionsEntity> findAllByUsuariosIdUsuario(int usuariosIdUsuario);
    SessionsEntity findByUsuariosIdUsuarioAndFechaCierreIsNull(int usuariosIdUsuario);

    @Query(value = "update sessions set \"fechaCierre\"=now() where \"fechaCierre\" is null and \"usuarios_idUsuario\"=?1 returning \"usuarios_idUsuario\" ",nativeQuery = true)
    void registrarcierre(Integer id_usuario);

    @Query(value = "select s from SessionsEntity s ",nativeQuery = false)
    List<SessionsInterface> findAllByusuarioInterfa();


    @Query("SELECT " +
            "u.intentoFallido, " +
            "s.fechaIngreso, " +
            "s.fechaCierre " +
            "FROM UsuariosEntity u " +
            "JOIN u.sessionsByIdUsuario s " +
            "WHERE u.idUsuario = :idUsuario AND s.fechaCierre IS NULL " +
            "ORDER BY s.fechaIngreso DESC")
    SesionsInfoInterface findLatestSessionInfoByUserId(@Param("idUsuario") Integer idUsuario);

    default SesionsInfoInterface findLatestSessionInfoByUserIdLogged(Integer idUsuario) {
        SesionsInfoInterface sessionInfo = findLatestSessionInfoByUserId(idUsuario);
        System.out.println("Consulta ejecutada: " + sessionInfo);
        return sessionInfo;
    }


    @Query("SELECT new com.example.login.entity.dto.SessionInfoDTO(" +
            "u.intentoFallido, " +
            "s.fechaIngreso, " +
            "s.fechaCierre) " +
            "FROM UsuariosEntity u " +
            "JOIN u.sessionsByIdUsuario s " +
            "WHERE u.idUsuario = :idUsuario AND s.fechaCierre IS NULL " +
            "ORDER BY s.fechaIngreso DESC")
    SessionInfoDTO findFirstByUsuariosIdUsuarioAndFechaCierreIsNullOrderByFechaIngresoDesc(Integer idUsuario);


}
