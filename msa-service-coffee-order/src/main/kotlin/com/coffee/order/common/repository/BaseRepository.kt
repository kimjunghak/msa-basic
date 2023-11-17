package com.coffee.order.common.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface BaseRepository<T, ID>: JpaRepository<T, ID>, JpaSpecificationExecutor<T>