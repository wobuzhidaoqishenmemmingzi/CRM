package com.crm.cust.service.imp;

import com.crm.cust.dao.UmsAdminPermissionRelationMapper;
import com.crm.cust.entity.UmsAdminPermissionRelation;
import com.crm.cust.service.IUmsAdminPermissionRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 服务实现类
 * </p>
 *
 * @author lvhd
 * @since 2020-09-10
 */
@Service
public class UmsAdminPermissionRelationServiceImpl extends ServiceImpl<UmsAdminPermissionRelationMapper, UmsAdminPermissionRelation> implements IUmsAdminPermissionRelationService {

}
