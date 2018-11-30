package com.springbootdemo.springbootshiro.repository;

import com.springbootdemo.springbootshiro.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: Little Rookies
 * @Date: 2018-11-29 15:45
 */
public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM `permission` WHERE permission.`id` IN " +
            "(SELECT `permissionId` FROM `role_permission` JOIN `user` ON " +
            "`role_permission`.`roleId`=`user`.`role_id` WHERE user.`account`=:account)")
    List<PermissionEntity> findAllByName(@Param("account") String account);
}
