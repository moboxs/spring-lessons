package com.github.moboxs.bean.factory;

import com.github.moboxs.ioc.overview.domain.User;

/**
 * {@link User} 工厂类
 */
public interface UserFactory {

    default User createUser() {
        return User.createUser();
    }

    void initUserFactory();

    void doDestroy();
}
