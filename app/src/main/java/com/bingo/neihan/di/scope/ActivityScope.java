package com.bingo.neihan.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <请描述这个类是干什么的>
 * Created by WangWB on 2018/04/03  10:07.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface ActivityScope {
}
